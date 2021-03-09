package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtils {

	private WebDriver driver;
	private JavaScriptUtil JsUtil;
	public ElementUtils(WebDriver driver)
	
	{
		this.driver = driver;
		JsUtil = new JavaScriptUtil(this.driver);
	}
	
		public  WebElement getElement(By locator)
		{
			WebElement ele = driver.findElement(locator);
			if(Boolean.parseBoolean(DriverFactory.highlight)) {
				JsUtil.flash(ele);
				
			}
			return ele;
		}
		
		public List<WebElement>getElements(By locator)
		{
			return driver.findElements(locator);
		}
		public void doSendKeys(By locator, String value)
		{
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		}
		
		public  void doClick(By locator) {
			getElement(locator).click();
			
		}
		
		public String doGetElementText(By locator)
		{
			return getElement(locator).getText();
		}

		
		public boolean doIsDisplayed(By locator)
		{
			return getElement(locator).isDisplayed();
		}

		public void confirmPassword(By password, String string) {
			// TODO Auto-generated method stub
			
		}

		public void doLinkClick(By locator,String value)
		{
			List<WebElement>linksList =getElements(locator);
			System.out.println("total links" +linksList.size());
			for(WebElement e : linksList) {
				String text = e.getText();
				System.out.println(text);
				if(text.equals(value))
				{
					e.click();
					break;
				}
				
			}
			
		}
		

			//*************************DropDownUtils**********************
			
			public  void doSelectByVisibleText(By locator,String text)
			{
				Select select = new Select(getElement(locator));
				select.selectByVisibleText(text);
				
			}

			public  void doSelectByValue(By locator,String value)
			{
				Select select = new Select(getElement(locator));
				select.deselectByValue(value);
			}

			public  void doSelectByIndex(By locator,int index)
			{
				Select select = new Select(getElement(locator));
				select.deselectByIndex(index);
			}
			
			
			public  List<String> getDropDownOptionsList(By locator)
			{
					
			Select select = new Select(getElement(locator));
		        List<String>optionsTextList = new ArrayList<String>();
		       List<WebElement> optionsList = select.getOptions();
		       
		       //System.out.println(optionsList.size());
		       
		       for(WebElement e : optionsList)
		       {
		    	   optionsTextList.add(e.getText());
		       }
		        
		        return optionsTextList;
				
			}

			
			
			public void  doSelectByTextOption(By locator, String text)
			{
				      
		        Select select = new Select(getElement(locator));
		        
		      List<WebElement>optionsList= select.getOptions();
		      
		      for(WebElement e: optionsList)
		      {
		    	  if(e.getText().equals(text)) {
		    		  e.click();
		    		  break;
		    	  }
		      }
		      /**
		       * this method is used to slect the value from drop down with out select class
		       * 
		       */
			}
			 public   void doSelectDropDownWithoutSelectClass(By locator,String value)
		        {
		        	List<WebElement> optionsList =  getElements(locator);
		        	  
		        	  for(WebElement  e : optionsList)
		        	  {
		        		  if(e.getText().equals(value))
		        		  {
		        			  e.click();
		        			  break;
		        		  }
		        	  }
		        	  
		        	  
		        	  }
		        	        



//****************Alert wait Utilities***************

public  Alert waitForAlertPresent(int timeOut)
{
	 WebDriverWait wait = new WebDriverWait(driver,timeOut);
	 return wait.until(ExpectedConditions.alertIsPresent());
}
public String getAlertText(int timeOut)
{
	String text= waitForAlertPresent(timeOut).getText();
	acceptAlert(timeOut);
	return text;
}
public void acceptAlert(int timeOut)
{
	 waitForAlertPresent(timeOut).accept();
}
public void dismissAlert(int timeOut)
{
	 waitForAlertPresent(timeOut).dismiss();
}

public String waitForTitleIs(int timeOut, String title) {
	WebDriverWait wait = new WebDriverWait(driver, timeOut);
	wait.until(ExpectedConditions.titleIs(title));
	return driver.getTitle();
}

public WebElement waitForPresenceOfElement(By locator, int timeOut) {
	WebDriverWait wait = new WebDriverWait(driver, timeOut);
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}



/**
 * An expectation for checking that an element, known to be present on the DOM
 * of a page, is visible. Visibility means that the element is not only
 * displayed but also has a height and width that is greater than 0.
 * 
 * @param locator
 * @param timeOut
 * @return
 */

public WebElement waitForVisiblilityOfElement(By locator, int timeOut) {
	WebDriverWait wait = new WebDriverWait(driver, timeOut);
	return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
}

}


		
