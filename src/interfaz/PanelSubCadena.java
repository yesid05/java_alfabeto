
package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSubCadena extends JDialog implements ActionListener {

    private Main interfaz;

    private JLabel lblPalabra;

    private JLabel lblSufijo;

    private JLabel lblPrefijo;

    private JTextField txtSubCadenaUno;

    private JTextField txtSubCadenaDos;

    private JButton btnAceptar;

    private JButton btnCancelar;

    public PanelSubCadena(String unaPalabra, Main unaInterfaz) {

        interfaz = unaInterfaz;

        JPanel panelSuperior = new JPanel(new GridBagLayout());
        JPanel panelInferior = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        lblPalabra = new JLabel("La palabra es: " + unaPalabra);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 2, 2);
        panelSuperior.add(lblPalabra, gbc);

        lblSufijo = new JLabel("Sufijo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 10, 2, 2);
        panelSuperior.add(lblSufijo, gbc);

        lblPrefijo = new JLabel("Prefijo:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(2, 10, 2, 2);
        panelSuperior.add(lblPrefijo, gbc);

        txtSubCadenaUno = new JTextField(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 10);
        panelSuperior.add(txtSubCadenaUno, gbc);

        txtSubCadenaDos = new JTextField(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 5, 10);
        panelSuperior.add(txtSubCadenaDos, gbc);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 5);
        panelInferior.add(btnAceptar, gbc);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 10);
        panelInferior.add(btnCancelar, gbc);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);

    }

    public String darSufijo() {
        return txtSubCadenaUno.getText();
    }

    public String darPrefijo() {
        return txtSubCadenaDos.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            String subCadena = interfaz.subCadena();
            try {
                if (Integer.parseInt(subCadena) == 0) {
                    JOptionPane.showMessageDialog(null, "Algunos campos están vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (Integer.parseInt(subCadena) == 1) {
                    JOptionPane.showMessageDialog(null, "Escriba datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (subCadena == null) {
                    JOptionPane.showMessageDialog(null, "Error en los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException numero) {
                if (subCadena == null) {
                    JOptionPane.showMessageDialog(null, "Error en los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "La sub cadena es: " + subCadena, "Sub cadena", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if (e.getSource() == btnCancelar) {
            dispose();
        }
    }

}
