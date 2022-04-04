package com.payroll.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import constants.Constants;
import pages.ReportPage;
import utilities.ExcelUtility;

public class ReportTest extends Base{
	ReportPage reportobj;
	@Test
	public void TC_28_report_Page_Verification() {
		reportobj=new ReportPage(driver);
		reportobj.click_Report_Button();
		Assert.assertEquals("PAYSLIPS", reportobj.get_pagetitle());
	}
	@Test
	public void TC_29_view_PayReport() throws IOException {
		reportobj=new ReportPage(driver);
		reportobj.click_Report_Button();
		reportobj.click_Select_Worker_field();
		reportobj.select_Worker_List(ExcelUtility.getString(1, 11,Constants.EXCELFILE, "worker"));
		reportobj.select_Worker_List_Enter(Keys.ENTER);
		reportobj.click_Save_Button();

		Assert.assertEquals(true, reportobj.verify_Searched_Worker().isDisplayed());

	}

	@Test
	public void TC_30_view_Company_Performance() {
		reportobj=new ReportPage(driver);
		reportobj.click_Report_Button();
		reportobj.click_Comapny_performence();
		Assert.assertEquals("PERFOMANCE", reportobj.verfiy_page_performane());

	}

	
}
