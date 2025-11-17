package com.lab;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sheet1 {
	public static void main(String[] args)throws InterruptedException {
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--start-maximized");
		// IMPORTANT: headless off
		options.addArguments("--disable-blink-features=AutomationControlled");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://latogo.techsaga.live/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div/div/div/div/button")).click();
		Thread.sleep(2000);*/
		
		ChromeOptions options = new ChromeOptions();
		
		
		//hello
        options.addArguments("--disable-blink-features=AutomationControlled");
        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("https://latogo.techsaga.live/");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='exampleModalCenter']/div/div/div/div/div/div/button")
        )).click();
        
        
        //Register
		/*
		 * driver.findElement(By.xpath("/html/body/div/header/div/nav/div/ul[2]/li[2]/a"
		 * )).click();
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[1]/input")).
		 * sendKeys("Rimjhim ");
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[2]/input")).sendKeys(
		 * "Singh");
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[3]/input")).sendKeys(
		 * "rimjhim098@yopmail.com");
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[4]/input")).sendKeys(
		 * "9162688710");
		 * driver.findElement(By.id("password")).sendKeys("Rimjhim@12345");
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0, 500)"); System.out.
		 * println("⚠️ Please complete the captcha manually within 15 seconds...");
		 * Thread.sleep(15000);
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[7]/label[1]/input")).
		 * click();
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[7]/label[2]/input")).
		 * click(); js.executeScript("arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[8]/button")));
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//*[@id=\"createFrm\"]/div[8]/button")).click();
		 */
    
    //Login
		
	/*
	 * driver.findElement(By.xpath(
	 * "/html/body/div[2]/header/div/nav/div/ul[2]/li[1]/a")).click();
	 * driver.findElement(By.xpath(
	 * "/html/body/div/div[2]/div/div[2]/div/div[2]/form/div[1]/input")).sendKeys(
	 * "rimjhim098@yopmail.com");
	 * driver.findElement(By.id("password")).sendKeys("Rimjhim@12345");
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("window.scrollBy(0, 500)"); Thread.sleep(2000);
	 * driver.findElement(By.xpath(
	 * "/html/body/div/div[2]/div/div[2]/div/div[2]/form/div[4]/button")).click();
	 * driver.findElement(By.id("country_id")).click();
	 * driver.findElement(By.xpath("//*[@id=\"country_id\"]/option[102]")).click();
	 * driver.findElement(By.id("timezone_id")).click();
	 * driver.findElement(By.xpath("//*[@id=\"timezone_id\"]/option[2]")).click();
	 * Thread.sleep(2000); driver.findElement(By.xpath(
	 * "//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
	 */
		
		// Login
     // LOGIN BUTTON CLICK
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/header/div/nav/div/ul[2]/li[1]/a")
        )).click();

        // EMAIL
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email']")
        )).sendKeys("rimjhim098@yopmail.com");

        // PASSWORD
        driver.findElement(By.id("password")).sendKeys("Rimjhim@12345");

        // LOGIN BUTTON
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Login')]")
                )
        );

        // Scroll + click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);

        // WAIT for FULL PAGE LOAD
        wait.until(web -> 
        ((JavascriptExecutor) web).executeScript("return document.readyState").equals("complete")
         );

       // WAIT FOR "User ID" widget (this confirms successful login)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[contains(text(),'User ID')]")
        ));

        System.out.println("🎉 Login Successful — Dashboard Loaded!");
        }
        }
