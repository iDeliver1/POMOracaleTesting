package com.AP.qa.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.AP.qa.base.TestBase;
import com.AP.qa.util.*;



public class TC001_Single_Product_Checkout extends TestBase {
	

@Test(priority = 1)	
public void LoginTest() throws Throwable{
		// OracleFunctions class object
		OracleFunctions oraLib = new OracleFunctions(getDriver());
	
		//Login Test
		boolean blnLogin = oraLib.AP_LoginPage_login("tester1000@gmail.com", "iDeliver1", "Yes");
		Assert.assertEquals(true, blnLogin);
		
		//Select Product Test
		boolean blnSelectProduct = oraLib.AP_SelectProductPage_Singleproduct("1", "L");
		Assert.assertEquals(true, blnSelectProduct);
		
		//Payment Test
		boolean blnPayment = oraLib.AP_PaymentPage_payment();
		Assert.assertEquals(true, blnPayment);
				
		//Logout Test
		boolean blnLogout = oraLib.AP_LogoutPage_logout();
		Assert.assertEquals(true, blnLogout);
		
	}
	
	

	
}
