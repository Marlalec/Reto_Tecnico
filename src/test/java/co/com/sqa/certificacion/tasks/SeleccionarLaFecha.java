package co.com.sqa.certificacion.tasks;

import co.com.sqa.certificacion.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarLaFecha implements Task {

    private static final int MAXIMO_DE_NAVEGACIONES = 60;

    private final String dia;
    private final String mes;   // Nombre del mes en ingles, ej: "July"
    private final String anio;  // ej: "2026"

    public SeleccionarLaFecha(String dia, String mes, String anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public static SeleccionarLaFecha conDiaMesYAnio(String dia, String mes, String anio) {
        return instrumented(SeleccionarLaFecha.class, dia, mes, anio);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        navegarHastaElMesYAnioObjetivo(actor);
        String diaSinCeroInicial = String.valueOf(Integer.parseInt(dia));
        actor.attemptsTo(
                Click.on(DatepickerPage.DIA_DEL_CALENDARIO.of(diaSinCeroInicial))
        );
    }

    private <T extends Actor> void navegarHastaElMesYAnioObjetivo(T actor) {
        int navegaciones = 0;
        while (!mesYAnioActualCoinciden(actor) && navegaciones < MAXIMO_DE_NAVEGACIONES) {
            actor.attemptsTo(Click.on(DatepickerPage.BOTON_MES_SIGUIENTE));
            navegaciones++;
        }
        if (!mesYAnioActualCoinciden(actor)) {
            throw new IllegalStateException(
                    "No fue posible navegar hasta " + mes + " " + anio
                            + " dentro del limite de navegaciones permitido.");
        }
    }

    private boolean mesYAnioActualCoinciden(Actor actor) {
        String mesActual = Text.of(DatepickerPage.ENCABEZADO_MES).answeredBy(actor).trim();
        String anioActual = Text.of(DatepickerPage.ENCABEZADO_ANIO).answeredBy(actor).trim();
        return mesActual.equalsIgnoreCase(mes) && anioActual.equals(anio);
    }
}
