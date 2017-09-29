package com.android.anjan.base;

import java.io.IOException;

public interface DeviceMethods {

	public void shellInput_KeyCode(String inputType, String keyinput);

	public void adb_command(String command, String packageOrFilePath) throws IOException, InterruptedException;

	public void appInstall(String filePath) throws IOException, InterruptedException;

	public void appUninstall(String packageName) throws IOException, InterruptedException;

	public void appUpgrade(String filePath) throws IOException, InterruptedException;

	public void launch_Application(String packageANDactivity);

	public void tapHomeKey();

	public void tapBackKey();

	public void tapTab() throws IOException, InterruptedException;

	public void hideKeyboard() throws IOException, InterruptedException;

	public void userLogin(String loginID) throws IOException, InterruptedException;

	public void userPassword(String password) throws IOException, InterruptedException;

	public void Change_Focus() throws InterruptedException;

	public void Get_Network_State();

	public void Enable_AirplaneMode();

	public void Enable_WiFi();

	public void Enable_Data();

	public void Enable_All_Networks();

	public void identifyCrash(String packageName);

	public String systemDate();

	public void appCrashlog(String appPackage);

	public void appMonkeyTest(String packagename, String numberofevents);

	/**
	 * This method takes the screenshot of the current screen, saves it to the
	 * device Screenshots Folder and then pulls the screenshot from the device,
	 * saves the it to screenshots folder in our project.
	 */
	public void takeScreenshot(String screenshotname);

	public void pullFile(String filename);

	public void findCenterOfTheComponent(int x1, int y1, int x2, int y2);
}
