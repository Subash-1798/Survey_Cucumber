package pageobjectsmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Survey_Home {
	
	

public static WebElement Sidebutton(WebDriver driver) {
		
		return driver.findElement(By.xpath("//div[@class=\"digi-side-toggle digi-side-left-min\"]"));
	}
	
	

	
    public static WebElement SurveyManagement(WebDriver driver) {
    	return driver.findElement(By.xpath("//div[text()='Survey Management']"));
		
		
		
	}
    
    public static WebElement Surveybank(WebDriver driver) {
    	return driver.findElement(By.xpath("//button[text() = 'Survey Bank']"));
    
    

}
    public static WebElement SurveyTemplate(WebDriver driver) {
    	return driver.findElement(By.xpath("//button[text()='Survey Templates']"));
    
   
}
    public static WebElement courselevel(WebDriver driver) {
    	return driver.findElement(By.xpath("//button[text() = 'Course level']"));
    
   
}
	

    
    
}
