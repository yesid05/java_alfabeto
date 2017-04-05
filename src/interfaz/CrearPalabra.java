
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

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CrearPalabra extends JDialog implements ActionListener{
    
    private Main interfaz;
    
    private JLabel lblAlfabeto;
    
    private JTextField txtPalabra;
    
    private JButton btnAceptar;
    
    private JButton btnCancelar;
    
    public CrearPalabra(String unAlfabeto, Main unaInterfaz){
        
        interfaz = unaInterfaz;
        
        setLayout(new BorderLayout());
        setTitle("Crear palabra");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        JPanel panelInferior = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        lblAlfabeto = new JLabel("Alfabeto: "+unAlfabeto);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 2, 10);
        gbc.fill = GridBagConstraints.BOTH;
        panelSuperior.add(lblAlfabeto,gbc);
        
        txtPalabra = new JTextField(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;
        panelSuperior.add(txtPalabra,gbc);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 5);
        panelInferior.add(btnAceptar,gbc);
        
        btnCancelar= new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 10);
        panelInferior.add(btnCancelar,gbc);
        
        add(panelSuperior,BorderLayout.NORTH);
        add(panelInferior,BorderLayout.SOUTH);
    }
    
    public String darPalabra(){
        return txtPalabra.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnAceptar){
           if(interfaz.crearPalabra()){
               JOptionPane.showMessageDialog(null, "La palabra se creó con éxito","Crear palabra",JOptionPane.INFORMATION_MESSAGE);
               interfaz.limpiarCampo();
               dispose();
           }else{
               JOptionPane.showMessageDialog(null, "La palabra no se puede crear con el alfabeto actual.","Error",JOptionPane.ERROR_MESSAGE);
           }
       }
       if(e.getSource()==btnCancelar){
           interfaz.limpiarCampo();
           dispose();
       }
    }
}
