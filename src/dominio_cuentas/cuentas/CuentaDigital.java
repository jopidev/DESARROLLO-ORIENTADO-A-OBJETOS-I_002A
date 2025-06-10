package dominio_cuentas.cuentas;

public class CuentaDigital extends CuentaBancaria {
    public CuentaDigital(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public double calcularInteres() {
        
        return saldo * 0.0001; // 0.01% de interés diario
    }


    public void transferenciaDigital(double monto, CuentaDigital destino) {
        if (this.girar(monto)) {
            destino.depositar(monto);
        } else {
            throw new IllegalArgumentException("Fondos insuficientes para la transferencia");
        }
    }
}