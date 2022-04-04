package com.payroll.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import constants.Constants;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import pages.WorkersPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class WorkersTest  extends Base{
	WorkersPage workerobj;
	@Test(dataProvider = "get_searchdata_Workers")
	public void TC_12_search_Worker(String fname,String lname,String post,String mi) {
		workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		WaitUtility.waitForElement(driver,workerobj.search_first_name);
		workerobj.get_First_Name(fname);
		workerobj.get_Last_Name(lname);
		workerobj.get_Postcode(post);
		workerobj.get_Ni_Number(mi);
		workerobj.search_Button();
	//	WaitUtility.waitForElementClickable(driver, workerobj.view_Button());
		if(workerobj.search_Result_Valid_Msg().isDisplayed()) {
			Assert.assertEquals(true,workerobj.valid_Search_Verification().isDisplayed() );

		}
		else if (workerobj.search_Invalid_Msg().isDisplayed()) {
			WaitUtility.waitForElement(driver, workerobj.search_Invalid_Msg());
			Assert.assertEquals(true, workerobj.search_Invalid_Msg().isDisplayed());

		}
	}

	@Test
	public void TC_13_create_New_Worker() throws IOException, InterruptedException {
		workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		WaitUtility.waitForElement(driver,workerobj.worker_Tiltle_Name());
		workerobj.create_New_Worker_Button();
		workerobj.select_Worker_Title();
		workerobj.select_Gender();
		workerobj.select_Branch(workerobj.getText_Branch());
		workerobj.create_Firstname(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.create_Lastname(ExcelUtility.getString(1, 1, Constants.EXCELFILE, "worker"));

		//WaitUtility.waitForElement(driver, workerobj.firstName_Field());
		workerobj.select_Division();
		workerobj.select_Type();
		workerobj.select_PaySlip_Method();
		workerobj.select_engage_Status();
		PageUtility.ScrollBy(driver);
		// System.out.println(prop1.getProperty("dob"));
		workerobj.dob().sendKeys(prop1.getProperty("dob"));
		workerobj.get_Phone(String.valueOf(ExcelUtility.getNumeric(1, 3, Constants.EXCELFILE, "worker")));
		workerobj.get_Email(ExcelUtility.getString(1, 5, Constants.EXCELFILE, "worker"));
		workerobj.get_add1(ExcelUtility.getString(1, 2, Constants.EXCELFILE, "worker"));
		workerobj.get_Post_Code(String.valueOf(ExcelUtility.getNumeric(1, 6, Constants.EXCELFILE, "worker")));
		workerobj.create_Ni_Number(ExcelUtility.getString(1, 4, Constants.EXCELFILE, "worker"));
		WaitUtility.waitForElementClickable(driver, workerobj.Next_Buttton_Click());
		workerobj.submit_Fisrtpage_Createworker();
		Assert.assertEquals(true, workerobj.verify_Worker_Create().isDisplayed());

	}


	@Test
	public void TC_14_verify_Mandatoryfield_Submission() throws InterruptedException {
		workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		WaitUtility.waitForElement(driver,workerobj.worker_Tiltle_Name());
		workerobj.create_New_Worker_Button();
		workerobj.select_Worker_Title();
		PageUtility.ScrollBy(driver);
		workerobj.submit_Fisrtpage_Createworker();
		Assert.assertEquals(true, workerobj.mandatory_Blank_Msg().isDisplayed());

	}

   @Test
   public void TC_15_view_Worker() throws IOException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
		workerobj.worker_View_Button();
		Assert.assertEquals(true, workerobj.get_View_Page_Titile().isDisplayed());
	   
   }
 
  @Test
   public void TC_16_view_Worker_Bankdeatils() throws IOException, InterruptedException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
		Thread.sleep(2000);
		WaitUtility.waitForElementClickable(driver, workerobj.view_Button());
		workerobj.worker_View_Button();
		workerobj.bankdetails_Viewbutton_Click();
		Assert.assertEquals(true, workerobj.bankdetails_Titile_Get().isDisplayed());
	   
   }
   
  @Test
   public void TC_17_view_Worker_Payslip_History() throws IOException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
		WaitUtility.waitForElementClickable(driver, workerobj.view_Button());
		workerobj.worker_View_Button();
		workerobj.click_Payslip_History_Button();
		Assert.assertEquals(true, workerobj.get_Payslip_History_Title().isDisplayed());
	   
   }
  @Test
   public void TC_18_view_Worker_Timesheet_History() throws IOException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
		WaitUtility.waitForElementClickable(driver, workerobj.view_Button());
        workerobj.worker_View_Button();
		workerobj.click_TimeSheet_History_Button();
		Assert.assertEquals(true, workerobj.get_Timesheet_History_Title().isDisplayed());

	   
   }
   
   @Test
   public void TC_19_view_Worker_Deduction_History() throws IOException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
		WaitUtility.waitForElementClickable(driver, workerobj.view_Button());

		workerobj.worker_View_Button();
		workerobj.click_Deduction_History_Button();
		Assert.assertEquals(true, workerobj.get_Deduction_History_Title().isDisplayed());

	   
   }
   
   @Test
   public void TC_20_view_Worker_Rate() throws IOException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
		WaitUtility.waitForElementClickable(driver, workerobj.view_Button());

		workerobj.worker_View_Button();
		workerobj.click_Rate_Button();
		workerobj.click_View_Rate_Button();
		workerobj.get_Name_Search_Rate(ExcelUtility.getString(1, 7, Constants.EXCELFILE, "worker"));
	   
   }
   
   @Test
   public void TC_21_edit_Worker_details() throws IOException {
	   workerobj=new WorkersPage(driver);
		workerobj.worker_Page_Button();
		workerobj.get_First_Name(ExcelUtility.getString(1, 0,Constants.EXCELFILE, "worker"));
		workerobj.search_Button();
     	workerobj.click_On_WorkerEdit_Button();
     	WaitUtility.waitForElement(driver, workerobj.edit_Page_Title());
     	workerobj.update_Add1_Field(ExcelUtility.getString(1, 8, Constants.EXCELFILE, "worker"));
	    PageUtility.ScrollBy(driver);
     	workerobj.click_Edit_Next_Button();
     	Assert.assertEquals(true, workerobj.verify_Worker_Create().isDisplayed());
   }
   

	@DataProvider
	public Object[][] get_searchdata_Workers()	{

		Object[][] searchdata= new Object[2][4];
		searchdata[0][0]="Akhila";
		searchdata[0][1]="Mathew";
		searchdata[0][2]="123";
		searchdata[0][3]="A123";

		searchdata[1][0]="Dennis123";
		searchdata[1][1]="Benny123";
		searchdata[1][2]="BN23 5RL2";
		searchdata[1][3]="SZ593292A1";

		return searchdata;	




	}







}
