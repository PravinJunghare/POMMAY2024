package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private By logoutLink = By.linkText("Logout");
	private By accHeader = By.xpath("//div[@id='content']//h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");

	public String getAccPageTitle() {
		String title = elementUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		//String title = elementUtil.waitForTitleIsAndFetch(10, "My Account");
		// String title=driver.getTitle();
		System.out.println("Account page title " + title);
		return title;
	}

	public String getAccPageUrl() {
		String url = elementUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		//String url = elementUtil.waitForURLContainsAndFetch(10, "route=account/account");
		// String url=driver.getTitle();
		System.out.println("Account page url " + url);
		return url;
	}

	public boolean isLogoutLinkExists() {
		return elementUtil.waitForElementVisible(logoutLink, AppConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
		// return driver.findElement(logoutLink).isDisplayed();

	}

	public boolean isSearchExists() {
		//
		return elementUtil.waitForElementVisible(search, AppConstants.DEFAULT_LONG_TIMEOUT).isDisplayed();
		// return driver.findElement(search).isDisplayed();
	}

	public List<String> getAccountsPageHeaderList() {

		List<WebElement> accHeaderList = elementUtil.waitForElementsPresence(accHeader, AppConstants.DEFAULT_LONG_TIMEOUT);// driver.findElements(accHeader);
		List<String> accHeaderValList = new ArrayList<String>();

		for (WebElement e : accHeaderList) {
			String text = e.getText();
			accHeaderValList.add(text);
		}
		return accHeaderValList;
	}
}
