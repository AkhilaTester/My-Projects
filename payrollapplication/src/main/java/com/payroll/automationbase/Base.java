package com.payroll.automationbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import constants.Constants;
import pages.SigninPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties prop,prop1;
	SigninPage  sign;
	FileInputStream fs,fs1;

	@BeforeMethod
	public WebDriver initilizeBrowser() throws IOException {
		prop=new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			prop.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		prop1=new Properties();

		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);


		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			prop1.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//java//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(WaitUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitUtility.IMPLICIT_WAIT,TimeUnit.SECONDS);
		sign=new SigninPage(driver);
		sign.getUsername(ExcelUtility.getString(0, 0,Constants.EXCELFILE, "sheet1"));
		sign.getPassword(ExcelUtility.getString(1, 0, Constants.EXCELFILE, "sheet1"));
		sign.clickOnLoginButton();
		return driver;

	}

	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		// String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(("user.dir")+"\\reports\\"+testCaseName+".png"));
		//return destinationFile;
	}


	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE); 
		//StringimagePath="./Screenshots/" ;
		//extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(imagePath )); 
		FileUtils.copyFile(screenshot, new	File("./reports/"+testCaseName+".png"));
	
	}





	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
