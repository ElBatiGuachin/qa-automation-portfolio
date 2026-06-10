package Definitions;

import PageObjects.DatosPage;
import PageObjects.PersonalPage;
import PageObjects.SelectPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import java.util.List;
import java.util.Map;

public class FormNombreDefinitions {

    DatosPage datos;
    SelectPage select;
    PersonalPage personal;

    public FormNombreDefinitions() {

        datos= new DatosPage(Hooks.driver);
        select= new SelectPage(Hooks.driver);
        personal= new PersonalPage(Hooks.driver);
    }

    @When("ingresa datos en el campo Nombre como {string}")
    public void ingresaDatosEnElCampoNombreComo(String nombre) {
        datos.IngresarNombre(nombre);
    }

    @And("ingresa su apellido en el campo Apellido como {string}")
    public void ingresaSuApellidoEnElCampoApellidoComo(String apellido) {
        datos.IngresarApellido(apellido);
    }

    @And("seleccionar sus pasatiempos con checks como {string}")
    public void seleccionarSusPasatiemposConChecksComo(String pasatiempo) {

        select.ClickPasatiempo(pasatiempo);
    }

    @And("selecciona el tipo de sexo {string}")
    public void seleccionaElTipoDeSexo(String genero) {
        select.Genero(genero);

    }

    @And("ingresa su telefono {string}")
    public void ingresaSuTelefono(String telefono) {

        datos.IngresaCampoTelefono(telefono);

    }

    @And("ingresa su correo electronico {string}")
    public void ingresaSuCorreoElectronico(String correo) {
        datos.IngresaCampoCorreo(correo);
    }

    @And("selecciona el departamento {string}")
    public void seleccionaElDepartamento(String departamento) {
        select.Departamento(departamento);

    }

    @And("selecciona la ciudad {string}")
    public void seleccionaLaCiudad(String ciudad) {
        select.Ciudad(ciudad);

    }

    @And("selecciona un tipo de comando {string}")
    public void seleccionaUnTipoDeComando(String comando) {
        select.ComandoSelenium(comando);

    }


    @And("validamos el nombre {string}")
    public void validamosElNombre(String nombre) {
        personal.ValidarNom(nombre);

    }


    @And("validamos el apellidos {string}")
    public void validamosElApellidos(String apellido) {
        personal.Apelli(apellido);

    }


    @And("seleccionar sus pasatiempos con checks como {string} y {string}")
    public void seleccionarSusPasatiemposConChecksComoY(String deport, String lectura) {
       select.Pasatiempos(deport,lectura);
    }

    @When("ingresa datos del usuario desde el feature")
    public void ingresaDatosDelUsuarioDesdeElFeature(DataTable datosForm) {
        List<Map<String,String >> lista=datosForm.asMaps(String.class,String.class);
        for (int i=0; i<lista.size();i++){
            datos.IngresarNombre(lista.get(i).get("nombre"));
            datos.IngresarApellido(lista.get(i).get("apellido"));
            select.ClickPasatiempo(lista.get(i).get("pasatiempo"));
            select.Genero(lista.get(i).get("genero"));
            datos.IngresaCampoTelefono(lista.get(i).get("telefono"));
            datos.IngresaCampoCorreo(lista.get(i).get("correo"));
            select.Departamento(lista.get(i).get("departamento"));
            select.Ciudad(lista.get(i).get("ciudad"));
            select.ComandoSelenium(lista.get(i).get("comando"));
        }
    }
}
