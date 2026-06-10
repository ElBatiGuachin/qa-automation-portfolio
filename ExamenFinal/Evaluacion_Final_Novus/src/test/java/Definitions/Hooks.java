package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // 🔧 Preferencias para desactivar por completo el gestor de contraseñas
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // algunas versiones usan esta clave:
        prefs.put("profile.password_manager_leak_detection", false);

        // evitar notificaciones del navegador
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.setExperimentalOption("prefs", prefs);

        // 🔒 Desactivar features relacionados a contraseñas/seguridad
        options.addArguments(
                "--disable-features=PasswordManagerUI," +
                        "PasswordLeakDetection," +
                        "PasswordCheck," +
                        "PasswordManagerOnboarding," +
                        "CredentialLeakCheck"
        );

        // Configura chromedriver
        WebDriverManager.chromedriver().setup();

        // Leer propiedad del sistema: -Dheadless=true  (por defecto true)
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        // Opciones recomendadas
        if (headless) {
            // Modo headless moderno (Chrome 109+)
            options.addArguments("--headless=new");
            // tamaño de ventana para que los elementos aparezcan igual que en UI
            options.addArguments("--window-size=1920,1080");
        } else {
            // Si NO es headless, puedes quitar estas opciones o dejarlas
            options.addArguments("--start-maximized");
        }

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }
    @After
    public static void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed");
        }
        driver.manage().deleteAllCookies();
        driver.quit();

    }


}
