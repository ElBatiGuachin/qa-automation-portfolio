package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Configurar mi Page
//1. Generar el Constructor
//2. Iniciar variables Webdriver, WebDriverWait
//3. Ingresar datos en el constructor.
public class DatosPage {

    //variables Driver y Wait
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public DatosPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Declarar WebElement de localizadores a utilizar.
    @FindBy (id="nombre") private WebElement nombre;
    @FindBy (id="apellido") private WebElement apellido;
    @FindBy (name="mobile") private WebElement telefono;
    @FindBy (id="email") private WebElement correo;

    public  void  IngresarDatosNombre(){
        nombre.sendKeys("Jorge Erickson");
    }

    public  void  IngresarNombre(String CampoNombre){
        nombre.sendKeys(CampoNombre);
    }

    public void IngresarDatoApellido ()  {
        apellido.sendKeys("Paz Diaz");

    }

    public void IngresarApellido (String CampoApellido) {
        apellido.sendKeys(CampoApellido);
    }



    public void IngresaTelefono(){
        telefono.sendKeys("93540484");

    }

    public void IngresaCampoTelefono(String CampoTelefono){
        telefono.sendKeys(CampoTelefono);

    }

    public void IngresaCorreo(){
        correo.sendKeys("jorgepazdiaz@gmail.com");
    }

    public void IngresaCampoCorreo(String CampoCorreo){
        correo.sendKeys(CampoCorreo);
    }
}
