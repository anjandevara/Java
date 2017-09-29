package com.android.anjan.testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.anjan.base.Device;
import com.android.anjan.base.Get_Device_Properties;
import com.android.anjan.base._Application_;

public class Test_Cases7 extends _Application_ {
	Get_Device_Properties getDeviceProperties = new Get_Device_Properties();
	Device device = new Device();

	@org.testng.annotations.BeforeTest
	public void BeforeTest() throws IOException, InterruptedException {
		// device.appUninstall("com.one20.ota.debug");
		// device.appInstall("./APKFolder/ota-debug.apk");
	}

	@Test
	public void TestingApp() throws IOException, InterruptedException {
		// device.launch_Application("com.one20.ota.debug/com.one20.ota.main.SplashActivity");
		try {
			String name = getDeviceProperties.getAndroidDeviceName().toString();
			deviceName(name);
			//
			// launchApplication("com.google.android.gm","com.google.android.gm.ConversationListActivityGmail");
			//
			launchApplication("com.one20.ota.qa", "com.one20.ota.explore.ExploreActivity");
			connectToAppiumServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// androidDriver.findElement(By.id("com.google.android.gm:id/welcome_tour_got_it")).click();
		// Thread.sleep(10000);

		Thread.sleep(4000);
		device.tapTab();
		device.tapTab();
		device.tapEnter();
		Thread.sleep(4000);
		// device.Change_Focus();
		// WebElement asd =
		// androidDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.one20.ota.qa:id/marketing_splash_login')]"));
		// asd.click();
		try {
			WebElement asd = androidDriver.findElement(By.id("com.one20.ota.qa:id/login_email_field"));
			asd.click();
			device.userLogin("adevara@innominds.com");
			device.hideKeyboard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		try {
			WebElement jdh = androidDriver.findElement(By.id("com.one20.ota.qa:id/login_email_button"));
			jdh.click();
			Thread.sleep(3000);
			device.userPassword("pass@123");
//			device.hideKeyboard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		try {
			WebElement adfj = androidDriver.findElement(By.id("com.one20.ota.qa:id/login_password_submit_button"));
			adfj.click();
			Thread.sleep(10000);
			androidDriver.findElement(By.id("com.one20.ota.qa:id/location_request_next")).click();
			// WebElement search_bar =
			// androidDriver.findElement(By.id("com.one20.ota.qa:id/toolbar"));

			Wait<WebDriver> wait = new FluentWait<WebDriver>(androidDriver).withTimeout(90, TimeUnit.SECONDS)
					.pollingEvery(20, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement searchbar = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver androidriver) {
					return androidDriver.findElement(By.id("com.one20.ota.qa:id/toolbar"));
				}
			});
			
			if (searchbar.isDisplayed()) {
				System.out.println("Login Successful");
			} else {
				System.out.println("Some Error Occurred Duting Login");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			WebElement layers_fab = androidDriver.findElement(By.id("com.one20.ota.qa:id/layers_fab"));
			layers_fab.click();
			
			WebElement button_container = androidDriver.findElement(By.id("com.one20.ota.qa:id/button_container"));
			List<WebElement> imageView = button_container.findElements(By.className("android.widget.ImageView"));
			int layers_list = imageView.size();
			
			for (int i = 0; i < layers_list; i++) {
				System.out.println("The index number of the layer is :: " + imageView.get(i).getAttribute("index"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
