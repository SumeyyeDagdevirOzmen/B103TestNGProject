package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    //Page Objelerini bu sinifta buluruz

    // 1. constructor: herbir page sinifi constructorla baslamak zorundadir.
    public OpenSourcePage() {
        //PageFactory seleniumdan gelen ve bu sayfa elemmentlerini instantiate(baslangic degeri vermek) etmek icin kullanilir.
        //Sayfa objeleri cagrildiginda nullpointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(), this);//Elementlere deger vermek icin kullanilir. Null pointer exception almamak icin.

    }

    //PAGE OBJELERINI OLUSTUR
    // GELENEKSEL = public WebElement username = driver.getDriver().findElement(By.name("username")); geleneksel yol ile web element bulma seklimiz buydu.
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitButton;















}