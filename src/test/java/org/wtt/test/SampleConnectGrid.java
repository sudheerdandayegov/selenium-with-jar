package org.wtt.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.itest.util.PropertiesUtility;

public class SampleConnectGrid {

	WebDriver driver;

	@Test(priority = 1, description = "this is test f", testName = "f")
	public void f() throws MalformedURLException {
		String key = PropertiesUtility.loadApplicationProperties().getProperty("grid.url");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL(key), capabilities);
		System.out.println("driver connected.............");
		driver.navigate().to("http://www.google.com");
		String title = driver.getTitle();
		Assert.assertEquals("Google.com", title);
	}
}
