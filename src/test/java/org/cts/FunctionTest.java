package org.cts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionTest {
	public WebDriver d;

	@BeforeClass
	public void before() {
		// install chromedriver setup
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();

		// launch the url
		d.get("https://demo.dealsdray.com/");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.manage().window().maximize();
	}

	@Test
	public void tc1() throws IOException, InterruptedException {
		// Enter username and password click login button
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("prexo.mis@dealsdray.com");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("prexo.mis@dealsdray.com");
		d.findElement(By.xpath("//button[text()='Login']")).click();

		// click order dashboard and click bulk order button
		d.findElement(By.xpath("//span[text()='Order']")).click();
		d.findElement(By.xpath("//span[text()='Orders']")).click();
		d.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();

		// uploading excel file
		d.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\VISHNU\\Downloads\\demo-data.xlsx");

		// click import button and validat button
		d.findElement(By.xpath("//button[text()='Import']")).click();
		d.findElement(By.xpath("//button[text()='Validate Data']")).click();

		// accept the alert box
		Thread.sleep(1000);
		Alert a = d.switchTo().alert();
		a.accept();

		// taking screenshot
		Shutterbug.shootPage(d, Capture.FULL, true)
				.save("C:\\Users\\VISHNU\\eclipse-workspace\\WebsiteAutomation\\PrexoScreenShot\\");

	}

}
