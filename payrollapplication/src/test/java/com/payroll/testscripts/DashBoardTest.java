package com.payroll.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import pages.DashBoardPage;

public class DashBoardTest extends Base {
	DashBoardPage dashboardobj;
	@Test
	 public void TC_05() {
		 dashboardobj=new DashBoardPage(driver);
		 String dashboardmsg=dashboardobj.welcomeDashboard();
		 System.out.println(dashboardmsg);
		  Assert.assertEquals(dashboardmsg,"Welcome to Payroll Application");
	 }

}
