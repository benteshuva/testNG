package asos.test;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asos.core.BaseDriver;
import asos.core.CommonConfig;
import asos.pages.AsosAfterSearch;
import asos.pages.AsosHomePage;
import junit.framework.Assert;

public class SearchTest extends BaseDriver{
	
	
	@BeforeMethod(enabled = true, alwaysRun = true)

	public void SigningInTest(){
		
		startSession();
		PageFactory.initElements(driver, asos.pages.AsosHomePage.class);
		PageFactory.initElements(driver, asos.pages.AsosAfterSearch.class);
	}

	@Test(enabled = true , priority = 1 , groups= {"dudi"})
	public void HappyFlow() 
	{
		asos.pages.AsosHomePage.searchBar.sendKeys("Adidas");
		asos.pages.AsosHomePage.searchButton.click();
		String found=asos.pages.AsosAfterSearch.foundMessage.getText(); // the message says how much items found
		System.out.println(found);
		Assert.assertTrue(found.contains("styles found"));	//in case not found anything, those words will not be included
		System.out.println("HappyFlow");
	}


	@Test(enabled = true , priority = 2 , groups = "sanity")
	public void BadSearch() 
	{
		asos.pages.AsosHomePage.searchBar.sendKeys("ugughghjgkvyjbhj");
		asos.pages.AsosHomePage.searchButton.click();
		String error=asos.pages.AsosAfterSearch.errorMessage.getText();//// the message says nothing found
		System.out.println(error);
		Assert.assertTrue(error.contains("OH NO! NOTHING MATCHES:"));	
		System.out.println("SearchBadFlow");
	}


	@Test(enabled = false)
	public void AdvancedSearch() 
	{
		//driver.findElement(By.cssSelector("button[class = '_2np3kDs']")).click();
		CommonConfig.waitForElement(driver, AsosHomePage.searchBar);
		AsosHomePage.searchBar.sendKeys("Adidas");
		CommonConfig.waitForElement(driver, AsosHomePage.searchButton);
		AsosHomePage.searchButton.click();
		
		CommonConfig.waitForElement(driver, AsosAfterSearch.sort);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsosAfterSearch.sort.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.sortChoose);
		AsosAfterSearch.sortChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.gender);
		AsosAfterSearch.gender.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.genderChoose);
		AsosAfterSearch.genderChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.productType);
		AsosAfterSearch.productType.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.productTypeChoose);
		AsosAfterSearch.productTypeChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.range);
		AsosAfterSearch.range.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.rangeChoose);
		AsosAfterSearch.rangeChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.color);
		AsosAfterSearch.color.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.colorChoose);
		AsosAfterSearch.colorChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.size);
		AsosAfterSearch.size.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.sizeChoose);
		AsosAfterSearch.sizeChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.brand);
		AsosAfterSearch.brand.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.brandChoose);
		AsosAfterSearch.brandChoose.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.priceRangeButton);
		asos.pages.AsosAfterSearch.priceRangeButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		moveSilder(20);
		
		String expected = "You've viewed 1 of 1 product";
		String actual = driver.findElement(By.cssSelector("p[data-auto-id='productsProgressBar']")).getAttribute("innerText");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(actual, expected);
	
	
	}
	@Test(groups = "dudi")
	public void AdvancedSearchNoResults() 
	{
		//driver.findElement(By.cssSelector("button[class = '_2np3kDs']")).click();
		CommonConfig.waitForElement(driver, AsosHomePage.searchBar);
		AsosHomePage.searchBar.sendKeys("Adidas");
		CommonConfig.waitForElement(driver, AsosHomePage.searchButton);
		AsosHomePage.searchButton.click();
		
		CommonConfig.waitForElement(driver, AsosAfterSearch.sort);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsosAfterSearch.sort.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.sortChoose);
		AsosAfterSearch.sortChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.gender);
		AsosAfterSearch.gender.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.genderChoose);
		AsosAfterSearch.genderChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.productType);
		AsosAfterSearch.productType.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.productTypeChoose);
		AsosAfterSearch.productTypeChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.range);
		AsosAfterSearch.range.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.rangeChoose);
		AsosAfterSearch.rangeChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.color);
		AsosAfterSearch.color.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.colorChoose);
		AsosAfterSearch.colorChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.size);
		AsosAfterSearch.size.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.sizeChoose);
		AsosAfterSearch.sizeChoose.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.brand);
		AsosAfterSearch.brand.click();
		CommonConfig.waitForElement(driver, AsosAfterSearch.brandChoose);
		AsosAfterSearch.brandChoose.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonConfig.waitForElement(driver, AsosAfterSearch.priceRangeButton);
		asos.pages.AsosAfterSearch.priceRangeButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		moveSilder(260);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "0 styles found";
		String actual = AsosAfterSearch.stylesFound.getAttribute("innerText");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(actual, expected);
	
	
	}
	
	
	@Test(enabled = false)
	public void searchItemAndLike(){
		
		asos.pages.AsosHomePage.searchBar.sendKeys("Adidas");
		asos.pages.AsosHomePage.searchButton.click();
		driver.findElement(By.cssSelector("button[class = '_2np3kDs']")).click();
		asos.pages.AsosAfterSearch.likeButton.click();	
		String active = "active";
		String liked = asos.pages.AsosAfterSearch.likeButton.getAttribute("data-auto-state");
		System.out.println(liked);
		Assert.assertEquals(active,liked);
		
		
	}
	
	public void moveSilder(int movement)
	{
		
		WebElement silder = driver.findElement(By.xpath("//*[@id='plp']/div/div[2]/div/div/div/div[1]/ul/li[8]/div/div/div/div/div/div/div/div[3]/span[1]/div"));
		Dimension dim = silder.getSize();
		int x = dim.getWidth();
		Actions act = new Actions(driver);
		// Code of Silder
		act.clickAndHold(silder).moveByOffset(movement, 0).release().build().perform();
	}

}


	
