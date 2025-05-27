public class Cliente {
    private String rut;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaCorriente cuenta;

    public Cliente(String rut, String nombre, String apPaterno, String apMaterno, String domicilio,
                   String comuna, String telefono, int numeroCuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = new CuentaCorriente(numeroCuenta);
    }

    public void mostrarDatos() {
        System.out.println("\n--- DATOS DEL CLIENTE ---");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre completo: " + nombre + " " + apPaterno + " " + apMaterno);
        System.out.println("Domicilio: " + domicilio + ", Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("N° Cuenta Corriente: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
    }

    public CuentaCorriente getCuenta() {
        return cuenta;
    }
}

