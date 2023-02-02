package techproed.tests.homework;
//    Name:
//    US101201_Negative_Login
//    Description:
//    Geçerli giriş yapmadan rezervasyon yapamamalı
//    Acceptance Criteria:
//    Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
//    Ve giris yapilmadiginda
//    Hata mesaji almali : Please first login
//    Giris yapildiginda hata mesaji alınmamalı


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day22_US101201_NegativeLogin2 {
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test
    public void US101201_Negative_Login() throws IOException {
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Select select = new Select(blueRentalHomePage.selectCar);
        select.selectByValue("9");
        blueRentalHomePage.pickUpLocation.sendKeys("Florida Pensacola", Keys.TAB, "Oregon Albany", Keys.TAB, "12.12.2023", Keys.TAB, "100",
                Keys.TAB, "14.12.2023", Keys.TAB, "100", Keys.TAB, Keys.ENTER);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.firstLoginMessage);
        ReusableMethods.getScreenshot("Ekran goruntusu");


        //login yaptiktansonra
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        select = new Select(blueRentalHomePage.selectCar);//selectCar
        select.selectByValue("9");
        blueRentalHomePage.pickUpLocation.sendKeys("Florida Pensacola", Keys.TAB, "Oregon Albany", Keys.TAB, "12.12.2023", Keys.TAB, "100",
                Keys.TAB, "14.12.2023", Keys.TAB, "100", Keys.TAB, Keys.ENTER);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.firstLoginMessage);
        ReusableMethods.getScreenshot("Ekran goruntusu");
    }

}