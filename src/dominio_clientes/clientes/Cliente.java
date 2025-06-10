package dominio_clientes.clientes;

import dominio_cuentas.cuentas.CuentaBancaria;

public class Cliente implements InfoCliente {
    private String rut;
    private String nombre;
    private String direccion;
    private String telefono;
    private CuentaBancaria cuenta;

    public Cliente(String rut, String nombre, String direccion, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Cliente: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        if (cuenta != null) {
            System.out.println("Cuenta asociada: " + cuenta.getNumeroCuenta());
            System.out.println("Saldo actual: " + cuenta.getSaldo());
        } else {
            System.out.println("No tiene cuenta asociada");
        }
    }
}