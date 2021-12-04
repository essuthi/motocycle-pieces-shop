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
public class DeletePanel extends JPanel{
    
    public JRadioButton radio_supprimer_achats = new JRadioButton();
    public JRadioButton radio_supprimer_pieces = new JRadioButton();
    public JRadioButton radio_supprimer_ventes = new JRadioButton();
    
    public ButtonGroup button_group = new ButtonGroup();
    
    public JLabel label_supprimer_achats = new JLabel("SUPPRIMER DES AHATS");
    public JLabel label_supprimer_pieces = new JLabel("SUPPRIMER DES PIECES");
    public JLabel label_supprimer_ventes = new JLabel("SUPPRIMER DES VENTES");
    public JLabel label_nombre =new JLabel("NOMBRE");
    
    public JTextField text_field_nombre = new JTextField();
    
    public JButton button_commencer = new JButton("COMMENCER");
    public JButton button_supprimer = new JButton("SUPPRIMER");
    public JButton button_annuler = new JButton("ANNULER");
    
    public int line , column ; // nunber of lines and the column of our column...
    
    public JTable table  ;
    
    public Object[][] data ;
    
    public String[] titles_supprimer_achats = {"identifiant Achats"};
    public String[] titles_supprimer_ventes = {"identifiant Ventes"};
    public String[] titles_supprimer_pieces = {"identifiant Pièces"};
    
    
    public JScrollPane scrollpan = new JScrollPane();
    
    
    public DeletePanel(){
        
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        this.add(radio_supprimer_achats);
        this.add(radio_supprimer_pieces);
        this.add(radio_supprimer_ventes);
        
        button_group.add(radio_supprimer_achats);
        button_group.add(radio_supprimer_pieces);
        button_group.add(radio_supprimer_ventes);
        
        this.add(label_supprimer_achats);
        this.add(label_supprimer_pieces);
        this.add(label_supprimer_ventes);
        this.add(label_nombre);
        
        this.add(text_field_nombre);
        
        this.add(button_commencer);
        this.add(button_supprimer);
        this.add(button_annuler);
        
        
        radio_supprimer_achats.setBounds(50, 50, 40, 30);
        radio_supprimer_pieces.setBounds(50, 100, 40, 30);
        radio_supprimer_ventes.setBounds(50, 150, 40, 30);
        
        radio_supprimer_achats.setBackground(new Color(8, 253, 180));
        radio_supprimer_pieces.setBackground(new Color(8, 253, 180));
        radio_supprimer_ventes.setBackground(new Color(8, 253, 180));
        
        radio_supprimer_achats.setSelected(true);
        
        label_supprimer_achats.setBounds(100 , 50, 200, 30);
        label_supprimer_pieces.setBounds(100, 100, 200, 30);
        label_supprimer_ventes.setBounds(100, 150, 200, 30);
        
        label_nombre.setBounds(350, 50, 50, 30);
        
        text_field_nombre.setBounds(430, 50, 50, 30);
        
        button_commencer.setBounds(550, 50, 150, 30);
        
        button_supprimer.setBounds(550, 600, 150, 30);
        button_annuler.setBounds(800, 600, 150, 30);
        
    }
}
