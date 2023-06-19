package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CreateAccountTests extends TestBase {


  @Test
  public void existetUserRegistrationNegativeTest() {
    //click on login link
//    driver.findElement(By.cssSelector("[href='/login']")).click();
    clickOnLoginLink();

    //віделить все три строки - рефактор

    //enter email
//    driver.findElement(By.cssSelector("[placeholder='Email']")).click();
//    driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
//    driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("koss@gmail.com");
    fillLoginRegistrationForm();
//    driver.findElement(By.cssSelector("[placeholder='Password']")).click();
//    driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
//    driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Koss123456$");

    //click on registration button
    clickOnRegistrationButton();
    // assert Sign aout button
    //тест после проверки стал невалидній, переименовали его в негативній тест и удаляем ассерт труе
    //    Assert.assertTrue(isElementPresent1(By.xpath("//button[.='Sign Out']")));
    Assert.assertTrue(isAlertPresent());
  }

}

