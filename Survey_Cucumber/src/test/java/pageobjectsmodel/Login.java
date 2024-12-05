package pageobjectsmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public static WebElement username(WebDriver driver) {
		
		return driver.findElement(By.xpath("//input[@type =\"input\"]")); 
	}
	
	
	public static WebElement  password(WebDriver driver) {
		
		
		return driver.findElement(By.xpath("//input [@type= \"password\"]"));
	}
	
	
    public static WebElement Submit(WebDriver driver) {
		
		return driver.findElement(By.xpath("//button [@type= 'submit']"));
	}
    
    public static WebElement Digiclass (WebDriver driver) {
    	
    	return driver.findElement(By.xpath("//img[@alt=\"DigiClass\"]"));
    }
	
    
    
    
}

