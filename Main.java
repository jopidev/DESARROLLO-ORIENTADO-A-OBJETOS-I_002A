import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        int opcion = -1;

        while (opcion != 6) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");

            while (true) {
                System.out.print("Seleccione una opción: ");
                try {
                    opcion = Integer.parseInt(sc.nextLine().trim());
                    if (opcion >= 1 && opcion <= 6) break;
                } catch (Exception ignored) {}
                System.out.println("Opción inválida.");
            }

            switch (opcion) {
                case 1:
                    if (cliente != null) {
                        System.out.println("Ya hay un cliente registrado.");
                        break;
                    }

                    String rut;
                    while (true) {
                        System.out.print("RUT (Ej: 12345678-9 o 0 para volver): ");
                        rut = sc.nextLine().trim();
                        if (rut.equals("0")) break;
                        if (rut.matches("^\\d{7,8}-[\\dkK]$")) break;
                        System.out.println("Formato de RUT inválido.");
                    }
                    if (rut.equals("0")) break;

                    String nombre;
                    while (true) {
                        System.out.print("Nombre (0 para volver): ");
                        nombre = sc.nextLine().trim();
                        if (nombre.equals("0")) break;
                        if (nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) break;
                        System.out.println("Nombre inválido. Solo admite letras.");
                    }
                    if (nombre.equals("0")) break;

                    String apPaterno;
                    while (true) {
                        System.out.print("Apellido paterno (0 para volver): ");
                        apPaterno = sc.nextLine().trim();
                        if (apPaterno.equals("0")) break;
                        if (apPaterno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) break;
                        System.out.println("Apellido inválido. Solo admite letras.");
                    }
                    if (apPaterno.equals("0")) break;

                    String apMaterno;
                    while (true) {
                        System.out.print("Apellido materno (0 para volver): ");
                        apMaterno = sc.nextLine().trim();
                        if (apMaterno.equals("0")) break;
                        if (apMaterno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) break;
                        System.out.println("Apellido inválido. Solo admite letras.");
                    }
                    if (apMaterno.equals("0")) break;

                    System.out.print("Domicilio: ");
                    String domicilio = sc.nextLine();
                    System.out.print("Comuna: ");
                    String comuna = sc.nextLine();

                    String telefono;
                    while (true) {
                        System.out.print("Teléfono (Ej: 912345678 o 0 para volver): ");
                        telefono = sc.nextLine().trim();
                        if (telefono.equals("0")) break;
                        if (telefono.matches("^9\\d{8}$")) break;
                        System.out.println("Teléfono inválido.");
                    }
                    if (telefono.equals("0")) break;

                    int numeroCuenta = 0;
                    while (true) {
                        System.out.print("Número de cuenta (9 dígitos, 0 para volver): ");
                        try {
                            numeroCuenta = Integer.parseInt(sc.nextLine().trim());
                            if (numeroCuenta == 0) break;
                            if (String.valueOf(numeroCuenta).length() == 9) break;
                        } catch (Exception ignored) {}
                        System.out.println("Número de cuenta inválido.");
                    }
                    if (numeroCuenta == 0) break;

                    System.out.println("Tipo de cuenta:");
                    System.out.println("1. Cuenta Corriente");
                    System.out.println("2. Cuenta Ahorro");
                    System.out.println("3. Cuenta Crédito");
                    System.out.println("0. Volver");

                    Cuenta cuenta = null;
                    while (cuenta == null) {
                        System.out.print("Seleccione tipo de cuenta: ");
                        try {
                            int tipo = Integer.parseInt(sc.nextLine().trim());
                            if (tipo == 0) break;
                            switch (tipo) {
                                case 1:
                                    cuenta = new CuentaCorriente(numeroCuenta);
                                    break;
                                case 2:
                                    cuenta = new CuentaAhorro(numeroCuenta);
                                    break;
                                case 3:
                                    cuenta = new CuentaCredito(numeroCuenta);
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada inválida.");
                        }
                    }
                    if (cuenta == null) break;

                    cliente = new Cliente(rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, cuenta);
                    System.out.println("Cliente registrado.");
                    break;

                case 2:
                    if (cliente == null) {
                        System.out.println("Debe registrar un cliente primero.");
                    } else {
                        cliente.mostrarDatos();
                    }
                    break;

                case 3:
                    if (cliente == null) {
                        System.out.println("Debe registrar un cliente primero.");
                    } else {
                        int montoDep;
                        while (true) {
                            System.out.print("Monto a depositar (0 para volver): ");
                            try {
                                montoDep = Integer.parseInt(sc.nextLine().trim());
                                if (montoDep == 0) break;
                                if (montoDep > 0) {
                                    cliente.getCuenta().depositar(montoDep);
                                    break;
                                }
                            } catch (Exception ignored) {}
                            System.out.println("Monto inválido.");
                        }
                    }
                    break;

                case 4:
                    if (cliente == null) {
                        System.out.println("Debe registrar un cliente primero.");
                    } else {
                        int montoGiro;
                        while (true) {
                            System.out.print("Monto a girar (0 para volver): ");
                            try {
                                montoGiro = Integer.parseInt(sc.nextLine().trim());
                                if (montoGiro == 0) break;
                                if (montoGiro > 0) {
                                    cliente.getCuenta().girar(montoGiro);
                                    break;
                                }
                            } catch (Exception ignored) {}
                            System.out.println("Monto inválido.");
                        }
                    }
                    break;

                case 5:
                    if (cliente == null) {
                        System.out.println("Debe registrar un cliente primero.");
                    } else {
                        cliente.getCuenta().consultarSaldo();
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        }

        sc.close();
    }
}









