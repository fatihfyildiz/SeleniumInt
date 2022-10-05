package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {

    /*
    Gerekli ayarlamalari yapip amazon sayfasina gidiniz
    1- Sayfa basligi "amazon" kelimesi icermeli
    2- Sayfa url'inde "Amazon" kelimesi olmali
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");

        String expectedTitleContent= "amazon";
        String expectedUrlContent= "Amazon";

        String actualUrl= driver.getCurrentUrl();
        String actualTitle= driver.getTitle();

        // hadi simdi test edelim...
        // once url testi...

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Url test PASSED");
        } else {
            System.out.println("Url test FAILED");
            System.out.println("Actual Url : " + actualUrl);
            System.out.println("Actual Url aranan " + expectedUrlContent + " kelimesini icermiyor");
        }

        // title test

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
            System.out.println("Actual Title : " + actualTitle);
            System.out.println("Actual Title aranan " + expectedTitleContent + " kelimesini icermiyor");
        }

        driver.quit();

        /*
        driver.close() ==> sadece acik olan browser'i kapatir
        driver.quit() ==> ise test calisirken acilan tum browser'lari kapatir
         */
    }
}
