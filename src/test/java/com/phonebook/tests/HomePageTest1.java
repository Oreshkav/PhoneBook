package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest1  {
  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://ilcarro.web.app");
    driver.manage().window();
//    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test
  public void openHomePageTest() {
    System.out.println("Home components is " + isHomeComponentPresent());
    Assert.assertTrue(isElementPresent(By.cssSelector("div:nth-child(2)>div>div")));
  }

  public boolean isHomeComponentPresent() {
    return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
  }

  //By -локатор селениума,  locator - переменная
  public boolean isElementPresent(By locator) {
    // (любое имя)
    return driver.findElements(locator).size() > 0;
  }

  public boolean isHomeComponentPresent1() {
    try {
      driver.findElement(By.xpath("//h1[.='Home Component']"));
      return true;
    } catch (NoSuchElementException exeption) {
      return false;
    }
  }

  public boolean isElementPresent1(By locator) {
    try {
      driver.findElement(By.xpath("//h1[.='Home Component']"));
      return true;
    } catch (NoSuchElementException exeption) {
      return false;
    }
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }

}
