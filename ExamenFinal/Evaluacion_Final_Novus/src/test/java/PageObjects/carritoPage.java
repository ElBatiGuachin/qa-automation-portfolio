package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class carritoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public carritoPage(WebDriver d)
    {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[contains(@id, 'remove-sauce-labs-bike-light')]") private WebElement deleteProducto;
    @FindBy(xpath = "//*[contains(@id, 'continue-shopping')]") private WebElement goInventario;
    @FindBy(xpath = "//*[contains(@id, 'header_container')]//div[2]/span") private WebElement tituloconfirmacion;
    @FindBy(id = "checkout") private WebElement btncheckout;

    public void validarPagina()
    {
        String textoActual = tituloconfirmacion.getText();
        String textoEsperado = "Your Cart";

        Assert.assertEquals(textoActual,textoEsperado);
    }
    public void eliminarProducto()
    {
        deleteProducto.click();
    }
    public void inventarioInicial()
    {
        goInventario.click();
    }
    public void goCheckout()
    {
        btncheckout.click();
    }
}
