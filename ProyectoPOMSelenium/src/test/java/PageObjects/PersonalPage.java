package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Set;

public class PersonalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PersonalPage( WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //locator 2
    @FindBy(id="nombreModal") private WebElement validarNombre;
    @FindBy(id = "apellidoModal") private WebElement validarApellido;
    @FindBy(xpath = "//*[@id=\"infoModal\"]/div/div/div[3]/button") private WebElement Boton;

   public void ValidarNombre(){
       long starTime=System.currentTimeMillis(); // inicia el tiempo
       wait.until(ExpectedConditions.visibilityOf(validarNombre));
       long endTime= System.currentTimeMillis();//Finaliza el tiempo
       long totalTime= endTime-starTime;
       System.out.println("el tiempo de espera del wait fue de : "+ totalTime + "ml");

       String capturaNombre=validarNombre.getText();
       Assert.assertEquals(capturaNombre,"Jorge Erickson");
       System.out.println("el nombre es: " + capturaNombre);

   }

    public void ValidarNom(String nombre){

        wait.until(ExpectedConditions.visibilityOf(validarApellido));
        String capturaNombre=validarNombre.getText();
        Assert.assertEquals(capturaNombre,nombre);
        System.out.println("el nombre es: " + capturaNombre);

    }

    public void ValidarApellido(){
       wait.until(ExpectedConditions.visibilityOf(validarApellido));
        String capturaApellido=validarApellido.getText();
        Assert.assertEquals(capturaApellido,"Paz Diaz");
        System.out.println("el apellido es: " + capturaApellido);

    }

    public void Apelli(String apellido){
        wait.until(ExpectedConditions.visibilityOf(validarApellido));
        String capturaApellido=validarApellido.getText();
        Assert.assertEquals(capturaApellido,apellido);
        System.out.println("el apellido es: " + capturaApellido);

    }
    public void ClickBtn(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Boton);
    }


}
