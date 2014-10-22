/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author AULA
 */
public class ParameterWindow extends JDialog{
    
    private JLabel lblName;
    private JTextField TxtName;
    private JLabel lblPoints;
    private JTextField TxtPoints;
    
    public ParameterWindow(){
        init();
    }

    private void init() {
        
        setBounds(500,0,200,200);
        setLayout(new GridLayout(2,2));
       lblName=new JLabel("Nombre del ususario");
       TxtName= new JTextField("");
       lblPoints= new JLabel("Puntos del jugador");
       TxtPoints= new JTextField("0");
       add(lblName);
       add(TxtName);
       add(lblPoints);
       add(TxtPoints);
        
    }
    
    public void setPoints(int points){
        TxtPoints.setText(String.valueOf(points));
    }
}
