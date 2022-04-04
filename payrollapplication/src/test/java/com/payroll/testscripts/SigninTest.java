package com.payroll.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.automationbase.Base;

import constants.Constants;
import pages.SigninPage;
import utilities.ExcelUtility;

public class SigninTest extends Base{
	SigninPage sign;


	@Test(priority = 1)
	public void TC_01_correct_Credential() throws IOException {
		sign=new SigninPage(driver);
		sign.logoutUser();
		sign.getUsername(ExcelUtility.getString(0, 0,Constants.EXCELFILE, "sheet1"));
		sign.getPassword(ExcelUtility.getString(1, 0, Constants.EXCELFILE,"sheet1")); 
		sign.clickOnLoginButton();
		Assert.assertEquals(sign.after_Login_Homepage_Visibility(),"PAYROLL APPLICATION");
	}



	@Test(priority = 2)
	public void TC_02_wrongCredential() throws IOException{
		driver.navigate().refresh();
		sign=new SigninPage(driver);
		sign.logoutUser();
		sign.getUsername(ExcelUtility.getString(0, 0,Constants.EXCELFILE, "sheet1"));
		sign.getPassword(ExcelUtility.getString(0, 0, Constants.EXCELFILE,"sheet1")); 
		sign.clickOnLoginButton(); 
		String incorrectcredentialmsg=sign.incorrectCredential();
		Assert.assertEquals(incorrectcredentialmsg,"Incorrect username or password.");


	}
	@Test
	private void TC_03_forgotPassword() throws IOException {
		sign=new SigninPage(driver);
		sign.logoutUser();
		sign.forgotPasswordbutton();
		sign.forgotPasswordMail(ExcelUtility.getString(1,2,Constants.EXCELFILE, "sheet1"));
		sign.forgotPasswordMailSendButton();
		Assert.assertEquals(true,sign.after_Forgot_Mail_Send());


	}
}