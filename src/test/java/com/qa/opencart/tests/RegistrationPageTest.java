package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest  extends BaseTest{
	
	@BeforeClass
	
	public void setupRegister()
	{
		
	registerPage =	loginPage.navigateToRegisterPage();
	}
	@DataProvider
	public Object[][]getRegisterData()
	{
	Object data[][] =	ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	return data;
	}
	
		
	@Test(dataProvider = "getRegisterData")
	public void userRegisterTest(String firstName, String lastName,String email, String telephone, String password,String subscribe)
	{
		Assert.assertTrue(registerPage.accountRegistartion(firstName, lastName, email, 
				telephone, password, subscribe),  Error.REGISTER_FAILED_MESSG);
	}
	
	

}
