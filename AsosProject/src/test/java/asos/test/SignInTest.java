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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;


public class SignInTest extends BaseDriver {

	@BeforeMethod(enabled = true)
	public void SigningInTest(){
		startSession();
		PageFactory.initElements(driver, asos.pages.AsosHomePage.class);
		PageFactory.initElements(driver, asos.pages.AsosSignIn.class);
	
	}

	@Test(enabled = true)
	public void HappyFlow()
	{
		//Entering user 
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signInButton);
		AsosHomePage.signInButton.click();
		
		
		
		asos.pages.AsosSignIn.emailAddressInput.sendKeys(username);
		asos.pages.AsosSignIn.passwordInput.sendKeys(password);
		//Filled user information

		CommonConfig.waitForElement(driver, AsosSignIn.signInButton);

		asos.pages.AsosSignIn.signInButton.click();
		//clicking on sign in
		String CurrUrl = driver.getCurrentUrl();
		String myAccountUrl="http://www.asos.com/#";
		Assert.assertTrue(CurrUrl.equals(myAccountUrl)); 
		//check if the current url is same as user page.
		System.out.println("HappyFlow passed");
	}
	@Test(enabled = true)
	public void HappyFlowUpperCase()//
	{
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signInButton);

		AsosHomePage.signInButton.click();
		asos.pages.AsosSignIn.emailAddressInput.sendKeys(username.toUpperCase()); // upper case username test
		asos.pages.AsosSignIn.passwordInput.sendKeys(password);

		CommonConfig.waitForElement(driver, AsosSignIn.signInButton);

		asos.pages.AsosSignIn.signInButton.click();
		String CurrUrl = driver.getCurrentUrl();
		String myAccountUrl="http://www.asos.com/#";
		Assert.assertTrue(CurrUrl.equals(myAccountUrl)); 
		System.out.println("HappyFlowUpperCase passed");
	}
	@Test(enabled = true)
	public void NoPassword()//N
	{
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signInButton);

		AsosHomePage.signInButton.click();
		//No password test
		asos.pages.AsosSignIn.emailAddressInput.sendKeys(username);

		CommonConfig.waitForElement(driver, AsosSignIn.signInButton);
		asos.pages.AsosSignIn.signInButton.click();
		String Error1 = AsosSignIn.passwordError.getText();
		Assert.assertTrue(Error1.equals("Hey, we need a password here"));
		System.out.println("NoPassword test passed");
	}
	@Test(enabled = true)
	public void NoUserName()//N
	{
		AsosHomePage.AccountInfoButton.click();
		CommonConfig.waitForElement(driver, AsosHomePage.signInButton);

		AsosHomePage.signInButton.click();
		//No username inserterd
		asos.pages.AsosSignIn.passwordInput.sendKeys(password);

		CommonConfig.waitForElement(driver, AsosSignIn.signInButton);

		asos.pages.AsosSignIn.signInButton.click();
		String Error1 = AsosSignIn.EmailAddressError.getText();
		Assert.assertTrue(Error1.equals("Oops! You need to type your email here"));
		System.out.println("NoUserName test passed");
	}

	
	@Test(priority=5,enabled=true)
	public void SignUpGoogle()//happy
	{
		//Log.info("Close coocies window");
		//asos.pages.AsosHomePage.closeCookies.click();
	
		//Log.info("Close country window");
		//asos.pages.AsosHomePage.closeCountry.click();
		
		//Log.info("Click on account Icon");
		asos.pages.AsosHomePage.AccountInfoButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='signin-link']")));
		
		//Log.info("Click on sign in link");
		asos.pages.AsosHomePage.signInButton.click();

		asos.pages.AsosSignIn.googleButton.click();
		//Log.info("Switch to the new window");
		
		

		for(String winHandle : driver.getWindowHandles() )
		{
			driver.switchTo().window(winHandle);
		}
		//Log.info("Assert");

		WebElement element = driver.findElement(By.id("headingText"));
		Assert.assertTrue(element.isDisplayed()); 
		System.out.println("SignUpGoogle passed");
		
	}

	@Test(priority=6,enabled=true)
	public void SignUpTwitter()//happy
	{
		//Log.info("Close coocies window");
		//asos.pages.AsosHomePage.closeCookies.click();
	
		//Log.info("Close country window");
		//asos.pages.AsosHomePage.closeCountry.click();
		
		//Log.info("Click on account Icon");
		asos.pages.AsosHomePage.AccountInfoButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='signin-link']")));
		
		//Log.info("Click on sign in link");
		asos.pages.AsosHomePage.signInButton.click();

		asos.pages.AsosSignIn.twitterButton.click();
		//Log.info("Switch to the new window");

		for(String winHandle : driver.getWindowHandles() )
		{
			driver.switchTo().window(winHandle);
		}
		//Log.info("Assert");


		WebElement element = driver.findElement(By.xpath("//h1[@class='logo']"));
		Assert.assertTrue(element.isDisplayed()); 
		System.out.println("SignUpTwitter passed");
		}
	@Test(priority=7,enabled=true)
	public void SignUpFacebook()//happy
	{
		//Log.info("Close coocies window");
		asos.pages.AsosHomePage.closeCookies.click();
	
		//Log.info("Close country window");
		asos.pages.AsosHomePage.closeCountry.click();
		
		//Log.info("Click on account Icon");
		asos.pages.AsosHomePage.AccountInfoButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='signin-link']")));
		
		//Log.info("Click on sign in link");
		asos.pages.AsosHomePage.signInButton.click();
		asos.pages.AsosSignIn.facebookButton.click();
		//Log.info("Switch to the new window");

		for(String winHandle : driver.getWindowHandles() )
		{
			driver.switchTo().window(winHandle);
		}
		//Log.info("Assert");

		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Facebook')]"));
		Assert.assertTrue(element.isDisplayed()); 
		System.out.println("SignUpFacebook passed");
	}
	

	
}


