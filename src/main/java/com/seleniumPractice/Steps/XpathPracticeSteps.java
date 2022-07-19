package com.seleniumPractice.Steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class XpathPracticeSteps {
	WebDriver driver;
	
	@Given("launch the application")
	public void launch_the_application() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-site-isolation-trials");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com");
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@When("landed in homepage")
	public void landed_in_homepage() {
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='hub-home']//a")).isDisplayed());
	}
	
	@Given("practice menu is avaiable in category menu") 
	public void is_practice_menu_visible(){
		boolean menuAvailable = driver.findElement(By.xpath("//div[@id='menu']//a[text()='Selenium Practice']")).isDisplayed();
		Assert.assertTrue(menuAvailable);
	}

	@When("navigate to xpath practice page")
	public void navigate_to_xpath_practice_page() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement seleniumPracticeMenu = driver.findElement(By.xpath("//div[@id='menu']//a[text()='Selenium Practice']"));
		Actions action = new Actions(driver);
		action.moveToElement(seleniumPracticeMenu).perform();
		WebElement xpathPractice = driver.findElement(By.xpath("//a[text()='XPath Practice']"));
		action.moveToElement(xpathPractice).click().perform();
		System.out.println(":::::::::::::::::: "+ driver.getTitle());
	}

	@Then("^enter firstname \"(.*)\" and lastname \"(.*)\"$")
	public void enter_firstname_and_lastname(String firstname, String lastname) {
	    System.out.println(firstname + " "+ lastname);
	}

	@Then("^Enter email \"(.*)\" and password \"(.*)\"$")
	public void enter_email_and_password(String email, String password) {
		System.out.println(email + " "+ password);
	}

}
