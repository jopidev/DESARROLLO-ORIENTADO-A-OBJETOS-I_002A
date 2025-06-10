import dominio_clientes.clientes.Cliente;
import dominio_cuentas.cuentas.CuentaAhorros;
import dominio_cuentas.cuentas.CuentaCorriente;
import dominio_cuentas.cuentas.CuentaDigital;
import dominio_cuentas.operaciones.OperacionesBancarias;
import dominio_clientes.gestion.GestionClientes;

public class Main {
    public static void main(String[] args) {
        Cliente juanPerez = new Cliente("12.345.678-9", "Juan Pérez", "Calle Los Pinos 123", "912345678");
        Cliente mariaGonzalez = new Cliente("98.765.432-1", "María González", "Av. Libertad 456", "987654321");
        Cliente carlosRamirez = new Cliente("11.111.111-1", "Carlos Ramírez", "Calle Luna 12", "912233445");
        Cliente anaTorres = new Cliente("22.222.222-2", "Ana Torres", "Pasaje Sol 45", "923344556");
        Cliente luisMartinez = new Cliente("33.333.333-3", "Luis Martínez", "Av. Siempre Viva 742", "934455667");
        Cliente sofiaRojas = new Cliente("44.444.444-4", "Sofía Rojas", "Calle Nube 88", "945566778");
        Cliente miguelDiaz = new Cliente("55.555.555-5", "Miguel Díaz", "Calle Río 101", "956677889");
        Cliente lauraVega = new Cliente("66.666.666-6", "Laura Vega", "Camino Verde 21", "967788990");
        Cliente pedroSoto = new Cliente("77.777.777-7", "Pedro Soto", "Av. Central 10", "978899001");
        Cliente elenaCruz = new Cliente("88.888.888-8", "Elena Cruz", "Calle Jardín 77", "989900112");

        CuentaCorriente cuentaCorrienteJuan = new CuentaCorriente("123456789", 520000, 200000);
        CuentaDigital cuentaDigitalMaria = new CuentaDigital("456789123", 275000);
        CuentaCorriente cuentaCorrienteCarlos = new CuentaCorriente("111222333", 310000, 150000);
        CuentaAhorros cuentaAhorrosAna = new CuentaAhorros("987654321", 1200000, 3.5);
        CuentaAhorros cuentaAhorrosLuis = new CuentaAhorros("444555666", 530000, 2.0);
        CuentaDigital cuentaDigitalSofia = new CuentaDigital("777888999", 120000);
        CuentaCorriente cuentaCorrienteMiguel = new CuentaCorriente("222333444", 770000, 250000);
        CuentaAhorros cuentaAhorrosLaura = new CuentaAhorros("555666777", 2100000, 4.0);
        CuentaDigital cuentaDigitalPedro = new CuentaDigital("888999000", 410000);
        CuentaDigital cuentaDigitalElena = new CuentaDigital("999000111", 620000);

        GestionClientes.asociarCuenta(juanPerez, cuentaCorrienteJuan);
        GestionClientes.asociarCuenta(mariaGonzalez, cuentaDigitalMaria);
        GestionClientes.asociarCuenta(carlosRamirez, cuentaCorrienteCarlos);
        GestionClientes.asociarCuenta(anaTorres, cuentaAhorrosAna);
        GestionClientes.asociarCuenta(luisMartinez, cuentaAhorrosLuis);
        GestionClientes.asociarCuenta(sofiaRojas, cuentaDigitalSofia);
        GestionClientes.asociarCuenta(miguelDiaz, cuentaCorrienteMiguel);
        GestionClientes.asociarCuenta(lauraVega, cuentaAhorrosLaura);
        GestionClientes.asociarCuenta(pedroSoto, cuentaDigitalPedro);
        GestionClientes.asociarCuenta(elenaCruz, cuentaDigitalElena);

        OperacionesBancarias.realizarDeposito(cuentaCorrienteJuan, 150000);
        OperacionesBancarias.realizarGiro(cuentaCorrienteJuan, 200000);
        OperacionesBancarias.realizarDeposito(cuentaDigitalMaria, 50000);
        OperacionesBancarias.realizarGiro(cuentaDigitalMaria, 100000);
        OperacionesBancarias.realizarDeposito(cuentaAhorrosAna, 200000);
        OperacionesBancarias.realizarGiro(cuentaCorrienteCarlos, 50000);

        juanPerez.mostrarInformacionCliente();
        System.out.println("-------------------");
        mariaGonzalez.mostrarInformacionCliente();
        System.out.println("-------------------");
        carlosRamirez.mostrarInformacionCliente();
        System.out.println("-------------------");
        anaTorres.mostrarInformacionCliente();
        System.out.println("-------------------");
        luisMartinez.mostrarInformacionCliente();
        System.out.println("-------------------");
        sofiaRojas.mostrarInformacionCliente();
        System.out.println("-------------------");
        miguelDiaz.mostrarInformacionCliente();
        System.out.println("-------------------");
        lauraVega.mostrarInformacionCliente();
        System.out.println("-------------------");
        pedroSoto.mostrarInformacionCliente();
        System.out.println("-------------------");
        elenaCruz.mostrarInformacionCliente();

        System.out.println("\nIntereses cuenta corriente Juan Pérez: " + (cuentaCorrienteJuan.calcularInteres() * 100) + "%");
        System.out.println("Intereses cuenta ahorros Ana Torres: " + (cuentaAhorrosAna.calcularInteres() * 100) + "%");
        System.out.println("Intereses cuenta digital María González: " + (cuentaDigitalMaria.calcularInteres() * 100) + "%");
        System.out.println("Intereses cuenta corriente Carlos Ramírez: " + (cuentaCorrienteCarlos.calcularInteres() * 100) + "%");
        System.out.println("Intereses cuenta digital Sofía Rojas: " + (cuentaDigitalSofia.calcularInteres() * 100) + "%");
        
    }
}

