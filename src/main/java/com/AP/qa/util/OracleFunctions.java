package com.AP.qa.util;


import org.openqa.selenium.WebDriver;

import com.AP.qa.base.TestBase;
import com.AP.qa.pages.*;

public class OracleFunctions extends TestBase  {
	
	//Page object
	LoginPage pglogin;
	SelectProductPage pgselectProduct;
	PaymentPage pgpayment;
	LogoutPage pglogout;
	
	public OracleFunctions(WebDriver driver) {
		
		//Initializing Page Object
		pglogin = new LoginPage(driver);
		pgselectProduct =  new SelectProductPage(driver);
		pgpayment  = new PaymentPage(driver);
		pglogout = new LogoutPage(driver);
	}
	
	
	// Function from Login Page-----------------------------------------------------------------------
	  
	  public boolean AP_LoginPage_login(String strUserName, String strPasswprd, String strSignInFlag) throws Throwable {
		  
					if(strSignInFlag.equals("Yes")){
						
						pglogin.clickOn_signIn_button();
					}
					
					pglogin.setUser_Name(strUserName);
					pglogin.setPassword(strPasswprd);
					pglogin.clickOn_logIn_button();
					pglogin.clickOn_homePage_link();
					return pglogin.validateUser();	
		}
	  
	  
	  
	  // Function from Select Product Page------------------------------------------------------------------
	  
	  public boolean AP_SelectProductPage_Singleproduct(String strQty, String strPickSize) throws Throwable {
			
			try {
					pgselectProduct.hover_element();
					pgselectProduct.clickOn_tshirt_link();
					pgselectProduct.setQty(strQty);					
					pgselectProduct.setSize(strPickSize);;//Select Size -S / M /L
					pgselectProduct.clickOn_cart();
					pgselectProduct.clickOn_checkout();
					pgselectProduct.clickOn_proceed();
					return pgpayment.validateProceedAddress_button();
				}
				catch(Exception e) {
					
						e.printStackTrace();
						return pgselectProduct.validateProceed_button();
				}
			}
	  
	  
	  public boolean AP_SelectProductPage_multiproduct(int productCount) throws Throwable {
			int counter = 0;
		  try {
				
				for(int j = 0;j<productCount;j++ ) {
						
					System.out.println(productCount);
						for(int i=0;i<=productCount;i++)
						{
							try {
							if(Excel_Libraries.getdata(j).isEmpty()==false) {
								if(pgselectProduct.get_productAvailability(i,j))
								{
									counter=counter+1;
									break;
								}
							}
						}
						catch(Exception f){
							f.printStackTrace();
							}
						}
						
						if(counter==productCount) {
							//ProccedCheckout.click();
							pgselectProduct.clickOn_proceedToCheckout();
						}
						else
							pgselectProduct.clickOn_continue_button();		
				}
				
			}
				catch(Exception e) {
					e.printStackTrace();
					afterSuite();
					//closeBrowser();
				}
			pgselectProduct.clickOn_proceed();
			return pglogin.validateUser();
	  }
	  
	  
	  //Function from Payment Page--------------------------------------------------------------------
	  
	  public boolean AP_PaymentPage_payment() throws Throwable {
		  
				    pgpayment.clickOn_proceedAddress();
				    pgpayment.clickOn_shippingCheckBox();
				    pgpayment.clickOn_processCarrier();
					//String FPrice = pgpayment.getAmount().replace("$", "");
					pgpayment.clickOn_payMethodAndConfirm();
					return pglogin.validateUser();
					
					}
	  
	  
	  //Function for Logout Page------------------------------------------------------------------------
	  
	  public boolean AP_LogoutPage_logout() throws Throwable {
			pglogout.clickOn_signOut_button();
	        return pglogin.validateSignIn_button();
		}
	  
	  
	  //Global Application Function----------------------------------------------------------------------
	  
	  /*public String AP_Page_gettitle() {
		    return driver.getTitle();
	  }*/
			
	  
}
