package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_findElement {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        // To find an element in a website, this web element should be introduced to our codes
        // While introducing, we must refer to an unique web element

        // WebElement amazonSearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        // since id name (twotabsearchtextbox) of the Amazon search box is a unique (only 1 in html codes) web element
        // it is wise to use it here...

        WebElement amazonSearchBox= driver.findElement(By.name("field-keywords"));

        amazonSearchBox.sendKeys("Nutella" + Keys.ENTER);

        Thread.sleep(5000);
        driver.close();

        /*
        Selenium'da 8 adet locators vardir, bunlardan 6 tanesi HTML uzerindeki tag veya attribute'lare goredir
        2 tanesi ise daha spesifik olarak ilk 6 locator ile bulamadigimiz web elementlerini locate etmek icin kullanilir

        There are 8 locators in Selenium, while 6 of them are for tag or attributes on the HTML.
        Wheereas 2 of them ar specifically used for locating the web elements which we cannot find by the other 6 locators

        1- By.id
            id attribute'u genelde unique olarak verilir
            dolayisiyla bir HTML element'de id varsa once By.id denenebilir

        1- By.id
            id is generally given as an unique attribute
            therefore, if there exists an id in HTML element, it should be used at first

        2- className
            Class attribute'u genelde ayni islevi ypan web element'leri gruplandirmak icin kullanilir.
            Bu gruplandirmalar sayesinde CSS ile gruptaki tum web elementler tek yerden sekillendirilebilir
            Class attribute'u kullanilirken eger class degeri (value) space (bosluk) iceriyorsa,
            className ile yapilan locate'ler hata verebilir...

            Genellikle classname ile yapilan locate'ler birden fazla web element getireceginden
            List<WebElement> seklinde olusturacagimiz bir List'e kaydodulur

            Bu listedeki elementler WebElement oldugu icin bu liste dogrudan yazdirilamaz,
            bunun yerine for-each loop kullanilarak web element ozellikleri yazdirilabilir

        2- className
            The class attribute is often used to group web elements that perform the same function.
            With the help of these groupings, all web elements in the group can be shaped from one place with CSS.
            When using the class attribute, if the class value (value) contains space,
            locates with className may give an error...

            Since the locates which usually made with classname will bring more than one web element,
            they are saved in a List that we will create as List<WebElement>

            Since the elements in this list are WebElements, this list cannot be printed directly,
            instead web element properties can be printed using the for-each loop.

        3- name
            Eger HTML kodunda name attribute varsa kullanilabilir

        3- name
            If there ise name in the HTML codes, this attribute can be also used

        4- tagname
            tagname de classname gibi gruplandirmalar icin kullanilir
            dolayisiyla tagname ile genelde bir element degil
            benzer ozelliklerdeki bir listeye ulasilir

        4- tagname
            similar to classname, tagname is also used for grouping
            thus, with tagname we can arrive a list instead an element

        5- linkTest
            sadece link'ler icin kullanilir
            her link HTML'nin uzerinde bir link yazisi olur
            bu yazi genelde kullanicinin front-end'te gordugu yazi ile aynidir
            ancak bazen space gibi farkedilemeyecek eklemeler olabilir ve
            locate ederken linkTest kullanilirsa link yazisinin tamami kullanilmalidir
            (varsa bosluk vb... locate alinirken yazilmalidir)

        5- linkTest
            only used for the links
            each link HTML has a link/text writtten on it
            this text i generally same as the one which the user see in front-end
            but sometemies there might be some additions which cannot be easily realized, such as spaces
            if linkTest is used for locating, the whole link text/writing should be used
            (if there exists space, etc... all must be used/written)

        6- partialLinkTest
            linkTest gibi sadece link'ler icin kullanilir ama linkTest'ten farki
            tum yaziyi degil de sadece bir kismini kullanacak olmamizdir

        6- partialLinkTest
            similar to the linkTest, only used for the links,
            but it has a difference; not the whole link text/writing just the partial is used
         */

    }
}
