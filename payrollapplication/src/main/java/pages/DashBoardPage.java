package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class DashBoardPage {
	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//p[text()='Welcome to Payroll Application']" )
	private WebElement welcomemsg;
	
	public String welcomeDashboard() {
		return PageUtility.getElementText(welcomemsg);
		
	}
	
	
	

}
