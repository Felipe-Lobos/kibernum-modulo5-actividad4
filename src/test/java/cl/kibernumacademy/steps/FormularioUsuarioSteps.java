package cl.kibernumacademy.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernumacademy.pages.FormularioTransferenciaPage;
import cl.kibernumacademy.pages.FormularioUsuarioPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormularioUsuarioSteps {
    private WebDriver driver;
    private String resultado;
    private FormularioUsuarioPage formularioUsuarioPage;

    @Before
    public void setUp() {
        System.out.println("Iniciando escenario de prueba....");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        formularioUsuarioPage = new FormularioUsuarioPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
        System.out.println("Finalizando escenario de prueba...");
    }


    @Given("que el usuario accede al formulario de datos")
    public void que_el_usuario_accede_al_formulario_de_datos(){
        formularioUsuarioPage.navigateTo();
    }
    


}
