package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String,String>> excelDatalari;//Gelen degiskeni java icinde tutmak icin bir list olusturdum.
// Bu method login sayfasina gitmek icin kullanilacak
    public void login(){
        // Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //HomePage login e tikla
        blueRentalHomePage= new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

//        ------SADECE ILK GIRIS---------
//        loginLink butonu sadece ilk girisde sayfada gorunur
//        ikinci ve ucunci girislerde sayfada gorunmeyeceginden NOSUCHELEMENTEXCEPTION alinir
//        Biz bu exception u try catch kullanarak yakalariz ve test cases calismaya devam eder
        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
//        LOGIN SAYFASINDAYIZ
        }catch (Exception e){
        }
//      -------------SONRAKI GIRISLER------
        try{
//            kullanici ID ye tikla      --->>> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla       --->>> try catch
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
//            OK e tikla                --->>> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page logine tikla    --->>> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
            //LOGIN SAYFASINDAYIZ
        }catch (Exception e){
        }



    }

    @Test
    public void customerLogin(){
        String path ="./src/test/java/resources/mysmoketestdata.xlsx";//Relative path i aldik
        // ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH. KULLANMAZSAK ONCEKI KISIMLARI UMURSAMA PROJEMDEKI SRC DOSYASINDAN BASLA demektir.

        String sayfa="customer_info";
        // DATALARI EXCEL UTILS METHODLARINI KULLANARAK BU SINIFA ALICAZ
        excelUtils= new ExcelUtils(path,sayfa);
        // excel datalarini getDataList() methodu ile cekelim
        excelDatalari= excelUtils.getDataList();
        // LOOP KULLANARAK DATALARI TEK TEK TEST CASE'DE KULLAN
        for(Map<String,String> data: excelDatalari){
            login();// Her loop da Login sayfasina goturecek
            ReusableMethods.waitFor(1);
            // Kullanici adini gir
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            //Kullanici sifresini gir
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            //Login butonuna tikla
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);

        }

    }
}

/*
sam.walker@bluerentalcars.com	c!fas_art
kate.brown@bluerentalcars.com	tad1$Fas
raj.khan@bluerentalcars.com	v7Hg_va^
pam.raymond@bluerentalcars.com	Nga^g6!

------ILK GIRIS---------
HOME PAGE DEYIZ
home page logine tikla---->>try catch
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al)
login page login buttonuna tikla
------2. GIRIS-----
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al)
login page login buttonuna tikla
------3. GIRIS---------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
---------4. GIRIS------------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini gir(excelden al)
login page login buttonuna tikla


 */