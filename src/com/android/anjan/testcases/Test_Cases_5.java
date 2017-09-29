package com.android.anjan.testcases;

import org.testng.annotations.Test;

import com.android.anjan.base.Device;

public class Test_Cases_5 {

	Device device = new Device();
			
	@Test
	public void MonkeyTest() {
		try {
			device.appMonkeyTest("com.one20.one20eld.qa", "10000");
			
		} catch (Exception e) {
			// TODO: handle exception
			device.takeScreenshot("testingmethos.png");
			device.identifyCrash("com.one20.one20eld.qa");
		}
	}
	
}
