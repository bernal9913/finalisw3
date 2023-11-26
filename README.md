# **Aplicación de Reservas**

## Descripción

La "Aplicación de Reservas" es un sistema simple para gestionar reservas en un restaurante. Permite a los usuarios realizar reservas, cancelarlas y ver la lista de reservas existentes.


## Características
* Hacer una nueva reserva con fecha, hora y número de comensales.
* Cancelar una reserva existente.
* Modificar una reserva existente.
* Ver la lista de todas las reservas.


## Tecnologías Utilizadas
* Java
* JavaFX (para la interfaz de usuario)
* JUnit (para pruebas unitarias)


## Configuración del Proyecto

1. Clonar el Repositorio:

`git clone https://github.com/bernal9913/finalisw3`
2. Configuración del Entorno:

   * Asegúrate de tener Java instalado en tu máquina.
   * Configura tu entorno de desarrollo preferido (Eclipse, IntelliJ, etc.).

3. Ejecutar la Aplicación:

   * Abre el proyecto en tu entorno de desarrollo.
   * Ejecuta la clase AplicacionReservasUI para iniciar la interfaz de usuario.

4. Ejecutar Pruebas:

   * Utiliza el entorno de desarrollo o ejecuta las pruebas desde la línea de comandos.
## Estructura del Proyecto
   * `src/main/java`: Contiene el código fuente de la aplicación.
   * `src/test/java`: Contiene las pruebas unitarias y de aceptación.

## Pruebas
   * Pruebas Unitarias: Utiliza TestNG (una variante de JUnit) para probar las unidades individuales del código.

## Definicion de las clases
   * Reserva:  clase del objeto reserva
   * AplicacionReservas: punto intermedio para el patron factory
   * AplicacionReservasUI: interfaz de usuario con javafx para la interfaz de usuario 
   * RepositorioReservas: clase para el patron repository
   * GestorReserva: clase con patron factory para hacer funcionar la consola 
   * ConsolaParaReservar: clase para hacer funcionar la aplicacion mediante el uso de la consola