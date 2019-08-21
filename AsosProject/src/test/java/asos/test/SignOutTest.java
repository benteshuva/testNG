package asos.test;

import org.testng.annotations.Test;
import asos.core.BaseDriver;
import asos.core.CommonConfig;
import asos.pages.AsosHomePage;
import asos.pages.AsosSignIn;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;


public class SignOutTest extends BaseDriver {
	@BeforeMethod(enabled = true)
	public void SigningInTest(){
		startSession();
		PageFactory.initElements(driver, asos.pages.AsosHomePage.class);
		PageFactory.initElements(driver, asos.pages.AsosMyAccount.class);
		PageFactory.initElements(driver, asos.pages.AsosSignIn.class);
		

	}

	public void HappyFlow()//happy
	{
		asos.pages.AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signInButton);
		AsosHomePage.signInButton.click();
		
		asos.pages.AsosSignIn.emailAddressInput.sendKeys(username);
		asos.pages.AsosSignIn.passwordInput.sendKeys(password); 
				
		CommonConfig.waitForElement(driver, AsosSignIn.signInButton);
		asos.pages.AsosSignIn.signInButton.click();//till here is the sign in procedure
		CommonConfig.waitForElement(driver, AsosHomePage.AccountInfoButton);
		asos.pages.AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signOutButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsosHomePage.signOutButton.click();
		
		
		
		asos.pages.AsosHomePage.AccountInfoButton.click();
		String nameOFUser = "";
		WebElement element = driver.findElement(By.xpath("//*[@id='myAccountDropdown']/div/div/div/div[1]/div/span"));
		Assert.assertTrue(nameOFUser.equals(element.getAttribute("innerText"))); 
		System.out.println("HappyFlow passed");
		
	}

}




