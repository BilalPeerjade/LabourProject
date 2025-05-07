package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import distributor.DistributerMethods;
import login.BasePage;
import performer.PerformerMethod;
import reviewer.ReviewerMethod;



public class ReviewerTestCases extends BasePage
{
	
	public static String link = "mgmt1";  
	

	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\ReviewerLogin.html",true);
		test = extent.startTest("Loging In -Reviewer");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,2,"Statutory");
	}
	
	//====================================My Document-Statutory document==================================================

	@Test(priority =1)
	void StatutoryDocApplyClaerBtn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Apply Button and clear Verification");
		
		
		ReviewerMethod.StatutoryDocApplyClaerBtn(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =2)
	void StatutoryDocFilter() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Filter Verification");
		
		
		ReviewerMethod.StatutoryDocFilter(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =3)
	void StateDocZipFile() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Branch -Registor Compliance Type -Action Column -Zip File Verification");
		
		
		ReviewerMethod.StateDocZipFile(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =4)
	void StateDownloadDoc() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Branch -Registor Compliance type-Action Column -Download Doc Verification");
		
		
		ReviewerMethod.StateDownloadDoc(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =5)
	void StatutoryDocViewandOverview() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Branch - Registor Compliance type -Action Column -Overview and view button Verification");
		
		
		ReviewerMethod.StatutoryDocViewandOverview(test);
		
		extent.endTest(test);
		extent.flush();

	}
	
	@Test(priority =6)
	void StatutoryDocZipFile() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-State -Registor Compliance Type -Action Column -Zip File Verification");
		
		
		ReviewerMethod.StatutoryDocZipFile(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =7)
	void StatutoryDocDownloadDoc() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-State -Registor Compliance type-Action Column -Download Doc Verification");
		
		
		ReviewerMethod.StatutoryDocDownloadDoc(test);
		
		extent.endTest(test);
		extent.flush();

	}
	
	
	
	@Test(priority =8)
	void ChallanDocDownload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Branch -Challan Compliance type-Action Column -Download Doc Verification");
		
		
		ReviewerMethod.ChallanDocDownload(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =9)
	void ChallanDocViewandOverview() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Branch -Challan Compliance type-Action Column -Overview and view button Verification");
		
		
		ReviewerMethod.ChallanDocViewandOverview(test);
		
		extent.endTest(test);
		extent.flush();

	}

	@Test(priority =10)
	void ChallanComplianceDocDownload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Compliance -Challan Compliance type-Action Column -Download Doc Verification");
		
		
		ReviewerMethod.ChallanComplianceDocDownload(test);
		
		extent.endTest(test);
		extent.flush();

	}
	@Test(priority =11)
	void ChallanComplianceDocViewandOverview() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutoty Document-Compliance -Challan Compliance type-Action Column -Overview and view button Verification");
		
		
		ReviewerMethod.ChallanComplianceDocViewandOverview(test);
		
		extent.endTest(test);
		extent.flush();

	}
	
	//-------------------------Onboard Entity---------------------------------

	@Test(priority =12)
	void OnBoardEntityExport() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("OnBoard Entity- Export Button verfication");
		
		
		ReviewerMethod.OnBoardEntityExport(test);
		
		extent.endTest(test);
		extent.flush();

	}
	
	//------------------------------Manage Masters---------------------------
	
	@Test(priority =13)
   	void UploadSealandSignature() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("State-City Master -Upload Seal and Signature verification");
   		
   		
   		ReviewerMethod.UploadSealandSignature(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
@Test(priority =14)
   	void AddDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Add Designation master verification");
   		
   		
   		ReviewerMethod.AddDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority =15)
   	void DuplicateDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Duplicate Designation verification");
   		
   		
   		ReviewerMethod.DuplicateDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =16)
   	void DesignationExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Export Button verification");
   		
   		
   		ReviewerMethod.DesignationExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =17) 
   	void BulkUploadDesignation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("Designation Master-Bulk Upload verification");
   		
   		
   		ReviewerMethod.BulkUploadDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =18) 
	void BulkUploadDesignationDetailes() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Designation Master-Bulk Upload designation Detailes verification");
		
		
		ReviewerMethod.BulkUploadDesignationDetailes(test, workbook);
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =19)
   	void DeleteDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Delete Designation verification");
   		
   		
   		ReviewerMethod.DeleteDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
		@Test(priority =20)
   	void DesignationClearBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Clear Button verification");
   		
   		
   		ReviewerMethod.DesignationClearBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	
	
	@AfterMethod

	void Close()
	{
		 getDriver().close(); 
	}


}
