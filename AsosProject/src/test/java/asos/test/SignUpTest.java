package asos.test;

import org.testng.annotations.Test;

import asos.core.BaseDriver;
import asos.core.CommonConfig;
import asos.pages.AsosHomePage;
import asos.pages.AsosSignUp;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class SignUpTest extends BaseDriver  {
	
	@BeforeMethod
	public void beforeMethod() {
		startSession();
		PageFactory.initElements(driver, asos.pages.AsosSignUp.class);
		PageFactory.initElements(driver, asos.pages.AsosHomePage.class);
		PageFactory.initElements(driver, asos.pages.AsosSignIn.class);

	}

	@Test(enabled = true)
	public void HappyFlow() //
	{
		asos.pages.AsosHomePage.AccountInfoButton.click();
		//asos.pages.AsosSignIn.registerButton.click();
	
		CommonConfig.waitForElement(driver, AsosHomePage.signUpButton);
		AsosHomePage.signUpButton.click();
		
		//fill all fields:
		asos.pages.AsosSignUp.emailInput.sendKeys("testQa@gmail.com");//already exsits
		asos.pages.AsosSignUp.firstNameInput.sendKeys("Michael");
		asos.pages.AsosSignUp.lastNameInput.sendKeys("Jeckson");
		asos.pages.AsosSignUp.passwordInput.sendKeys("pass123qa");
		
		Select dropdown= new Select(asos.pages.AsosSignUp.dateDaySelect);
		dropdown.selectByIndex(2);

		Select dropdown2= new Select(asos.pages.AsosSignUp.dateMonthSelect);
		dropdown2.selectByIndex(3);

		Select dropdown3= new Select(asos.pages.AsosSignUp.dateYearSelect);
		dropdown3.selectByIndex(5);

		asos.pages.AsosSignUp.maleRadioButton.isSelected();
		//asos.pages.AsosSignUp.updatesRadioButton.click();
		
		CommonConfig.waitForElement(driver,AsosSignUp.registerButton );
		
		asos.pages.AsosSignUp.registerButton.click();
		
		String currUrl = driver.getCurrentUrl();
		String urlRegister="https://my.asos.com/identity/register?signin=5aafba13aa3a68522ee77097f79a0b36&checkout=False&forceAuthentication=True";
		Assert.assertFalse(currUrl.equals(urlRegister));
		// if current page differ from the registeration page- means we finished the registeration succecfully
		System.out.println("SuccefullyCreate passed");
	}

	@Test(enabled = true)
	public void BadPassword_LessThan6Letters()//N 
	{
		asos.pages.AsosHomePage.AccountInfoButton.click();
		//asos.pages.AsosSignIn.registerButton.click();
		
		CommonConfig.waitForElement(driver, AsosHomePage.signUpButton);
		AsosHomePage.signUpButton.click();
		
		asos.pages.AsosSignUp.emailInput.sendKeys("testQa@gmail.com");//already exsits
		asos.pages.AsosSignUp.firstNameInput.sendKeys("Michael");
		asos.pages.AsosSignUp.lastNameInput.sendKeys("Jeckson");
		asos.pages.AsosSignUp.passwordInput.sendKeys("Qa121");// password less than 6 characters
		Select dropdown= new Select(asos.pages.AsosSignUp.dateDaySelect);
		dropdown.selectByIndex(2);

		Select dropdown2= new Select(asos.pages.AsosSignUp.dateMonthSelect);
		dropdown2.selectByIndex(3);

		Select dropdown3= new Select(asos.pages.AsosSignUp.dateYearSelect);
		dropdown3.selectByIndex(5);

		asos.pages.AsosSignUp.maleRadioButton.isSelected();
		//asos.pages.AsosSignUp.updatesRadioButton.click();
		
		//CommonConfig.waitForElement(driver, AsosSignUp.registerButton);
		
		asos.pages.AsosSignUp.registerButton.click();
		String Error1 = AsosSignUp.PasswordError.getText();
		Assert.assertTrue(Error1.equals("At least 6 letters and 1 number, please!"));
		System.out.println("BadPasswordLessThan6Letters passed");

	}

	@Test(enabled = true)
	public void BadPassword_NoNumbers()//N 
	{
		asos.pages.AsosHomePage.AccountInfoButton.click();
		//asos.pages.AsosSignIn.registerButton.click();
		
		CommonConfig.waitForElement(driver, AsosHomePage.signUpButton);
		AsosHomePage.signUpButton.click();
		
		asos.pages.AsosSignUp.emailInput.sendKeys("testQa@gmail.com");//already exsits
		asos.pages.AsosSignUp.firstNameInput.sendKeys("Michael");
		asos.pages.AsosSignUp.lastNameInput.sendKeys("Jeckson");
		asos.pages.AsosSignUp.passwordInput.sendKeys("HelloWorld");// password less than 6 characters
		Select dropdown= new Select(asos.pages.AsosSignUp.dateDaySelect);
		dropdown.selectByIndex(2);

		Select dropdown2= new Select(asos.pages.AsosSignUp.dateMonthSelect);
		dropdown2.selectByIndex(3);

		Select dropdown3= new Select(asos.pages.AsosSignUp.dateYearSelect);
		dropdown3.selectByIndex(5);

		asos.pages.AsosSignUp.maleRadioButton.isSelected();
		//asos.pages.AsosSignUp.updatesRadioButton.click();
		
		//CommonConfig.waitForElement(driver, AsosSignUp.registerButton);
		
		asos.pages.AsosSignUp.registerButton.click();
		
		String Error1 = AsosSignUp.PasswordError.getText();
		Assert.assertTrue(Error1.equals("At least 6 letters and 1 number, please!"));
		System.out.println("BadPassword_NoNumbers passed");

	}
	
	@Test(enabled = true)
	public void BadPassword_FirstNameEmpty()//N 
	{
		asos.pages.AsosHomePage.AccountInfoButton.click();
		//asos.pages.AsosSignIn.registerButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signUpButton);
		AsosHomePage.signUpButton.click();
		
		asos.pages.AsosSignUp.emailInput.sendKeys("testQa@gmail.com");//already exsits
		asos.pages.AsosSignUp.lastNameInput.sendKeys("Jeckson");
		asos.pages.AsosSignUp.passwordInput.sendKeys("pass123qa");// password less than 6 characters
		Select dropdown= new Select(asos.pages.AsosSignUp.dateDaySelect);
		dropdown.selectByIndex(2);

		Select dropdown2= new Select(asos.pages.AsosSignUp.dateMonthSelect);
		dropdown2.selectByIndex(3);

		Select dropdown3= new Select(asos.pages.AsosSignUp.dateYearSelect);
		dropdown3.selectByIndex(5);

		asos.pages.AsosSignUp.maleRadioButton.isSelected();
		//asos.pages.AsosSignUp.updatesRadioButton.click();
		
		//CommonConfig.waitForElement(driver, AsosSignUp.registerButton);
		
		asos.pages.AsosSignUp.registerButton.click();
		String Error1 = AsosSignUp.FirstNameError.getText();
		Assert.assertTrue(Error1.equals("We need your first name – it’s nicer that way"));
		System.out.println("FirstNameEmpty passed");
	}
	
	

}
