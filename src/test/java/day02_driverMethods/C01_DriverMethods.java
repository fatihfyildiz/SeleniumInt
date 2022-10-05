package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        // If we leave just on this stage, only a browser is opened but not go to an Url
        // When a driver object is created, Selenium WebDriver make our PC/laptop to open an empty page in browser

        /*
        If we want to use firefox or other browser like edge or safari;
        We need to download the WebDriver of that browser from the Selenium site and add it to our project.
         */

        driver.get("https://www.amazon.com"); // opens the Amazon web site

        // If we want to wait our testing for a while;
        Thread.sleep(5000); // Testing will wait as the written duration

        System.out.println("page url is : " + driver.getCurrentUrl());

        System.out.println("page title is : " + driver.getTitle());

        driver.close(); // closing the browser




    }

}
