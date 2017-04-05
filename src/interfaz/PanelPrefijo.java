
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

public class PanelPrefijo extends JDialog implements ActionListener {

    private Main interfaz;

    private JLabel lblPalabra;

    private JTextField txtPrefijo;

    private JButton btnAceptar;

    private JButton btnCancelar;

    public PanelPrefijo(String unaPalabra, Main unaInterfaz) {

        interfaz = unaInterfaz;

        setLayout(new BorderLayout());
        setTitle("Prefijo");

        JPanel panelSuperior = new JPanel(new GridBagLayout());
        JPanel panelInferior = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        lblPalabra = new JLabel(unaPalabra);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 2, 10);
        panelSuperior.add(lblPalabra, gbc);

        txtPrefijo = new JTextField(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;
        panelSuperior.add(txtPrefijo, gbc);

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
        
        add(panelSuperior,BorderLayout.NORTH);
        add(panelInferior,BorderLayout.SOUTH);
    }
     
    public String darPrefijo(){
        return txtPrefijo.getText();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAceptar){
            if(interfaz.prefijo()!=null){
                JOptionPane.showMessageDialog(null, "El prefijo de la palabra es: "+interfaz.prefijo());
            }else{
                JOptionPane.showMessageDialog(null, "Error los datos no son validos","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==btnCancelar){
            interfaz.limpiarCampo();
            dispose();
        }
    }

}
