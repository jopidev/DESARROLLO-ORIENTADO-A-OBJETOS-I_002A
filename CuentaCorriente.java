public class CuentaCorriente {
    private int numeroCuenta;
    private int saldo;

    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public void depositar(int monto) {
        saldo += monto;
        System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
    }

    public void girar(int monto) {
        if (monto > saldo) {
            System.out.println("Error: Fondos insuficientes.");
        } else {
            saldo -= monto;
            System.out.println("Giro exitoso. Saldo actual: $" + saldo);
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }
}

