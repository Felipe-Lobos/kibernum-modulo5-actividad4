package cl.kibernumacademy.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernumacademy.pages.FormularioTransferenciaPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormularioTransferenciaSteps {
    private WebDriver driver;
    private String resultado;
    private FormularioTransferenciaPage formularioTransferenciaPage;

    @Before
    public void setUp() {
        System.out.println("Iniciando escenario de prueba....");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        formularioTransferenciaPage = new FormularioTransferenciaPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
        System.out.println("Finalizando escenario de prueba...");
    }

    @Given("que el usuario ha iniciado sesión")
    public void que_el_usuario_ha_iniciado_sesión() {
        formularioTransferenciaPage.navigateTo();
    }

    //@When("^transfiere (-?\\d+) a la cuenta (\\d+)$")
    @When("^transfiere (-?\\d+) a la cuenta {string}")
    public void transfiere_a_la_cuenta(double monto, String cuenta) {
        formularioTransferenciaPage.ingresarMonto(monto);
        formularioTransferenciaPage.ingresarCuenta(cuenta);
        formularioTransferenciaPage.pagar();
    }

    @Then("debería ver el mensaje {string}")
    public void debería_ver_el_mensaje(String mensajeEsperado) {
        String mensajeReal = formularioTransferenciaPage.obtenerMensajeResultado();
        Assertions.assertTrue(mensajeReal.contains(mensajeEsperado),
                "EL mensaje real no contiene el esperado, Esperado: '" + mensajeEsperado + "', Real: '" + mensajeReal+ "'");

    }

}
