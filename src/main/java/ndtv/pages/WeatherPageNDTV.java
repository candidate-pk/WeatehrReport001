package ndtv.pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ndtv.BaseNDTV;

public class WeatherPageNDTV extends BaseNDTV{
	HomePageNDTV homepageNdtv;
	WeatherPageNDTV weatherPageNdtv;
	
	
	@BeforeMethod
	public void SetupPage() {
		Setup();
		homepageNdtv = new HomePageNDTV();
	}
	
	@Test
	public void presenceOfCityInput() {
		
	}

}