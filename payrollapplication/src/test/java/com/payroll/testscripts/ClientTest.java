package com.payroll.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import constants.Constants;
import pages.ClientPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ClientTest extends Base{
	ClientPage clientobj;

	@Test(dataProvider = "searchClient")	
	public void TC_06_searchForValidClientAndInvalidClientByName_ID(String name, String id, String msg) throws InterruptedException {
		clientobj=new ClientPage(driver);
		clientobj.clientHomebutton();
		WaitUtility.waitForElement(driver, clientobj.clients_button);
		clientobj.clientSearchbutton();
		clientobj.enter_Search_Name(name);
		clientobj.enter_Search_By_Id(id);
		clientobj.search_Button_Click();
		if(clientobj.valid_Search_Verify().isDisplayed()) {

		//	WaitUtility.waitForElement(driver, clientobj.verify_Valid_User());
			Assert.assertEquals(true, clientobj.verify_Valid_User().isDisplayed());
		}
		else   {
			//WaitUtility.waitForElement(driver, clientobj.no_Result_Found());
			Assert.assertEquals(true, clientobj.no_Result_Found().isDisplayed());
		}

	}


	@Test(dataProvider = "searchClient")	
	public void TC_07_searchForValidClientAndInvalidClientByName_Only(String name, String id,String msg) throws InterruptedException {
		clientobj=new ClientPage(driver);
		clientobj.clientHomebutton();
		clientobj.clientSearchbutton();
		clientobj.enter_Search_Name(name);
		clientobj.search_Button_Click();
		if(clientobj.valid_Search_Verify().isDisplayed()) {
			// WaitUtility.waitForElement(driver, clientobj.valid_Search_Verify());
			Assert.assertEquals(true, clientobj.verify_Valid_User().isDisplayed());
		}
		else  {
			//WaitUtility.waitForElement(driver, clientobj.no_Result_Found());
			Assert.assertEquals(true, clientobj.no_Result_Found().isDisplayed());
		}

	}




	@Test
	public void TC_08_createNewUser() throws IOException {
		clientobj=new ClientPage(driver);
		clientobj.clientHomebutton();
		clientobj.createClientbuttonClick();
		clientobj.selectBranch();
		clientobj.selectInvoiceOrder();
		clientobj.division();
		clientobj.invoice_Select_Method();
		clientobj.master_Document();
		clientobj.vat_Rate();
		clientobj.invoice_Contact(ExcelUtility.getString(1, 0, Constants.EXCELFILE, "createclientdata"));
		clientobj.getClient_Name(ExcelUtility.getString(1, 1, Constants.EXCELFILE, "createclientdata"));
		clientobj.get_Client_Address(ExcelUtility.getString(1, 3, Constants.EXCELFILE, "createclientdata"));
		clientobj.get_Company_Reg(ExcelUtility.getString(1, 7, Constants.EXCELFILE, "createclientdata"));
		clientobj.get_settlement(String.valueOf(ExcelUtility.getNumeric(1, 5, Constants.EXCELFILE, "createclientdata")));
		clientobj.get_Email(ExcelUtility.getString(1, 4, Constants.EXCELFILE, "createclientdata"));
		clientobj.get_Post_Code(String.valueOf(ExcelUtility.getNumeric(1, 6, Constants.EXCELFILE, "createclientdata")));
		clientobj.get_Phone_Number(String.valueOf(ExcelUtility.getNumeric(1, 2, Constants.EXCELFILE, "createclientdata")));
        clientobj.clickon_Save_Button();
        Assert.assertEquals(true, clientobj.verfiy_Usercreated_Title().isDisplayed());

	}

	@Test
	public void TC_09_viewOption() {
		clientobj=new ClientPage(driver);
		clientobj.clientHomebutton();
		clientobj.view_Client_details();
		Assert.assertEquals(true,clientobj.verify_Client_View().isDisplayed());
	}

	@Test
	public void TC_10_editOption() {
		clientobj=new ClientPage(driver);
		clientobj.clientHomebutton();
		clientobj.edit_Client_details();
		Assert.assertEquals(true, clientobj.verfiy_Edit_Title().isDisplayed());
	}


	@Test
	public void TC_11_pageTitileCheck() {
		clientobj=new ClientPage(driver);
		clientobj.clientHomebutton();
		String title=clientobj.get_Page_Title();
		System.out.println(title);
		Assert.assertEquals(title,"CLIENTS");
	}


	@DataProvider
	public Object[][] searchClient(){
		Object[][] searchadata=new Object[2][3];
		searchadata[0][0]="Akhila Mathew";
		searchadata[0][1]="694";
		searchadata[0][2]="Search successful";

		searchadata[1][0]="Selenium12";
		searchadata[1][1]="5455";
		searchadata[1][2]="Search unsuccessful";

		return searchadata;

	}



}
