package com.qa.DarkSky.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DarkSky.base.BasePage;
import com.qa.DarkSky.util.ElementUtil;

public class MainPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;

	public MainPage (WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	By mainpageElement= By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[1]/span[1]");

    By zoomIn=By.xpath("/button[@class='ol-zoom-in']");
    By lowTemp=By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[2]/span[1]");

    By highTemp=By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[3]/span[1]") ;

    By header =By.xpath("//*[@id=\"currentDetails\"]/div[1]/span[1]");

    public void getLowestTemp(){
    	String tempL=elementUtil.doGetText(lowTemp);
        System.out.println("The tempreture range is starting from " + tempL);
    }
    public void getHighestTemp(){
    	String tempH=elementUtil.doGetText(highTemp);
        System.out.println("The tempreture range goes to  " + tempH);
    }

    public void getMainPageAElement(){
    	String text=elementUtil.doGetText(mainpageElement);
    	System.out.println("One of the elements on the main page is " +text);
        
    }

   public void getPageHeader(){
      String headerText =elementUtil.doGetText(header);
      System.out.println("Todays weather condition is " +headerText);
   }

	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;

	}
}
