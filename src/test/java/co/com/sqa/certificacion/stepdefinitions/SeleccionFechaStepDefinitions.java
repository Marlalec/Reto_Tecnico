package co.com.sqa.certificacion.stepdefinitions;

import co.com.sqa.certificacion.questions.ElCampoCumpleElFormato;
import co.com.sqa.certificacion.questions.FechaRegistradaEnElCampo;
import co.com.sqa.certificacion.tasks.AbrirElCalendario;
import co.com.sqa.certificacion.tasks.SeleccionarDiaDelMesActual;
import co.com.sqa.certificacion.tasks.SeleccionarLaFecha;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SeleccionFechaStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {string} abre el calendario emergente del campo de fecha")
    public void queElUsuarioAbreElCalendario(String nombreActor) {
        OnStage.theActorCalled(nombreActor).attemptsTo(
                AbrirElCalendario.enLaPaginaDelDatepicker()
        );
    }

    @When("selecciona el dia {string} del mes {string} del anio {string}")
    public void seleccionaLaFecha(String dia, String mes, String anio) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarLaFecha.conDiaMesYAnio(dia, mes, anio)
        );
    }

    @Then("la fecha {string} queda registrada en el campo de entrada")
    public void laFechaQuedaRegistrada(String fechaEsperada) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("la fecha del campo",
                        FechaRegistradaEnElCampo.valor(), equalTo(fechaEsperada))
        );
    }

    @When("selecciona el dia {string} del mes actual mostrado por el calendario")
    public void seleccionaDiaDelMesActual(String dia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarDiaDelMesActual.conElDia(dia)
        );
    }

    @Then("la fecha seleccionada queda reflejada en el campo en formato {string}")
    public void laFechaCumpleElFormato(String formato) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el campo cumple el formato " + formato,
                        ElCampoCumpleElFormato.mmDdYyyy(), is(true))
        );
    }
}
