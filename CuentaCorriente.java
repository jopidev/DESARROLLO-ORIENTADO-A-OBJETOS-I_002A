public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }

    public CuentaCorriente(int numeroCuenta, int saldo) {
        super(numeroCuenta, saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo cuenta corriente: $" + saldo);
    }
}


