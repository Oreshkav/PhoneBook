package com.phonebook.tests;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
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

public class AddContactNegativeTests extends TestBase{

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
