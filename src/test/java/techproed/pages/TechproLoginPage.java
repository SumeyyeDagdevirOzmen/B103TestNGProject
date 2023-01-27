package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproLoginPage {
/*
https://testcenter.techproeducation.com/index.php?page=form-authentication
Page object Model kullanarak sayfaya giriş yapildigini test edin
Sayfadan cikis yap ve cikis yapildigini test et
techproed
SuperSecretPassword
TechproLoginPage
userName
password
submitButton
TechproHomePage
homeHeader
homeLogoutButton
TEST:
Class: TechproLoginTest
Metot : loginTest()
 */
    public TechproLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "exampleInputEmail1")
    public WebElement username;
    @FindBy(id = "exampleInputPassword1")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


}
