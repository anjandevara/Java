package com.android.anjan.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author adevara
 *
 */
public class _Application_ extends Appium_Capabilities{

	/**
	 * Finding the object on the Application Screen its using resource_id.
	 *
	 */

	public WebElement findElementById(String resource_id) {
		return androidDriver.findElement(By.id(resource_id));
	}
	
	public WebElement findElementByClass(String className) {
		return androidDriver.findElement(By.className(className));
	}

	@SuppressWarnings("unchecked")
	public List<WebElement> findElementListByID(String resource_id) {
		return (List<WebElement>) androidDriver.findElement(By.className(resource_id));
	}
	public WebElement findElementByText(String text) {
		return androidDriver.findElement(By.name(text));
	}
	
//	public void swipeHorizontally() {
//		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
//		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
//		swipeObject.put("startX", 712.00);
//		swipeObject.put("startY", 1050.00);
//		swipeObject.put("endX", 8.00);
//		swipeObject.put("endY", 80.00);
//		swipeObject.put("duration", 1.8);
//		js.executeScript("mobile: swipe", swipeObject);
//	}
}
