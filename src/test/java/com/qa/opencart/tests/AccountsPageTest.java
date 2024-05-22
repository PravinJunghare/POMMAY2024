package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetU() {
		accountsPage = loginPage.doLogin("pravinjunghare01@gmail.com", "Test@1234");
	}

	@Test
	public void accountsPageTitleTest() {
		String actTitle = accountsPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	 @Test
	 public void accountsPageUrlTest() {
	 String actUrl = accountsPage.getAccPageUrl();
	 Assert.assertTrue(actUrl.contains(AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE));
	 }

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExists());
	}

	@Test
	public void accountHeaderTest() {
		List<String> actualAccHeaderList = accountsPage.getAccountsPageHeaderList();
		System.out.println("acc page headers" + actualAccHeaderList);
		Assert.assertEquals(actualAccHeaderList.size(), AppConstants.ACCOUNTS_PAGE_HEADERCOUNT);

	}

}
