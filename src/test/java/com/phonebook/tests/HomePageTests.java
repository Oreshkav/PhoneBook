package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void openHomePageTest() {
        // isHomeComponentPresent();
        //System.out.println("Home Component is " + isHomeComponentPresent1());
        Assert.assertTrue(isHomeComponentPresent());
    }
 // сделали все функции здесь и вінесли в TestBase
    //стать на пустом сесте, refactor / PullMembersUp -
    // поднимаем в родительский класс TestBase, а єтот делаем extends TestBase
    //в окне віделяем, что переносим,  Refactor - Replace -
    // и все перенесено в TestBase
}
