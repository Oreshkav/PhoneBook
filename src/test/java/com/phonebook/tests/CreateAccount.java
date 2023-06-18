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
//    driver.findElement(By.cssSelector("[href='/login']")).click();
    click(By.cssSelector("[href='/login']"));

    //віделить все три строки - рефактор

    //enter email
//    driver.findElement(By.cssSelector("[placeholder='Email']")).click();
//    driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
//    driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("koss@gmail.com");
    type(By.cssSelector("[placeholder='Email']"), "koss@gmail.com");

//  enter password
    type(By.cssSelector("[placeholder='Password']"), "Koss123456$");
//    driver.findElement(By.cssSelector("[placeholder='Password']")).click();
//    driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
//    driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Koss123456$");

    //click on registration button
   click(By.name("registration"));
  // assert Sign aout button
    Assert.assertTrue(isElementPresent1(By.xpath("//button[.='Sign Out']")));

  }

}

