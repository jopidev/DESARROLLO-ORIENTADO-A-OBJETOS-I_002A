public class VehiculoPasajero extends Vehiculo implements InterfaceBoleta {
    private int maxPasajeros;

    public VehiculoPasajero() {}
    public VehiculoPasajero(String patente, String marca, String modelo, int diasArriendo, int maxPasajeros) {
        super(patente, marca, modelo, diasArriendo);
        this.maxPasajeros = maxPasajeros;
    }

    public int getMaxPasajeros() { return maxPasajeros; }
    public void setMaxPasajeros(int maxPasajeros) { this.maxPasajeros = maxPasajeros; }

    @Override
    public String calcularBoleta() {
        double precioBase = 12000 * diasArriendo;
        double iva = precioBase * IVA;
        double descuento = precioBase * DESCUENTO_PASAJEROS;
        double total = precioBase + iva - descuento;
        return String.format("Boleta Vehículo Pasajeros:\nPatente: %s\nMarca: %s\nModelo: %s\nDías: %d\nMax Pasajeros: %d\nPrecio Base: $%.2f\nIVA (19%%): $%.2f\nDescuento (12%%): $%.2f\nTotal: $%.2f\n",
            patente, marca, modelo, diasArriendo, maxPasajeros, precioBase, iva, descuento, total);
    }
}

