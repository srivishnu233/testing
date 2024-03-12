
package org.cts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleChrome {
	public WebDriver d;

	@BeforeClass
	public void before() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("https://www.getcalley.com/page-sitemap.xml");
		Dimension d1 = new Dimension(1920, 1080);
		d.manage().window().setSize(d1);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test
	public void tc1() throws IOException {

		d.findElement(By.xpath("//a[text()='https://www.getcalley.com/']")).click();
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\VISHNU\\eclipse-workspace\\WebsiteAutomation\\ChromeScreenShot\\ss1.png");
		FileUtils.copyFile(src, des);

	}

	@Test
	public void tc2() throws IOException {

		d.findElement(By.xpath("//a[text()='https://www.getcalley.com/calley-call-from-browser/']")).click();
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\VISHNU\\eclipse-workspace\\WebsiteAutomation\\ChromeScreenShot\\ss2.png");
		FileUtils.copyFile(src, des);
	}

	@Test
	public void tc3() throws IOException {

		d.findElement(By.xpath("//a[text()='https://www.getcalley.com/calley-pro-features/']")).click();
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\VISHNU\\eclipse-workspace\\WebsiteAutomation\\ChromeScreenShot\\ss3.png");
		FileUtils.copyFile(src, des);
	}

	@Test
	public void tc4() throws IOException {

		d.findElement(By.xpath("//a[text()='https://www.getcalley.com/best-auto-dialer-app/']")).click();
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\VISHNU\\eclipse-workspace\\WebsiteAutomation\\ChromeScreenShot\\ss4.png");
		FileUtils.copyFile(src, des);
	}

	@Test
	public void tc5() throws IOException {

		d.findElement(By.xpath("//a[text()='https://www.getcalley.com/how-calley-auto-dialer-app-works/']")).click();
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\VISHNU\\eclipse-workspace\\WebsiteAutomation\\ChromeScreenShot\\ss5.png");
		FileUtils.copyFile(src, des);
	}

	@AfterMethod
	public void aftertest() {
		d.navigate().to("https://www.getcalley.com/page-sitemap.xml");
	}

}
