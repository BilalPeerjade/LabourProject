package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;




public class LoginMethods extends BasePage {
	private static WebElement uname = null;			//WebElement variable created for Username input 
	private static WebElement pass = null;			//WebElement variable created for Password input
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	private static WebElement QALink = null;		//WebElement variable created for Question Answer link after comes up after login
	private static WebElement question1 = null;		//WebElement variable created for question1 element
	private static WebElement question2 = null;		//WebElement variable created for question2 element
	private static WebElement ans1 = null;			//WebElement variable created for Answer1 input
	private static WebElement ans2 = null;			//WebElement variable created for Answer2 input
	private static WebElement validate = null;		//WebElement variable created for Answer Submit/Validate button
	private static WebElement comp_img = null;		//WebElement variable created for Compliance Image click
	
	public static WebElement setUname(WebDriver driver)		//Method for searching Username input
	{
		uname = driver.findElement(By.xpath("//*[@id='txtemail']"));
		return uname;
	}
	
	public static WebElement setPassword(WebDriver driver)	//Method for searching Password input
	{
		pass =driver.findElement(By.xpath("//*[@id='txtpass']"));
		return pass;
	}
	
	public static WebElement clickSubmit(WebDriver driver)	//Method for searching button for Save/Sign-in
	{
		submit = driver.findElement(By.xpath("//input[@name='Submit']"));
		return submit;
	}

	
	public static void UserLogin(String username, String password) throws InterruptedException
	{		
		//WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
		
		LoginLocators.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(3000);
		LoginLocators.setPassword().sendKeys(password);	//Sent password to input box
		Thread.sleep(3000);
		LoginLocators.clickSubmit().click();				//Clicked on Sign-in button
		Thread.sleep(3000);
		
}
}
