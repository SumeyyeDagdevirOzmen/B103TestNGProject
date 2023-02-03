package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalHomePage {
    public BlueRentalHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);//constructor olustur
    }
    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;

//    @FindBy(xpath= "//select[@name='car']")
//
//    public WebElement selectCar;
//
//    @FindBy(xpath = "//input[@name='pickUpLocation']")
//    public WebElement pickUpLocation;
//
//    @FindBy(name="pickUpLocation")
//    public WebElement pickUpLocationSelect;
//
//    @FindBy(name="dropOfLocation")
//    public WebElement dropOfLocationSelect;
//
//    @FindBy(name="pickUpDate")
//    public WebElement pickUpDateSelect;
//
//    @FindBy(name="dropOffDate")
//    public WebElement dropOfDateSelect;
//
//    @FindBy(name="pickUpTime")
//    public WebElement pickUpTimeSelect;
//
//    @FindBy(name="dropOffTime")
//    public WebElement dropOfTimeSelect;
//
//    @FindBy(className = "w-100 btn btn-primary btn-lg")
//    public WebElement submitCarButton;
//
//    @FindBy(xpath = "//div[text()='Please first login']")
//    public WebElement firstLoginMessage;
}


