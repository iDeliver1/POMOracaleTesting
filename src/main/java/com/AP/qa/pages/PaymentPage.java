package com.AP.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.AP.qa.base.BasePage;
import com.AP.qa.util.Extent_Report;


public class PaymentPage extends BasePage{
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	 WebElement proceed;
	
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement processAddress;
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement processCarrier; 
	
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement pay_method;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirm;
	
	@FindBy(xpath = "//span[@class='price']")
	 WebElement price;
	
	@FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement order_msg;
	
	@FindBy(xpath = "//span[@id='total_price']")
	
	WebElement amount;
	
	@FindBy(xpath = "//span[contains(@id,'total_product_price')]")
	  List<WebElement> Price;
	
	@FindBy(xpath = "//td[@id='total_shipping']")
	  WebElement tax;
	
	@FindBy(xpath = "//span[@id='total_price']")
	 WebElement TotalPrice;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement user;

	
	Extent_Report objExp = new Extent_Report();
	
	public PaymentPage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	public boolean validateProceedAddress_button(){
		return processAddress.isDisplayed();
	}
	
	
	public void clickOn_proceedAddress(){
		processAddress.click();
	}
	
	public void clickOn_shippingCheckBox(){
		checkbox.click();
	}
	
	public void clickOn_processCarrier(){
		processCarrier.click();
	}
	
	public String getAmount(){
		return amount.getText();
	}
	
	public void clickOn_payMethodAndConfirm(){
		pay_method.click();
		confirm.click();
	}
		
	
	
	
	
	
}
