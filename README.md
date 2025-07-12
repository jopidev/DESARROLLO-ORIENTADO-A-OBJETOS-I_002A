# SafeVoteSystem - Semana 8

Proyecto de la asignatura Desarrollo Orientado a Objetos I  
Actividad: Aplicando Colecciones Sincronizadas, `Queue` y `Topic`  

---

## Descripción

SafeVoteSystem es un sistema de votación electrónica seguro que utiliza números primos para garantizar la integridad y anonimato de los votos. El proyecto maneja de forma concurrente la generación, verificación y almacenamiento de números primos mediante hilos y colecciones sincronizadas.

---

## Funcionalidades

- Clase `PrimesList` que extiende `ArrayList<Integer>`, validando solo números primos.
- Método `isPrime` eficiente para verificar números primos.
- Sobrescritura de métodos `add` y `remove` en `PrimesList` que lanzan excepción si no se cumple la condición de primo.
- Implementación de `PrimesThread` que verifica y añade primos concurrentemente usando `Runnable`.
- Uso de cola sincronizada (`Queue`) con `wait` y `notify` para gestionar la distribución de números entre hilos.
- Manejo de archivos con `BufferedReader` para cargar números desde CSV y `FileWriter` para guardar resultados.
- Sincronización de accesos con `Lock` para evitar condiciones de carrera.
- Interfaz de consola simple e intuitiva para interacción con el usuario.

---

## Notas sobre la implementación

- La cola sincronizada (`Queue`) funciona como mecanismo de distribución de tareas entre hilos, implementando el patrón productor-consumidor.
- El concepto de `Topic` en la actividad se interpreta como el patrón de publicación/suscripción que puede ser aplicado con colas y notificaciones en este contexto, sin necesidad de componentes externos.
- La sincronización entre hilos está garantizada con `wait`, `notify` y bloqueos explícitos (`Lock`).
- El proyecto prioriza simplicidad y claridad, manteniendo la eficiencia y seguridad en el manejo concurrente.

---

## Autor

Jorge Pinto  
Estudiante de Ingeniería Informática, *mención Ciencia de Datos* – DUOC UC  
Julio 2025
