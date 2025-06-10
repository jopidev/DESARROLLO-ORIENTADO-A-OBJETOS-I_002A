# Bank Europe

Proyecto en Java que simula la gestión de clientes y cuentas bancarias para una institución financiera.

## Estructura del Proyecto

- `CuentaBancaria`: Clase abstracta base para todas las cuentas.
- `CuentaCorriente`, `CuentaAhorros`, `CuentaDigital`: Subclases que extienden `CuentaBancaria` e implementan el cálculo de intereses.
- `Cliente`: Clase que representa a un cliente del banco.
- `InfoCliente`: Interfaz para mostrar información del cliente.
- `GestionClientes`: Clase para asociar clientes a cuentas.
- `OperacionesBancarias`: Permite depósitos, giros y consultas.
- `Main`: Clase principal para ejecutar el programa y probar funcionalidades.

## Paquetes

- `dominio_clientes.clientes`
- `dominio_clientes.gestion`
- `dominio_cuentas.cuentas`
- `dominio_cuentas.operaciones`

## Requisitos

- JDK 17 o superior
- IDE recomendado: IntelliJ IDEA o Eclipse

## Ejecución

Compilar y ejecutar la clase `Main` para simular la interacción entre clientes y cuentas.
