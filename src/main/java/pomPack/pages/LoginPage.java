package pomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pomPack.base.BasePage;
import pomPack.util.Constants;

public class LoginPage extends BasePage {

	@FindBy(id = "ap_email")
	public WebElement emailField;
	@FindBy(id = "ap_password")
	public WebElement passwordField;
	@FindBy(id = "signInSubmit")
	public WebElement signinButton;

	public LoginPage(WebDriver driver, ExtentTest eTest) {
		this.driver = driver;
		this.eTest = eTest;

	}

	public boolean doLogin() {

		emailField.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO, "username got entered in to email field");
		passwordField.sendKeys(Constants.PASSWORD);
		eTest.log(LogStatus.INFO, "Password entered in to password field");
		signinButton.click();
		eTest.log(LogStatus.INFO, "Click on login button");
		HomePage homepage = new HomePage(driver, eTest);
		PageFactory.initElements(driver, homepage);
		boolean LoginStatus = homepage.verifyDisplayOfHomePage();
		return LoginStatus;

	}

}
