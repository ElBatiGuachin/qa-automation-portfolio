package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class enviarPage {
    //variables Driver y Wait
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public enviarPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"registroForm\"]/div[6]/div/button") private WebElement clickEnviar;
    @FindBy(xpath = "//*[@id=\"mostrarAlerta\"]") private WebElement clickAlerta;

    public void clickEnviar (){

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickEnviar);

    }

    public void ClickAlerta(){
        wait.until(ExpectedConditions.elementToBeClickable(clickAlerta));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickAlerta);
    }

    public void aceptAlerta (){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
