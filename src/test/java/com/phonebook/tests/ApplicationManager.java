package com.phonebook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

  WebDriver driver;
  UserHelper user;
  ContactHelper contact;
  HomePageHelper homePage;

  public void init() {
      System.err.close();

      driver = new ChromeDriver();
      driver.get("https://telranedu.web.app");
//        driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      user = new UserHelper(driver);
      contact = new ContactHelper(driver);
      homePage = new HomePageHelper(driver);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public UserHelper getUser() {
    return user;
  }

  public ContactHelper getContact() {
    return contact;
  }

  public HomePageHelper getHomePage() {
    return homePage;
  }

  public void stop() {
      driver.quit();
  }

}
