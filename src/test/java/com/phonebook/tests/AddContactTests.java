package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
    clickOnLoginLink();
    type(By.cssSelector("[placeholder='Email']"), "alex2@gmail.com");
    type(By.cssSelector("[placeholder='Password']"), "Word212345$");
    click(By.name("login"));
  }

  @Test
  public void addContactPositiveTest() {
    clickOnAddLink();
//    int i =(int) (System.currentTimeMillis() / 1000)%3600;
    fillAddContactForm();
    clickOnSaveButton();
    Assert.assertTrue(isContactCreated("Val"));
  }

}