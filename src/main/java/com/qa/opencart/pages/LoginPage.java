package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	// 1. private webdriver
	private WebDriver driver;
	private ElementUtil elementUtil;

	// 2.public constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgottenPwdlink = By.id("input-email");
	private By registerlink = By.linkText("Register");

	// 4 Page Actions

	public String getLoginPageTitle() {
		String title=elementUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		//String title=elementUtil.waitForTitleIsAndFetch(10, "Account Login");
		//String title = driver.getTitle();
		System.out.println("Login Page Title"+title);
		return title;
	}

	public String getLoginUrl() {
		String url =elementUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		//String url =elementUtil.waitForURLContainsAndFetch(10, "route=account/login");
		//String url = driver.getCurrentUrl();
		System.out.println("LoginPage Url :"+url);
		return url;
	}

	public boolean isForgotpwdLinkExits() {
		return elementUtil.waitForElementVisible(forgottenPwdlink, AppConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
		//return elementUtil.waitForElementVisible(forgottenPwdlink, 10).isDisplayed();
		// return driver.findElement(forgottenPwdlink).isDisplayed();
	}

	public AccountsPage doLogin(String un, String pwd) {

		
		System.out.println("App Credientials are :"+ un+":"+ pwd);
		
		elementUtil.waitForElementVisible(emailId, AppConstants.DEFAULT_SHORT_TIMEOUT).sendKeys(un);
		//elementUtil.waitForElementVisible(emailId, 10).sendKeys(un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);

		// Removed driver. method() with elementutil
		// driver.findElement(emailId).sendKeys(un);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(loginBtn).click();

	}

}
