package co.com.sqa.certificacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://jqueryui.com/datepicker/")
public class DatepickerPage extends PageObject {

    public static final Target IFRAME_DEMO = Target.the("iframe del demo del datepicker")
            .locatedBy(".demo-frame");

    public static final Target CAMPO_FECHA = Target.the("campo de entrada de fecha")
            .locatedBy("#datepicker");

    public static final Target ENCABEZADO_MES = Target.the("mes mostrado en el calendario")
            .locatedBy(".ui-datepicker-month");

    public static final Target ENCABEZADO_ANIO = Target.the("anio mostrado en el calendario")
            .locatedBy(".ui-datepicker-year");

    public static final Target BOTON_MES_SIGUIENTE = Target.the("boton siguiente mes")
            .locatedBy(".ui-datepicker-next");

    public static final Target BOTON_MES_ANTERIOR = Target.the("boton mes anterior")
            .locatedBy(".ui-datepicker-prev");

    public static final Target DIA_DEL_CALENDARIO = Target.the("dia {0} del calendario")
            .locatedBy("//table[contains(@class,'ui-datepicker-calendar')]//a[normalize-space(text())='{0}']");
}
