package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class overwiewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public overwiewPage(WebDriver d)
    {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[contains(@id, 'checkout_summary_container')]//div[contains(text(), 'not every')]") private WebElement dscrproducto;
    @FindBy(id = "finish") private WebElement btnFinalizar;
    @FindBy(xpath = "//*[contains(@id, 'checkout_complete_container')]//*[contains(text(), 'Thank you for your order!')]") private WebElement textoCompra;
    @FindBy(id = "back-to-products") private WebElement btnHome;

    public void validarInformacion()
    {
        String detalleActual = dscrproducto.getText();
        String descripcion = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";

        Assert.assertEquals(detalleActual,descripcion);
    }
    public void finalizarCompra()
    {
        btnFinalizar.click();
    }

    public void validarCompra()
    {
        String textoActual = textoCompra.getText();
        String textoEsperado = "Thank you for your order!";

        Assert.assertEquals(textoActual,textoEsperado);
    }

    public void regresaPaginaInicial()
    {
        btnHome.click();
    }

}
