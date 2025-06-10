package dominio_cuentas.cuentas;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, double saldoInicial, double limiteSobregiro) {
        super(numeroCuenta, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public double calcularInteres() {
   
        return saldo < 0 ? saldo * 0.05 : 0; // 5% de interés por sobregiro
    }

    @Override
    public boolean girar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a girar debe ser positivo");
        }
        if (saldo + limiteSobregiro >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}