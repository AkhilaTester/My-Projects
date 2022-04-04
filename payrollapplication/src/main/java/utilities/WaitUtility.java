package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	
	
	public enum LocatorType {
		Id, Xpath, CssSelector, Linktext, PartiallinkText, Tagname, Name, ClassName;
	}

	public static void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		 
			wait.until(ExpectedConditions.visibilityOf(target));
	}
	
	public static void waitForElementClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
}
}
