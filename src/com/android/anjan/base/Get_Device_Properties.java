package com.android.anjan.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Get_Device_Properties {

	public BufferedReader getAndroidDeviceName() throws IOException, InterruptedException {

		// Read Output from the command


			String s;
			String[] adbCommand = { "./adbtools/adb", "shell", "getprop", "ro.product.name" };
			Runtime runTime = Runtime.getRuntime();

			Process process = runTime.exec(adbCommand);
			process.waitFor();

			BufferedReader standardInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader standardOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			s = null;
			while ((s = standardInput.readLine()) != null) {
				System.out.println("This is Readline Input : " + s);
				
			}

			while ((s = standardOutput.readLine()) != null) {
				System.out.println("This is Readline Output : " + s );
				
			}
			return standardInput;
	}

	public BufferedReader getAndroidDeviceVersion() throws IOException, InterruptedException {

		String[] adbCommand = { "./adbtools/adb", "shell", "getprop",
				"ro.build.version.release" };
		Runtime runTime = Runtime.getRuntime();

		Process process = runTime.exec(adbCommand);
		process.waitFor();

		BufferedReader standardInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader standardOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		// Read Output from the command
		String s = null;
		while ((s = standardInput.readLine()) != null) {
			System.out.println(s);
		}

		while ((s = standardOutput.readLine()) != null) {
			System.out.println(s);
		}
		return standardInput;

	}
}
