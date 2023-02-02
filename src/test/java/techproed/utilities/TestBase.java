package techproed.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestBase {
    //TestBase i abstract yapmamizin sebebi bu sinifin objesini olustirmak istemiyorum.
    //TestBase testBase = new TestBase(); -> YAPILAMAZ
    //Amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak.
    //driver objesini olustur.Driver ya public ya da protected olmali .
    // Sebebi child classlarda kullanilabilmesi icin.
    // Sebepi child classlarda gorulebilir olmasi

    protected static WebDriver driver;

    /*
    1. <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->pom.xml'e yuklemek
    2. Eger extentReport almak istersek ilk yapmamiz gereken ExtentReport class'indan bir obje olusturmak
    3. HTML formatinda duzenlenecegi icin ExtentHtmlReporter Class'indan obje olusturmak
     */

    protected ExtentReports extentReports;//Raporlamayi baslatiriz
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu HTML formatinda duzenler
    protected ExtentTest extentTest;//Test asamalarina extentTest objesi ile bilgi ekleriz


    // setUp
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-------------------------------------------------------------------------------------------------
        extentReports=new ExtentReports();
        String  date = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "target/ExtentReports/htmlreport"+date+".html";//Dosya yolu olarak kaydettim
        extentHtmlReporter=new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Sumeyye");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Result");



    }

    //tearDown
    @After
    public void tearDown() {
        waitFor(5);
        //driver.quit();
       // extentReports.flush();
    }

    //    MULTIPLE WINDOW
    //1 parametre alir:gecis yapmak istedigim sayfanin title'i
    //Ornek:
    // driver.get("https://the-internet.herokuapp.com/windows");
    // switchToWindow("New Window");
    //switchToWindow("The Internet  ")
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//cik loop yapmayi birak break gibi.
            }
        }
        driver.switchTo().window(origin);
    }

    //windowNumber sıfır (0)'dan başlıyor.
    // index numarasini parametre olarak alir
    //Veo indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
    @param : second
*/
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }

    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions() {
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions() {
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }


    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    //   SCREENSHOTS
    public void takeScreenShotOfPage() throws IOException, IOException {
//        1. Take screenshot
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));
    }

    //    SCREENSHOT
//    @params: WebElement
//    takes screenshot
    public void takeScreenshotOfElement(WebElement element) throws IOException {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "\\test-output/Screenshots\\" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));
    }

    //  SCROLLINTOVIEWJS methodunu olusturalim
    //    @param : WebElement
    //    Verilen webelementin uzerine kaydirir
    public void scrollIntoViewsJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    // SAYFANIN EN ALTINA IN
    // Bu method ile sayfanin en altina inebiliriz
    public void scrollEndJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //Bu method ile sayfanin en ustune cikabiliriz
    public void scrollTopJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");//eksi yonde en yukari cik demektir.
    }

    //Belirli bir elemente JS executor ile tiklanabilir
    public void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Javascript ile bir elemanin degerini(value) degistirebiliriz.
    //GIRMIS OLDUGUM METNI ELEMENTE YAZDIRIR.
    //Bu method sendKeys metoduna bir alternatifdir.
    //sendKeys oncelikli tercihimizdir.
    public void typeWithJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }


    //   input elementindeki degerleri al. Belirli bir elementin value degerini verecek. Inputdaki halihazirdaki degeri verir.
    //   Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür
    //        input elementindeki degerleri al
//        return
//        document HTML E GIT
//        .getElementById('"+idOfElement+"') ID SI VERILEN ELEMENTI BUL
//        .value") VALUE ATTRIBUTE INDEKI DEGERI BUL
//        .toString() STRINGE CEVIR
    public void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();//Bu kisim bana inputdaki degeri (value yu) verir.
        System.out.println("Kutudaki deger: " + text);
        //        NOT: document.querySelector("p").value;  -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR
    }


}

/*
//   Js Executer Scroll
public static void jsScroll(By locator){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement elementName = driver.findElement(locator);
    js.executeScript("arguments[0].scrollIntoView(true);",elementName);
}
 */

/*
public static void clickOutside() {
    Actions action = new Actions(driver);
    action.moveByOffset(0, 0).click().build().perform();
}
 */
/*public static void dragAndDrop(String adres1,String adres2) {
    Actions actions = new Actions(driver);
    WebElement kaynak = driver.findElement(By.xpath(adres1));
    WebElement hedef = driver.findElement(By.xpath(adres2));
    actions.dragAndDrop(kaynak, hedef).build().perform();
}

 */

