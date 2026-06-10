package Definitions;

import PageObjects.carritoPage;
import PageObjects.inventarioPage;
import PageObjects.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flujo1SauceDemoDefinitions {

    loginPage login;
    inventarioPage inventario;
    carritoPage carrito;

    public Flujo1SauceDemoDefinitions()
    {
        login = new loginPage(Hooks.driver);
        inventario = new inventarioPage(Hooks.driver);
        carrito = new carritoPage(Hooks.driver);
    }

    @Given("El usuario inicia sesion en la plataforma")
    public void elUsuarioIniciaSesionEnLaPlataforma() {

        Hooks.driver.get("https://www.saucedemo.com/");
        login.IngresarUsuario();
        login.IngresarPassword();
        login.ClicBoton();
    }

    @When("hace clic en el boton add to cart de cualquier producto")
    public void haceClicEnElBotonAddToCartDeCualquierProducto() {

        inventario.elegirProducto();
       }

    @Then("se dirige al icono del carrito de compras")
    public void seDirigeAlIconoDelCarritoDeCompras() {

        inventario.carritoDeCompras();
    }

    @And("aparece el producto seleccionado previamente")
    public void apareceElProductoSeleccionadoPreviamente() {
        carrito.validarPagina();
    }

    @And("decide remover su producto para elegir otro de su preferencia")
    public void decideRemoverSuProductoParaElegirOtroDeSuPreferencia() {
        carrito.eliminarProducto();
    }

    @And("regresa al catalogo general productos")
    public void regresaAlCatalogoGeneralProductos() {
        carrito.inventarioInicial();
    }
}
