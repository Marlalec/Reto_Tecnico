# Reto Técnico SQA — Automatización HU-001 (Selección de fecha)

Automatización de pruebas web para la Historia de Usuario **HU-001 — Selección de
fecha en un campo de formulario**, sobre la URL pública
`https://jqueryui.com/datepicker/`, implementada con **Java + Serenity BDD +
Cucumber** bajo el **patrón de diseño Screenplay**, siguiendo los lineamientos del
Gobierno de Automatización de SQA.

## Tabla de contenido
- [Contexto](#contexto)
- [Stack tecnológico](#stack-tecnológico)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Requisitos previos](#requisitos-previos)
- [Instalación](#instalación)
- [Ejecución de pruebas](#ejecución-de-pruebas)
- [Reporte Serenity](#reporte-serenity)
- [Análisis estático con SonarQube](#análisis-estático-con-sonarqube)
- [Evidencias](#evidencias)

## Contexto
Como usuario de la aplicación, quiero seleccionar una fecha desde un calendario
emergente para evitar errores al ingresar fechas manualmente. Los escenarios
automatizados incluyen, de forma obligatoria, **la selección de una fecha
específica en un mes diferente al actual**.

## Stack tecnológico
| Componente | Versión |
|---|---|
| Java (JDK) | 17 |
| Serenity BDD | 4.0.30 |
| Cucumber | 7.14.0 |
| Gradle | 8.x (wrapper) |
| Patrón de diseño | Screenplay |
| Navegador | Chrome (configurable a Firefox/Edge) |

## Estructura del proyecto
```
src
├── main/java/co/com/sqa/certificacion
└── test
    ├── java/co/com/sqa/certificacion
    │   ├── interactions      # Interactions personalizadas (si aplican)
    │   ├── models            # Modelos de datos
    │   ├── questions         # Preguntas (validaciones)
    │   ├── runners           # Runners de Serenity Cucumber
    │   ├── stepdefinitions   # Glue de Cucumber con OnStage
    │   ├── tasks             # Tareas del actor
    │   ├── userinterfaces    # Localizadores (Targets)
    │   └── utils             # Utilidades
    └── resources
        ├── features          # Archivos .feature en Gherkin
        └── serenity.conf      # Configuración de driver, navegadores, timeouts
```

## Requisitos previos
- JDK 17
- Google Chrome instalado
- Conexión a internet (Serenity descarga el driver automáticamente)

## Instalación
```bash
git clone https://github.com/<TU_USUARIO>/Reto_Tecnico.git
cd Reto_Tecnico
./gradlew clean build -x test
```

## Ejecución de pruebas
```bash
# Ejecución completa
./gradlew clean test

# Ejecución en modo headless (CI)
./gradlew clean test -Denvironment=ci

# Solo el escenario obligatorio (mes diferente al actual)
./gradlew clean test -Dcucumber.filter.tags="@MesDiferente"
```

## Reporte Serenity
Tras la ejecución, el reporte HTML queda en:
```
target/site/serenity/index.html
```

## Análisis estático con SonarQube
```bash
./gradlew sonarqube \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=<TOKEN>
```
El informe exportado (PDF/HTML/captura del dashboard) se almacena en
`docs/sonarqube/`.

## Evidencias
Las evidencias de ejecución, reporte Serenity y análisis SonarQube se encuentran
en la carpeta `docs/evidencias/`.
