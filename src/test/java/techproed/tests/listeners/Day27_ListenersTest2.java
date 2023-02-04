package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
//import techproed.utilities.Driver;
/*
1. listeners paketi olustur
2. ListenersTest2 classi olustur
3. 4 tane metot olustur: test1(PASS), test2(FAIL), test3(SKIP), test4(NOSUCHELEMETNEXCEPTION)
4. Test classi Listeners class ile iliskilendir
xml file i olustur
Ismi değiştir: listeners1.xml
Code > Reformat code
Listeners tagini suite taginden hemen sonra kullan
<listeners>
  <listener class-name="techproed.utilities.Listeners"></listener>
</listeners>
 */



public class Day27_ListenersTest2 {
    @Test
    public void test1(){
        System.out.println("PASS");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("FAIL");
//        throw new NoSuchElementException("No Such Element Exception");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));//FAIL ETSIN
    }
    @Test
    public void test3(){
        System.out.println("SKIP");
        throw new SkipException("Metotu Atla");
    }
    @Test
    public void test4(){
        System.out.println("EXCEPTION");
//        throw new NoSuchElementException("No Such Element Exception");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));//FAIL ETSIN
    }
}

