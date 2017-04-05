
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

public class PanelSubSecuencia extends JDialog implements ActionListener {

    private Main interfaz;

    private JLabel lblPalabra;

    private JLabel lblNumSimbolos;

    private JTextField txtNumSimbolos;

    private JButton btnAceptar;

    private JButton btnCancelar;

    public PanelSubSecuencia(String unaPalabra, Main unaInterfaz) {

        interfaz = unaInterfaz;

        setTitle("Sub secuencia");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panelSuperior = new JPanel(new GridBagLayout());
        JPanel panelInferior = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        lblPalabra = new JLabel("La palabra es: " + unaPalabra);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 2, 2);
        panelSuperior.add(lblPalabra, gbc);

        lblNumSimbolos = new JLabel("Posición de los símbolos que desea eliminar.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 10, 2, 2);
        panelSuperior.add(lblNumSimbolos, gbc);

        txtNumSimbolos = new JTextField(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 2, 2, 10);
        panelSuperior.add(txtNumSimbolos, gbc);

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
        gbc.insets = new Insets(5, 2, 5, 10);
        panelInferior.add(btnCancelar, gbc);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);

    }

    public String darNumSubSecuencia() {
        return txtNumSimbolos.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            if (interfaz.subSecuencia() != null) {
                JOptionPane.showMessageDialog(null, "La sub secuencia es: " + interfaz.subSecuencia(), "Sub secuencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Existe un error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnCancelar) {
            dispose();
        }
    }

}
