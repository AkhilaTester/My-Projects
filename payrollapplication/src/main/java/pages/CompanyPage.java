package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class CompanyPage {
	WebDriver driver;
	public CompanyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[text()='Company']")
	private  WebElement company;
	
	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	private WebElement company_page;
	
	
	
	public void clickOnCompany() {
		PageUtility.clickOnElement(company);
		
	}
	
	public WebElement verify_Company_Page() {
		return company_page;
	}

}
