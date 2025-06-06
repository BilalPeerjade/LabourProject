package performer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class LocatorsP extends BasePage {
	
	
	private static WebElement uname = null;			//WebElement variable created for Username input 
	private static WebElement pass = null;			//WebElement variable created for Password input
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	
	public static WebElement HighRisk1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(21) > text"));
		return submit;
	}
	
	
	public static WebElement MediumRisk1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(24) > text"));
		return submit;
	}
	public static WebElement LowRisk1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(27) > text"));
		return submit;
	}
	
	public static WebElement CompHighRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(4) > g > g:nth-child(1) > g > g:nth-child(1) > path"));
		return submit;
	}
	
	public static WebElement CompMediumRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(4) > g > g:nth-child(2) > g > g:nth-child(1) > path:nth-child(1)"));
		return submit;
	}
	public static WebElement CompLowRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(4) > g > g:nth-child(3) > g > g:nth-child(1) > path:nth-child(1)"));
		return submit;
	}
	
	
	
	
	
	
	
	
	
}
