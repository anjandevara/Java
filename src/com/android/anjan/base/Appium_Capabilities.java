package com.android.anjan.base;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author adevara
 *
 */
public class Appium_Capabilities extends Application_Properties {

	protected DesiredCapabilities capabilities = new DesiredCapabilities();
	protected AndroidDriver androidDriver;

	/**
	 * Providing Device Name
	 * @return
	 */
	public String deviceName(String name) {
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, name);
		return name;
	}

	/**
	 * Providing Platform Version
	 */
	public void androidVersion(String androidVersion) {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidVersion);
	}

	/**
	 * Providing Platform Name
	 */
	public void androidPlatform() {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	}

	/**
	 * Providing Application Package
	 */
	public void packageName(String applicationPackage) {
		try {
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, applicationPackage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Providing Activity Names
	 */
	public void activityName(String activityName) {
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityName);
	}

	public void connectToAppiumServer() {
		try {
			/* Connecting to the Appium Server with local host */
			androidDriver = new AndroidDriver(new URL(getElelment("server_hostname")), capabilities);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}

	/**
	 * Installing Application
	 */
	public void installingApplication(String applicationPath) {
		try {
			File file = new File(applicationPath);
			capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
			capabilities.setCapability("noReset", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launching Existing Application
	 */
	public void launchApplication(String APP_PACKAGE, String APP_ACTIVITY) {
		 try {
				capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
			capabilities.setCapability("appPackage", APP_PACKAGE);
			capabilities.setCapability("appActivity", APP_ACTIVITY);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchFacebook() {
		try {
//			capabilities.setCapability("appPackage", "com.facebook.katana");
//			capabilities.setCapability("appActivity", "com.facebook.katana.app.FacebookSplashScreenActivity");
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  "com.one20.maps.qa");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.one20.maps.main.SplashActivity");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
