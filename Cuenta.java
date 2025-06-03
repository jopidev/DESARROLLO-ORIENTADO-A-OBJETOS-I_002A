public abstract class Cuenta {
    protected int numeroCuenta;
    protected int saldo;

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public Cuenta(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        saldo += monto;
        System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
    }

    public void girar(int monto) {
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Giro exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public abstract void consultarSaldo();
}

