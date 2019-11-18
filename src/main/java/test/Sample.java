package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Sample extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		launchBrowser("http://demo.guru99.com/test/drag_drop.html");
		WebElement src = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
		WebElement dec = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
		Actions a = new Actions(driver);
		Thread.sleep(20000);
		a.clickAndHold(src).perform();
		a.moveToElement(dec).perform();
		a.click(dec).perform();
	}
}
