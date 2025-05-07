package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Methods;
import clientPortal.All_ClientPortal_Methods;
import clientPortal.All_ClientPortal_Methods;
import login.BasePage;
import rcp.OneCommonMethod;

//Take screenshot
import org.testng.ITestResult;



public class FailedTC2 extends BasePage {
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\FailedTC2.html",true);
		test = extent.startTest("Loging In - Client Portal"); // Need to change
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,6,"Statutory"); //Need to change
	
	}
	
	
	
	
	
	
	
	
	

	
	
//	@Test(priority = 3) 
	void EntitiesTabPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify Entities tab Paginations are working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.EntitiesTabPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 27)
	void exportERE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportERE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 13) // Bilal done 2 TC
	void assignedSelectActFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Select Act & Apply button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.assignedSelectActFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 32)//05/02/2025 Pass
	void ViewAddNewNotices() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - View - add new button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ViewAddNewNotices(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 73) //Bilal 6 Done
	void RegistrationActiveEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - InitiateAction Back button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 94) //25/02/2025
	void RegistrationSHistoryViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - View and Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryViewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 123) //Bilal - Fail raised an issue
	void RSG_ExpiredHistoryViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - History - View and Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredHistoryViewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 200) 
	void InputUploadFilters() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - To check weather All dropdowns are working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadFilters(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 210)  
	void IUHistoryD() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Attendance - History - Input History get downloaded or not");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 219)  
	void IUHistoryDSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - History - Input History get downloaded or not");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 220)  
	void IUFianlUploadDownload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Attendance and Salary Final Upload download or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUFianlUploadDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 221)  
	void IUFianlUploadDownloadSalary() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Salary Final Upload download or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUFianlUploadDownloadSalary(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 232) //Bilal
	void InputUploadReturn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate to download template and upload file.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadReturn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 233) //Bilal (Need to Check with Mayuri)getting failed
	void InputUploadReturnOtherUp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate to upload Other Files.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadReturnOtherUp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 240)  
	void IUHistoryDRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Return - Salary - History - Input History get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 256)
   	void RegisrationRespository() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - View and Download Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.RegisrationRespository(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	
   	@Test(priority = 266) //Bilal TC 5
   	void NoticeEditDocumentRepositoryDownload() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Check weather documents in document repository is downloaded or not?");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.NoticeEditDocumentRepositoryDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	
   	
   	

	@Test(priority = 290)
	void CriticalDocumentNewFile() throws InterruptedException, IOException, AWTException {
		test = extent.startTest("Critical Document - Check to Add/Upload New File");
		All_ClientPortal_Methods.filterEntityAUTO2(test);

		All_ClientPortal_Methods.CriticalDocumentNewFile(test);

		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	void browserClosing(ITestResult result) throws InterruptedException
  	{	
		
//	    boolean isFailed = result.getStatus() == ITestResult.FAILURE;
//	    OneCommonMethod.captureScreenshotOnFailure(getDriver(), test, isFailed); // call to your common method
		
	    
	    boolean isFailed = result.getStatus() == ITestResult.FAILURE;
	    OneCommonMethod.captureScreenshotOnFailure(getDriver(), test, isFailed); // Your common method call
	    Thread.sleep(3000);
		closeBrowser();
  		//Thread.sleep(1000);
  		//getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}
	
	
	
	
	
	
}