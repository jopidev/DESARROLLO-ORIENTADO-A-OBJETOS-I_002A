# Bank Europe

Proyecto en Java que simula la gestión de clientes y cuentas bancarias para una institución financiera.

## Estructura del Proyecto

Bank_Europe/
├── src/
│   ├── dominio_cuentas/
│   │   ├── cuentas/
│   │   │   ├── CuentaBancaria.java
│   │   │   ├── CuentaCorriente.java
│   │   │   ├── CuentaAhorros.java
│   │   │   └── CuentaDigital.java
│   │   └── operaciones/
│   │       └── OperacionesBancarias.java
│   ├── dominio_clientes/
│   │   ├── clientes/
│   │   │   ├── Cliente.java
│   │   │   └── InfoCliente.java
│   │   └── gestion/
│   │       └── GestionClientes.java
└── Main.java

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
