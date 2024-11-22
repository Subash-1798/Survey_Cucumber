package student_Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Student_Login {
	
	
	
     public static WebElement username(WebDriver incognitoDriver) {
		
		return incognitoDriver.findElement(By.xpath("//input[@class='floating-input ']"));
		
		
	} 
	
     public static WebElement Password(WebDriver incognitoDriver) {
 		
 		return incognitoDriver.findElement(By.xpath("//input[@type='password']"));
 		
 		
 	}
 	
     public static WebElement Submit(WebDriver incognitoDriver) {
 		
 		return incognitoDriver.findElement(By.xpath("//button[@type='submit']"));
 		
 		
 	}
     
     
     public static WebElement studentsideicon(WebDriver incognitoDriver) {
 		
 		return incognitoDriver.findElement(By.xpath("//div[@class='digi-side-toggle digi-side-left-min']"));
 		
 		
 	}
     
     
     public static WebElement survey(WebDriver incognitoDriver) {
 		
 		return incognitoDriver.findElement(By.xpath("(//a[@class='d-flex align-items-center TreeActive-inactive '])[2]"));
 		
 		
 	}
     
      public static WebElement Mysurvey(WebDriver incognitoDriver) {
 		
 		return incognitoDriver.findElement(By.xpath("//a/div[text()='My Survey']"));
 		
 		
 	}
     
      public static WebElement Courselevel(WebDriver incognitoDriver) {
  		
  		return incognitoDriver.findElement(By.xpath("//button[text()='Course level']"));
  		
  		
  	}
     
     
	

}
