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
        // veya asagidaki gibi iki satirla da bu isi halledebiliriz
        // searchBox.sendKeys("city bike")
        // searchBox.submit();

        List<WebElement> resultWebElementList= driver.findElements(By.className("sg-col-inner"));

        System.out.println(resultWebElementList.size()); // 122 ==> current size
        // bu listenin 1nci elementi bulan snouc sayisi??

        System.out.println(resultWebElementList.get(0));
        // [[ChromeDriver: chrome on WINDOWS (f075161929cc556d94c25e669adcb707)] -> class name: sg-col-inner]

        System.out.println(resultWebElementList.get(0).getText());
        // 1-16 of 140 results for "city bike" ==> current text

        driver.findElement(By.className("s-image")).click();
        // Eger bir locate ile birden fazla element bulunuyorsa, Selenium, ilk elementi kullanmaktadir

        Thread.sleep(5000);

        driver.close();

    }

}
