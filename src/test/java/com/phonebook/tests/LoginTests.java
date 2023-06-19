package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  public void ensurePrecondition() {
    if (!isLoginLinkPresent())
    {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  @Test
  public void newUserRegistrationPisitiveTest () {

    //click on login link
    clickOnLoginLink();

    //enter email
    fillLoginRegistrationForm();

    //click on registration burton
    clickOnLoginButton();

    // assert Sign out button
    Assert.assertTrue(isSignOutButtonPresent());
  }

  public boolean isSignOutButtonPresent() {
    return isElementPresent1(By.xpath("//button[.='Sign Out']"));
  }

  public void clickOnLoginButton() {
    click(By.name("login"));
  }
}
