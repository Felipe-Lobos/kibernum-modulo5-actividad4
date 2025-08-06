package cl.kibernumacademy.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernumacademy.pages.FormularioTransferenciaPage;
import cl.kibernumacademy.pages.FormularioUsuarioPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void que_el_usuario_accede_al_formulario_de_datos() {
        formularioUsuarioPage.navigateTo();
    }

    // Este método representa un paso en Cucumber que completa varios campos de un
    // formulario
    // Está comentado porque podría haberse reemplazado o modificado
    @When("completa los siguientes datos:")
    public void completa_los_siguientes_datos(DataTable dataTable) {

        // Convierte la tabla de Cucumber en una lista de mapas.
        // Cada fila es un mapa con claves como "campo" y "valor"
        List<Map<String, String>> datos = dataTable.asMaps();

        // Itera por cada fila de la tabla
        for (Map<String, String> fila : datos) {
            // Obtiene el nombre del campo (por ejemplo: "nombre") y el valor
            // correspondiente (por ejemplo: "Juan")
            String campo = fila.get("campo");
            String valor = fila.get("valor");

            // Imprime por consola el campo y su valor (útil para depuración)
            System.out.println("Campo: " + campo + ", Valor: " + valor);

            // Utiliza un switch para decidir qué acción tomar según el nombre del campo
            switch (campo.toLowerCase()) { // convierte a minúsculas para evitar problemas con mayúsculas
                case "nombre":
                    // Llama al método que ingresa el nombre en el formulario
                    formularioUsuarioPage.ingresarNombre(valor);
                    break;
                case "apellido":
                    // Llama al método que ingresa el apellido
                    formularioUsuarioPage.ingresarApellido(valor);
                    break;
                case "email":
                    // Llama al método que ingresa el email
                    formularioUsuarioPage.ingresarEmail(valor);
                    break;
                case "edad":
                    // Convierte el valor de edad a entero y lo ingresa en el formulario
                    formularioUsuarioPage.ingresarEdad(Integer.parseInt(valor));
                    break;
                // Puedes agregar más casos aquí si se agregan nuevos campos
            }
        }

    }

    @Then("los datos ingresados deben mostrarse correctamente en consola")
    public void los_datos_ingresados_deben_mostrarse_correctamente_en_consola() {
        // Una vez completados todos los campos, se envía el formulario
        formularioUsuarioPage.enviarFormulario();
        System.out.println("Los datos fueron ingresados y enviados correctamente.");
    }

}
