package pageobjectsmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reports_Page {
	
	
	
	
	public static WebElement Reporticon(WebDriver driver) {
		return driver.findElement(By.xpath("(//div[@class=\"cursor-pointer\"])[2]"));
		
		
 }
	
	public static WebElement ViewReports(WebDriver driver) {
		return driver.findElement(By.xpath("//div[text()='View Reports']"));
		
		
 }
	
	public static WebElement SectionA(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text() = 'Section A']"));
		
		
 }
	public static WebElement staticAnalysis(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text() = 'Statistic Analysis']"));
		
		
 }
	

	public static WebElement viewreports1(WebDriver driver) {
		return driver.findElement(By.xpath("//div/button[text()='View Reports']"));
		
		
 }

	


	

}
