package pageobjectsmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Survey_Creation {
	
public static WebElement CreateSurvey(WebDriver driver) {
		
		return driver.findElement(By.xpath("//button[text()='Create Survey']"));
		
	}
    public static WebElement CreateTemplate(WebDriver driver) {
		
		return driver.findElement(By.xpath("//div[text()='Create Template']"));
		
	}
    
    public static WebElement EnterSurveyTitle(WebDriver driver) {
		
		return driver.findElement(By.xpath("//input[@placeholder=\"Enter Survey Title\"]"));
		
	}
    
    public static WebElement EnterDescription(WebDriver driver) {
		
		return driver.findElement(By.xpath("//textarea[@placeholder=\"Enter Description\"]"));
		
	}
	
    public static WebElement SurveyLevel(WebDriver driver) {
		
		return driver.findElement(By.xpath("(//input[@type=\"radio\"])[3]"));
		
	}
    
    public static WebElement Surveytypeselection(WebDriver driver) {
		
		return driver.findElement(By.xpath("//div[@role=\"combobox\"]"));
		
	}
    
    public static WebElement Surveytype(WebDriver driver) {
		
		return driver.findElement(By.xpath("//label[text()='Automation final testing']"));
		
	}
    
    public static WebElement LearningOutcome(WebDriver driver) {
		
		return driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
		
	}
    
     public static WebElement MappingOutcome(WebDriver driver) {
		
		return driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]"));
		
	}
     
     public static WebElement TagMapping(WebDriver driver) {
 		
 		return driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[4]"));
 		
 	}
     
    
     public static WebElement StartCreation(WebDriver driver) {
 		
 		return driver.findElement(By.xpath("//button[text()='Start Creation']"));
 		
 	}



}
