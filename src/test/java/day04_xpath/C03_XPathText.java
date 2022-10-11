package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPathText {

    public static void main(String[] args) {

        // Asagidaki testi text’leri kullanarak locate edin
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //2- Add Element butonuna basin
        //3- Delete butonu’nun gorunur oldugunu test edin
        //4- Delete tusuna basin
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        /*
        Bir web element link olmasa da text icerebilir
        link olmayan bir HTML element'te By.linktext kullanilamaz
        ancak text kullanilarak Xpath yazilabilir. Soyle:

        //tagName[text()='.....']  ==> .... olan kisim text'in kendisi/degeri/yazisi

        tagName oneml idegilse yerine * yazilabilir ==> //*[text()=‘Add Element’]
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin
        WebElement addButton= driver.findElement(By.xpath("//*[text()='Add Element']"));
        addButton.click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton= driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Displaying test of Delete Button is PASSED");
        } else {
            System.out.println("Delete Button is not displayed, related test FAILED");
        }

        //4- Delete tusuna basin
        deleteButton.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addremoveButton= driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addremoveButton.isDisplayed()){
            System.out.println("Displaying test of Add/Remove Element is PASSED");
        } else {
            System.out.println("Add/Remove Element is not displayed, related test FAILED");
        }

        driver.close();





    }
}
