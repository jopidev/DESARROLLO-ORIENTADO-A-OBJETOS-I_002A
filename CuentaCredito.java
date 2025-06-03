public class CuentaCredito extends Cuenta {
    public CuentaCredito(int numeroCuenta) {
        super(numeroCuenta);
    }

    public CuentaCredito(int numeroCuenta, int saldo) {
        super(numeroCuenta, saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponible en línea de crédito: $" + saldo);
    }
}

