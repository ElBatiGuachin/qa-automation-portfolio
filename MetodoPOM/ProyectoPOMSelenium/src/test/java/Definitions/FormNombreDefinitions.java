package Definitions;

import PageObjects.DatosPage;
import PageObjects.PersonalPage;
import PageObjects.SelectPage;
import com.opencsv.CSVParser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static Support.Pantallazo.evidencia;

public class FormNombreDefinitions {

    DatosPage datos;
    SelectPage select;
    PersonalPage personal;

    String CSV_File_Path = "src/test/resources/data/data.csv";

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

    @And("validamos datos de datable y cerramos registro")
    public void validamosDatosDeDatableYCerramosRegistro(DataTable datosForm2) {
        List<Map<String,String >> lista=datosForm2.asMaps(String.class,String.class);
        for (int i=0; i<lista.size();i++){
            personal.ValidarNom(lista.get(i).get("nombre"));
            personal.Apelli(lista.get(i).get("apellido"));
        }
        personal.ClickBtn();
    }

    @When("ingresa datos en el campos de texto {string} , {string} , {string} , {string}")
    public void ingresaDatosEnElCamposDeTexto(String nombre, String apellido, String telefono, String correo) {

        datos.IngresarNombre(nombre);
        datos.IngresarApellido(apellido);
        datos.IngresaCampoTelefono(telefono);
        datos.IngresaCampoCorreo(correo);
    }

    @And("ingresa usamos todos los campos seleccionables {string}, {string} , {string}, {string} , {string}")
    public void ingresaUsamosTodosLosCamposSeleccionables(String pasatiempo, String genero, String departamento, String ciudad, String comandos) {
        select.ClickPasatiempo(pasatiempo);
        select.Genero(genero);
        select.Departamento(departamento);
        select.Ciudad(ciudad);
        select.ComandoSelenium(comandos);

    }

    @And("validamos los datos {string} , {string}")
    public void validamosLosDatos(String nombre, String apellido) {

    }

    @When("ingresa datos desde un archivo CSV")
    public void ingresaDatosDesdeUnArchivoCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
        CSVFormat formato = CSVFormat.DEFAULT
                .withHeader("nombre","apellido","pasatiempo","genero","telefono","correo","departamento","ciudad","comando")
                .withSkipHeaderRecord()   // ignora la primera fila del header
                .withTrim();              // limpia espacios

        Iterable<CSVRecord> records = formato.parse(reader);

        for (CSVRecord fila : records) {
            datos.IngresarNombre(fila.get("nombre"));
            datos.IngresarApellido(fila.get("apellido"));
            select.ClickPasatiempo(fila.get("pasatiempo"));
            select.Genero(fila.get("genero"));
            datos.IngresaCampoTelefono(fila.get("telefono"));
            datos.IngresaCampoCorreo(fila.get("correo"));
            select.Departamento(fila.get("departamento"));
            select.Ciudad(fila.get("ciudad"));
            select.ComandoSelenium(fila.get("comando"));
        }
        evidencia();
    }

    @And("validamos datos del csv y cerramos registro")
    public void validamosDatosDelCsvYCerramosRegistro() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
        CSVFormat formato = CSVFormat.DEFAULT
                .withHeader("nombre","apellido","pasatiempo","genero","telefono","correo","departamento","ciudad","comando")
                .withSkipHeaderRecord()   // ignora la primera fila del header
                .withTrim();              // limpia espacios

        Iterable<CSVRecord> records = formato.parse(reader);

        for (CSVRecord fila : records) {
            personal.ValidarNom(fila.get("nombre"));
            personal.Apelli(fila.get("apellido"));
        }
    }
}
