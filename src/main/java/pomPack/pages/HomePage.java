package pomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import pomPack.base.BasePage;

public class HomePage extends BasePage {

	@FindBy(id = "pv-nav-home")
	public WebElement home;
	@FindBy(id = "pv-nav-tv-shows")
	public WebElement TVShow;
	@FindBy(id = "pv-nav-movies")
	public WebElement Movies;
	@FindBy(id = "pv-nav-kids")
	public WebElement Kids;

	public HomePage(WebDriver driver, ExtentTest eTest) {
		this.driver = driver;
		this.eTest = eTest;
	}

	public boolean verifyDisplayOfHomePage() {
		return (isElementPresent(home));

	}
}
