package asos.test;

import static org.testng.Assert.assertEquals;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asos.core.BaseDriver;
import asos.core.CommonConfig;
import asos.pages.AsosAfterSearch;
import asos.pages.AsosHomePage;
import asos.pages.AsosMyAccount;
import asos.pages.AsosSignIn;


public class ChangePasswordTest extends BaseDriver {
 
	
	@BeforeMethod(enabled = true)
	public void ChangePassword(){
		startSession();
		PageFactory.initElements(driver, asos.pages.AsosHomePage.class);
		PageFactory.initElements(driver, asos.pages.AsosMyAccount.class);
		PageFactory.initElements(driver, asos.pages.AsosSignIn.class);
		
	}
	
	
  @Test (enabled = true)
  public void changeWrongPassword() {
	  

	  	CommonConfig.signinfunc(driver, username, password);
		
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.myAccount);
		AsosHomePage.myAccount.click();
		//CommonConfig.waitForElement(driver, AsosMyAccount.changePassBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsosMyAccount.changePassBtn.click();
		AsosMyAccount.currentPassFld.sendKeys("KokoRabi333");
		AsosMyAccount.newPassFld.sendKeys("SQbloof123");
		AsosMyAccount.savePassBtn.click();
		String expected = "Current password does not match";
		String actual = AsosMyAccount.errorPassTxt.getAttribute("innerText");
		assertEquals(actual, expected);  
  }
  public void changePasswordUnconditional() {
	  

	  	CommonConfig.signinfunc(driver, username, password);
		
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.myAccount);
		AsosHomePage.myAccount.click();
		//CommonConfig.waitForElement(driver, AsosMyAccount.changePassBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsosMyAccount.changePassBtn.click();
		AsosMyAccount.currentPassFld.sendKeys("Qa123456");
		AsosMyAccount.newPassFld.sendKeys("Abcdefg");
		AsosMyAccount.savePassBtn.click();
		String expected = "Erm, you need 1 number";
		String actual = AsosMyAccount.errorNewPassTxt.getAttribute("innerText");
		assertEquals(actual, expected);  
}
  public void changePassword() {
	  

	  	CommonConfig.signinfunc(driver, username, password);
		
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.myAccount);
		AsosHomePage.myAccount.click();
		//CommonConfig.waitForElement(driver, AsosMyAccount.changePassBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsosMyAccount.changePassBtn.click();
		AsosMyAccount.currentPassFld.sendKeys("Qa123456");
		AsosMyAccount.newPassFld.sendKeys("Abcdefg");
		AsosMyAccount.savePassBtn.click();
		String expected = "Password saved";
		String actual = AsosMyAccount.successTxt.getAttribute("innerText");
		assertEquals(actual, expected);  
}
  
  

	  
  
}
