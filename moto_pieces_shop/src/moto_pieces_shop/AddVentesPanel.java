/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moto_pieces_shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.MenuComponent;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author famille_essuthi
 */
public class AddVentesPanel extends JPanel{
    
    public JLabel label_ajout = new JLabel("AJOUT DE VENTES");
    public JLabel label_identifiant_vendeur = new JLabel("IDENTIFIANT VENDEUR");
    public JLabel label_nombre = new JLabel("NOMBRE");
    public JLabel label_date = new JLabel("DATE");
    
    public JTextField text_field_nombre = new JTextField();
    public JTextField text_field_identifiant = new JTextField();
    public JFormattedTextField text_field_date ;
    
    public JButton button_commencer = new JButton("COMMENCER");
    public JButton button_ajouter = new JButton("AJOUTER");
    public JButton button_annuler = new JButton("ANNULER");
    
    public int line , column ; // nunber of lines and the column of our column...
    
    public JTable table  ;
    
    public Object[][] data ;
    
    public String[] titles = {"identifiant pièce", "prix de vente" ,"Quantité" };
    
    public JScrollPane scrollpan = new JScrollPane();
    
    
    public AddVentesPanel(){
        
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        
        
        //PUT THE text_field_date IN A FORMAT...
        try{
            MaskFormatter mask_date = new MaskFormatter("****-**-**");
            text_field_date = new JFormattedTextField(mask_date);
            text_field_date.setText("aaaa-mm-jj");
            text_field_date.setFont(new Font("Arial", Font.BOLD, 15));
        }catch(ParseException pe){
            pe.printStackTrace();
        }
        
        this.add(label_ajout);
        this.add(label_nombre);
        this.add(label_identifiant_vendeur);
        this.add(label_date);
        
        this.add(text_field_nombre);
        this.add(text_field_identifiant);
        this.add(text_field_date);
        
        this.add(button_commencer);
        this.add(button_ajouter);
        this.add(button_annuler);
        
        label_ajout.setBounds(600, 8, 200, 50);
        label_nombre.setBounds(150, 50, 50, 30);
        label_identifiant_vendeur.setBounds(400, 50, 150, 30);
        label_date.setBounds(750, 50, 50, 30);
        
        text_field_nombre.setBounds(230, 50, 100, 30);
        text_field_identifiant.setBounds(580, 50, 100, 30);
        text_field_date.setBounds(830, 50, 100, 30);
        
        button_commencer.setBounds(1000, 50, 150, 30);
        button_ajouter.setBounds(600, 630, 100, 30);
        button_annuler.setBounds(750, 630, 100, 30);

    }
}
