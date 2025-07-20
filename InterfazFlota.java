import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class InterfazFlota extends JFrame {

    private GestionFlota gestionFlota;
    private JTextField patenteField, marcaField, modeloField, diasArriendoField, capacidadField, pasajerosField;
    private JRadioButton cargaRadio, pasajerosRadio;
    private JTextArea outputArea;
    private JTable tablaVehiculos;
    private DefaultTableModel tablaModelo;

    public InterfazFlota() {
        this.gestionFlota = new GestionFlota();
        setTitle("DriveQuest Rentals - Gestión de Flota");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.add("Agregar Vehículo", panelAgregarVehiculo());
        pestañas.add("Listar Vehículos", panelListarVehiculos());
        pestañas.add("Mostrar Boletas", panelMostrarBoletas());
        pestañas.add("Arriendos Largos", panelArriendosLargos());
        add(pestañas);
    }

    private JPanel panelAgregarVehiculo() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        cargaRadio = new JRadioButton("Carga");
        pasajerosRadio = new JRadioButton("Pasajeros");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(cargaRadio);
        grupoTipo.add(pasajerosRadio);
        cargaRadio.setSelected(true);

        patenteField = new JTextField(10);
        marcaField = new JTextField(10);
        modeloField = new JTextField(10);
        diasArriendoField = new JTextField(5);
        capacidadField = new JTextField(5);
        pasajerosField = new JTextField(5);

        JLabel labelPatente = new JLabel("Patente (Ej: AB1234):");
        JLabel labelMarca = new JLabel("Marca:");
        JLabel labelModelo = new JLabel("Modelo:");
        JLabel labelDias = new JLabel("Días Arriendo:");
        JLabel labelCapacidad = new JLabel("Capacidad (kg):");
        JLabel labelPasajeros = new JLabel("Pasajeros Máx:");

        JButton agregarBtn = new JButton("Agregar Vehículo");

        c.insets = new Insets(5,5,5,5);
        c.gridx = 0; c.gridy = 0; panel.add(new JLabel("Tipo de Vehículo:"), c);
        c.gridx = 1; panel.add(cargaRadio, c);
        c.gridx = 2; panel.add(pasajerosRadio, c);

        c.gridx = 0; c.gridy = 1; panel.add(labelPatente, c);
        c.gridx = 1; c.gridwidth = 2; panel.add(patenteField, c);
        c.gridwidth = 1;

        c.gridx = 0; c.gridy = 2; panel.add(labelMarca, c);
        c.gridx = 1; c.gridwidth = 2; panel.add(marcaField, c);
        c.gridwidth = 1;

        c.gridx = 0; c.gridy = 3; panel.add(labelModelo, c);
        c.gridx = 1; c.gridwidth = 2; panel.add(modeloField, c);
        c.gridwidth = 1;

        c.gridx = 0; c.gridy = 4; panel.add(labelDias, c);
        c.gridx = 1; c.gridwidth = 2; panel.add(diasArriendoField, c);
        c.gridwidth = 1;

        c.gridx = 0; c.gridy = 5; panel.add(labelCapacidad, c);
        c.gridx = 1; c.gridwidth = 2; panel.add(capacidadField, c);
        c.gridwidth = 1;

        c.gridx = 0; c.gridy = 6; panel.add(labelPasajeros, c);
        c.gridx = 1; c.gridwidth = 2; panel.add(pasajerosField, c);
        c.gridwidth = 1;

        c.gridx = 1; c.gridy = 7; panel.add(agregarBtn, c);

        actualizarCamposSegunTipo();
        cargaRadio.addActionListener(e -> actualizarCamposSegunTipo());
        pasajerosRadio.addActionListener(e -> actualizarCamposSegunTipo());
        agregarBtn.addActionListener(e -> agregarVehiculo());

        return panel;
    }

    private void actualizarCamposSegunTipo() {
        if (cargaRadio.isSelected()) {
            capacidadField.setEnabled(true);
            pasajerosField.setEnabled(false);
            pasajerosField.setText("");
        } else {
            capacidadField.setEnabled(false);
            capacidadField.setText("");
            pasajerosField.setEnabled(true);
        }
    }

    private JPanel panelListarVehiculos() {
        JPanel panel = new JPanel(new BorderLayout());
        tablaModelo = new DefaultTableModel();
        tablaModelo.setColumnIdentifiers(new String[] {
            "Tipo", "Patente", "Marca", "Modelo", "Días Arriendo", "Capacidad (kg)", "Pasajeros"
        });
        tablaVehiculos = new JTable(tablaModelo);
        JScrollPane scroll = new JScrollPane(tablaVehiculos);

        JButton refrescarBtn = new JButton("Refrescar lista");
        refrescarBtn.addActionListener(e -> refrescarTabla());

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(refrescarBtn, BorderLayout.SOUTH);

        return panel;
    }

    private void refrescarTabla() {
        tablaModelo.setRowCount(0);
        synchronized(gestionFlota.getListaVehiculos()) {
            for (Vehiculo v : gestionFlota.getListaVehiculos()) {
                String tipo = v instanceof VehiculoCarga ? "Carga" : "Pasajeros";
                String patente = v.getPatente();
                String marca = v.getMarca();
                String modelo = v.getModelo();
                int dias = v.getDiasArriendo();
                String capacidad = v instanceof VehiculoCarga ? String.valueOf(((VehiculoCarga) v).getCapacidadCarga()) : "-";
                String pasajeros = v instanceof VehiculoPasajero ? String.valueOf(((VehiculoPasajero) v).getMaxPasajeros()) : "-";
                tablaModelo.addRow(new Object[] { tipo, patente, marca, modelo, dias, capacidad, pasajeros });
            }
        }
    }

    private JPanel panelMostrarBoletas() {
        JPanel panel = new JPanel(new BorderLayout());
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);

        JButton mostrarBtn = new JButton("Mostrar todas las boletas");
        mostrarBtn.addActionListener(e -> mostrarBoletas());

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(mostrarBtn, BorderLayout.SOUTH);

        return panel;
    }

    private void mostrarBoletas() {
        StringBuilder sb = new StringBuilder();
        synchronized(gestionFlota.getListaVehiculos()) {
            for (Vehiculo v : gestionFlota.getListaVehiculos()) {
                sb.append(v.calcularBoleta());
                sb.append("\n----------------------------\n");
            }
        }
        outputArea.setText(sb.toString());
    }

    private JPanel panelArriendosLargos() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea texto = new JTextArea();
        texto.setEditable(false);
        JScrollPane scroll = new JScrollPane(texto);

        JButton btnCantidad = new JButton("Mostrar cantidad de arriendos >= 7 días");
        btnCantidad.addActionListener(e -> {
            int cantidad = gestionFlota.cantidadArriendosLargos();
            texto.setText("Cantidad de vehículos con arriendo >= 7 días: " + cantidad);
        });

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnCantidad, BorderLayout.SOUTH);

        return panel;
    }

    private void agregarVehiculo() {
        String patente = patenteField.getText().trim().toUpperCase();
        String marca = marcaField.getText().trim();
        String modelo = modeloField.getText().trim();
        String diasStr = diasArriendoField.getText().trim();
        String capacidadStr = capacidadField.getText().trim();
        String pasajerosStr = pasajerosField.getText().trim();

        if (!patente.matches("[A-Z]{2}\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Patente inválida. Formato válido: dos letras y cuatro números (Ej: AB1234).");
            return;
        }
        if (marca.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Marca y Modelo no pueden estar vacíos.");
            return;
        }
        int diasArriendo;
        try {
            diasArriendo = Integer.parseInt(diasStr);
            if (diasArriendo <= 0) {
                JOptionPane.showMessageDialog(this, "Días de arriendo debe ser mayor que cero.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Días de arriendo debe ser un número entero válido.");
            return;
        }

        if (cargaRadio.isSelected()) {
            double capacidad;
            try {
                capacidad = Double.parseDouble(capacidadStr);
                if (capacidad <= 0) {
                    JOptionPane.showMessageDialog(this, "Capacidad debe ser un número positivo.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Capacidad debe ser un número válido.");
                return;
            }

            VehiculoCarga vc = new VehiculoCarga(patente, marca, modelo, diasArriendo, capacidad);
            try {
                gestionFlota.agregarVehiculo(vc);
                JOptionPane.showMessageDialog(this, "Vehículo de carga agregado correctamente.");
                limpiarCampos();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            int maxPasajeros;
            try {
                maxPasajeros = Integer.parseInt(pasajerosStr);
                if (maxPasajeros <= 0) {
                    JOptionPane.showMessageDialog(this, "Número de pasajeros debe ser mayor que cero.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Número de pasajeros debe ser un número entero válido.");
                return;
            }

            VehiculoPasajero vp = new VehiculoPasajero(patente, marca, modelo, diasArriendo, maxPasajeros);
            try {
                gestionFlota.agregarVehiculo(vp);
                JOptionPane.showMessageDialog(this, "Vehículo de pasajeros agregado correctamente.");
                limpiarCampos();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    private void limpiarCampos() {
        patenteField.setText("");
        marcaField.setText("");
        modeloField.setText("");
        diasArriendoField.setText("");
        capacidadField.setText("");
        pasajerosField.setText("");
    }
}


