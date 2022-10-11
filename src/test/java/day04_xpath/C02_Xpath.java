package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {

    public static void main(String[] args) throws InterruptedException {

        // 1-Yeni bir class olusturun
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(2000);

        // 4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        // 5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle= driver.getTitle();
        String searchedText= "Spend less";

        if (driver.getTitle().contains(searchedText)) {
            System.out.println("Title contains the searched word, title test PASSED");
        }else {
            System.out.println("Title test FAILED");
        }

        // 6- Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();

        /*
         We did as above (since there is only one Gift Car in the current HTML codes)...

        But alternatively, we can also do as follows:

        WebElement giftCard= driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));
        giftCard.click();
         */

        // 7- Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();

        /*
        FFY:
        WebElement birthdayButton= driver.findElement(By.xpath("//*[@id=\"contentGrid_420836\"]/div/div[2]/div[3]/div/div/a/img"));
         */

        // 8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

        // 9- Gift card details’den 25 $’i  secin
        driver.findElement(By.xpath("//button[@value='25']")).click();

        // 10-Urun ucretinin 25$ oldugunu test edin
        WebElement priceElement= driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));

        System.out.println(priceElement);

        String actualPriceStr= priceElement.getText();
        String expectedPriceStr= "$25.00";

        if (actualPriceStr.equals(expectedPriceStr)){
            System.out.println("Gift Card test PASSED");
        } else {
            System.out.println("Price of Gift Card is different, related test FAILED");
        }

        // 11-Sayfayi kapatin
        driver.close();

    }
}
