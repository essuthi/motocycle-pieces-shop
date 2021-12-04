/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moto_pieces_shop;

import java.awt.Color;
import javax.swing.*;


/**
 *
 * @author famille_essuthi
 */
public class AddUsersPanel extends JPanel{
   
    public JLabel label_ajout = new JLabel("AJOUT D'UTILISATEURS");
    public JLabel label_nombre = new JLabel("NOMBRE");
    
    public JTextField text_field_nombre = new JTextField();
    
    public JButton button_commencer = new JButton("COMMENCER");
    public JButton button_ajouter = new JButton("AJOUTER");
    public JButton button_annuler = new JButton("ANNULER");
    
    public int line , column ; // nunber of lines and the column of our column...
    
    public JTable table  ;
    
    public Object[][] data ;
    
    public String[] titles = {"identifiant", "Nom" ,"Numéro" };
    
    public JScrollPane scrollpan = new JScrollPane();
    
    public AddUsersPanel(){
        
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        this.add(label_ajout);
        this.add(label_nombre);
        
        this.add(text_field_nombre);
        
        this.add(button_commencer);
        this.add(button_ajouter);
        this.add(button_annuler);
        
        label_ajout.setBounds(600, 10, 200, 50);
        label_nombre.setBounds(100, 50, 100, 30);
        
        text_field_nombre.setBounds(210, 50, 100, 30);
        
        button_commencer.setBounds(330, 50, 150, 30);
        button_ajouter.setBounds(600, 630, 100, 30);
        button_annuler.setBounds(750, 630, 100, 30); 
    }
}
