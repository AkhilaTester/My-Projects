package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class InvoicePage {
	WebDriver driver;
	public InvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='/payrollapp/invoice/index']")
	private WebElement invoicebutton;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']")
	private WebElement invoicetitle;
	
	
	public void click_Invoice_Button() {
		PageUtility.clickOnElement(invoicebutton);
	}
	

	public WebElement invoice_Title() {
		return invoicetitle;
	}
}
