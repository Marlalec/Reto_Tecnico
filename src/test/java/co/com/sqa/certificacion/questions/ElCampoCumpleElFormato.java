package co.com.sqa.certificacion.questions;

import co.com.sqa.certificacion.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class ElCampoCumpleElFormato implements Question<Boolean> {

    private static final String PATRON_MM_DD_YYYY = "^(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/\\d{4}$";

    public static ElCampoCumpleElFormato mmDdYyyy() {
        return new ElCampoCumpleElFormato();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String valor = Value.of(DatepickerPage.CAMPO_FECHA).answeredBy(actor).trim();
        return valor.matches(PATRON_MM_DD_YYYY);
    }
}
