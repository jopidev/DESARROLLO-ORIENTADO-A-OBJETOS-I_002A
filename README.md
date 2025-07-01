# ComicCollectorSystem - Semana 6

Proyecto Java desarrollado como actividad sumativa individual de la semana 6 del curso "Desarrollo Orientado a Objetos I", enfocado en la integración de entradas y salidas (I/O) y manejo de archivos externos para un sistema de administración de cómics y coleccionables.

## Características

- Uso de **ArrayList** para el almacenamiento secuencial de cómics.
- Uso de **HashMap** para la gestión de usuarios por RUT.
- Uso de **HashSet** y **TreeSet** para mantener unicidad y orden en colecciones específicas.
- Manejo robusto de **excepciones personalizadas** y validación de reglas de negocio con bloques `try/catch`.
- Lectura de datos de cómics desde archivo CSV (`comics.csv`) utilizando `BufferedReader`.
- Escritura de datos de reservas y usuarios en archivo de texto (`reservas.txt`) con `FileWriter`.
- Validación de formato de RUT chileno.
- Interfaz de consola amigable para interacción con el usuario, que permite registrar usuarios, consultar y reservar cómics.

## Estructura de clases

- `Comic`: clase base que contiene información del cómic como nombre, editorial, tipo y estado (disponible o reservado).
- `Usuario`: representa al cliente con nombre y RUT.
- `Tienda`: maneja la lógica de negocio, colecciones y operaciones como agregar cómics, usuarios, reservar y mostrar catálogo.
- `Main`: punto de entrada con interfaz de consola, manejo de entrada/salida y flujo principal.

## Objetivo de la semana

Demostrar el dominio en la integración de operaciones de entrada y salida (I/O) y manejo de archivos externos para persistir datos, combinado con el uso eficiente de colecciones de Java para gestionar grandes volúmenes de información y asegurar la robustez del sistema mediante manejo adecuado de excepciones.

---

**DUOC UC - Desarrollo Orientado a Objetos I**

