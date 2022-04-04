package com.payroll.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import pages.PaySlipPage;
import pages.ReportPage;

public class PaySlipTest extends Base{
	PaySlipPage payslipobj;
	@Test
	public void TC_26_payslipscreate() {	
		payslipobj=new PaySlipPage(driver);
		payslipobj.clickonpayslip();
		Assert.assertEquals(true, payslipobj.Pay_Slip_Title().isDisplayed());

	}

	@Test
	public void TC_27_download_Payslip() {
		payslipobj=new PaySlipPage(driver);
		payslipobj.clickonpayslip();
		
		payslipobj.click_Payslip_Attach_Button();

		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();

		Iterator itr=s.iterator();
		System.out.println(parent);

		String child="";
		while(itr.hasNext()) {
			child=(String) itr.next();
			System.out.println(child);
		}

		driver.switchTo().window(child);
		System.out.println(driver.switchTo().window(child).getTitle());

		driver.switchTo().window(parent);
		Assert.assertEquals(true, payslipobj.Pay_Slip_Title().isDisplayed());

	}

}
