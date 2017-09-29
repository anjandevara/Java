package com.android.anjan.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.anjan.base.Appium_Capabilities;
import com.android.anjan.base.Device;
import com.android.anjan.base.Get_Device_Properties;

public class Test_Cases_3 extends Appium_Capabilities{
	Get_Device_Properties getDeviceProperties = new Get_Device_Properties();
	Device device = new Device();

//	@BeforeTest
//	public void pre_requsites() throws IOException, InterruptedException {
//		String name = getDeviceProperties.getAndroidDeviceName().toString();
//		deviceName(name);
//		androidPlatform();
//	}
	
	@Test
	public void Device_Inputs() throws IOException, InterruptedException{
		device.userLogin("anjandevara@aol.com");
		device.tapTab();
		device.userPassword("qwerty123");
		device.hideKeyboard();
	}
}
