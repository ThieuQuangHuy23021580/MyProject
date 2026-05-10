/**
 * 
 */
package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;
import io.github.lambdatest.SmartUISnapshot;

/**
 * @author Hitendra
 *
 */
public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;
    
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		SmartUISnapshot.smartuiSnapshot(getDriver(), "IndexPage - Verify Logo");
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() throws Throwable {
		Log.startTestCase("verifyTitle");
		indexPage = new IndexPage();
		String actTitle=indexPage.getMyStoreTitle();
		SmartUISnapshot.smartuiSnapshot(getDriver(), "IndexPage - Verify Title");
		Assert.assertTrue(actTitle.contains("My Shop"));
		Log.endTestCase("verifyTitle");
	}

	
}
