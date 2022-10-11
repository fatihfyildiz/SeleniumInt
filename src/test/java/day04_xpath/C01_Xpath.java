package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        Su ana kadar ogrenilen 6 adet locator HTML koduna baglidir
        Xpath ve cssSelector ise sadece bir attirubute'e veya tag'e bagimli olmadan
        her web elementi locate etmemize yarar

        Her HTML element'te olmazsa olmaz olan 3 sey:
        1- tag
        2- attribute(s)
        3- attribute value(s)

        Xpath ve cssSelector bu 3 maddenin kombinasyonu ile olusur...
        //tagismi[@attribute-ismi="attribute-value"]
          veya alt(child) attribute ile alt(child) attribute value de kullanilir daha detayli olmasi icin

        The 6 locators that we learnt until this point are depend on HTML codes
         */


        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin
        WebElement addButton= driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]"));
        addButton.click();

        // 3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton= driver.findElement(By.xpath("//button[@onclick=\"deleteElement()\"]"));

        if (deleteButton.isDisplayed()){
            System.out.println("Displaying test of Delete Button is PASSED");
        } else {
            System.out.println("Delete Button is not displayed, related test FAILED");
        }

        // 4- Delete tusuna basin
        deleteButton.click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        // WebElement addremoveElement= driver.findElement(By.tagName("h3")); ==> can be find this way or other below
        WebElement addremoveElement= driver.findElement(By.xpath("//h3"));

        if (addremoveElement.isDisplayed()){
            System.out.println("Displaying test of Add/Remove Element is PASSED");
        } else {
            System.out.println("Add/Remove Element is not displayed, related test FAILED");
        }

        Thread.sleep(5000);
        driver.close();

    }
}
