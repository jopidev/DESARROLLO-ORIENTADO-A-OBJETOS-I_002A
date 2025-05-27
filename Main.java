import java.util.InputMismatchException;
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
                    if (opcion < 1 || opcion > 6) {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número.");
                }
            }

            switch (opcion) {
                case 1:
                    if (cliente != null) {
                        System.out.println("Ya hay un cliente registrado.");
                        break;
                    }

                    String rut;
                    while (true) {
                        System.out.print("Ingrese RUT (formato 12345678-9): ");
                        rut = sc.nextLine().trim();
                        if (rut.matches("^\\d{7,8}-[\\dkK]$")) {
                            break;
                        } else {
                            System.out.println("Error: Formato de RUT no válido.");
                        }
                    }

                    String nombre;
                    while (true) {
                        System.out.print("Ingrese nombre: ");
                        nombre = sc.nextLine().trim();
                        if (nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                            break;
                        } else {
                            System.out.println("Error: El nombre no puede contener números ni símbolos.");
                        }
                    }

                    String apPaterno;
                    while (true) {
                        System.out.print("Ingrese apellido paterno: ");
                        apPaterno = sc.nextLine().trim();
                        if (apPaterno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                            break;
                        } else {
                            System.out.println("Error: El apellido no puede contener números ni símbolos.");
                        }
                    }

                    String apMaterno;
                    while (true) {
                        System.out.print("Ingrese apellido materno: ");
                        apMaterno = sc.nextLine().trim();
                        if (apMaterno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                            break;
                        } else {
                            System.out.println("Error: El apellido no puede contener números ni símbolos.");
                        }
                    }

                    System.out.print("Ingrese domicilio: ");
                    String domicilio = sc.nextLine();

                    System.out.print("Ingrese comuna: ");
                    String comuna = sc.nextLine();

                    String telefono;
                    while (true) {
                        System.out.print("Ingrese teléfono (9 dígitos): ");
                        telefono = sc.nextLine().trim();
                        if (telefono.matches("^\\d{9}$")) {
                            break;
                        } else {
                            System.out.println("Error: El teléfono debe tener 9 dígitos.");
                        }
                    }

                    int numeroCuenta;
                    while (true) {
                        System.out.print("Ingrese número de cuenta corriente (9 dígitos): ");
                        String inputCuenta = sc.nextLine().trim();
                        if (inputCuenta.matches("^\\d{9}$")) {
                            numeroCuenta = Integer.parseInt(inputCuenta);
                            break;
                        } else {
                            System.out.println("Error: La cuenta debe tener 9 dígitos numéricos.");
                        }
                    }

                    cliente = new Cliente(rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, numeroCuenta);
                    System.out.println("¡Cliente registrado exitosamente!");
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
                        while (true) {
                            System.out.print("Ingrese un monto para depositar: ");
                            try {
                                int montoDep = Integer.parseInt(sc.nextLine().trim());
                                if (montoDep > 0) {
                                    cliente.getCuenta().depositar(montoDep);
                                    break;
                                } else {
                                    System.out.println("El monto debe ser mayor que cero.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Debe ingresar un número válido.");
                            }
                        }
                    }
                    break;

                case 4:
                    if (cliente == null) {
                        System.out.println("Debe registrar un cliente primero.");
                    } else {
                        while (true) {
                            System.out.print("Ingrese un monto para girar: ");
                            try {
                                int montoGiro = Integer.parseInt(sc.nextLine().trim());
                                if (montoGiro > 0) {
                                    cliente.getCuenta().girar(montoGiro);
                                    break;
                                } else {
                                    System.out.println("El monto debe ser mayor que cero.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Debe ingresar un número válido.");
                            }
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
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        }

        sc.close();
    }
}




