package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	@Test
	public void login() {
		
	    WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        String url = "https://www.lambdatest.com/";
 
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 
 
        WebElement login = driver.findElement(By.linkText("Login"));
        System.out.println("Clicking on the login element in the main page");
        login.click();
 
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
 
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
 
        email.clear();
        System.out.println("Entering the email");
        email.sendKeys("your_email");
 
        password.clear();
        System.out.println("entering the password");
        password.sendKeys("your_password");
 
        System.out.println("Clicking login button");
        loginButton.click();

        String actualTitle = driver.getTitle();
 
        System.out.println("the title is : "+actualTitle);
        driver.quit();
    }
	

}
