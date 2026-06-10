import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class formularioGuru {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try
        {
            driver.get("https://demo.guru99.com/telecom/addtariffplans.php");
            driver.manage().window().maximize();

            driver.findElement(By.name("rental")).sendKeys("30");
            driver.findElement(By.name("local_minutes")).sendKeys("5");
            driver.findElement(By.id("inter_minutes")).sendKeys("10");
            driver.findElement(By.id("sms_pack")).sendKeys("55");
            driver.findElement(By.name("minutes_charges")).sendKeys("20");
            driver.findElement(By.name("inter_charges")).sendKeys("6");
            driver.findElement(By.id("sms_charges")).sendKeys("300");

            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[36]/ul/li[1]/input"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",btnEnviar);

        }finally {
            driver.manage().deleteAllCookies();
        }
    }
}
