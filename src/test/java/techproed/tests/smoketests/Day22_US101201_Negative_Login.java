package techproed.tests.smoketests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

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
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();


        Select select=new Select(blueRentalHomePage.selectCar);
       // List<WebElement> carOptions= select.getOptions();
        Thread.sleep(2000);
        blueRentalHomePage.selectCar.click();
        Thread.sleep(3000);
        select.selectByValue("3");
        blueRentalHomePage.selectCar.click();
    }
}