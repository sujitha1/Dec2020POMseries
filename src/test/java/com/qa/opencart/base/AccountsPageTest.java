package com.qa.opencart.base;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;

public class AccountsPageTest extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void AccSetUp() {
	accPage  =	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void accPageTitleTest()
	{
	String title=	accPage.getAccPageTitle();
	System.out.println("home page tiltle " +title);
	Assert.assertEquals(title, Constants.ACC_PAGE_TITLE,
			
			Error.ACC_PAGE_MISMATCHED_ERROR);
	}
	@Test(priority=2)
	public void accPageLogoTest() {
		Assert.assertTrue(accPage.isLogoExist(),
				Error.LOGO_NOT_AVAILABLE_ERROR);
	}
	@Test(priority=3)
	public void accPageSectionsCountTest() {
	Assert.assertEquals(accPage.getAccountPageHeadersCount(),
			Constants.ACC_PAGE_SECTIONS_COUNT,
			Error.ACC_PAGE_SECTION_ERROR);	
		
	}
	@Test(priority=4)
	public void  accPageSectionsTest(){
	List<String>actualAccSecList =	accPage.getAccountPageHeaderList();
	System.out.println(actualAccSecList);
	
	Assert.assertEquals(actualAccSecList, Constants.expectedAccSecList());
	}
	
	@Test(priority=5)
	public void searchTest() {
		searchResultPage = accPage.doSearch("macbook");
	 Assert.assertTrue (searchResultPage.getProductResultsCount()>0,Error.SEARCH_NOT_SUCCESSFUL);
	}
	
	@Test(priority=6)
	
		public void selectProductTest()
		{
			searchResultPage = accPage.doSearch("macbook");
			productInfoPage  =	searchResultPage .selectProductFromResults("MacBook Pro");
		  String actualHeader =   productInfoPage.getProductHeaderText();
		  softAssert.assertEquals(actualHeader ,"MacBook Pro", Error.PRODUCT_HEADER_NOT_FOUND);
		  Assert.assertEquals(productInfoPage.getProductImagesCount(), Constants.PRODUCT_IMAGES_COUNT_MACBOOK);
		  softAssert.assertAll();
		}
	
	
	
	}


