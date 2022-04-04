package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class WorkersPage {
	WebDriver driver;
	
	public WorkersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[text()='Workers']" )
	private WebElement worker_button_homepage;
	
	@FindBy(xpath="//input[@id='workersearch-first_name']")
	public  WebElement search_first_name;
	
	@FindBy(xpath="//input[@id='workersearch-last_name']")
	private WebElement searc_last_name;
	
	@FindBy(xpath = "//input[@id='workersearch-postcode']")
	private WebElement search_postcode;
	
	@FindBy(xpath = "//input[@id='workersearch-ni_number']")
	private WebElement ninumber;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement search_button;
	
	@FindBy(xpath = "//div[text()='Showing ']")
	private WebElement search_result_msg;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']")
	private WebElement searched_worker;
	
	@FindBy (xpath = "//div[text()='No results found.']")
	private WebElement search_invalidresult;
	
	
	@FindBy(xpath = "//a[text()='Create Worker']")
	private WebElement create_new_worker_button;
	
	@FindBy(xpath ="//h1[text()='Workers']")
	private WebElement workers_page_title_button;
	
	@FindBy(xpath = "//select[@id='worker-title']")
	private WebElement workertitle;
	
	@FindBy(xpath = "//select[@id='worker-gender']")
	private WebElement gender;
	
	@FindBy(xpath = "//select[@id='worker-branch_id']")
	private WebElement branch;
	
	@FindBy(xpath="//option[text()='Alpha_new']")
	private WebElement branchtext;
	
	@FindBy(xpath="//select[@id='worker-division_id']")
	private WebElement division;
	

	@FindBy(xpath="//select[@id='worker-payslip_method']")
	private WebElement payslip_method;
	
	@FindBy(xpath="//select[@id='worker-employment_type']")
	private WebElement worker_type;
	
	@FindBy(xpath="//select[@id='worker-engage_status']")
	private WebElement worker_engage_status;
	
	
	@FindBy(xpath = "//input[@id='worker-dob']")
	private WebElement dob;
	
	@FindBy(xpath = "//input[@id='worker-first_name']")
	private WebElement create_firstname;
	
	 @FindBy(xpath="//input[@id='worker-last_name']")
	 private WebElement create_lastname;
	 
	 
	@FindBy(xpath="//input[@id='worker-phone']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@id='worker-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='worker-address1']")
	private WebElement add1;
	
	@FindBy(xpath="//input[@id='worker-postcode']")
	private WebElement postcode;
	
	@FindBy(xpath = "//input[@id='worker-ni_number']")
	private WebElement create_ni;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement create_next;
	
	@FindBy(xpath="//div[text()='First Name cannot be blank.']")
	private WebElement blankmsg;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement create_worker_submit_button;
	
	@FindBy(xpath="//h1[starts-with(text(),'Worker Bank details:')]")
	private WebElement titile_after_new_worker_submit;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/view?id=1059']")
	public WebElement worker_view_button;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']")
	private WebElement view_page_titile;
	
	@FindBy(xpath="//li//a[text()='Bank Details']")
	private WebElement bankdetails_viewbutton;
	
	@FindBy(xpath = "//h1[starts-with(text(),'Worker Bank details:')]")
	private WebElement bankdetails_titile;
	
	@FindBy(xpath="//a[text()='Timesheet History']")
	private WebElement timesheethistory_button;
	
	@FindBy(xpath = "//h1[starts-with(text(),'Payslip History:')]")
	private WebElement paysliphistory_title;
	
	@FindBy(xpath="//a[text()='Payslip History']")
	private WebElement paysliphistory_button;
	
	@FindBy(xpath = "//h1[starts-with(text(),'Timesheet History:')]")
	private WebElement timesheet_title;
	
	@FindBy(xpath="//a[text()='Deduction History']")
	private WebElement deductionhistory_button;
	
	@FindBy(xpath = "//h1[starts-with(text(),'Deduction History:')]")
	private WebElement deductionhistory_title;
	
	@FindBy(xpath="//a[text()='Rate']")
	private WebElement rate_button;
	
	@FindBy(xpath="//span[@id='select2-workerratesearch-client_id-container']")
	private WebElement select_client_view_rate;
	
	@FindBy(xpath ="//input[@class='select2-search__field']")
	private WebElement entername_search_rate;
	
	@FindBy(xpath ="//a[@href='/payrollapp/worker/update?id=1059']")
	private WebElement workereditbutton;
	
	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	private WebElement edit_page_title;
	
	@FindBy(xpath = "//input[@id='worker-address1']")
	private WebElement update_add1;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement edit_next_button;
	
	
	public void worker_Page_Button() {
		PageUtility.clickOnElement(worker_button_homepage);
	}
	
	public void get_First_Name(String fname) {
		PageUtility.enterText(search_first_name,fname);
		
	}
	
	public void get_Last_Name(String lname) {
		PageUtility.enterText(searc_last_name, lname);
	}

	public void get_Postcode(String postcode) {
		PageUtility.enterText(search_postcode, postcode);
	}
	
	public void get_Ni_Number(String ni) {
		PageUtility.enterText(ninumber, ni);
		
	}
	
	public WebElement search_Result_Valid_Msg() {
		return search_result_msg;
	}
	
	public WebElement valid_Search_Verification() {
		return searched_worker;
	}
	
	public WebElement search_Invalid_Msg() {
		return search_invalidresult;
	}
	
	public void create_New_Worker_Button() {
		PageUtility.clickOnElement(create_new_worker_button);
	}
	
	public WebElement worker_Tiltle_Name() {
		return workers_page_title_button;	
	}
	public void select_Worker_Title() {
		PageUtility.selectDropdownbyIndex(workertitle, 2);
	}
	
	public void select_Gender() {
		PageUtility.selectDropdownbyIndex(gender, 1);
	}
	
	public void select_Branch(String branchtext) {
		PageUtility.selectDropdownbyText(branch, branchtext);
		
	}
	public String getText_Branch() {
		return PageUtility.getElementText(branchtext);
	}
	
	public void select_Division() {
		PageUtility.selectDropdownbyIndex(division, 1);
	}
	public void select_Type() {
		PageUtility.selectDropdownbyIndex(worker_type, 1);
	}
	public void select_PaySlip_Method() {
		PageUtility.selectDropdownbyIndex(payslip_method, 1);
	}
	public void select_engage_Status() {
		PageUtility.selectDropdownbyIndex(worker_engage_status, 1);
	}
	
	public WebElement dob() {
		return dob;
		
	}
	
	public void create_Firstname(String cfname) {
		PageUtility.enterText(create_firstname, cfname);
	}
	
	public void create_Lastname(String lastname) {
		PageUtility.enterText(create_lastname, lastname);
	}
	public void get_Phone(String phonenum) {
		PageUtility.enterText(phone,phonenum);
		
	}
	public void get_Email(String mail) {
		PageUtility.enterText(email, mail);
	}
	
	public void get_add1(String add) {
		PageUtility.enterText(add1, add);
	}
	

	public void get_Post_Code(String post) {
		PageUtility.enterText(postcode, post);
	}
	
	public void create_Ni_Number(String cni) {
		PageUtility.enterText(create_ni, cni);
	}
	
	public WebElement Next_Buttton_Click() {
		return 	create_new_worker_button;
	}
	
	public void create_Next_Buttton_Click() {
		PageUtility.clickOnElement(create_new_worker_button);
	}
	public void submit_Fisrtpage_Createworker() {
		PageUtility.clickOnElement(create_worker_submit_button);
	}
	public WebElement mandatory_Blank_Msg() {
		return blankmsg;
	}
	
	public WebElement verify_Worker_Create() {
		return titile_after_new_worker_submit;
	}
	
	public void worker_View_Button() {
		PageUtility.clickOnElement(worker_view_button);
	}
	public WebElement get_View_Page_Titile() {
		return view_page_titile;
		
	}
	
	public void bankdetails_Viewbutton_Click() {
		PageUtility.clickOnElement(bankdetails_viewbutton);
	}
	
	public WebElement bankdetails_Titile_Get() {
		return bankdetails_titile;
	}
	
	public void click_Payslip_History_Button() {
		PageUtility.clickOnElement(paysliphistory_button);
	}
	public WebElement  get_Payslip_History_Title() {
		return paysliphistory_title ;
	}
	
	public void click_TimeSheet_History_Button() {
		PageUtility.clickOnElement(timesheethistory_button);
	}
	
	public WebElement  get_Timesheet_History_Title() {
		return timesheet_title;
	}
	
	public void click_Deduction_History_Button() {
		PageUtility.clickOnElement(deductionhistory_button);
	}
	
	public WebElement  get_Deduction_History_Title() {
		return deductionhistory_title;
	}
	
	public void click_Rate_Button() {
		PageUtility.clickOnElement(rate_button);
	}
	public void click_View_Rate_Button() {
		PageUtility.clickOnElement(select_client_view_rate);
		
	}
	
	public void get_Name_Search_Rate(String searchname) {
		PageUtility.enterText(entername_search_rate, searchname);
	}
	
	public void search_Button() {
		PageUtility.clickOnElement(search_button);
	}
	
	public void click_On_WorkerEdit_Button() {
		PageUtility.clickOnElement(workereditbutton);
	}
	
	public WebElement view_Button() {
		return worker_view_button;
	}
	
	public WebElement no_Result_Found() {
		return search_invalidresult;
	}
	
	public WebElement edit_Page_Title() {
		return edit_page_title;
	}
	
	public void update_Add1_Field(String newadd1) {
		PageUtility.enterText(update_add1, newadd1);
	}
	
	public void click_Edit_Next_Button ()
	{
		PageUtility.clickOnElement(edit_next_button);
	}
}
