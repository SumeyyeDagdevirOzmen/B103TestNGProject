package techproed.tests.homework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class Day22_US101201_Negative_Login {
    //Name:
    //US101201_Negative_Login
    //Description:
    //Geçerli giriş yapmadan rezervasyon yapamamalı
    //Acceptance Criteria:
    //Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
    //Ve giris yapilmadiginda
    //Hata mesaji almali : Please first login
    //Giris yapildiginda hata mesaji alınmamalı

    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;




    @Test
    public void US101122_Negative_Login() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();


        Select select=new Select(blueRentalHomePage.selectCar);


        Thread.sleep(2000);
        try {
            blueRentalHomePage.selectCar.click();
        } catch (Exception e) {
           js.executeScript("arguments[0].click();",blueRentalHomePage.selectCar);
        }
        Thread.sleep(3000);
        select.selectByValue("3");




        blueRentalHomePage.pickUpLocationSelect.sendKeys("New York Terryville");
        blueRentalHomePage.dropOfLocationSelect.sendKeys("New York Lloyd");
//        Pick Up date
//        Pick Up time
//        Drop Off date
//        Drop Off time
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmaa");
        Calendar calendar = Calendar.getInstance();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dtf.format(currentDate);
        blueRentalHomePage.pickUpDateSelect.sendKeys(formattedDate);
        blueRentalHomePage.pickUpTimeSelect.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.dropOfDateSelect.sendKeys("05.02.2023");
        blueRentalHomePage.dropOfTimeSelect.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.submitCarButton.click();

            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.submitCarButton);


        }
    }





/*
  //Error message : Please first login
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_home_url"));
        //Select a car
        Select car = new Select(blueRentalHomePage.selectACar);
        car.selectByValue("10");
        blueRentalHomePage.pickUpLocation.sendKeys(Faker.instance(Locale.JAPAN).address().cityName());
        blueRentalHomePage.dropOfLocation.sendKeys(Faker.instance(Locale.JAPAN).address().cityName());
//        Pick Up date
//        Pick Up time
//        Drop Off date
//        Drop Off time
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmaa");
        Calendar calendar = Calendar.getInstance();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dtf.format(currentDate);
        blueRentalHomePage.pickUpDate.sendKeys(formattedDate);
        blueRentalHomePage.pickUpTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.dropOffDate.sendKeys("05.02.2023");
        blueRentalHomePage.dropOffTime.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.continueReservationButton.click();
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.pleaseFirstLogin);
    }
    @AfterClass
    public void closeDriver(){
        Driver.closeDriver();
    }
 */