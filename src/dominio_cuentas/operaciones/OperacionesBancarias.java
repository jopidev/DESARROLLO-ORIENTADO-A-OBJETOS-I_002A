package dominio_cuentas.operaciones;

import dominio_cuentas.cuentas.CuentaBancaria;

public class OperacionesBancarias {
    public static void realizarDeposito(CuentaBancaria cuenta, double monto) {
        cuenta.depositar(monto);
    }

    public static boolean realizarGiro(CuentaBancaria cuenta, double monto) {
        return cuenta.girar(monto);
    }

    public static double consultarSaldo(CuentaBancaria cuenta) {
        return cuenta.consultarSaldo();
    }

    public static double calcularInteres(CuentaBancaria cuenta) {
        return cuenta.calcularInteres();
    }
}