package com.TestNG.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.MasterPageFactory;
import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondClass {
	
	@Test

	public void getLogIn() {
		WebDriverManager.chromedriver().setup();
		
		//Headless/Ghost Broswer
//		ChromeOptions Headless = new ChromeOptions();
//		Headless.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.navigate().to(BaseConfig.getConfigValue("QA_URL"));
		driver.manage().window().maximize();
		
		
		MasterPageFactory mpf = new MasterPageFactory(driver);
		
		//Explicit wait( wait until login btn homepage is loaded
//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(mpf.getLoginBtnHome()));
		
		//Highlight login btn homepage
		Highlighter.addColor(driver, mpf.getLoginBtnHome());
		mpf.getLoginBtnHome().click();
//or		driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
		
		Highlighter.addColor(driver, mpf.getEmailfield());
		mpf.getEmailfield().sendKeys(BaseConfig.getConfigValue("email"));
//or		driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("1996mainul@gmail.com");
		
		Highlighter.addColor(driver, mpf.getPasswirdfield());
		mpf.getPasswirdfield().sendKeys(BaseConfig.getConfigValue("password"));
//or		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Mainul1996");
		
		Highlighter.addColor(driver, mpf.getLoginBtn2());
		mpf.getLoginBtn2().click();
//		driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();	
//		driver.findElement(By.xpath("//button[text()='Login']")).click();//button is a tag name(* means all tag)
//		driver.findElement(By.xpath("(//*[contains(text(),'Login')])[4]")).click();
		
		Screenshot.getScreenShot(driver, "Homepage_AfterLogIn");

}
}
