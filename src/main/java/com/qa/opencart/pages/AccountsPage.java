package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {
	private WebDriver driver;
	ElementUtils elementUtil;

	private By logo = By.cssSelector("#logo");
	private By AccHeaders = By.cssSelector("#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	
	
	//constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtils(driver);
		
	}
	
	public String getAccPageTitle() {
		return elementUtil.waitForTitleIs(5, Constants.ACC_PAGE_TITLE);
	}
	public boolean isLogoExist() {
		return elementUtil.doIsDisplayed(logo);
	}
	public int getAccountPageHeadersCount() {
		
		return elementUtil.getElements(AccHeaders).size();
	}
	public  List<String> getAccountPageHeaderList() {
	List<WebElement>	accList = elementUtil.getElements(AccHeaders);
		List<String> accSectionList = new ArrayList<String>();
			for(WebElement e : accList) {
				accSectionList.add(e.getText());
	}
			return accSectionList;
}
	public SearchResultPage doSearch(String productName) {
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return  new SearchResultPage(driver);
	}
}