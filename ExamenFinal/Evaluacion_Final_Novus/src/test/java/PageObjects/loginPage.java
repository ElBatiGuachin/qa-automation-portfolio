package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public loginPage(WebDriver d)
    {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "user-name") private WebElement usuario;
    @FindBy (id = "password") private WebElement contrasena;
    @FindBy (id = "login-button") private WebElement btnLogin;

    public void IngresarUsuario()
    {
        usuario.clear();
        usuario.sendKeys("standard_user");
    }
    public void IngresarPassword()
    {
        contrasena.clear();
        contrasena.sendKeys("secret_sauce");
    }

    public void ClicBoton()
    {
        btnLogin.click();
    }
}