package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class SigninPage {
	WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="loginform-username")
	private WebElement username;

	@FindBy(id="loginform-password")
	private WebElement password;


	@FindBy(name="login-button")
	private WebElement logginbutton;
   
	@FindBy(xpath = "//h1[text()='Payroll Application']")
	private WebElement homepage_payroll;
	

	@FindBy(xpath="//p[text()='Incorrect username or password.']")
	private WebElement incorrectcredential;

	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement nameofuserbutton;

	@FindBy(className = "logout-btn")
	private WebElement logoutbutton;

	@FindBy(xpath = "//a[text()='reset it']")
	private WebElement forgotbutton;
	
	@FindBy(id="passwordresetrequestform-email")
	public WebElement resetmail;
	
	@FindBy(xpath ="//button[text()='Send']")
	private WebElement resetmailsendbutton;
	
	@FindBy(xpath =  "//p[text()='There is no user with this email address.']")
	private WebElement after_send_msg;
	
   
    
    
	public void getUsername(String uName ) {
		PageUtility.enterText(username, uName);

	}

	public void getPassword(String pName) {
		PageUtility.enterText(password, pName);
	}

	public void clickOnLoginButton() {
		PageUtility.clickOnElement(logginbutton);
	}

	public String after_Login_Homepage_Visibility() {
		return PageUtility.getElementText(homepage_payroll);
	}
	
	
	public String incorrectCredential() {
		return PageUtility.getElementText(incorrectcredential);
	}

	public void logoutUser() {
		PageUtility.clickOnElement(nameofuserbutton);
		PageUtility.clickOnElement(logoutbutton); 
	}
	
	public void forgotPasswordbutton() {
		PageUtility.clickOnElement(forgotbutton);
	}
	
	public void forgotPasswordMail(String mail) {
		PageUtility.enterText(resetmail, mail);
	}
	public void forgotPasswordMailSendButton() {
		PageUtility.clickOnElement(resetmailsendbutton);
		
	}
	
	public boolean after_Forgot_Mail_Send() {
		return  PageUtility.isElementDisplayed(after_send_msg);
	}
	
	
	
}

