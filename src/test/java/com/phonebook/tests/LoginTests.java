package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  public void ensurePrecondition() {
    if (!isElementPresent(By.cssSelector("[href='/login']")))
    {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  @Test
  public void newUserRegistrationPisitiveTest () {
    //click on login link
    click(By.cssSelector("[href='/login']"));
    //enter email
    type(By.cssSelector("[placeholder='Email']"), "koss@gmail.com");
//  enter password
    type(By.cssSelector("[placeholder='Password']"), "Koss123456$");
    //click on registration burton
    click(By.name("login"));
    // assert Sign aout button
    Assert.assertTrue(isElementPresent1(By.xpath("//button[.='Sign Out']")));
  }
}
