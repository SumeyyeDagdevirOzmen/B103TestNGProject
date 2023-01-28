package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_US101122_Negative_Login {
    //Name:
    //US101122_Negative_Login
    //Description:
    //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
    //Acceptance Criteria:
    //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
    //Error Message: email must be a valid email
    //Dogru email uzantisi girildiğinde hata mesajı alınmamalı

    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;
    @Test
    public void US101122_Negative_Login() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("gecersiz_email"));
        Thread.sleep(3000);
        Assert.assertTrue(blueRentalLoginPage.email_error_message.isDisplayed());
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("customer_email"));
        Assert.assertFalse(blueRentalLoginPage.email_error_message.isDisplayed());

        Driver.closeDriver();

    }
}
