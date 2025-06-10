package dominio_cuentas.cuentas;

public abstract class CuentaBancaria {
    protected String numeroCuenta; 
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        if (numeroCuenta.length() != 9 || !numeroCuenta.matches("\\d+")) {
            throw new IllegalArgumentException("El número de cuenta debe tener exactamente 9 dígitos");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }


    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public abstract double calcularInteres();


    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        saldo += monto;
    }


    public boolean girar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a girar debe ser positivo");
        }
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }


    public double consultarSaldo() {
        return saldo;
    }
}