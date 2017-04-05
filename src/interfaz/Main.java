package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mundo.Alfbeto;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

    private Alfbeto alfabeto;

    private CrearPalabra crearPalabra;

    private PanelPrefijo panelPrefijo;

    private PanelSufijo panelSufijo;

    private PanelSubCadena panelSubCadena;

    private PanelSubSecuencia panelSubSecuencia;

    private JLabel lblPalabra;

    private JLabel lblPrefijo;

    private JLabel lblSufijo;

    private JLabel lblSubCadena;

    private JLabel lblSubSecuancia;

    private JTextField txtOpcion;

    private JButton btnAceptar;

    private JButton btnCancelar;

    public Main() {

        alfabeto = new Alfbeto(3);

        setTitle("Alfabeto");
        setLayout(new BorderLayout(1, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panelSuperior = new JPanel(new GridBagLayout());
        JPanel panelInferior = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        lblPalabra = new JLabel("1.-Crear palabra");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 2, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        panelSuperior.add(lblPalabra, gbc);

        lblPrefijo = new JLabel("2.-Prefijo de la palabra");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 10, 2, 10);
        gbc.anchor = GridBagConstraints.WEST;
        panelSuperior.add(lblPrefijo, gbc);

        lblSufijo = new JLabel("3.-Sufijo de la palabra");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(2, 10, 2, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        panelSuperior.add(lblSufijo, gbc);

        lblSubCadena = new JLabel("4.-Sub cadena de la palabra");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(2, 10, 2, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        panelSuperior.add(lblSubCadena, gbc);

        lblSubSecuancia = new JLabel("5.-Sub secuencia de la palabra");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(2, 10, 2, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        panelSuperior.add(lblSubSecuancia, gbc);

        txtOpcion = new JTextField(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        panelSuperior.add(txtOpcion, gbc);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 10);
        panelInferior.add(btnAceptar, gbc);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelInferior.add(btnCancelar, gbc);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Main ventana = new Main();
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public void limpiarCampo() {
        txtOpcion.setText("");
    }

    public boolean crearPalabra() {
        String palabra = crearPalabra.darPalabra();
        alfabeto.cambiarPalabra(palabra);
        return alfabeto.existePalabra();
    }

    public String prefijo() {
        try {
            int prefijo = Integer.parseInt(panelPrefijo.darPrefijo());
            return alfabeto.darPrefijo(prefijo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String sufijo() {
        try {
            int sufijo = Integer.parseInt(panelSufijo.darSufijo());
            return alfabeto.darSufijo(sufijo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String subCadena() {
        try {
            if (panelSubCadena.darSufijo() != null && panelSubCadena.darPrefijo() != null) {
                int sufijo = Integer.parseInt(panelSubCadena.darSufijo());
                int prefijo = Integer.parseInt(panelSubCadena.darPrefijo());
                return alfabeto.darSubcadena(sufijo, prefijo);
            } else {
                return "0";
            }
        } catch (NumberFormatException e) {
            return "1";
        }
    }

    public String subSecuencia() {
        String simbolos = panelSubSecuencia.darNumSubSecuencia();
        char[] vecSimbolos = simbolos.toCharArray();
        int[] vecPosiciones = new int[vecSimbolos.length];
        boolean perfecto = true;
        for (int i = 0; i < vecSimbolos.length && perfecto; i++) {
            try {
                int numValido = Integer.parseInt(String.valueOf(vecSimbolos[i]));
                if (numValido >= 0) {
                    perfecto = true;
                    vecPosiciones[i] = numValido;
                } else {
                    perfecto = false;
                }
            } catch (NumberFormatException e) {
                perfecto = false;
            }
        }
        if (perfecto) {
            return alfabeto.darSubSecuencia(vecPosiciones);
        } else {
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            try {
                int opcion = Integer.parseInt(txtOpcion.getText());
                switch (opcion) {
                    case 1:
                        crearPalabra = new CrearPalabra(alfabeto.darAbecedario(), this);
                        crearPalabra.pack();
                        crearPalabra.setLocationRelativeTo(this);
                        crearPalabra.setModal(true);
                        crearPalabra.setVisible(true);
                        break;
                    case 2:
                        if (alfabeto.darPalabra() != null) {
                            panelPrefijo = new PanelPrefijo(alfabeto.darPalabra(), this);
                            panelPrefijo.pack();
                            panelPrefijo.setLocationRelativeTo(this);
                            panelPrefijo.setModal(true);
                            panelPrefijo.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "En este momento no tiene una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        if (alfabeto.darPalabra() != null) {
                            panelSufijo = new PanelSufijo(alfabeto.darPalabra(), this);
                            panelSufijo.pack();
                            panelSufijo.setLocationRelativeTo(this);
                            panelSufijo.setModal(true);
                            panelSufijo.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "En este momento no tiene una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        if (alfabeto.darPalabra() != null) {
                            panelSubCadena = new PanelSubCadena(alfabeto.darPalabra(), this);
                            panelSubCadena.pack();
                            panelSubCadena.setLocationRelativeTo(this);
                            panelSubCadena.setModal(true);
                            panelSubCadena.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "En este momento no tiene una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        if (alfabeto.darPalabra() != null) {
                            panelSubSecuencia = new PanelSubSecuencia(alfabeto.darPalabra(), this);
                            panelSubSecuencia.pack();
                            panelSubSecuencia.setLocationRelativeTo(this);
                            panelSubSecuencia.setModal(true);
                            panelSubSecuencia.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "En este momento no tiene una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error en el menu", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException numero) {
                JOptionPane.showMessageDialog(null, "Error digite un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnCancelar) {
            System.exit(0);
        }
    }
}
