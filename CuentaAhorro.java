public class CuentaAhorro extends Cuenta {
    public CuentaAhorro(int numeroCuenta) {
        super(numeroCuenta);
    }

    public CuentaAhorro(int numeroCuenta, int saldo) {
        super(numeroCuenta, saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo cuenta de ahorro: $" + saldo);
    }
}

