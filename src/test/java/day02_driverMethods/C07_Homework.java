package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Homework {

    public static void main(String[] args) throws InterruptedException {

        /*
        1.Yeni bir class olusturalim (Homework)
        2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
         degilse dogru basligi yazdirin.
        3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        4.https://www.walmart.com/ sayfasina gidin.
        5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        6. Tekrar “facebook” sayfasina donun
        7. Sayfayi yenileyin
        8. Sayfayi tam sayfa (maximize) yapin
        9.Browser’i kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedTitleContent= "facebook";
        String expectedUrlContent= "facebook";

        String actualUrl= driver.getCurrentUrl();
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
            System.out.println("Actual Title : " + actualTitle);
            System.out.println("Actual Title doesn't contain " + expectedTitleContent + " word");
        }

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Url test PASSED");
        } else {
            System.out.println("Url test FAILED");
            System.out.println("Actual Url : " + actualUrl);
            System.out.println("Actual Url doesn't contain " + expectedUrlContent + " word");
        }

        Thread.sleep(2000);

        driver.navigate().to("https://www.walmart.com/");

        String expectedTitleContent2= "Walmart.com";
        String actualTitle2= driver.getTitle();

        if (actualTitle2.contains(expectedTitleContent2)){
            System.out.println("Title test-2 PASSED");
        } else {
            System.out.println("Title test-2 FAILED");
            System.out.println("Actual Title-2 : " + actualTitle2);
            System.out.println("Actual Title-2 doesn't contain " + expectedTitleContent2 + " word");
        }

        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.close();

    }
}
