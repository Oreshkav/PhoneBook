package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CreateAccount extends TestBase {
  //precondition user should be logged out
  @BeforeMethod
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
   click(By.name("registration"));
  // assert Sign aout button
    Assert.assertTrue(isElementPresent1(By.xpath("//button[.='Sign Out']")));

  }

}

