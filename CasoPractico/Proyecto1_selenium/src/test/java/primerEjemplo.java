import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class primerEjemplo {

    public static void main (String []args)
    {
        //configurar el controlador del navegador - Utilizar Webdrivermanager
        WebDriverManager.chromedriver().setup();

        //crear una instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        try
        {
            //navegar en la web de pruebas
            driver.get("https://novustechnology.pe/practice-form/");

            //expandir la pantalla

            driver.manage().window().maximize();

            //escribir el nombre en la caja de texto con findelement.
            driver.findElement(By.id("nombre")).sendKeys("Joan Manuel");
            //escribir el apellido en la caja de texto con findelement.
            driver.findElement(By.id("apellido")).sendKeys("Serrato Lopez");
            //escribir el telefono en la caja de texto con findelement.
            driver.findElement(By.name("mobile")).sendKeys("963258741");
            //escribir el correo en la caja de texto con findelement.
            driver.findElement(By.id("email")).sendKeys("jomaselo05@gmail.com");
            //hace clic sobre una opcion

            //cuando no permite utilizar un localizador con comando de JAVA - usaremos JavaScript
            WebElement CheckMusic =   driver.findElement(By.id("music"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,CheckMusic);

            WebElement CheckSport =   driver.findElement(By.id("sports"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,CheckSport);

            WebElement CheckLectura =   driver.findElement(By.id("reading"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,CheckLectura);

            WebElement ClicMale =   driver.findElement(By.id("male"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,ClicMale);

            //select usando WebElement
            WebElement SelectDepartamento = driver.findElement(By.id("department"));
            new Select(SelectDepartamento).selectByValue("LIMA");

            //Select usando findelement
            new Select(driver.findElement(By.id("city"))).selectByValue("CAÑETE");

            //seleccionar un comando
            new Select(driver.findElement(By.id("commands"))).selectByVisibleText("Navigation Commands");

            //Click en enviar
            WebElement ClickEnviar = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/div[6]/div/button"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,ClickEnviar);

        } finally {

            driver.manage().deleteAllCookies();
            //driver.close();
            //driver.quit();
        }
    }
}
