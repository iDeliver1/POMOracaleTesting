package com.AP.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.AP.qa.base.BasePage;

public class LogoutPage extends BasePage{
	@FindBy(xpath = "//a[@class='logout']")
	WebElement signOut;
	
	@FindBy(xpath = "//div[@class='header_user_info']" )
	WebElement signIn;
	
	public LogoutPage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	public void clickOn_signOut_button(){
		signOut.click();
	}
	
	
	
	
}
