package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectPage {

    //variables Driver y Wait
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public SelectPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Declarar WebElement
    @FindBy(id="sports") private WebElement deporte;
    @FindBy(id="reading") private WebElement lectura;
    @FindBy(id="music") private WebElement musica;
    @FindBy(id="male") private WebElement masculino;
    @FindBy(id="female") private WebElement femenino;
    @FindBy(id="other") private WebElement otro;
    @FindBy(id = "department") private WebElement departamento;
    @FindBy(id = "city") private WebElement ciudad;
    @FindBy(id = "commands") private WebElement comandos;
    //Crear Metodos

    public void ClickDeportes(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",deporte);
    }

    public void ClickPasatiempo(String pasatiempo){
        System.out.println("El deporte ingresado es: " + pasatiempo);
        if (pasatiempo.equals("deporte")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deporte);
        } else if (pasatiempo.equals("lectura")) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lectura);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musica);
        }
    }

    public void Pasatiempos(String pasatiempo1, String pasatiempo2){

        if (pasatiempo1.equals("deporte")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deporte);
        }

        if (pasatiempo2.equals("lectura")){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lectura);
        }

    }

    public void ClickGenero(){

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", masculino);

    }

    public void Genero(String Genero){
        if (Genero.equals("Masculino")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", masculino);
        } else if (Genero.equals("Femenino")) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", femenino);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", otro);
        }
    }

    public void SelectDepartamento(){
        new Select(departamento).selectByValue("LIMA");
    }

    public void Departamento(String depart){
        new Select(departamento).selectByValue(depart);
    }

    public void SelectCiudad(){
        new Select(ciudad).selectByValue("CAÑETE");
    }

    public void Ciudad(String city){
        new Select(ciudad).selectByValue(city);
    }

    public void SelectComandoSelenium(){
        new Select(comandos).selectByVisibleText("Switch Commands");
    }

    public void ComandoSelenium(String Command){
        new Select(comandos).selectByVisibleText(Command);
    }


}
