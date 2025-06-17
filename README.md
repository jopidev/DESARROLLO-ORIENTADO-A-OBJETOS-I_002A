# Biblioteca DUOC UC - Semana 4

Proyecto Java desarrollado para gestionar una biblioteca con manejo robusto de excepciones utilizando Try/Catch, excepciones personalizadas y manejo de archivos externos.

## Características

- Manejo de colecciones para almacenar libros (`ArrayList`) y usuarios (`HashMap`).
- Validación y control de errores mediante excepciones personalizadas:
  - `LibroNoEncontradoException` para búsqueda de libros inexistentes.
  - `LibroYaPrestadoException` para evitar préstamos de libros ya prestados.
- Control de formato válido para RUT chileno con reintentos en caso de error.
- Uso de excepciones checked y unchecked para propagar y manejar errores específicos.
- Lectura de datos desde archivos CSV para cargar libros.
- Escritura de registros de préstamos en archivos de texto.
- Interfaz de consola amigable que solicita registro de usuario antes de mostrar catálogo.
- Opción para realizar múltiples préstamos en una sesión o finalizar la ejecución.
- Uso correcto de bloques try-catch para evitar que el programa se caiga ante entradas inválidas o situaciones inesperadas.
