package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_webElementMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella");
        Thread.sleep(2000);
        searchBox.clear();
        searchBox.sendKeys("Java");
        Thread.sleep(2000);
        // if we locate two separate keys sequently, Selenium tests is as NutellaJava
        // therefore, we must put a clear between them and make deleting the first one
        // and, to see the delete operation we put a sleep

        System.out.println(searchBox.getSize()); // (806, 38)
        System.out.println(searchBox.getTagName()); // input
        System.out.println(searchBox.getAttribute("name")); // field-keywords
        System.out.println(searchBox.getRect().getX()); // 281

        System.out.println(searchBox.isDisplayed()); // true
        // to ask whether related web element is displayed, we use this method

        System.out.println(searchBox.isEnabled()); // true
        // to ask whether related web element is arrivable/reached, we use the above method

        searchBox.isSelected(); //

        driver.close();

    }
}
