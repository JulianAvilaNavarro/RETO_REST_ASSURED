package co.com.sofka.stepdefinition;

import co.com.sofka.runner.PracticeFormTestCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import static co.com.sofka.util.Utilities.userDir;

public class GetDeleteStepDefinition extends Reqresin{
    private static final Logger LOGGER = Logger.getLogger(GetDeleteStepDefinition.class);
    private Response response;
    @Given("el usuario esta en la pagina de busqueda y desea buscar la informacion de una persona")
    public void elUsuarioEstaEnLaPaginaDeBusquedaYDeseaBuscarLaInformacionDeUnaPersona() {
        try {
            generalSetUp();
            LOGGER.info("Inicializar configuracion general");
        } catch (Exception e) {
            //log4j
            LOGGER.warn("Error en el septup");
            Assertions.fail(e.getMessage());
        }
    }
    @When("el usuario busca el recurso que desea y obtiene una respuesta")
    public void elUsuarioBuscaElRecursoQueDeseaYObtieneUnaRespuesta() {
        try {
                response = given()
                        .get(RESOURCE_GET);

        } catch (Exception e) {
            LOGGER.warn("Error en la obtencion de información");
            Assertions.fail(e.getMessage());
        }
    }
    @Then("el usuario podra ver los datos de la persona")
    public void elUsuarioPodraVerLosDatosDeLaPersona() {

        try {
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body(containsString("janet.weaver@reqres.in"));
                    LOGGER.info("Se verifica que el correo de la persona sea igual");

        } catch (Exception e) {
            LOGGER.warn("Error en la validacion");
            Assertions.fail(e.getMessage());
        }

    }


    @Given("el usuario esta en la pagina y desea borrar un registro")
    public void elUsuarioEstaEnLaPaginaYDeseaBorrarUnRegistro() {
        try {
            generalSetUp();
        } catch (Exception e) {
            LOGGER.warn("Error en el septup");
            Assertions.fail(e.getMessage());
        }

    }
    @When("el usuario escribe la instruccion de borrar el registro")
    public void elUsuarioEscribeLaInstruccionDeBorrarElRegistro() {
        try {
            response = given()
                    .delete(RESOURCE_DELETE);

        } catch (Exception e) {
            LOGGER.warn("Error en el borrado del registro");
            Assertions.fail(e.getMessage());
        }

    }
    @Then("el usuario obtiene una la respuesta de borrado")
    public void elUsuarioObtieneUnaLaRespuestaDeBorrado() {

        try {
            response.then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
            LOGGER.info("Se verifica que el contenido de la pagina es eliminado");

        } catch (Exception e) {
            LOGGER.warn("Error en la validacion");
            Assertions.fail(e.getMessage());
        }
    }
}
