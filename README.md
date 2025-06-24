# Biblioteca DUOC UC - Semana 5

Proyecto Java desarrollado como actividad formativa de la semana 5 del curso "Desarrollo Orientado a Objetos I", enfocado en la implementación de colecciones eficientes para manejar grandes volúmenes de datos en un sistema de biblioteca.

## Características

- Uso de **ArrayList** para el almacenamiento secuencial de libros.
- Uso de **HashMap** para la gestión de usuarios por RUT.
- Uso de **HashSet** para evitar duplicados de libros al cargar datos.
- Uso de **TreeSet** para mantener un catálogo ordenado alfabéticamente por título.
- Manejo de **excepciones personalizadas**:
  - `LibroNoEncontradoException`
  - `LibroYaPrestadoException`
- Validación del formato del RUT chileno.
- Registro y almacenamiento de préstamos en archivo `prestamos.txt`.
- Lectura de libros desde archivo `libros.csv`.

## Estructura de clases

- `Libro`: clase base con título, autor y estado (prestado o disponible).
- `Usuario`: representa al lector con nombre y RUT.
- `Biblioteca`: contiene la lógica de negocio y las colecciones.
- `Main`: punto de entrada con interfaz de consola.

## Objetivo de la semana

Demostrar la correcta selección y uso de diferentes tipos de colecciones en Java para enfrentar el crecimiento de datos, mejorando el rendimiento en operaciones de búsqueda, inserción y eliminación, sin perder la legibilidad ni la robustez del código.

---

**DUOC UC - Desarrollo Orientado a Objetos I**
