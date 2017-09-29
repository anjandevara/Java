package com.android.anjan.testcases;

import org.testng.annotations.AfterClass;
import 	org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.android.anjan.base.Device;

public class Test_Cases_6 {

	Device devices = new Device();
	
//	@BeforeTest
//	public void BeforeTest() {
//		devices.startAppiumServer();
//	}
	
	@Test
	public void Test() {
		try {
			devices.startAppiumServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		devices.Get_Network_State();
	}
	
//	@AfterClass
//	public void AfterTest() {
//		devices.stopAppiumServer();
//	}
	
}
