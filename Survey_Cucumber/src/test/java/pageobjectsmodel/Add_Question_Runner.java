package pageobjectsmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add_Question_Runner {
	
	
	
	
	public static  WebElement Duplicate(WebDriver driver) {
		
		return driver.findElement(By.xpath("(//span[text()='Duplicate'])[2]"));
		
	}
	
    public static  WebElement Required(WebDriver driver) {
		
		return driver.findElement(By.xpath("(//span[text()='Required'])[2]"));
		
	}
	
    public static  WebElement Delete(WebDriver driver) {
		
		return driver.findElement(By.xpath("(//span[text()='Delete'])[3]"));
		
	}
    
    public static  WebElement CreateTemplateSurvey (WebDriver driver) {
		
		 return driver.findElement(By.xpath("//button[text()=\"Create Template Survey\"]"));
	}
    
    
    public static  WebElement RunSurvey (WebDriver driver) {
		
		 return driver.findElement(By.xpath("(//button[text()='Run Survey'])[1]"));
	}
    
    public static  WebElement Selectprogram (WebDriver driver) {
		
		 return driver.findElement(By.xpath("//div/span[text()='Select Program']"));
	}
	
    public static  WebElement programname(WebDriver driver) {
		
		 return driver.findElement(By.xpath("//li[text() = 'MT007 - Medicine Testing']"));
	}
	
    public static  WebElement selectTerm(WebDriver driver) {
		
		 return driver.findElement(By.xpath("//div/span[text() = 'Select Term']"));
	}
    
    public static  WebElement Regular(WebDriver driver) {
		
		 return driver.findElement(By.xpath("//li[text()='Regular']"));
	}
    
    public static  WebElement Selectyear(WebDriver driver) {
		
		 return driver.findElement(By.xpath("//div/span[text()='Select Year']"));
	}
    
    public static WebElement Year(WebDriver driver) {
		return driver.findElement(By.xpath("//li[contains(@data-value,'year2')]"));
		
		
	}
	
	public static WebElement SelectLevel(WebDriver driver) {
		return driver.findElement(By.xpath("//div/span[text()='Select Level']"));
		
		
	}
	
	public static WebElement Level(WebDriver driver) {
		return driver.findElement(By.xpath("//li[text()='Level 4']"));
		
		
	}
	
	public static WebElement SelectCourse(WebDriver driver) {
		return driver.findElement(By.xpath("//div/span[text()='Select Course']"));
		
		
	}
	
	public static WebElement Coursename(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-35ms2r\"]"));
		
		
	}
	
	
	public static WebElement Surveyversionname(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@placeholder=\"Enter Survey version name\"]"));
		
		
	}
    
	public static WebElement Overview(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text() = 'Overview']"));
		
		
	}
    
	public static WebElement courseOverview(WebDriver driver) {
		return driver.findElement(By.xpath(".//button[text()='Course level']"));
		
		
	}
    
    
    

}
