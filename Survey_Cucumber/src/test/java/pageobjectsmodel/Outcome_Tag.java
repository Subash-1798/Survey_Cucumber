package pageobjectsmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Outcome_Tag {
	
	 
	public static WebElement Moresettings(WebDriver driver) {
		 return driver.findElement(By.xpath("(//button[@title=\"More Settings\"])[4]"));
		
		
	}
	
	public static WebElement CourseOutcome(WebDriver driver) {
		 return driver.findElement(By.xpath("//div[@class=\"pl-4 ml-2\"]"));
		
		
	}
	
	
	public static WebElement selectFramework(WebDriver driver) {
		 return driver.findElement(By.xpath("//div[@class=\"d-flex align-items-center pl-5\"]"));
		
		
	}
	
	public static WebElement Knowledge(WebDriver driver) {
		 return driver.findElement(By.xpath("(//div[@class=\"d-flex align-items-center pl-5 ml-4\"])[1]"));
		
		
	}
	
	
	public static WebElement Clo1checkbox(WebDriver driver) {
		 return driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[5]"));
		
		
	}
	
	
	public static WebElement Tag(WebDriver driver) {
		 return driver.findElement(By.xpath("(//div[@class=\"border d-flex align-items-center justify-content-between p-2 rounded\"])[2]"));
		
		
	}
	
	public static WebElement Tagselection(WebDriver driver) {
		 return driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[8]"));
		
		
	}
	
	public static WebElement particpantsdropdown(WebDriver driver) {
		 return driver.findElement(By.xpath("//label[text()='Medicine Testing']"));
		
		
	}
	
	public static WebElement leveldropdown(WebDriver driver) {
		 return driver.findElement(By.xpath("(//*[@data-testid=\"ExpandMoreIcon\"])[1]"));
		
		
	}
	
	public static WebElement yeardropdown(WebDriver driver) {
		 return driver.findElement(By.xpath("(//*[@data-testid=\"ExpandMoreIcon\"])[2]"));
		
		
	}
	
	
	public static WebElement clock1select(WebDriver driver) {
		 return driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']"));
		
		
	}
	
	
	public static WebElement clock1label(WebDriver driver) {
		 return driver.findElement(By.xpath("//button[@aria-label=\"clock view is open, go to text input view\"]"));
		
		
	}
	
	
	public static WebElement clock2select(WebDriver driver) {
		 return driver.findElement(By.xpath("(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk\"])[2]"));
		
		
	}
	
	public static WebElement clock2label(WebDriver driver) {
		 return driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium MuiPickersToolbar-penIconButton css-1beylcr\"]"));
		
		
	}

}
