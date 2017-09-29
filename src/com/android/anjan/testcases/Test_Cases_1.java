package com.android.anjan.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.anjan.base.Appium_Capabilities;
import com.android.anjan.base.Device;
import com.android.anjan.base.Get_Device_Properties;

public class Test_Cases_1 extends Appium_Capabilities {

	Get_Device_Properties getDeviceProperties = new Get_Device_Properties();

	@BeforeTest
	public void pre_requsites() throws IOException, InterruptedException {
		String name = getDeviceProperties.getAndroidDeviceName().toString();
		Device device = new Device();
		device.startAppiumServer();
		deviceName(name);
		//androidPlatform();
	}

	@Test
	public void InstallingCCApp() {
		try {
			/*
			 * Installing the CipherCloud APK File
			 * 
			 * UN-installing the CipherCloud APK Automatically if already exists
			 * in the Device
			 */
			installingApplication(getElelment("One20Release"));
			/* Connecting to the Appium Server with local host */
			/* Connecting to the Appium Server with local host */
			connectToAppiumServer();
			// Assert.assertEquals(ad.isAppInstalled("com.one20.one20eld.qa"),
			// true);
			/*
			 * * Verifying whether the curent opened app after installation is
			 * the Splash Screen of CipherCloud App
			 */

			// Thread.sleep(2000);
			org.junit.Assert.assertEquals(androidDriver.currentActivity(), getElelment("One20_FlashScreen"));
			Thread.sleep(8000);
			org.junit.Assert.assertEquals(androidDriver.currentActivity(), getElelment("One20_HomeScreen"));
			//
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}
}
