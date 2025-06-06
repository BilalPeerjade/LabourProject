package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
import distributor.MethodsD;
import clientPortal.All_ClientPortal_Methods;
import clientPortal.All_ClientPortal_Methods;
import login.BasePage;
import performer.PerformerMethod;
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
	
	//Client Portal Before Method
/*	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,6,"Statutory"); //Need to change
	
	} */
	
	//Performer Before Method
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,1,"Statutory");
		
		XSSFSheet sheet = ReadExcel(count);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
	
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
	
	
	}
	
	
	
	
	
	
	//---Manage Masters---
	
	@Test(priority = 50) //Bilal
   	void StateCitySearch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
   		
   		PerformerMethod.StateCitySearch(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 51) //Bilal
   	void DesignationSearch() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
   		   		
   		PerformerMethod.DesignationSearch(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
    @Test(priority = 52)
   	void AddDesignation() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Designation - Verify Add New Designation Error is throwing or not?");
   		
   		PerformerMethod.AddDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 53) //Fail
   	void DesignationExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Export Button verification");
   		
   		PerformerMethod.DesignationExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   
    @Test(priority = 54) //Pass
   	void DeleteDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - Designation - Verify to Delete/Inactive Designation");
   		
   		PerformerMethod.DeleteDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
	@Test(priority = 55)
   	void DesignationClearBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Clear Button verification");
   		
   		PerformerMethod.DesignationClearBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
	@Test(priority = 56) //Bilal 
   	void LeaveTypeSearch() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Leave Type - Verify to check Search Leave Type dropdown is working or not?");
   		   		
   		PerformerMethod.LeaveTypeSearch(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 57) //Bilal
   	void PaycodeMappingSearchField() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check Add New error is displayed or not?");
   		   		
   		PerformerMethod.PaycodeMappingSearchField(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 58) //Bilal
   	void PaycodeMappingAddNew() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check Add New error is displayed or not?");
   		   		
   		PerformerMethod.PaycodeMappingAddNew(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 59) //Bilal
   	void PaycodeMappingEditUpdate() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode is editable or not?");
   		   		
   		PerformerMethod.PaycodeMappingEditUpdate(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 60) //Bilal 
   	void PaycodeMappingUpload() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode Upload or not?");
   		   		
   		PerformerMethod.PaycodeMappingUpload(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 61) //Bilal
   	void MastersStaturyDoc() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Statutory Master - Verify to check Exports with all Compliance Types are working or not?");
   		   		
   		PerformerMethod.MastersStaturyDoc(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
//	@Test(priority = 61) //Bilal  hide this due to in PT Location data is not reflecting
   	void ChallanPTSlab() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Challan PT Slab - Verify the Employee is mapping or not?");
   		   		
   		PerformerMethod.ChallanPTSlab(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
   	
   	
   	
   	
   	//Onboard Employee:--
   	
    @Test(priority = 100)
 	void SearchFilerEmp() throws InterruptedException, IOException
 	{
 		test = extent.startTest("OnBoard Employee - Search filter verification");
 		
 		PerformerMethod.SearchFilerEmp(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
    
    
    
    
   	//Premises Master / OnBoard Entity---
	@Test(priority = 150)
	void OnBoardEntitySearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("OnBoard Entity - Verify to check search field is working or not?");
		
		PerformerMethod.OnBoardEntitySearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
   	@Test(priority = 151)
   	void OnBoardEntityExport() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBoard Entity - Export Button verfication");
   		
   		PerformerMethod.OnBoardEntityExport(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   	
   	@Test(priority = 152)
   	void onBoardEntityPremiseViewBtn() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBoard Entity- triangle button -Premise details frame verfication");
   		
   		PerformerMethod.onBoardEntityPremiseViewBtn(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	

   	
   	
	

	
	

//	@Test(retryAnalyzer = RetryAnalyzer.class , priority = 27)
	void exportERE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportERE(test);
		
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