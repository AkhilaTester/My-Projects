package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ReportPage {
	WebDriver driver;
	public ReportPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[@href='/payrollapp/report/payslip']")
	private WebElement report_button;
	
	@FindBy(xpath = "//h1[text()='Payslips']")
	private WebElement report_pagetitle;
	
	@FindBy(xpath="//span[@id='select2-ratesearch-worker_id-container']")
	private WebElement select_worker_field;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement select_Worker_List;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement save_button;
	
	@FindBy(xpath = "//div[@class='summary']")
	private WebElement verfiy_worker;
	
	@FindBy(xpath = "//a[text()='Company Performance']")
	private WebElement company_performance_button;;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']")
	private WebElement performance_title;
	
	
	public void click_Report_Button() {
		PageUtility.clickOnElement(report_button);
	}
	
	public String get_pagetitle() {
		return PageUtility.getElementText(report_pagetitle);
	}
	
	public void click_Select_Worker_field() {
		PageUtility.clickOnElement(select_worker_field);
	}
	
	public void select_Worker_List(String wname) {
		 PageUtility.enterText(select_Worker_List, wname);
	}
	
	public WebElement select_Worker_List_Enter(Keys enter) {
		 return select_Worker_List;
	}
	
	public void click_Save_Button() {
		PageUtility.clickOnElement(save_button);
	}
	
	public WebElement verify_Searched_Worker() {
		return verfiy_worker;
		
	}
	
	public void click_Comapny_performence() {
		PageUtility.clickOnElement(company_performance_button);
	}
	public String verfiy_page_performane() {
		return PageUtility.getElementText(performance_title);
	}
}
