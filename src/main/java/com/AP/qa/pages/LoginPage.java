package com.AP.qa.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.AP.qa.base.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInbtn;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement validatesignInbtn;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement user;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement logIn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement home;
	
	@FindBy(xpath = "//span[contains(text(),'tester demo')]")
	WebElement validate_user;
	
	
	public LoginPage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	public boolean validateUser(){
		return validate_user.isDisplayed();
	}
	
	public boolean validateSignIn_button(){
		return validatesignInbtn.isDisplayed();
	}
	
	public void setUser_Name(String userName){
		user.clear();
		user.sendKeys(userName);
		
	}
	
	public void setPassword(String pwd){
		password.clear();
		password.sendKeys(pwd);
		
	}
	
	public void clickOn_signIn_button(){
		signInbtn.click();
		
	}
	
	public void clickOn_logIn_button(){
		logIn.click();
		
	}
	
	public void clickOn_homePage_link(){
		home.click();
		
	}
	
	
		
	}


