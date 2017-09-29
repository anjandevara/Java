package com.android.anjan.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.anjan.base.Appium_Capabilities;
import com.android.anjan.base.Get_Device_Properties;

import io.appium.java_client.remote.MobileCapabilityType;

public class Test_Cases2 extends Appium_Capabilities {
	Get_Device_Properties getDeviceProperties = new Get_Device_Properties();

	@BeforeTest
	public void pre_requsites() throws IOException, InterruptedException {
		String name = getDeviceProperties.getAndroidDeviceName().toString();
		deviceName(name);
		androidPlatform();
//		 
	}

	@Test
	public void Launch_One20_Application(){

		try {
//			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.one20.one20eld");
//			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.one20.one20eld.launch.LaunchActivity");


//			launchApplication(getElelment("one20_package"),getElelment("one20_activity"));
//			launchApplication("com.one20.maps.qa", "com.one20.maps.main.SplashActivity");
			launchFacebook();
			connectToAppiumServer();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}
}
