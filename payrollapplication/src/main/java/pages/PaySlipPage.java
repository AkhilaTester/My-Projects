package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class PaySlipPage {
	
	public PaySlipPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	
	
	@FindBy(xpath="//a[@href='/payrollapp/payslip/index']")
	public WebElement clickonpayslip;
	
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']")
	public WebElement payslipheadingverify;
	
	@FindBy(xpath = "//a[@href='/payrollapp/payslip/pdf?id=2781']")
	private WebElement payslipattchbutton;
	
	public void clickonpayslip() {
		PageUtility.clickOnElement(clickonpayslip);
	}
	
	public WebElement Pay_Slip_Title() {
		return payslipheadingverify;
	}
   
	public void click_Payslip_Attach_Button() {
		PageUtility.clickOnElement(payslipattchbutton);
	}
}
