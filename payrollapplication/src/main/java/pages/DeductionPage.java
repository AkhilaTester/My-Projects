package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class DeductionPage {
	WebDriver driver;
	
	public DeductionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	private WebElement deduction_button;
	
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/view?id=5557']")
	private WebElement view_button;
	
	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	private WebElement view_page_title;
	
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/update?id=5557']")
	private WebElement edit_button;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement select_worker;
	
	@FindBy(xpath = "//span[@id='select2-deduction-worker_id-container']")
	private WebElement select_edit_worker;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement save_button;
	
	@FindBy(xpath ="//div[@class='col-sm-6 page-title']")
	private WebElement after_deduction_titile;
	
	@FindBy(xpath = "//select[@id='deduction-type']")
	private WebElement deduction_type;
	
	@FindBy(xpath = "//input[@id='deduction-amount']")
	private WebElement deductionamount;
	
	public void click_Deduction_Button() {
		PageUtility.clickOnElement(deduction_button);
	}
	
	public void click_View_Button() {
		PageUtility.clickOnElement(view_button);
		
	}
	
	public WebElement view_Page_Title() {
		return view_page_title;
		
	}
	
	public void click_Edit_Button() {
		PageUtility.clickOnElement(edit_button);
	}

	public void select_Worker(String workername) {
		PageUtility.enterText(select_worker, workername);
	}
	
	public WebElement  select_Workerfield(Keys abc) {
		return select_worker;
	}
	
	public void select_Worker_First_Field() {
		PageUtility.clickOnElement(select_edit_worker);
	}
	
	public void click_Save_Button() {
		PageUtility.clickOnElement(save_button);
	}
	
	public WebElement after_Deduction() {
		return after_deduction_titile;
	}
	
	public void select_Deduction_Type() {
		PageUtility.selectDropdownbyIndex(deduction_type, 2);
		
	}
	
	public void get_Amount(String amount) {
		PageUtility.enterText(deductionamount, amount);
	}
}
