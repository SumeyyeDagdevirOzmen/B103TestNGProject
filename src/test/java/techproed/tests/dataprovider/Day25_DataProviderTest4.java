package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day25_DataProviderTest4 {
    //Bu ornekte data provider methodumuz Util classdan gelecek

    //Musteri verileri
    @Test(dataProvider = "musteriVerileri", dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username, String password,String sube) {

        System.out.println("Username : " + username + ". Password : " + password+". Sube : "+sube);//Username : menejer1. Password : 12345
        //Username : menejer2. Password : 98765
        //Username : menejer3. Password : 5678
    }

    //musteriHizmetleriVerileri

    @Test(dataProvider = "musteriHizmetleriVerileri", dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileriTest(String username, String password) {

        System.out.println(username + "  |  " + password);
    }

    // customerData
    @Test(dataProvider = "customerData", dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String username, String password) {
        System.out.println("EXCEL DATALARIM");
        System.out.println(username + " ||| " + password);
    }
}