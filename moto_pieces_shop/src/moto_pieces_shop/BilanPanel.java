/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moto_pieces_shop;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author famille_essuthi
 */
public class BilanPanel extends JPanel{
    
    public JLabel label_vente_totale = new JLabel("VENTE TOTALE");
    public JLabel label_benefice = new JLabel("BENEFICE ");
    public JLabel label_depense_achats_totale = new JLabel("DEPENSE TOTALE DES ACHATS");
    public JLabel label_bilan_operation = new JLabel("BILAN DES OPERATIONS");
    public JLabel date_debut = new JLabel("DATE DE DEBUT DU BILAN");
    
    public JTextField text_field_vente_totale = new JTextField();
    public JTextField text_field_benefice = new JTextField();
    public JTextField text_field_depense_achats_totale = new JTextField();
    public JFormattedTextField text_field__date_debut = new JFormattedTextField();
    
    public JButton button_afficher = new JButton("AFFICHER");
    
    public BilanPanel(){
    
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        //PUT THE text_field_date IN A FORMAT...
        try{
            MaskFormatter mask_date = new MaskFormatter("****-**-**");
            text_field__date_debut = new JFormattedTextField(mask_date);
            text_field__date_debut.setText("aaaa-mm-jj");
            text_field__date_debut.setFont(new Font("Arial", Font.BOLD, 15));
        }catch(ParseException pe){
            pe.printStackTrace();
        }
        
        this.add(label_vente_totale);
        this.add(label_benefice);
        this.add(label_depense_achats_totale);
        this.add(label_bilan_operation);
        this.add(date_debut);
        
        
        this.add(text_field_vente_totale);
        this.add(text_field_benefice);
        this.add(text_field_depense_achats_totale);
        this.add(text_field__date_debut);
        
        text_field_vente_totale.setEditable(false);
        text_field_benefice.setEditable(false);
        text_field_depense_achats_totale.setEditable(false);
        
        
        
        this.add(button_afficher);
        
        label_bilan_operation.setBounds(550, 10, 200, 30);
        label_vente_totale.setBounds(100, 200, 200, 30);
        label_benefice.setBounds(100, 350, 200, 30);
        label_depense_achats_totale.setBounds(100, 500, 200, 30);
        date_debut.setBounds(100, 50, 200, 30);
        
        
        text_field_vente_totale.setBounds(350, 200, 100, 30);
        text_field_benefice.setBounds(350, 350, 100, 30);
        text_field_depense_achats_totale.setBounds(350, 500, 100, 30);
        text_field__date_debut.setBounds(350, 50, 100, 30);
        
        button_afficher.setBounds(550, 250, 150, 30);
        
        
    }
}
