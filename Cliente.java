public class Cliente implements Mostrable {
    private String rut;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuenta;

    public Cliente(String rut, String nombre, String apPaterno, String apMaterno, String domicilio, String comuna, String telefono, Cuenta cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\nDatos del Cliente:");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apPaterno + " " + apMaterno);
        System.out.println("Domicilio: " + domicilio + ", " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Cuenta: " + cuenta.getNumeroCuenta());
        cuenta.consultarSaldo();
    }
}


