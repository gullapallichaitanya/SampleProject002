package com.seleniumPractice;

import java.awt.Desktop;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleClass {
	
	public static void main(String[] args) throws Exception {
		String browserVerion = "103.0.5060.53";
		WebDriver driver;
		String date = "15";
		//driver = WebDriverManager.chromedriver().browserVersion(browserVerion).create();
		//driver = WebDriverManager.chromedriver().create();
		driver = WebDriverManager.edgedriver().create();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		File file = new File("report.html");
		ExtentReports reportEngine = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		reportEngine.attachReporter(sparkReport);
		String xmlData = "<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		String jsonData = "{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		List<String> listData = new ArrayList<>();
		listData.add("Cucumber");
		listData.add("TestNG");
		listData.add("Selenium");
		
		Map<Integer, String> mapData = new HashMap<>();
		mapData.put(1, "Cucumber");
		mapData.put(2, "TestNG");
		mapData.put(3, "Selenium");
		
		Set <Integer> setData = mapData.keySet();
		/*
		 * ExtentTest test1 = reportEngine.createTest("Test 1"); test1.pass("Pass");
		 */
		/*reportEngine.createTest("Test 1")
		.log(Status.INFO, "Test 1 Info 1")
		.log(Status.PASS, "<b><i>Test 1 Pass</i></b>")
		.log(Status.FAIL, "Test 1 Failed")
		.log(Status.WARNING, "Test 1 Warning")
		.log(Status.SKIP, "Test SKIP");
		reportEngine.createTest("XML Test")
		.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		reportEngine.createTest("JSON Test")
		.log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		reportEngine.createTest("List Test")
		.info(MarkupHelper.createOrderedList(listData))
		.log(Status.INFO, MarkupHelper.createUnorderedList(listData));
		
		reportEngine.createTest("Map Test")
		.info(MarkupHelper.createOrderedList(mapData))
		.log(Status.INFO, MarkupHelper.createUnorderedList(mapData));
		
		reportEngine.createTest("Set Test")
		.info(MarkupHelper.createOrderedList(setData))
		.log(Status.INFO, MarkupHelper.createUnorderedList(setData));
		
		reportEngine.createTest("Highlighted Log")
		.log(Status.INFO, MarkupHelper.createLabel("This is a highlited message", ExtentColor.LIME));
		
		try {
			int i = 5/0;
		} catch (Exception e){
			reportEngine.createTest("Exception Test 1")
			.log(Status.FAIL, e);
		}
		
		RuntimeException t = new RuntimeException("This is a custom Exception");
		reportEngine.createTest("Runtime Exception Test")
		.log(Status.FAIL, t);*/
		
				
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.id("first_date_picker")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\Test.png");
		FileUtils.copyFile(src, dest);
		//dest.getAbsolutePath();
		
		reportEngine.createTest("Test Level Screenshot", "Add screenshot using image path")
		.info("Add Screenshot using image")
		.addScreenCaptureFromPath(dest.getAbsolutePath());
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+date+"']")).click();
		String base64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		reportEngine.createTest("Test Level Screenshot", "Add Screenshot using base64")
		.info("using base 64")
		.addScreenCaptureFromBase64String(base64);
		reportEngine.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
		driver.quit();
		
	}

}
