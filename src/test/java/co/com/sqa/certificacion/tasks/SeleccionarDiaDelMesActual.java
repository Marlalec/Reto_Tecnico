package co.com.sqa.certificacion.tasks;

import co.com.sqa.certificacion.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarDiaDelMesActual implements Task {

    private final String dia;

    public SeleccionarDiaDelMesActual(String dia) {
        this.dia = dia;
    }

    public static SeleccionarDiaDelMesActual conElDia(String dia) {
        return instrumented(SeleccionarDiaDelMesActual.class, dia);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DatepickerPage.DIA_DEL_CALENDARIO.of(dia))
        );
    }
}
