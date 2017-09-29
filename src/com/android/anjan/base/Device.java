package com.android.anjan.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.Connection;
//import io.appium.java_client.android.Connection;

/**
 * @author adevara
 *
 */
public class Device extends Appium_Capabilities implements DeviceMethods {

	private static final String KEYCODE_HOME = "3";
	private static final String KEYCODE_MENU = "82";
	private static final String KEYCODE_BACK = "4";
	private static final String KEYCODE_TAB = "61";
	private static final String KEYCODE_ENTER = "66";
	private static final String KEYCODE_KEYBOARD_HIDE = "111";
	private static final int AirplaneMode_On = 1;
	private static final int Wifi_On = 2;
	private static final int Data_On = 4;
	private static final int All_Networks_On = 6;
//	private static Connection ncs;

	public void startAppiumServer() {

		/* Building ADB SHELL Command */
		try {
			List<String> cmd = new LinkedList<String>();
			cmd.add("/usr/local/lib/node_modules/appium/build/lib/main.js");
			// cmd.add("/usr/local/bin/");

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
			//
			// cmd.add("appium");
			// /* Running Command */
			// builder = new ProcessBuilder(cmd);
			// builder.redirectErrorStream(true);
			// p = builder.start();
			// buf = new BufferedReader(new
			// InputStreamReader(p.getInputStream()));
			// // ByteArrayOutputStream bao = new ByteArrayOutputStream();
			// String line2 = "";
			// while ((line = buf.readLine()) != null) {
			// System.out.println(line2);
			// }
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}

	}

	public void stopAppiumServer() {

		/* Building ADB SHELL Command */
		try {
			List<String> cmd = new LinkedList<String>();
			cmd.add("ctrl+shift+c");

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}

	}

	public void shellInput_KeyCode(String inputType, String keyinput) {
		/* Building ADB SHELL Command */
		try {
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("shell");
			cmd.add("input");
			cmd.add(inputType);
			cmd.add(keyinput);

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void adb_command(String command, String packageOrFilePath) throws IOException, InterruptedException {
		/* Building ADB SHELL Command */
		try {
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add(command);
			cmd.add(packageOrFilePath);

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void appInstall(String filePath) throws IOException, InterruptedException {
		try {
			adb_command("install", filePath);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void appUninstall(String packageName) throws IOException, InterruptedException {
		try {
			adb_command("uninstall", packageName);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void appUpgrade(String filePath) throws IOException, InterruptedException {

		/* Building ADB SHELL Command */
		try {
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("install");
			cmd.add("-r");
			cmd.add(filePath);

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void launch_Application(String packageANDactivity) {
		try {
			/* Building ADB SHELL Command */
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("shell");
			cmd.add("am");
			cmd.add("start");
			cmd.add("-n");
			cmd.add(packageANDactivity);

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
			return;
		}

	}

	public void tapHomeKey() {
		try {
			shellInput_KeyCode("keyevent", KEYCODE_HOME);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void tapBackKey() {
		try {
			shellInput_KeyCode("keyevent", KEYCODE_BACK);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void tapTab() throws IOException, InterruptedException {
		try {
			shellInput_KeyCode("keyevent", KEYCODE_TAB);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void tapEnter() throws IOException, InterruptedException {
		try {
			shellInput_KeyCode("keyevent", KEYCODE_ENTER);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}
	
	public void hideKeyboard() throws IOException, InterruptedException {
		try {
			shellInput_KeyCode("keyevent", KEYCODE_KEYBOARD_HIDE);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void userLogin(String loginID) throws IOException, InterruptedException {
		try {
			shellInput_KeyCode("text", loginID);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void userPassword(String password) throws IOException, InterruptedException {
		try {
			shellInput_KeyCode("text", password);
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void Change_Focus() throws InterruptedException {
		try {
			String current_context = androidDriver.getContext();
			if (current_context.contains("NATIVE_APP")) {
				androidDriver.context("WEBVIEW_com.ciphercloud.android.application");
			} else {
				androidDriver.context("NATIVE_APP");
			}
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public void Get_Network_State() {
//		System.out.println(androidDriver.getNetworkConnection());
		System.out.println(androidDriver.getConnection());
	}

	public void Enable_AirplaneMode() {
		androidDriver.setConnection(Connection.AIRPLANE);
//		androidDriver.setNetworkConnection(new NetworkConnectionSetting(AirplaneMode_On));
		Get_Network_State();
	}

	public void Enable_WiFi() {
		androidDriver.setConnection(Connection.WIFI);
//		androidDriver.setNetworkConnection(new NetworkConnectionSetting(Wifi_On));
		Get_Network_State();
	}

	public void Enable_Data() {
		androidDriver.setConnection(Connection.DATA);
//		androidDriver.setNetworkConnection(new NetworkConnectionSetting(Data_On));
		Get_Network_State();
	}

	public void Enable_All_Networks() {
		androidDriver.setConnection(Connection.ALL);
//		androidDriver.setNetworkConnection(new NetworkConnectionSetting(All_Networks_On));
		Get_Network_State();
	}

//	public void Disable_All_Networks() {
////		androidDriver.setConnection(Connection.NONE);
//		androidDriver.setNetworkConnection(new NetworkConnectionSetting(bitmask));
//		Get_Network_State();
//	}
	public void identifyCrash(String packageName) {
		try {
			String activity = androidDriver.currentActivity();
			if (!activity.equals(packageName)) {
				System.out.println("Application Crashed");
				appCrashlog(packageName);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return;
		}
	}

	public String systemDate() {
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println();
		return dateformat.format(date);
	}

	public void appCrashlog(String appPackage) {

		try {

			String systemdate = systemDate();
			/* Building ADB SHELL Command */
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("logcat");
			cmd.add("|");
			cmd.add("grep");
			cmd.add(appPackage);
			cmd.add(">>");
			cmd.add("./crashlogs/Logcat.txt" + systemdate);

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
			return;
		}
	}

	public void appMonkeyTest(String packagename, String numberofevents) {

		try {

			/* Building ADB SHELL Command */
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("shell");
			cmd.add("monkey");
			cmd.add("-p");
			cmd.add(packagename);
			cmd.add("-v");
			cmd.add(numberofevents);
			cmd.add("-s");
			cmd.add("100");

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
			return;
		}

	}

	/**
	 * This method takes the screenshot of the current screen, saves it to the
	 * device Screenshots Folder and then pulls the screenshot from the device,
	 * saves the it to screenshots folder in our project.
	 */
	public void takeScreenshot(String screenshotname) {

		try {
			/* Building ADB SHELL Command */
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("shell");
			cmd.add("screencap");
			cmd.add("/sdcard/DCIM/Screenshots/" + screenshotname);

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}

			pullFile(screenshotname);
		} catch (IOException e) {

			e.printStackTrace();
			return;
		}
	}

	public void pullFile(String filename) {
		try {
			/* Building ADB SHELL Command */
			List<String> cmd = new LinkedList<String>();
			cmd.add("./adbtools/adb");
			cmd.add("pull");
			cmd.add("/sdcard/DCIM/Screenshots/" + filename);
			cmd.add("./screenshots");

			/* Running Command */
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
			return;
		}

	}

	public void findCenterOfTheComponent(int x1, int y1, int x2, int y2) {

		int x = (x1 + x2) / 2;
		int y = (y1 + y2) / 2;

		System.out.println("X : " + x);
		System.out.println("Y :" + y);
	}
}
