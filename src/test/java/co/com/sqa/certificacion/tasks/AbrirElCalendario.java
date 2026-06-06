package co.com.sqa.certificacion.tasks;

import co.com.sqa.certificacion.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirElCalendario implements Task {

    public static AbrirElCalendario enLaPaginaDelDatepicker() {
        return instrumented(AbrirElCalendario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(new DatepickerPage()),
                Switch.toFrame(0),
                Click.on(DatepickerPage.CAMPO_FECHA),
                WaitUntil.the(DatepickerPage.ENCABEZADO_MES, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
