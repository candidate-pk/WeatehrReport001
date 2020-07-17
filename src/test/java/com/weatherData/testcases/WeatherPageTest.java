package com.weatherData.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ndtv.BaseNDTV;

import ndtv.pages.HomePageNDTV;
import ndtv.pages.WeatherPageNDTV;

public class WeatherPageTest extends BaseNDTV {

	HomePageNDTV homepageNdtv;
	WeatherPageNDTV weatherPageNdtv;
	int cityTemperature;
	int cityHumidity;
	String tempDatacollector;

	@BeforeMethod
	public void SetupPage() {
		Setup();
		homepageNdtv = new HomePageNDTV();
		homepageNdtv.OpenExtendedMenu();
		weatherPageNdtv = homepageNdtv.ClickWeatherLink();
	}

	@Test
	public void presenceOfCityInput() {
		Assert.assertEquals(weatherPageNdtv.cityInputFieldEnabled(), true);
	}

	@Test(dependsOnMethods = { "presenceOfCityInput" })
	public void enterCityNameTest() { //This will enter city name in text-field and verify on the map
		weatherPageNdtv.enterCityName("Lucknow");
		//System.out.println();
		Assert.assertEquals(weatherPageNdtv.presenceOfCityonList("Lucknow"), true);
		
	}
	
	@Test//(dependsOnMethods = { "enterCityNameTest" })
	public void selectCityCheckbox(){ //This will do steps from search city and click on it on Map to verify if weather details panel opens
		weatherPageNdtv.enterCityName("Bhopal");
		
		do {
			weatherPageNdtv.clickCityCheckBox("Bhopal");
		}while(!weatherPageNdtv.cityDisplayedOnMap("Bhopal")) ;
		
		
		weatherPageNdtv.clickCityOnMap("Bhopal");
		Assert.assertEquals(weatherPageNdtv.weatherPanelDisplay("Bhopal"), true);		
	}
	
	@Test
	public void recordTempAndHumidity() {
		weatherPageNdtv.enterCityName("Ajmer");
		
		do {
			weatherPageNdtv.clickCityCheckBox("Ajmer");
		}while(!weatherPageNdtv.cityDisplayedOnMap("Ajmer")) ;
				
		weatherPageNdtv.clickCityOnMap("Ajmer");		
		System.out.println(driver.findElement(By.xpath("//*[@id='map_canvas' and contains(., 'Temp in Degrees')]")).getText());
		tempDatacollector = driver.findElement(By.xpath("//*[@id='map_canvas' and contains(., 'Temp in Degrees')]")).getText();
		
	}
	
	

}
