package dominio_cuentas.cuentas;

public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresAnual;

    public CuentaAhorros(String numeroCuenta, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
    }

    @Override
    public double calcularInteres() {

        return saldo * (tasaInteresAnual / 12 / 100);
    }

    @Override
    public boolean girar(double monto) {

        return super.girar(monto);
    }
}