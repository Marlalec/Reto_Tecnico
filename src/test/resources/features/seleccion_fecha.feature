# language: en
Feature: HU-001 Seleccion de fecha en un campo de formulario
  Como usuario de la aplicacion
  quiero seleccionar una fecha desde un calendario emergente en el campo de entrada
  para evitar errores al ingresar fechas manualmente

  @SmokeTest @HU-001 @MesDiferente
  Scenario Outline: Seleccion de una fecha especifica en un mes diferente al actual
    Given que "Marlon" abre el calendario emergente del campo de fecha
    When selecciona el dia "<dia>" del mes "<mes>" del anio "<anio>"
    Then la fecha "<fechaEsperada>" queda registrada en el campo de entrada

    Examples:
      | dia | mes      | anio | fechaEsperada |
      | 15  | December | 2026 | 12/15/2026    |
      | 03  | March    | 2027 | 03/03/2027    |

  @RegressionTest @HU-001 @MesActual
  Scenario: Seleccion de una fecha valida dentro del mes actual
    Given que "Marlon" abre el calendario emergente del campo de fecha
    When selecciona el dia "10" del mes actual mostrado por el calendario
    Then la fecha seleccionada queda reflejada en el campo en formato "MM/DD/YYYY"
