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
public class UpdatePanel extends JPanel{
    
    public JRadioButton radio_modifier_prix_ventes = new JRadioButton();
    public JRadioButton radio_modifier_tel_users = new JRadioButton();
    
    public ButtonGroup button_group = new ButtonGroup();
    
    public JLabel label_prix_ventes = new JLabel("MODIFIER LES PRIX DE VENTES");
    public JLabel label_tel_users = new JLabel("MODIFIER LES  NUMEROS DE TELEPHONE DES UTILISATEURS");
    public JLabel label_nombre = new JLabel("NOMBRE");
    
    public JTextField text_field_nombre = new JTextField();
    
    public JButton button_commencer = new JButton("COMMENCER");
    public JButton button_modifier = new JButton("MODOFIER");
    public JButton button_annuler = new JButton("ANNULER");
    
    public int line , column ; // nunber of lines and the column of our column...
    
    public JTable table  ;
    
    public Object[][] data ;
    
    public String[] titles_modifier_prix_ventes = {"Identifiant Pièce", "Premier Prix de vente", "Deuxieme Prix de vente"};
    public String[] titles_numero_tel_user = {"Identifiant Utilisateur", "Nouveau Numéro"};
    
    
    public JScrollPane scrollpan = new JScrollPane();
    
    public UpdatePanel(){
    
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        this.add(radio_modifier_prix_ventes);
        this.add(radio_modifier_tel_users);
        
        radio_modifier_prix_ventes.setSelected(true);
        
        button_group.add(radio_modifier_prix_ventes);
        button_group.add(radio_modifier_tel_users);
        
        this.add(label_prix_ventes);
        this.add(label_tel_users);
        this.add(label_nombre);
        
        this.add(text_field_nombre);
        
        this.add(button_commencer);
        this.add(button_modifier);
        this.add(button_annuler);
        
        
        radio_modifier_prix_ventes.setBounds(50, 50, 50, 30);
        radio_modifier_tel_users.setBounds(50, 100, 50, 30);
        
        radio_modifier_prix_ventes.setBackground(new Color(8, 253, 180));
        radio_modifier_tel_users.setBackground(new Color(8, 253, 180));
        
        label_prix_ventes.setBounds(100, 50, 250, 30);
        label_tel_users.setBounds(100, 100, 350, 30);
        label_nombre.setBounds(550, 50, 50, 30);
        
        text_field_nombre.setBounds(650, 50, 50, 30);
        
        button_commencer.setBounds(750, 50, 150, 30);
        button_modifier.setBounds(550, 600, 150, 30);
        button_annuler.setBounds(800, 600, 150, 30);
        
        
                
    }
    
}
