package com.android.anjan.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.android.anjan.base.Device;
import com.android.anjan.base.Get_Device_Properties;
import com.android.anjan.base._Application_;

public class Test_Cases8 extends _Application_{
	Get_Device_Properties getDeviceProperties = new Get_Device_Properties();
	Device device = new Device();
	
	@Test
	public void Identifying_Poi() throws IOException, InterruptedException {
		String name = getDeviceProperties.getAndroidDeviceName().toString();
		 deviceName(name);
		 
		 launchApplication("com.one20.ota.qa","com.one20.ota.main.SplashActivity");
		 connectToAppiumServer();
		 Thread.sleep(10000);
		 WebElement poi_view = androidDriver.findElement(By.xpath("//android.view.View[@content-desc='Google Map']"));
		 List<WebElement> poi = poi_view.findElements(By.className("android.view.View"));
		 for (WebElement pois : poi) {
			pois.click();
			
			WebElement overview_heading = androidDriver.findElement(By.id("com.one20.ota.qa:id/poi_name"));
			String poi_name = overview_heading.getAttribute("text");
			
			System.out.println("ONE20 POI Name is :: " + poi_name);
		}
	}
}
