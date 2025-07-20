import java.io.*;
import java.util.*;

public class GestionFlota {

    private final List<Vehiculo> listaVehiculos = Collections.synchronizedList(new ArrayList<>());
    private final String archivo = "vehiculos.txt";

    public GestionFlota() {
        cargarVehiculosDesdeArchivo();
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo v) {
        synchronized (listaVehiculos) {
            for (Vehiculo veh : listaVehiculos) {
                if (veh.getPatente().equalsIgnoreCase(v.getPatente())) {
                    throw new IllegalArgumentException("Ya existe un vehículo con esa patente.");
                }
            }
            listaVehiculos.add(v);
            guardarVehiculosEnArchivo();
        }
    }

    public int cantidadArriendosLargos() {
        int contador = 0;
        synchronized (listaVehiculos) {
            for (Vehiculo v : listaVehiculos) {
                if (v.getDiasArriendo() >= 7) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private void cargarVehiculosDesdeArchivo() {
        File file = new File(archivo);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length < 6) continue;

                String tipo = partes[0];
                String patente = partes[1];
                String marca = partes[2];
                String modelo = partes[3];
                int dias = Integer.parseInt(partes[4]);

                if ("Carga".equalsIgnoreCase(tipo)) {
                    double capacidad = Double.parseDouble(partes[5]);
                    VehiculoCarga vc = new VehiculoCarga(patente, marca, modelo, dias, capacidad);
                    listaVehiculos.add(vc);
                } else if ("Pasajeros".equalsIgnoreCase(tipo)) {
                    int pasajeros = Integer.parseInt(partes[5]);
                    VehiculoPasajero vp = new VehiculoPasajero(patente, marca, modelo, dias, pasajeros);
                    listaVehiculos.add(vp);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar vehículos: " + e.getMessage());
        }
    }

    private void guardarVehiculosEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            synchronized (listaVehiculos) {
                for (Vehiculo v : listaVehiculos) {
                    String linea;
                    if (v instanceof VehiculoCarga) {
                        VehiculoCarga vc = (VehiculoCarga) v;
                        linea = String.format("Carga;%s;%s;%s;%d;%.2f",
                                vc.getPatente(), vc.getMarca(), vc.getModelo(), vc.getDiasArriendo(), vc.getCapacidadCarga());
                    } else if (v instanceof VehiculoPasajero) {
                        VehiculoPasajero vp = (VehiculoPasajero) v;
                        linea = String.format("Pasajeros;%s;%s;%s;%d;%d",
                                vp.getPatente(), vp.getMarca(), vp.getModelo(), vp.getDiasArriendo(), vp.getMaxPasajeros());
                    } else {
                        continue;
                    }
                    bw.write(linea);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar vehículos: " + e.getMessage());
        }
    }
}


