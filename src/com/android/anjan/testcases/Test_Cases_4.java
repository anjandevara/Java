package com.android.anjan.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.android.anjan.base.Device;

public class Test_Cases_4{

	Device device = new Device();
	
	@Test
	public void test() throws IOException, InterruptedException {
//		device.appUpgrade("./APKFolder/app-release.apk");
//		device.appUninstall("com.one20.one20eld.qa");
//		device.appInstall("./APKFolder/app-qa.apk");
		device.launch_Application("com.one20.one20eld.qa/com.one20.one20eld.auth.SplashActivity");
	}
	
	
}
