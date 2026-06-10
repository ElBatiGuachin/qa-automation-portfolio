package Definitions;

import PageObjects.carritoPage;
import PageObjects.inventarioPage;
import PageObjects.loginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static Definitions.Hooks.driver;

public class ValidarProductoDefinitions {

    loginPage login;
    inventarioPage inventario;

    public ValidarProductoDefinitions()
    {
        login = new loginPage(driver);
        inventario = new inventarioPage(driver);
    }

    @Given("el usuario esta en la pagina de inventarios")
    public void elUsuarioEstaEnLaPaginaDeInventarios() {

        Hooks.driver.get("https://www.saucedemo.com/");
        login.IngresarUsuario();
        login.IngresarPassword();
        login.ClicBoton();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("valida la disponibilidad de los productos en stock")
    public void validaLaDisponibilidadDeLosProductosEnStock(DataTable datosProductos) {

        List<Map<String, String>> productosPrueba = datosProductos.asMaps(String.class, String.class);
        for (Map<String, String> fila : productosPrueba) {
            String nombres = fila.get("nombreProducto");
            WebElement producto = driver.findElement(By.xpath("//*[contains(text(),'" + nombres + "')]"));
            Assert.assertTrue("El producto no está visible: " + nombres, producto.isDisplayed());
        }

    }

    @Then("los productos se encuentran en la galeria para comprar")
    public void losProductosSeEncuentranEnLaGaleriaParaComprar() {

        System.out.println("Todos los productos existen en el inventario");
    }

    @When("busca el producto {string}")
    public void buscaElProducto(String listaProductos) {

        WebElement producto = driver.findElement(By.xpath("//*[contains(text(),'" + listaProductos + "')]"));
        Assert.assertTrue("El producto no está visible: " + listaProductos, producto.isDisplayed());
    }

    @Then("el producto {string} esta activo en la galeria.")
    public void elProductoEstaActivoEnLaGaleria(String nombreProducto) {

            System.out.println("Producto encontrado: " + nombreProducto);

    }
}
