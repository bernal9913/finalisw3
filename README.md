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

## Modelo-Vista-Controlador (MVC):
   Este patrón se utiliza para separar la lógica de presentación (Vista) de la lógica de negocios (Modelo) y la lógica de control (Controlador). En este caso, la lógica de negocios se encuentra en las clases Reserva, RepositorioReservas, y GestorReservas, mientras que la interfaz de usuario (Vista) está representada por la clase AplicacionReservasUI.

## Singleton (en RepositorioReservas):
   La clase RepositorioReservas parece estar diseñada como un Singleton, ya que solo se crea una instancia de esta clase en AplicacionReservasUI. Este patrón garantiza que haya una única instancia de la clase en todo el programa.

## Inyección de Dependencias:
   La clase GestorReservas toma una instancia de RepositorioReservas como parámetro en su constructor, lo que permite la inyección de dependencias. Esto facilita la prueba unitaria y hace que GestorReservas no esté fuertemente acoplado a una implementación específica de RepositorioReservas.

## Apertura/Cierre de Bertrand Meyer (OCP):
   El principio OCP establece que una clase debe estar abierta para la extensión pero cerrada para la modificación. En este código, puedes extender la funcionalidad sin modificar las clases existentes. Por ejemplo, podrías crear una nueva clase ConsolaInteractiva sin necesidad de modificar GestorReservas o RepositorioReservas.

## Interfaz Gráfica de Usuario (GUI):
   Se está utilizando JavaFX para implementar una interfaz gráfica de usuario (GUI). La GUI facilita la interacción del usuario con la aplicación.

## Manejo de Archivos (en RepositorioReservas):
   El manejo de archivos para cargar y guardar reservas desde y hacia un archivo CSV puede considerarse como un patrón simple de manejo de persistencia de datos.

## Patrón Repository:
   El RepositorioReservas actúa como un repositorio que encapsula el acceso y la manipulación de objetos Reserva. Proporciona métodos para agregar (agregarReserva), eliminar (eliminarReserva), y listar (listarReservas) reservas. Este enfoque es consistente con el patrón Repository, que separa la lógica de acceso a los datos del resto de la aplicación.

## Patrón Factory (Simple):
   Aunque no es un Factory en el sentido clásico, el constructor de la clase Reserva sirve como un método de creación (constructor) de instancias de la clase Reserva. El uso del constructor para crear nuevas instancias sigue un patrón de creación de objetos, y en este caso, es un enfoque simple de Factory Method.