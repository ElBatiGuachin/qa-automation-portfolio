package Definitions;

import PageObjects.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.Principal;

public class FormularioDefinitions {
    //DECLARAR VARIABLES DE OTRAS CLASES A USAR
    DatosPage datos;
    SelectPage select;
    enviarPage enviar;
    PersonalPage personal;
    HomePage home;


    //INICIAR VARIABLES DE CLASES EN EL CONSTRUCTOR
    public FormularioDefinitions() {
        datos = new DatosPage(Hooks.driver);
        select= new SelectPage(Hooks.driver);
        enviar= new enviarPage(Hooks.driver);
        personal= new PersonalPage(Hooks.driver);
        home= new HomePage(Hooks.driver);
    }

    //METODOS DE COMANDOS DE GHERKIN DE LOS ESCENARIOS
    @Given("El usuario requiere registrarse en la pagina de Novus")
    public void elUsuarioRequiereRegistrarseEnLaPaginaDeNovus() {
        Hooks.driver.get("https://novustechnology.pe/practice-form/");
    }


    @When("ingresa datos en el campo Nombre")
    public void ingresaDatosEnElCampoNombre() {

        datos.IngresarDatosNombre();

    }


    @And("ingresa su apellido en el campo Apellido.")
    public void ingresaSuApellidoEnElCampoApellido() {
        datos.IngresarDatoApellido();

    }

    @And("seleccionar sus pasatiempos con checks")
    public void seleccionarSusPasatiemposConChecks() {
        select.ClickDeportes();
    }

    @And("selecciona el tipo de sexo")
    public void seleccionaElTipoDeSexo() {
        select.ClickGenero();
    }

    @And("ingresa su telefono")
    public void ingresaSuTelefono() {
        datos.IngresaTelefono();
    }

    @And("ingresa su correo electronico")
    public void ingresaSuCorreoElectronico() {
        datos.IngresaCorreo();
    }

    @And("selecciona el departamento")
    public void seleccionaElDepartamento() {
        select.SelectDepartamento();
    }

    @And("selecciona la ciudad")
    public void seleccionaLaCiudad() {
        select.SelectCiudad();
    }

    @And("selecciona un tipo de comando")
    public void seleccionaUnTipoDeComando() {
        select.SelectComandoSelenium();
    }

    @Then("Damos click en enviar")
    public void damosClickEnEnviar() {
        enviar.clickEnviar();
    }

    @And("validamos el nombre")
    public void validamosElNombre() {
        personal.ValidarNombre();
    }

    @And("validamos el apellidos")
    public void validamosElApellidos() {
        personal.ValidarApellido();
    }

    @And("doy click en el boton")
    public void doyClickEnElBoton() {
        personal.ClickBtn();
    }

    @When("ingresa datos del usuario")
    public void ingresaDatosDelUsuario() {
        datos.IngresarDatosNombre();
        datos.IngresarDatoApellido();
        select.ClickDeportes();
        select.ClickGenero();
        datos.IngresaTelefono();
        datos.IngresaCorreo();
        select.SelectDepartamento();
        select.SelectCiudad();
        select.SelectComandoSelenium();
        enviar.clickEnviar();
    }

    @And("validamos datos y cerramos registro")
    public void validamosDatosYCerramosRegistro() {
        personal.ValidarNombre();
        personal.ValidarApellido();
        personal.ClickBtn();
    }

    @When("da click en el boton alerta")
    public void daClickEnElBotonAlerta() {
        enviar.ClickAlerta();
    }

    @Then("aparece una mensaje de alerta en la pantalla")
    public void apareceUnaMensajeDeAlertaEnLaPantalla() {
        enviar.aceptAlerta();

    }

    @And("me redirige a la pantalla principal de NT")
    public void meRedirigeALaPantallaPrincipalDeNT() {
        home.CambiarVentana();
        home.ValidarTexto();
       home.CerrarVentana();
    }
}
