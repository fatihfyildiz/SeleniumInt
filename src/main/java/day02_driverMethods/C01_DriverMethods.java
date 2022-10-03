package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        // FFY: Kodlari boyle birakirsak, bos bir sayfa/sekme olusturur ama herhangi bir url'ye gitmez
        // Hoca: driver objesi olusturunca Selenium WebDriver,
        // bilgisayarimizda chrome browser'dan bir bos sayfa actirir...

        /*
        Eger firefo veya edge ya da safari gibi baska browser kullanmak istersek
        Selenium sitesinden o browser'in WebDriver'ini indirip projemize eklememiz gerekir
         */

        driver.get("https://www.amazon.com"); // Amazon web site acar

        // Eger kodlarimiz belli bir sure bekletmek istersek
        Thread.sleep(5000); // yazilan milisaniye kadar kodlari bekletir...

        System.out.println("sayfa url'i : " + driver.getCurrentUrl());

        System.out.println("sayfanin title'i : " + driver.getTitle());

        driver.close(); // // Amazon web site acar ve acilma tamamlaninca hemen kapatir




    }

}
