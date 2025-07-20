public class VehiculoCarga extends Vehiculo implements InterfaceBoleta {
    private double capacidadCarga;

    public VehiculoCarga() {}
    public VehiculoCarga(String patente, String marca, String modelo, int diasArriendo, double capacidadCarga) {
        super(patente, marca, modelo, diasArriendo);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }

    @Override
    public String calcularBoleta() {
        double precioBase = 10000 * diasArriendo;
        double iva = precioBase * IVA;
        double descuento = precioBase * DESCUENTO_CARGA;
        double total = precioBase + iva - descuento;
        return String.format("Boleta Vehículo Carga:\nPatente: %s\nMarca: %s\nModelo: %s\nDías: %d\nCapacidad: %.2f kg\nPrecio Base: $%.2f\nIVA (19%%): $%.2f\nDescuento (7%%): $%.2f\nTotal: $%.2f\n",
            patente, marca, modelo, diasArriendo, capacidadCarga, precioBase, iva, descuento, total);
    }
}

