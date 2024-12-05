package student_Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Student_Preview {
	
	

	        
	       public static WebElement Preview(WebDriver incognitoDriver) {
	    		
	    		return incognitoDriver.findElement(By.xpath("(//button[text()='preview'])[1]"));
	    		
	    	}
	       
	       public static WebElement nextbutton(WebDriver incognitoDriver) {
	    		
	    		return incognitoDriver.findElement(By.xpath("//input[@title=\"Next\"]"));
	    		
	    	}
	       
	           
	       
	       public static WebElement previous(WebDriver incognitoDriver) {
	      		
	      		return incognitoDriver.findElement(By.xpath("//input[@title=\"Previous\"]"));
	      		
	      	}
	       


}
