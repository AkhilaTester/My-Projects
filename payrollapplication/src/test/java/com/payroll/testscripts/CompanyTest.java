package com.payroll.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import pages.CompanyPage;

public class CompanyTest extends Base{
	
	CompanyPage companyobj;
	
	@Test
	public void TC_04() throws IOException{
		
		companyobj=new CompanyPage(driver);
		companyobj.clickOnCompany();
		Assert.assertEquals(true, companyobj.verify_Company_Page().isDisplayed());
		
	}
	
	
}
