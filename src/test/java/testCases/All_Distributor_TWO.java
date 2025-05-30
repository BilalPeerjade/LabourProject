package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.All_Distributor_Methods;
import distributor.Methods;
import distributor.All_Distributor_Methods;
import login.BasePage;
import login.LoginLocators;





public class All_Distributor_TWO  extends BasePage {
	
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	public static List<WebElement> elementsList2 = null;
	public static List<WebElement> elementsList3 = null;
	public static List<WebElement> elementsList4 = null;
	public static List<WebElement> menus = null;
	public int count = 0;
	public int interest = 0;					//Variable created for reading Interest
	public int penalty = 0;						//Variable created for reading Penalty
	
	public static String link = "mgmt1";  
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\LabourD.html",true);
		test = extent.startTest("Loging In - DistributorAdmin");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,0,"Statutory");
	
	}

	
	
	    @Test(priority = 1)
		void ComplianceBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on 'Compliance'");
			
			All_Distributor_Methods.complianceBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
	   
		@Test(priority = 2)
		void ComplianceFilter1() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Box Filter Verification'");
			
			All_Distributor_Methods.ComplianceFilter1(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 3)
		void UpcomingBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Upcoming'");
			
			All_Distributor_Methods.UpcomingBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
	
	
	
	
	
	
	
	   
	   
	   
	   
	   
	   
	   
	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//Thread.sleep(1000);
  		//getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}
	
	
	
}
