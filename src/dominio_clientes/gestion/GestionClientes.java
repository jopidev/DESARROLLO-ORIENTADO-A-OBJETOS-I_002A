package dominio_clientes.gestion;

import dominio_clientes.clientes.Cliente;
import dominio_cuentas.cuentas.CuentaBancaria;

public class GestionClientes {
    public static void asociarCuenta(Cliente cliente, CuentaBancaria cuenta) {
        cliente.setCuenta(cuenta);
    }

    public static void actualizarDatosCliente(Cliente cliente, String nuevaDireccion, String nuevoTelefono) {
        cliente.setDireccion(nuevaDireccion);
        cliente.setTelefono(nuevoTelefono);
    }
}