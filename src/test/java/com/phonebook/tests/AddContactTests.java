package com.phonebook.tests;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("adam2@gm.com")
                .setPassword("Adam1234567$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on ADD link
        app.getContact().clickOnAddLink();
        //  int i = (int) (System.currentTimeMillis() / 1000)%3600;
        //fill in all fields
        app.getContact().fillAddContactForm(new Contact()
                .setName("Petr")
                .setLastname("PetrB")
                .setPhone("1234567501")
                .setEmail("petr@gm.com")
                .setAddress("Kharkiv")
                .setDesc("piece"));
        //click on save button
        app.getContact().clickOnSaveButton();
        //assert contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Petr"));
    }

    @Test(dataProvider = "addContact")
    public void addContactPositiveFromDataProviderTest(String name, String lastname,
                                                       String Phone, String email, String Adress,
                                                       String Desc) {
        //click on ADD link
        app.getContact().clickOnAddLink();
        //  int i = (int) (System.currentTimeMillis() / 1000)%3600;
        //fill in all fields
        app.getContact().fillAddContactForm(new Contact()
            .setName("Petr")
            .setLastname("PetrB")
            .setPhone("1234567501")
            .setEmail("petr@gm.com")
            .setAddress("Kharkiv")
            .setDesc("piece"));
        //click on save button
        app.getContact().clickOnSaveButton();
        //assert contact is added
        Assert.assertTrue(app.getContact().isContactCreated(name));
    }

  @Test(dataProvider = "addContactFromCsvFile")
  public void addContactPositiveFromDataProviderTest(Contact contact) {
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(contact);
    app.getContact().clickOnSaveButton();
  }

  @AfterMethod
    public void removeContact() {
        app.getContact().removeContact();
    }


  @DataProvider
  public Iterator<Object[]> addContact() {

    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"Oliver","Kan","1234567890","kan@gm.com","Berlin","goalkeeper"});
    list.add(new Object[]{"Oliver","Kan","12345678912","kan+1@gm.com","Berlin","goalkeeper"});
    list.add(new Object[]{"Oliver","Kan","12345678913","kan+2@gm.com","Berlin","goalkeeper"});

    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> addContactFromCsvFile() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contact.csv")));

    String line = reader.readLine();

    while (line!=null) {
      String[] split = line.split(",");

      list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
          .setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
      line = reader.readLine();
    }

    return list.iterator();
  }

  @Test(dataProvider = "addContactFromCsvFileWrongPhone")
  public void addContactNegativeFromDataProviderTest(Contact contact) {
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(contact);
    app.getContact().clickOnSaveButton();
  }

  @DataProvider
  public Iterator<Object[]> addContactFromCsvFileWrongPhone() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources" +
        "/ContactWrongPhone.csv")));

    String line = reader.readLine();

    while (line!=null) {
      String[] split = line.split(",");

      list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
          .setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
      line = reader.readLine();
    }

    return list.iterator();
  }


}
