package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {

    public static void main(String[] args) {

        /*
        1- su adrese gidin: https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
        2- relativeLocators kullanarak Boston web element'ini 3 farkli sekilde lcoate edin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        // London'un sagi ve Berlin'in solu diye tarif edelim Boston web elementini

        WebElement london= driver.findElement(By.id("pid5_thumb"));
        WebElement berlin= driver.findElement(By.id("pid7_thumb"));

        WebElement boston1= driver.findElement(RelativeLocator
                                .with(By.tagName("p"))
                                .toRightOf(london)
                                .toLeftOf(berlin));

        System.out.println(boston1.getAttribute("id")); // pid6_price ==> id of Boston (Test PASSED)

        // Toronto'nun alti diye tarif edelim Boston web elementini

        WebElement toronto= driver.findElement(By.id("pid2_price"));

        WebElement boston2= driver.findElement(RelativeLocator
                                .with(By.className("ui-li-aside"))
                                .below(toronto));

        System.out.println(boston2.getAttribute("id")); // pid6_price ==> id of Boston (Test PASSED)

        // Mountie'nin ustunde diye tarif edelim Boston web elementini

        WebElement mountie= driver.findElement(By.id("pid10_thumb"));
        WebElement amsterdam= driver.findElement(By.id("pid9_thumb"));

        WebElement boston3= driver.findElement(RelativeLocator
                                .with(By.tagName("p"))
                                .above(mountie));

        System.out.println(boston3.getAttribute("id")); //

        driver.close();

    }
}
