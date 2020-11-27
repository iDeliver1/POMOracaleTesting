package com.AP.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.AP.qa.base.TestBase;
import com.AP.qa.pages.LoginPage;
import com.AP.qa.pages.LogoutPage;
import com.AP.qa.pages.PaymentPage;
import com.AP.qa.pages.SelectProductPage;
import com.AP.qa.util.Genral_Function;
import com.AP.qa.util.OracleFunctions;


public class TC003_Reorder_Products_Checkout_3 extends TestBase{

	
	
	OracleFunctions oraLib;
	//Login Test
	@Test
	public void ReorderTest() throws Throwable{
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