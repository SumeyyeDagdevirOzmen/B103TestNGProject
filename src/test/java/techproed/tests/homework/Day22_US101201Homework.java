package techproed.tests.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBase;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Day22_US101201Homework {
    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;

    @Test
    public void test03() {
//
//        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        blueRentalHomePage = new BlueRentalHomePage();
//        blueRentalLoginPage = new BlueRentalLoginPage();
//        Select car = new Select(blueRentalHomePage.selectCar);
//        car.selectByValue(String.valueOf(randomSelectValue()));
//        blueRentalHomePage.pickUpLocationSelect.sendKeys(Faker.instance(Locale.US).address().cityName());
//        blueRentalHomePage.dropOfLocationSelect.sendKeys(Faker.instance(Locale.US).address().cityName());
//
//    LocalDate localDate1 = LocalDate.now();
//    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//    LocalTime localTime = LocalTime.now();
//    SimpleDateFormat dtfHour = new SimpleDateFormat("HH:'00'");
//    Calendar calendar = Calendar.getInstance(Locale.US);
//        calendar.add(Calendar.HOUR,2);     // Simdiki saatten 2 saat sonrasina
//        blueRentalHomePage.pickUpDateSelect.sendKeys(dateTimeFormatter.format(localDate1));
//        blueRentalHomePage.pickUpTimeSelect.sendKeys(dtfHour.format(calendar.getTime()));
//        blueRentalHomePage.dropOfDateSelect.sendKeys(dateTimeFormatter.format(localDate1.plusWeeks(1)));
//        blueRentalHomePage.dropOfTimeSelect.sendKeys(dtfHour.format(calendar.getTime()));
//        blueRentalHomePage.submitCarButton.click();
//        TestBase.waitFor(1);
//        System.out.println(blueRentalHomePage.firstLoginMessage.getText());
//        assert blueRentalHomePage.firstLoginMessage.isDisplayed();
//        TestBase.waitFor(3);
//        Driver.closeDriver();
//}
//    public int randomSelectValue() {
//        int rnd = (int) (Math.random() * 16);
//        if (rnd == 0 || rnd == 1 || rnd == 14) {
//            randomSelectValue();
//        }
//        return rnd;
//    }
    }
}