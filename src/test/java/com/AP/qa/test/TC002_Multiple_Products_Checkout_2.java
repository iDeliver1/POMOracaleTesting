package com.AP.qa.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.AP.qa.base.TestBase;
import com.AP.qa.util.OracleFunctions;

public class TC002_Multiple_Products_Checkout_2 extends TestBase{

	OracleFunctions oraLib;

	
	@Test//(dataProvider = "Run")
	public void TC002_Multiple_Products_Checkout() throws Throwable {
		
		oraLib = new OracleFunctions(getDriver());
		
		//Login Test
		boolean blnLogin = oraLib.AP_LoginPage_login("tester1000@gmail.com", "iDeliver1", "Yes");
		Assert.assertEquals(true, blnLogin);
		
		
		//Select Product Test
		boolean blnSelectProduct = oraLib.AP_SelectProductPage_multiproduct(3);
		Assert.assertEquals(true, blnSelectProduct);
		
		//Payment Test
		boolean blnPayment = oraLib.AP_PaymentPage_payment();
		Assert.assertEquals(true, blnPayment);
		
		//Logout Test
		boolean blnLogout = oraLib.AP_LogoutPage_logout();
		Assert.assertEquals(true, blnLogout);

	}
			
	
}
