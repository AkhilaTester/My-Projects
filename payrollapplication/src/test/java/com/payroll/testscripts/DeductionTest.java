package com.payroll.testscripts;

import java.awt.RenderingHints.Key;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import constants.Constants;
import pages.DeductionPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class DeductionTest extends Base{
	
	DeductionPage deductionobj;
	@Test
	public void TC_22_view_Deduction() {
		deductionobj=new DeductionPage(driver);
		deductionobj.click_Deduction_Button();
		deductionobj.click_View_Button();
		Assert.assertEquals(true, deductionobj.view_Page_Title().isDisplayed());
		
		
	}
	
	@Test
	public void TC_23_edit_Deduction() throws IOException {
		deductionobj=new DeductionPage(driver);
		deductionobj.click_Deduction_Button();
		deductionobj.click_Edit_Button();
		deductionobj.select_Worker_First_Field();
		Assert.assertEquals(true, deductionobj.view_Page_Title().isDisplayed());
		deductionobj.select_Worker(ExcelUtility.getString(1, 9,Constants.EXCELFILE, "worker"));
		deductionobj.select_Workerfield(Keys.ENTER);
		deductionobj.click_Save_Button();
		WaitUtility.waitForElement(driver, deductionobj.after_Deduction());
		Assert.assertEquals(true, deductionobj.after_Deduction().isDisplayed());
		
		
	}
	

	@Test
	public void TC_24_add_Deduction() throws IOException {
		deductionobj=new DeductionPage(driver);
		deductionobj.click_Deduction_Button();
		deductionobj.click_Edit_Button();
		deductionobj.select_Worker_First_Field();
		Assert.assertEquals(true, deductionobj.view_Page_Title().isDisplayed());
		deductionobj.select_Worker(ExcelUtility.getString(1, 9,Constants.EXCELFILE, "worker"));
		deductionobj.select_Workerfield(Keys.ENTER);
		deductionobj.select_Deduction_Type();
		deductionobj.get_Amount(String.valueOf(ExcelUtility.getNumeric(1, 10,Constants.EXCELFILE, "worker")));
		deductionobj.click_Save_Button();
		WaitUtility.waitForElement(driver, deductionobj.after_Deduction());
		Assert.assertEquals(true, deductionobj.after_Deduction().isDisplayed());
	}

}
