package com.telran.webshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        //precondition: user should be logged out
        if (!isElementPresent(By.xpath("//a[contains(.,'Log in')]"))){
            click(By.xpath("//a[contains(.,'Log out')]"));
        } else {
            //click Login link
            click(By.xpath("//a[contains(.,'Log in')]"));
        }
    }

    @Test
    public void loginPositiveTest() throws InterruptedException {
        //assert is registration form dispalyed
        Assert.assertTrue(isElementPresent(By.cssSelector(".returning-wrapper")));
        //fill login form
        type(By.cssSelector("[autofocus='autofocus']"), "rg.94@mail.ru");
        type(By.xpath("//input[@id='Password']"), "qwerty1234");
        //click on Registration button
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]"));
        //verify Log Out button displayed
        pause(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'Log out')]")));

    }



}
