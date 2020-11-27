package com.AP.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.AP.qa.base.TestBase;
import com.AP.qa.util.OracleFunctions;

public class TC004_Single_Products_WithoutLogin_Checkout_4 extends TestBase{

	OracleFunctions oraLib;
	
	//Select product test
	@Test(priority = 1, enabled = true)
	public void BookingTest() throws Throwable{
		oraLib = new OracleFunctions(getDriver());	
		
		//Select Product Test
		boolean blnSelectProduct = oraLib.AP_SelectProductPage_Singleproduct("1", "L");
		Assert.assertEquals(true, blnSelectProduct);
		
		//Login Test
		boolean blnLogin = oraLib.AP_LoginPage_login("tester1000@gmail.com", "iDeliver1", "No");
		Assert.assertEquals(true, blnLogin);
		
		//Payment Test
		boolean blnPayment = oraLib.AP_PaymentPage_payment();
		Assert.assertEquals(true, blnPayment);
		
		//Logout Test
		boolean blnLogout = oraLib.AP_LogoutPage_logout();
		Assert.assertEquals(true, blnLogout);

	}
}