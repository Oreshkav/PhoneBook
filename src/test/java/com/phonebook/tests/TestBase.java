package com.phonebook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {
  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    // чтобы не выводились системные ошибки в терминале
    System.err.close();

      driver = new ChromeDriver();
      driver.get("https://telranedu.web.app");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  public boolean isHomeComponentPresent() {
      return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
  }

  public boolean isElementPresent(By locator) {
      return driver.findElements(locator).size()>0;
  }

  public boolean isHomeComponentPresent1() {
      try {
          driver.findElement(By.xpath("//h1[.='Home Component']"));
          return true;
      }catch (NoSuchElementException ex) {
          return false;
      }
  }

  public boolean isElementPresent1(By locator) {
      try {
          driver.findElement(locator);
          return true;
      }catch (NoSuchElementException ex) {
          return false;
      }
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
      driver.quit();
  }

  //заменяем три строки из CreateAccount  на функцию.
  public void type(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public boolean isAlertPresent() {
    Alert alert = new WebDriverWait(driver,
        Duration.ofSeconds(20))
            .until(ExpectedConditions.alertIsPresent());
    if (alert == null) {
      return false;
    } else {
      driver.switchTo().alert();
      alert.accept();
      return true;
    }
  }

  //precondition user should be logged out
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      driver.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.cssSelector("[href='/login']"));
  }

  public void clickOnRegistrationButton() {
    click(By.name("registration"));
  }

  public void clickOnLoginLink() {
    click(By.cssSelector("[href='/login']"));
  }

  public void fillLoginRegistrationForm() {
    type(By.cssSelector("[placeholder='Email']"), "koss@gmail.com");
    type(By.cssSelector("[placeholder='Password']"), "Koss123456$");
  }

  public void clickOnAddLink() {
    click(By.xpath("//a[.='ADD']"));
  }

  public void clickOnSaveButton() {
    click(By.cssSelector(".add_form__2rsm2 button"));
  }

  public void fillAddContactForm() {
    type(By.cssSelector("input:nth-child(1)"), "Mix");
    type(By.cssSelector("input:nth-child(2)"), "Brenz");
    type(By.cssSelector("input:nth-child(3)"), "1234567890");
    type(By.cssSelector("input:nth-child(4)"), "qqq@qqq.com");
    type(By.cssSelector("input:nth-child(5)"), "Paris");
    type(By.cssSelector("input:nth-child(6)"), "must visit that guy");
  }

  public boolean isContactCreated(String text) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
    for (WebElement element : contacts) {
      if (element.getText().contains((text));
    }
    return false;
  }
}
