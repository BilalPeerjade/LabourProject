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

import distributor.Methods;
import distributor.MethodsD;
import login.BasePage;
import login.LoginLocators;

public class ReviewerTest extends BasePage {
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Reviewer.html",true);
		test = extent.startTest("Loging In - Reviewer");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,2,"Statutory");
	
	}
	
	
	   @Test(priority = 1)
		void ComplianceBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Compliance'");
			
			MethodsD.complianceBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 2)
		void UpcomingBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Upcoming'");
			
			MethodsD.UpcomingBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 3)
		void OverdueBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Overdue'");
			
			MethodsD.OverdueBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 4)
		void PendingActionBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Action'");
			
			MethodsD.PendingActionBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 5)
		void PendingReviewBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Review'");
			
			MethodsD.PendingReviewBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 6)
		void PendingReviewAction() throws InterruptedException, IOException
		{
			test = extent.startTest("Action Review from pending Review'");
			
			MethodsD.PendingReviewAction(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		/*
		@Test(priority = 7)
		void RegisterUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
			
			Methods.RegisterUpcoming(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 8)
		void RegisterOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
			
			Methods.RegisterOverdue(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 9)
		void RegisterActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
			
			Methods.RegisterActionReview(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 10)
		void ReturnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
			
			Methods.ReturnUpcoming(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 11)
		void ReturnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
			
			Methods.ReturnOverdue(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 12)
		void ReturnActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
			
			Methods.ReturnActionReview(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 13)
		void ChallanUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
			
			Methods.ChallanUpcoming(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 14)
		void ChallanOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
			
			Methods.ChallanOverdue(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 15)
		void ChallanActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
			
			Methods.ChallanActionReview(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 16)
		void Complied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
			
			Methods.Complied(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		*/
		@Test(priority = 15)
		void NotComplied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Not Complied - match verification");
			
			MethodsD.NotComplied(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 21)
		void RiskSummaryNotCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Not Complied - Count Verification");
			
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			//LoginLocators.Search().sendKeys("AVAREGTR");
			LoginLocators.Search().sendKeys("AVACORED5");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(2000);
		    
			Thread.sleep(3000);
			//int high = Integer.parseInt(LoginLocators.HighRisk().getText());	//Reading Dashboard count.
			int medium = Integer.parseInt(LoginLocators.MediumRisk().getText());	//Reading Dashboard count.
			//int low = Integer.parseInt(LoginLocators.LowRisk().getText());	//Reading Dashboard count.
			
			Thread.sleep(500);
			
//				if(high >= 0)
//				{
//					//Methods.HighRisk(test);
//					Methods.RiskGraph( test, "High", high);
//				}
//				else
//				{
//					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
//				}
				
				if(medium >= 0)
				{
					//js.executeScript("window.scrollBy(0,300)");
					MethodsD.RiskGraph( test, "Medium", medium);
				}
				else
				{
					//js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
//				if(low >= 0)
//				{
//					js.executeScript("window.scrollBy(0,300)");
//					Methods.RiskGraph( test, "Low", low);
//				}
//				else
//				{
//					js.executeScript("window.scrollBy(0,300)");
//					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
//				}
						
				Thread.sleep(5000);
			
				Thread.sleep(2000);
				LoginLocators.Dashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			extent.endTest(test);
			extent.flush();
		}
		/*
		@Test(priority = 22)
		void RiskSummaryCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
			
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		//	LoginLocators.Search().sendKeys("AVAREGTR");
			LoginLocators.Search().sendKeys("AVACORED5");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue1().click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(2000);
		    
			Thread.sleep(3000);
		//	int high = Integer.parseInt(LoginLocators.CompHighRisk().getText());	//Reading Dashboard count.
			int medium = Integer.parseInt(LoginLocators.CompMediumRisk().getText());	//Reading Dashboard count.
		//	int low = Integer.parseInt(LoginLocators.CompLowRisk().getText());	//Reading Dashboard count.
			
			Thread.sleep(500);
			
//				if(high >= 0)
//				{
//					//Methods.HighRisk(test);
//					Methods.CompRiskGraph( test, "High", high);
//				}
//				else
//				{
//					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+high);
//				}
				
				if(medium >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
					Methods.CompRiskGraph( test, "Medium", medium);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
			
//				if(low >= 0)
//				{
//					js.executeScript("window.scrollBy(0,300)");
//					Methods.CompRiskGraph( test, "Low", low);
//				}
//				else
//				{
//					js.executeScript("window.scrollBy(0,300)");
//					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
//				}
						
				Thread.sleep(5000);
			
				Thread.sleep(2000);
				LoginLocators.Dashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 27)
		void ApplicableStatues() throws InterruptedException, IOException
		{
			test = extent.startTest("Applicable Statue verification");
			
			Methods.ApplicableStatues(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 28)
		void DailyUpdate() throws InterruptedException, IOException
		{
			test = extent.startTest("Daily Update verification");
			
			Methods.DailyUpdate(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 29)
		void Report() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Assignment Report ");
			
			Methods.Report(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 30)
		void StatusReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Status Report ");
			
			Methods.StatusReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 31)
		void VariousReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Various Report ");
			
			Methods.VariousReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 32)
		void CLRAAssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("CLRA Assignment Report");
			
			Methods.CLRAAssignmentReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		*/
		
		@Test(priority = 33)
		void MyDocumnent() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Add Registration Repository ");
			
			MethodsD.MyDocumnent(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		/*
		@Test(priority = 34)
		void MyDocumnentExport() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document Export ");
			
			Methods.MyDocumnentExport(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}

		
		@Test(priority = 35)
		void MyDocumentSearch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - search ");
			
			Methods.MyDocumentSearch(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 36)
		void MyDocumnentDigitalSignature() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature ");
			
			Methods.MyDocumnentDigitalSignature(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		*/
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
