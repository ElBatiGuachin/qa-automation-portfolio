package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public InfoPage(WebDriver d)
    {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "firstName") private WebElement nombre;
    @FindBy(name = "lastName") private WebElement apellido;
    @FindBy(name = "postalCode") private WebElement codigoPostal;
    @FindBy(id = "continue") private WebElement btnContinuar;

    public void completarInfoPersonal()
    {
        nombre.sendKeys("Joan Manuel");
        apellido.sendKeys("Serrato Lopez");
        codigoPostal.sendKeys("15076");
        btnContinuar.click();
    }
}
