package co.com.sqa.certificacion.questions;

import co.com.sqa.certificacion.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class FechaRegistradaEnElCampo implements Question<String> {

    public static FechaRegistradaEnElCampo valor() {
        return new FechaRegistradaEnElCampo();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Value.of(DatepickerPage.CAMPO_FECHA).answeredBy(actor).trim();
    }
}
