package cl.kibernumacademy.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioUsuarioPage {

    private By inputNombre = By.cssSelector("#tabla-datos tr:nth-of-type(1) td:nth-of-type(2) input");
    private By inputApellido = By.cssSelector("#tabla-datos tr:nth-of-type(2) td:nth-of-type(2) input");
    private By inputEmail = By.cssSelector("#tabla-datos tr:nth-of-type(3) td:nth-of-type(2) input");
    private By inputEdad = By.cssSelector("#tabla-datos tr:nth-of-type(4) td:nth-of-type(2) input");

    private By buttonImprimir = By.id("btn-imprimir-datos");

    private WebDriverWait wait;
    private WebDriver driver;

    public FormularioUsuarioPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo() {
        driver.get("https://web-actividad-4.netlify.app/");
    }

    // Ingresar el nombre
    public void ingresarNombre(String nombre) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputNombre));
        element.clear();
        element.sendKeys(nombre);
    }

    // Ingresar el apellido
    public void ingresarApellido(String apellido) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputApellido));
        element.clear();
        element.sendKeys(apellido);
    }

    // Ingresar email
    public void ingresarEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        element.clear();
        element.sendKeys(email);
    }

    // Ingresar edad
    public void ingresarEdad(int edad) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputEdad));
        element.clear();
        element.sendKeys(String.valueOf(edad));
    }

    public void enviarFormulario() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonImprimir));
        element.click();
    }
}