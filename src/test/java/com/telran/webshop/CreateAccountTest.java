package com.telran.webshop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{


    @BeforeMethod
    public void ensurePreconditions(){
        //precondition: user should be logged out
        if (!isElementPresent(By.xpath("//a[contains(.,'Log in')]"))){
            driver.findElement(By.xpath("//a[contains(.,'Log out')]")).click();
        } else {
            //click Login link
            driver.findElement(By.xpath("//a[contains(.,'Log in')]")).click();
        }
    }

    //test
    @Test
    public void createAccountPositiveTest() throws InterruptedException {
        //click on Registration button
        driver.findElement(By.cssSelector("[class='button-1 register-button']")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Robert");
        driver.findElement(By.xpath("//input[@id='LastName']")).click();
        driver.findElement(By.xpath("//input[@id='LastName']")).clear();
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Matiz");
        driver.findElement(By.xpath("//input[@id='Email']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).clear();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("forstranger@mail.ru");
        driver.findElement(By.xpath("//input[@id='Password']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).clear();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).click();
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        //verify Log Out button displayed
        Thread.sleep(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'Log out')]")));
    }

    public boolean isAllertPresent(){
        Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        } else {
            driver.switchTo().alert();
            return true;
        }
    }

    @Test
    public void createAccountNagativTest() throws InterruptedException {
        //click on Registration button
        driver.findElement(By.cssSelector("[class='button-1 register-button']")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Robert");
        driver.findElement(By.xpath("//input[@id='LastName']")).click();
        driver.findElement(By.xpath("//input[@id='LastName']")).clear();
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Matiz");
        driver.findElement(By.xpath("//input[@id='Email']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).clear();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("rm@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).clear();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).click();
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        //verify Log Out button displayed
        Thread.sleep(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//li[contains(text(),'The specified email already exists')]")));
    }

//    @Test
//    public void createNegativPositiveTest() throws InterruptedException {
//        //assert is registration form dispalyed
//        Assert.assertTrue(isElementPresent(By.cssSelector(".returning-wrapper")));
//        //fill registration form
//        driver.findElement(By.cssSelector("[autofocus='autofocus']")).click();
//        driver.findElement(By.cssSelector("[autofocus='autofocus']")).clear();
//        driver.findElement(By.cssSelector("[autofocus='autofocus']")).sendKeys("gr.94@mail.ru");
//        driver.findElement(By.xpath("//input[@id='Password']")).click();
//        driver.findElement(By.xpath("//input[@id='Password']")).clear();
//        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("qwerty1234");
//        //click on Registration button
//        driver.findElement(By.cssSelector("[class='button-1 register-button']")).click();
//        //verify Log Out button displayed
//        Thread.sleep(1000);
//        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'Log out')]")));
//    }





}
