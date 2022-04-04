package com.payroll.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import pages.InvoicePage;

public class InvoiceTest extends  Base{
	
	InvoicePage invoiceobj;
	@Test
	public void TC_25_invoice() {
	invoiceobj=new InvoicePage(driver);
	invoiceobj.click_Invoice_Button();
	Assert.assertEquals(true, invoiceobj.invoice_Title().isDisplayed());
		
	}
	

}
