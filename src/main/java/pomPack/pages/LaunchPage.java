package pomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pomPack.base.BasePage;
import pomPack.util.Constants;

public class LaunchPage extends BasePage {

	@FindBy(id = "pv-nav-sign-in")
	public WebElement loginOption;

	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		this.driver = driver;
		this.eTest = eTest;

	}

	public boolean goToLoginPage() {
		driver.get(Constants.APP_URL);
		eTest.log(LogStatus.INFO, "Opened" + Constants.APP_URL);
		loginOption.click();
		eTest.log(LogStatus.INFO, "Click on Login Button");
		LoginPage loginpage = new LoginPage(driver, eTest);
		PageFactory.initElements(driver, loginpage);
		boolean loginStatus = loginpage.doLogin();
		return loginStatus;

	}

}
