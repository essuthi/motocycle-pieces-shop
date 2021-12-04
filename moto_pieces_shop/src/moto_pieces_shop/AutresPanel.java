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
public class AutresPanel extends JPanel{
    
    public JRadioButton radio_achats_par_pieces = new JRadioButton();
    public JRadioButton radio_pieces_restantes = new JRadioButton();
    public JRadioButton radio_achats_par_date = new JRadioButton();
    public JRadioButton radio_ventes_par_piece = new JRadioButton();
    public JRadioButton radio_ventes_par_date = new JRadioButton();
    
    
    public ButtonGroup button_group = new ButtonGroup();
    
    public JLabel label_pieces_restantes = new JLabel("LISTE DES PIECES RESTANTES");
    public JLabel label_achats_par_pieces= new JLabel("LISTE DES ACHATS PAR PIECES");
    public JLabel label_achats_par_date = new JLabel("LISTE DES ACHATS PAR DATES");
    public JLabel label_ventes_par_piece = new JLabel("LISTE DES VENTES PAR PIECES");
    public JLabel label_ventes_par_date = new JLabel("LISTE DES VENTES PAR DATE");
    
    public JButton button_afficher = new JButton("AFFICHER");
    
    
    public int line , column ; // nunber of lines and the columns of our table...
    
    public JTable table  ;
    
    public Object[][] data ;
    
    public String[] titles_autres_pieces_restantes = {"identifiant de la Peièce", "Nom", "Quantité Restante"};
    public String[] titles_autres_achats_par_piece = {"identifiant de la Piece", "Nom", "Quantité Totale Achetée"};
    public String[] titles_autres_achats_par_date = {"Identifiant de l'achat", "identifiant de la Pièce", "Nom", "Quantité", "Date de l'Achat"};
    public String[] titles_autres_ventes_par_piece = {"identifiant de Pièces", "Nom", "Quantité tolale Vendue"};
    public String[] titles_autres_ventes_par_date = {"Identifiant de la vente", "identifiantde la  Pièce", "Nom", "Quantité", "Date de la Vente"};
    
    
    public JScrollPane scrollpan = new JScrollPane();
    
    public AutresPanel(){
    
        this.setLayout(null);
        this.setBackground(new Color(8, 253, 180));
        
        this.add(radio_achats_par_pieces);
        this.add(radio_pieces_restantes);
        this.add(radio_achats_par_date);
        this.add(radio_ventes_par_piece);
        this.add(radio_ventes_par_date);
        
        radio_achats_par_pieces.setSelected(true);
        
        button_group.add(radio_achats_par_pieces);
        button_group.add(radio_pieces_restantes);
        button_group.add(radio_achats_par_date);
        button_group.add(radio_ventes_par_piece);
        button_group.add(radio_ventes_par_date);
        
        this.add(label_achats_par_pieces);
        this.add(label_pieces_restantes);
        this.add(label_achats_par_date);
        this.add(label_ventes_par_piece);
        this.add(label_ventes_par_date);
        
        this.add(button_afficher);
        
        radio_pieces_restantes.setBounds(100, 10, 30, 30);
        radio_achats_par_pieces.setBounds(100, 60, 30, 30);
        radio_achats_par_date.setBounds(100, 110, 30, 30);
        radio_ventes_par_piece.setBounds(450, 10, 30, 30);
        radio_ventes_par_date.setBounds(450, 60, 30, 30);
        
        radio_pieces_restantes.setBackground(new Color(8, 253, 180));
        radio_achats_par_pieces.setBackground(new Color(8, 253, 180));
        radio_achats_par_date.setBackground(new Color(8, 253, 180));
        radio_ventes_par_piece.setBackground(new Color(8, 253, 180));
        radio_ventes_par_date.setBackground(new Color(8, 253, 180));
        
        label_pieces_restantes.setBounds(150, 10, 300, 30);
        label_achats_par_pieces.setBounds(150, 60, 250, 30);
        label_achats_par_date.setBounds(150, 110, 250, 30);
        label_ventes_par_piece.setBounds(500, 10, 250, 30);
        label_ventes_par_date.setBounds(500, 60, 250, 30);
        
        button_afficher.setBounds(800, 55, 100, 30);
        
        radio_pieces_restantes.setSelected(true);
      
       
        
        
    }
    
    
}
