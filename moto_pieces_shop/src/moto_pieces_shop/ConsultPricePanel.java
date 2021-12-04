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
public class ConsultPricePanel extends JPanel{
    
    public JLabel label_consulter_prix = new JLabel("CONSULTER LES PRIX");
    
    public JLabel label_identifiant_piece = new JLabel("IDENTIFIANT PIECE");
    public JLabel label_prix_achat = new JLabel("PRIX D'ACHAT");
    public JLabel label_premier_prix = new JLabel("PREMIER PRIX");
    public JLabel label_deuxieme_prix = new JLabel("DEUXIEME PRIX");
    
    public JTextField text_field_id_piece = new JTextField();
    public JTextField text_field_prix_achat = new JTextField();
    public JTextField text_field_premier_prix = new JTextField();
    public JTextField text_field_deuxieme_prix = new JTextField();
    
    public JButton button_afficher = new JButton("AFFICHER");
    
    public ConsultPricePanel(){
    
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        this.add(label_consulter_prix);
        this.add(label_identifiant_piece);
        this.add(label_prix_achat);
        this.add(label_premier_prix);
        this.add(label_deuxieme_prix);
        
        this.add(text_field_id_piece);
        this.add(text_field_prix_achat);
        this.add(text_field_premier_prix);
        this.add(text_field_deuxieme_prix);
        
        text_field_prix_achat.setEditable(false);
        text_field_premier_prix.setEditable(false);
        text_field_deuxieme_prix.setEditable(false);
        
        this.add(button_afficher);
        
        label_consulter_prix.setBounds(550, 10, 200, 30);
        label_identifiant_piece.setBounds(100, 100, 200, 30);
        label_prix_achat.setBounds(100, 200, 200, 30);
        label_premier_prix.setBounds(100, 250, 200, 30);
        label_deuxieme_prix.setBounds(100, 300, 200, 30);
        
        text_field_id_piece.setBounds(350, 100, 100, 30);
        text_field_prix_achat.setBounds(350, 200, 100, 30);
        text_field_premier_prix.setBounds(350, 250, 100, 30);
        text_field_deuxieme_prix.setBounds(350, 300, 100, 30);
        
        button_afficher.setBounds(500, 200, 150, 30);
        
        
    }
    
}
