/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moto_pieces_shop;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author famille_essuthi
 */
public class HomePanel extends JPanel{
    
    
    public ImageIcon img = new ImageIcon(getClass().getResource("image_shop1.jpg"));
    
    public JLabel label_image = new JLabel(img);
    public JLabel label_utilisateur = new JLabel("UTILISATEUR");
   public JLabel label_password = new JLabel("MOT DE PASSE");
    
    public JTextField text_field_identifiant = new JTextField();
    public JPasswordField text_field_password = new JPasswordField();
    
    public JButton button_enter = new JButton("ENTRER");
 
    
    public HomePanel(){
        
       this.setLayout(null);
       this.setBackground(new Color(8, 253, 180));

       this.add(label_image);
       this.add(label_utilisateur);
       this.add(label_password);
       
       this.add(text_field_identifiant);
       this.add(text_field_password);
       
       this.add(button_enter);
       
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       label_image.setBounds(0, 0, 1500, 530);
       
       label_utilisateur.setBounds(500, 550, 100, 50);
       label_password.setBounds(500, 600, 100, 50);
       
       
       text_field_identifiant.setBounds(620, 550, 120, 30);
       text_field_password.setBounds(620, 600, 120, 30);
       
       button_enter.setBounds(820, 575, 100, 40);
       
       System.out.println(screenSize.getSize().height);
       System.out.println(screenSize.getSize().width);

        
        
    }
}
