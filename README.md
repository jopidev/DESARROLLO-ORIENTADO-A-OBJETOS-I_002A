# DriveQuest Rentals - Semana 9

Proyecto de la asignatura Desarrollo Orientado a Objetos I  
Actividad: Creando colecciones de objetos y gestión de flota con interfaz gráfica

## Descripción

DriveQuest Rentals es un sistema para la gestión de una flota de vehículos de arriendo que permite agregar, listar y analizar vehículos de carga y pasajeros. El proyecto utiliza colecciones sincronizadas para manejar la lista de vehículos, con validaciones de datos específicas al contexto chileno. Incluye una interfaz gráfica basada en Swing que facilita la interacción con el usuario para administrar la flota y visualizar información relevante como boletas y estadísticas de arriendos largos.

## Funcionalidades

- Clases `VehiculoCarga` y `VehiculoPasajero` que extienden `Vehiculo` con atributos específicos.
- Validación estricta de formatos de patente, días de arriendo, capacidad y pasajeros máximos.
- Gestión de la flota mediante la clase `GestionFlota` con métodos para agregar vehículos y calcular estadísticas.
- Manejo seguro de la lista de vehículos con sincronización para evitar condiciones de carrera.
- Interfaz gráfica Swing con pestañas para:
  - Agregar vehículos con campos dinámicos según tipo seleccionado.
  - Listar vehículos en tabla con columnas detalladas.
  - Mostrar boletas calculadas de cada vehículo.
  - Contar y mostrar cantidad de vehículos con arriendo igual o superior a 7 días.
- Lectura y escritura de archivo de texto `vehiculos.txt` con formato compatible.

## Notas sobre la implementación

- Se aplican validaciones con expresiones regulares y control de errores para asegurar datos correctos.
- La interfaz gráfica adapta los campos de entrada según tipo de vehículo para mejorar usabilidad.
- La lista de vehículos está sincronizada para soportar accesos concurrentes.
- Se prioriza claridad, orden y mantenimiento del código.

## Autor

Jorge Pinto  
Estudiante de Ingeniería Informática, mención Ciencia de Datos – DUOC UC  
Julio 2025
