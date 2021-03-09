package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

//import com.qa.opencart.base.BaseTest;

public class LoginPage {
	

private ElementUtils elementUtil;
private WebDriver driver;

private	By username = By.id("input-email");
private	By password = By.id("input-password");
private	By loginButton =By.xpath("//input[@value='Login']");
private	By forgotPassword = By.xpath("//div[@class='form-group'] /a[text()='Forgotten Password']");
private By registerLink = By.linkText("Register");
	//constructor
public  LoginPage(WebDriver driver)
{
	this.driver = driver;
	elementUtil = new ElementUtils(driver);
}
	
//page actions
public String getLoginPageTitle()
{
	return elementUtil.waitForTitleIs(5, Constants.LOGIN_PAGE_TITLE);
}

public boolean isForgotPwdLinkExist()
{
return elementUtil.doIsDisplayed(forgotPassword);
}
public AccountsPage doLogin(String un,String pwd)
{
	System.out.println("login with:"+un +" "+pwd);
	elementUtil.doSendKeys(username, un);
	elementUtil.doSendKeys(password, pwd);
	elementUtil.doClick(loginButton);
	return new AccountsPage(driver);
}

public RegisterPage navigateToRegisterPage()
{
	elementUtil.doClick(registerLink);
	return new RegisterPage(driver);
	
}
}

