package cl.kibernumacademy.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioTransferenciaPage {

    private By montoInput = By.id("monto");
    private By cuentaInput = By.id("cuenta");
    private By buttonPagar = By.cssSelector("button.btn-success");
    private By resultadoText = By.id("resultado-transferencia");
    

    private WebDriverWait wait;
    private WebDriver driver;


    public FormularioTransferenciaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo() {
        driver.get("https://web-actividad-4.netlify.app/");
    }

    // Ingresar el monto
    public void ingresarMonto(double monto) {
        WebElement montoElement = wait.until(ExpectedConditions.elementToBeClickable(montoInput));
        montoElement.clear();
        montoElement.sendKeys(String.valueOf(monto));
    }

    // Ingresar el cuenta
    public void ingresarCuenta(String cuenta) {
        WebElement cuentaElement = wait.until(ExpectedConditions.elementToBeClickable(cuentaInput));
        cuentaElement.clear();
        cuentaElement.sendKeys(cuenta);
    }

    // Obtener el resultado
    public String obtenerMensajeResultado() {
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(resultadoText));
        return resultado.getText().replaceAll("<.*?>", "").trim();
    }

    public void pagar() {
        WebElement pagarBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonPagar));
        pagarBtn.click();
    }

    

}
