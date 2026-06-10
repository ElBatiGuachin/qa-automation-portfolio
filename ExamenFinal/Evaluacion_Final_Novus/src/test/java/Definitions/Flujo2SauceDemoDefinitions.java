package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flujo2SauceDemoDefinitions {

    loginPage login;
    inventarioPage inventario;
    carritoPage carrito;
    InfoPage informacion;
    overwiewPage overview;

    public Flujo2SauceDemoDefinitions()
    {
        login = new loginPage(Hooks.driver);
        inventario = new inventarioPage(Hooks.driver);
        carrito = new carritoPage(Hooks.driver);
        informacion = new InfoPage(Hooks.driver);
        overview = new  overwiewPage(Hooks.driver);
    }


    @Given("El usuario se loguea en la web de SauceDemo")
    public void elUsuarioSeLogueaEnLaWebDeSauceDemo() {
        Hooks.driver.get("https://www.saucedemo.com/");
        login.IngresarUsuario();
        login.IngresarPassword();
        login.ClicBoton();

    }

    @When("elige un producto previa validacion de nombre y precio")
    public void eligeUnProductoPreviaValidacionDeNombreYPrecio() {
        inventario.seleccionarProducto();
        inventario.carritoDeCompras();

    }

    @Then("se dirige a realizar el checkout")
    public void seDirigeARealizarElCheckout() {
        carrito.goCheckout();
    }

    @And("el usuario ingresa sus datos personales")
    public void elUsuarioIngresaSusDatosPersonales() {
        informacion.completarInfoPersonal();
    }

    @And("revisa la descripcion general del producto")
    public void revisaLaDescripcionGeneralDelProducto() {
        overview.validarInformacion();
        overview.finalizarCompra();
    }

    @And("finaliza la compra para regresar al inventario")
    public void finalizaLaCompraParaRegresarAlInventario() {
        overview.validarCompra();
        overview.regresaPaginaInicial();
    }
}
