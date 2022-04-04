package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class ClientPage {
	WebDriver driver;

	public ClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Clients']")
	private WebElement client_button_on_homepage;

	@FindBy(xpath = "//a[text()='Clients']")
	public WebElement clients_button;

	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	public WebElement search_client_name;

	@FindBy(name = "ClientSearch[id]")
	public WebElement search_client_id;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement search_button;

	@FindBy(xpath = "//div[text()='No results found.']")
	public WebElement noresultfoundmsg;

	@FindBy(xpath = "//a[text()='Create Client']")
	private WebElement createaclientbutton;

	@FindBy(id = "client-branch_id")
	private WebElement brachfield;

	@FindBy(xpath = "//select[@id='client-invoice_order']")
	private WebElement invoice_order_field;

	@FindBy(xpath = "//select[@id='client-division_id']")
	private WebElement division_field;

	@FindBy(xpath = "//select[@id='client-invoice_delivery_method']")
	private WebElement invoice_select_method;

	@FindBy(xpath = "//select[@id='client-master_document']")
	private WebElement master_document;

	@FindBy(xpath = "//select[@id='client-vat_rate']")
	private WebElement client_vate_rate;

	@FindBy(xpath = "//input[@id='client-invoice_contact']")
	private WebElement invoice_contact;

	@FindBy(xpath = "//input[@id='client-client_name']")
	private WebElement client_name;

	@FindBy(xpath = "//textarea[@id='client-client_address']")
	private WebElement client_addr;

	@FindBy(xpath = "//input[@id='client-company_reg']")
	private WebElement company_reg;

	@FindBy(xpath = "//input[@id='client-settilement_days']")
	private WebElement settlement_days;

	@FindBy(xpath = "//input[@id='client-email']")
	private WebElement client_email;

	@FindBy(xpath = "//input[@id='client-postcode']")
	private WebElement post_code;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-eye-open']")
	public WebElement client_detail_view;

	@FindBy(xpath = "(//li[@class='active'])[2]")
	private WebElement verifyClient;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-pencil']")
	private WebElement client_details_edit_button;

	@FindBy(xpath = "//h1[text()='Clients']")
	private WebElement page_title;

	@FindBy(xpath = "//div[text()='Showing ']")
	public WebElement validsearchresult;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']")
	private WebElement verify_valid_user;
	
	
	@FindBy(xpath = "//input[@id='client-phone']")
	private WebElement phone_number;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save_button;
	
	
	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	private WebElement newclienttitile;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']")
	private WebElement page_title_client_view;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']")
	private WebElement edit_page_title;

	public void clientHomebutton() {
		PageUtility.clickOnElement(client_button_on_homepage);
	}

	public void clientSearchbutton() {
		PageUtility.clickOnElement(clients_button);
	}

	public void createClientbuttonClick() {
		PageUtility.clickOnElement(createaclientbutton);
	}

	public void selectBranch() {
		PageUtility.selectDropdownbyIndex(brachfield,1);
	}

	public void selectInvoiceOrder() {
		PageUtility.selectDropdownbyIndex(invoice_order_field, 2);
	}

	public void division() {
		PageUtility.selectDropdownbyIndex(division_field, 1);
	}

	public void invoice_Select_Method() {
		PageUtility.selectDropdownbyIndex(invoice_select_method, 1);
	}

	public void master_Document() {
		PageUtility.selectDropdownbyIndex(master_document, 2);
	}

	public void vat_Rate() {
		PageUtility.selectDropdownbyIndex(client_vate_rate, 1);
	}

	public void invoice_Contact(String invoice_contact_value) {
		PageUtility.enterText(invoice_contact, invoice_contact_value);
	}

	public void getClient_Name(String clientname) {
		PageUtility.enterText(client_name, clientname);
	}

	public void get_Client_Address(String add) {
		PageUtility.enterText(client_addr, add);
	}

	public void get_Company_Reg(String reg) {
		PageUtility.enterText(company_reg, reg);

	}

	public void get_settlement(String days) {
		PageUtility.enterText(settlement_days, days);
	}

	public void get_Email(String mail) {
		PageUtility.enterText(client_email, mail);
	}

	public void get_Post_Code(String post) {
		PageUtility.enterText(post_code, post);
	}

	public void view_Client_details() {
		PageUtility.clickOnElement(client_detail_view);
	}

	public void edit_Client_details() {
		PageUtility.clickOnElement(client_details_edit_button);
	}

	public String get_Page_Title() {
		return PageUtility.getElementText(page_title);
	}
	
	  public WebElement verify_Client_View() { 
		  return page_title_client_view;
		  }
	 
	
	 public WebElement valid_Search_Verify() { 	 
	return validsearchresult; 
	}
	 
	 
	 public WebElement no_Result_Found() {
		 return noresultfoundmsg;
		 
	 }
	 public void enter_Search_Name(String name ) {
		 PageUtility.enterText(search_client_name,name);
	 }
	 
	 public void enter_Search_By_Id(String id) {
		  PageUtility.enterText(search_client_id,id);
	 }
	 
	 public void search_Button_Click() {
		 PageUtility.clickOnElement(search_button);
	 }
	 
	 public WebElement verify_Valid_User() {
		 return verify_valid_user;
	 }
	 
	 public void get_Phone_Number(String phone) {
		 PageUtility.enterText(phone_number,phone);
	 }
	 
	 
	 public void clickon_Save_Button() {
		 PageUtility.clickOnElement(save_button);
	 }
	 
	 public WebElement verfiy_Usercreated_Title() {
		 return newclienttitile;
	 }
	 public WebElement verfiy_Edit_Title() {
		 return edit_page_title;
	 }
}
