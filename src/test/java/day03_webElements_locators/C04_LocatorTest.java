package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_LocatorTest {

    /*
    2. Create the main method and complete the following tasks:
        a. go to the website: https://www.amazon.com/
        b. search "city bike"
        c. print the related results on Amazon web page
        d. click on the image of the first result

    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        a.web sayfasına gidin. https://www.amazon.com/
        b. Search(ara) “city bike”
        c. Amazon’da görüntülenen ilgili sonuçların sayısını yazdırın
        d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("city bike" + Keys.ENTER);
        /*
        alternatively, this last (above) task can be also done by the following two:
        searchBox.sendKeys("city bike")
        searchBox.submit();
         */

        List<WebElement> resultWebElementList= driver.findElements(By.className("sg-col-inner"));

        System.out.println(resultWebElementList.size()); // 122 ==> current size
        // if we want to find the first element of those results...

        System.out.println(resultWebElementList.get(0));
        // [[ChromeDriver: chrome on WINDOWS (f075161929cc556d94c25e669adcb707)] -> class name: sg-col-inner]

        System.out.println(resultWebElementList.get(0).getText());
        // 1-16 of 140 results for "city bike" ==> current text

        driver.findElement(By.className("s-image")).click();
        // if more than one element might be found by a locator, then Selenium will just use the first one

        Thread.sleep(5000);

        driver.close();

    }

}
