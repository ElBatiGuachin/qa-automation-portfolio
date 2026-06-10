package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver d) {
        driver= d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-23942\"]/a/span") private WebElement Contactanos;


    //Metodo CambiarVentana
    public void CambiarVentana() {
        Set<String> identificadores = driver.getWindowHandles(); //obtener los identificadores de las ventanas
        for (String identificador : identificadores) { //recorrer los identificadores
            driver.switchTo().window(identificador);
        }
    }

    public void ValidarTexto(){
        wait.until(ExpectedConditions.elementToBeClickable(Contactanos));
        String CapturarTexto= Contactanos.getText();
        Assert.assertEquals(CapturarTexto,"Contáctanos");

    }

    public void CerrarVentana(){
        driver.close();
        driver.switchTo().window("");
    }



}
