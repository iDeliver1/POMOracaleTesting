package com.AP.qa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.AP.qa.base.BasePage;
import com.AP.qa.util.Excel_Libraries;
import com.AP.qa.util.TestUtil;

public class SelectProductPage extends BasePage{
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceed;
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	  WebElement orderDetails;	

	@FindBy(xpath = "//tr[contains(@class,'first_item')]")
	  WebElement orderTable;
		
	@FindBy(xpath = "//tr[contains(@class,'first_item')]//a[2]")
	  WebElement selectFirstOrder;
	
	@FindBy(xpath = "//span[contains(text(),'tester demo')]")
	  WebElement profile;
	
	@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//a[@class='product-name'][contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement Tshirt;
	
	@FindBy(xpath = "//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-image-container']")
	 WebElement Target;
	
	@FindBy(xpath = "//input[@id='quantity_wanted']") 
	  WebElement qty;
	
	@FindBy(xpath = "//div[@id='uniform-group_1']//following-sibling::option")
	 List < WebElement> size;
	 
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	  WebElement cart;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	  WebElement checkout;
	
	@FindBy(xpath = "//div[@class='box-info-product']")
	  WebElement frame;
	
	@FindBy(xpath = "//ul[@id='homefeatured']//following-sibling::li")
	  List<WebElement> MultiProducts;
	
	@FindBy(xpath = "//li[contains(@class,'ajax_block_product col-xs-12 col-sm-4 col-md-3')]//span[contains(text(),'Add to cart')]")
	  List<WebElement> Addtocart;
	
	@FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
	  WebElement ContinueShop;
	
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	  WebElement ProccedCheckout;
	
	@FindBy(xpath = "//span[contains(@id,'total_product_price')]")
	List<WebElement> Price;
	
	@FindBy(xpath = "//span[@id='total_price']")
	  WebElement TotalPrice;
	
	@FindBy(xpath = "//td[@id='total_shipping']")
	WebElement tax;
	
	@FindBy(xpath = "//td[@id='total_shipping']")
	  WebElement FinalProced;
	
	
	
	public SelectProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void hover_element(){
		MoveElement(Target);
	}
	
	
	public void clickOn_proceed(){
		proceed.click();
	}
	
	public void clickOn_tshirt_link() throws Throwable{
		Tshirt.click();
		waitForElementToAppear(qty);
		qty.click();
	}
	
	public void setQty(String strqty){
		qty.clear();
		qty.sendKeys(strqty);
	}
	
	public void setSize(String strsize){
		TestUtil.SelectQuantity(size, strsize);
	}
	
	public void clickOn_cart() throws Throwable{
		cart.click();
	}
	
	public void clickOn_checkout(){
		waitForElementToAppear(checkout);
		checkout.click();
	}
	
	public boolean validateProceed_button(){	
		return proceed.isDisplayed();
	}
	
	public void clickOn_proceedToCheckout(){
		ProccedCheckout.click();
	}
	
	public void clickOn_continue_button() throws Throwable {
		waitForElementToAppear(ContinueShop);
		ContinueShop.click();
	}
	
	public boolean get_productAvailability(int productindex, int excelindex) throws Throwable {
		
		if(MultiProducts.get(productindex).getText().contains(Excel_Libraries.getdata(excelindex)))
		{
			MoveElement(MultiProducts.get(productindex));
			waitForElementToAppear(Addtocart.get(productindex));
			Addtocart.get(productindex).click();
			return true;
		}
		else
			return false;
	}
	
	
}
	
		
		
