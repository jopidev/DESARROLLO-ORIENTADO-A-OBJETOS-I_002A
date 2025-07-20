public abstract class Vehiculo {
    protected String patente, marca, modelo;
    protected int diasArriendo;

    public Vehiculo() {}
    public Vehiculo(String patente, String marca, String modelo, int diasArriendo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.diasArriendo = diasArriendo;
    }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getDiasArriendo() { return diasArriendo; }
    public void setDiasArriendo(int diasArriendo) { this.diasArriendo = diasArriendo; }

    public abstract String calcularBoleta();
}

