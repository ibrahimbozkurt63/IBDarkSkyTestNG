package com.qa.DarkSky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.DarkSky.base.BasePage;
import com.qa.DarkSky.page.MainPage;

public class MainPageTest {

	WebDriver driver;
	Properties prop;
	BasePage base;
	MainPage mainPage;

	@BeforeTest

	public void setUP() {

		base = new BasePage();
		prop = base.init_properties();
		String browsername = prop.getProperty("browser");
		driver = base.init_drver(browsername);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
	}

	@Test(priority = 1, description = "Getting Title from DarkSky", enabled = true)
	public void verifyHomePageTitle() {
		String title = mainPage.getPageTitle();
		System.out.println("Getting Title: " + title);
		Assert.assertEquals(title, "Dark Sky - 1 City Hall, New York, NY");
	}

	@Test(priority = 2, description = "Getting Url from DarkSky", enabled = true)
	public void verifyUrl() {
		String url = mainPage.getUrl();
		System.out.println("Getting Url: " + url);
		Assert.assertEquals(url, "https://darksky.net/forecast/40.7127,-74.0059/us12/en");
	}

	@Test(priority = 3, description = "Getting the low temperature range", enabled = true)
	public void getLow() {
		mainPage.getLowestTemp();
	}

	@Test(priority = 4, description = "Getting the high temperature range", enabled = true)
	public void getHigh() {
		mainPage.getHighestTemp();
	}

	@Test(priority = 5, description = "Getting the page header", enabled = true)
	public void getHeader() {
		mainPage.getPageHeader();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}
}
