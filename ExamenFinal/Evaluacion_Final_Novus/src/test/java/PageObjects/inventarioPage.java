package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class inventarioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public inventarioPage(WebDriver d) {
        driver= d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[contains(@id, 'add-to-cart-sauce-labs-bike-light')]") private WebElement prdelegido;
    @FindBy(xpath = "//*[contains(@id, 'add-to-cart-sauce-labs-fleece-jacket')]") private WebElement prdcompra;
    @FindBy(xpath = "//*[contains(@id, 'item_5_title_link')]/div") private WebElement tituloprd;
    @FindBy(xpath = "//*[contains(@id, 'inventory_container')]/div/div[4]/div[2]/div[2]/div") private WebElement tituloprice;
    @FindBy(xpath = "//*[contains(@id, 'shopping_cart_container')]//a/span") private WebElement btncarrito;

    public void elegirProducto()
    {
        prdelegido.click();
    }
    public void carritoDeCompras()
    {
        btncarrito.click();
    }

    public void seleccionarProducto()
    {
        String tituloesperado = "Sauce Labs Fleece Jacket";
        String precioesperado = "$49.99";
        if(tituloprd.getText().equals(tituloesperado) && tituloprice.getText().equals(precioesperado))
        {
            System.out.println("El producto es correcto , proceder con la compra");
            prdcompra.click();
        } else
        {
            System.out.println("Los textos del objeto no coinciden");
        }
    }

}
