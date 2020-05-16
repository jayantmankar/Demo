package pomPack.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pomPack.pages.LaunchPage;
import pomPack.test.base.BaseTest;
import pomPack.util.Constants;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {

		eTest = eReport.startTest("Test Started ");
		eTest.log(LogStatus.INFO, "Starting Login Test");
		OpenBrowser(Constants.BROWSER_TYPE);

		LaunchPage launchpage = new LaunchPage(driver, eTest);
		PageFactory.initElements(driver, launchpage);
		boolean loginStatus = launchpage.goToLoginPage();
		if (loginStatus) {
			reportPass("Login test passed");
		} else {
			reportFail("Login Test Failed");
		}
	}

	@AfterMethod
	public void testClosure() {
		if (eReport != null) {
			eReport.endTest(eTest);
			eReport.flush();
		}
		if (driver != null) {
			driver.quit();
		}
	}
}
