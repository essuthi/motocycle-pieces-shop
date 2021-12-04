/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moto_pieces_shop;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author famille_essuthi
 */
public class ControlWindow  extends JFrame{
    
    public HomePanel homepanel = new HomePanel();
    public AddPiecesPanel addpiecespanel = new AddPiecesPanel();
    public AddAchatsPanel addachatspanel = new AddAchatsPanel();
    public AddVentesPanel addventespanel = new AddVentesPanel();
    public AddUsersPanel adduserspanel = new AddUsersPanel();
    public DeletePanel deletepanel = new DeletePanel();
    public UpdatePanel updatepanel = new UpdatePanel();
    public ConsultPricePanel consultpricepanel = new ConsultPricePanel();
    public BilanPanel bilanpanel = new BilanPanel();
    public AutresPanel autrespanel = new AutresPanel();
    
    public JPanel content = new JPanel();
    
    public CardLayout card = new CardLayout();
    
     public JMenuBar menubar = new JMenuBar();
    
    public JMenu menu_fichier = new JMenu("Fichier");
    public JMenu menu_ajouter = new JMenu("Ajouter");
    public JMenu menu_supprimer = new JMenu("Supprimer");
    public JMenu menu_modifier = new JMenu("Modifier");
    public JMenu menu_consulter = new JMenu("Consulter");
    public JMenu menu_aide = new JMenu("Aide");
    
    //menu items of menu Fichier
    public JMenuItem item_accueil = new JMenuItem("Accueil");
    public JMenuItem item_quiter = new JMenuItem("Quiter");
    
    //menu items of menu Ajouter
    public JMenuItem item_pieces = new JMenuItem("Pièces");
    public JMenuItem item_achats = new JMenuItem("Achats");
    public JMenuItem item_ventes = new JMenuItem("Ventes");
    public JMenuItem item_utilisateurs = new JMenuItem("Utilisateurs");
    
    //Menu items of menu Supprimer..
    public JMenuItem item_suppression = new JMenuItem("Suppression");
    
    
    //Menu items of menu Modofier..
    public JMenuItem item_modifier = new JMenuItem("Modifier");
    
    //menu items of menu Consulter
    public JMenuItem item_prix = new JMenuItem("Prix");
    public JMenuItem item_bilan = new JMenuItem("Bilan");
    public JMenuItem item_autres = new JMenuItem("Autres");
    
    public ConnectionDB con = new ConnectionDB();
    public boolean connection_checker = false ;
    
    
    
    public ControlWindow(){
        setting();
        menu_setting();
        functconnect();
        insertionfuction();
        deletefunction();
        updatefunction();
        queryfunction();
    }
    
    // SETTINGS FUNCTION...
    public void setting(){
        
        this.setJMenuBar(menubar);
        this.setTitle("ESSUTHI_MOTO_PIECES");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(homepanel.img.getImage());
        
        content.setLayout(card);
        content.add(homepanel, "homepanel");
        content.add(addpiecespanel, "addpiecespanel");
        content.add(addachatspanel, "addachatspanel");
        content.add(addventespanel, "addventespanel");
        content.add(adduserspanel,"adduserspanel");
        content.add(deletepanel, "deletepanel");
        content.add(updatepanel, "updatepanel");
        content.add(consultpricepanel, "consultpricepanel");
        content.add(bilanpanel, "bilanpanel");
        content.add(autrespanel, "autrespanel");
        
        card.show(content, "homepanel");
        
        this.setContentPane(content);
        this.setVisible(true);
        
    }
    
    // MENU SETTING FUNCTION...
    public void menu_setting(){
        
        menubar.add(menu_fichier);
        menubar.add(menu_ajouter);
        menubar.add(menu_supprimer);
        menubar.add(menu_modifier);
        menubar.add(menu_consulter);
        menubar.add(menu_aide);
        
        menu_fichier.add(item_accueil);
        menu_fichier.add(item_quiter);
        
        menu_ajouter.add(item_pieces);
        menu_ajouter.add(item_achats);
        menu_ajouter.add(item_ventes);
        menu_ajouter.add(item_utilisateurs);
        
        menu_supprimer.add(item_suppression);
       
        menu_modifier.add(item_modifier);
        
        menu_consulter.add(item_prix);
        menu_consulter.add(item_bilan);
        menu_consulter.add(item_autres);
        
        
        
        // ITEM "Accueil" TO COME BACK TO THE HOME PAGE...
        item_accueil.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(content, "homepanel");
                homepanel.button_enter.setEnabled(true);
                homepanel.text_field_identifiant.setText(null);
                homepanel.text_field_password.setText(null);
                connection_checker = false;
            }
        
        });
        
        
        
        
        // ITEM "Quité" TO QUIT THE APPLICATION...
        item_quiter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        // ITEM "PIECES" TO ACCESS THE AddPiecesPanel...
        item_pieces.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "addpiecespanel");
                    
                }
            }
        
            
        });
        
        // ITEM ACHATS TO ACCESS THE AddachatsPanel...
        item_achats.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "addachatspanel");
                    
                }
            }
        
            
        });
        
        // ITEM VENTES TO ACCESS THE AddVentesPanel...
        item_ventes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "addventespanel");
                    
                }
            }
        
            
        });
        
        
        // ITEM UTILISATEURS TO ACCESS THE AddVentesPanel...
        item_utilisateurs.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "adduserspanel");
                    
                }
            }
        
            
        });
        
        
        // MENU ITEM SUPPRESSION TO ACCESS THE DeletePanel...
        item_suppression.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "deletepanel");
                }
            }
        
            
        });
        
        
        // MENU ITEM MODIFIER TO ACCESS THE UpdatePanel...
        item_modifier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "updatepanel");
                }
            }
        
            
        });
        
        
        // MENU ITEM PRIX TO ACCESS THE CunsultPricePanel...
        item_prix.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "consultpricepanel");
                }
            }
        
            
        });
        
        
        
        // MENU ITEM BILAN TO ACCESS THE BilanPanel....
        item_bilan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "bilanpanel");
                }
            }
        
            
        });
        
     
        
        // MENU ITEM AUTRES TO ACCESS THE AutresPanel....
        item_autres.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection_checker != true){
                    JOptionPane.showMessageDialog(null, "conecter vous d'abord !");
                }
                else{
                    card.show(content, "autrespanel");
                }
            }
        
            
        });
    }
    
    
    // FUNCTION TO CONNECT TO THE APPLICATION AND DATABASE AS A USER...
        public void functconnect(){
        
        homepanel.button_enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(homepanel.text_field_password.getText().equals("essoh") && homepanel.text_field_identifiant.getText().replaceAll("\\s+$", "").equals("essuthi")){
                    JOptionPane.showMessageDialog(null, "connexion réussie");
                    connection_checker = true;
                    homepanel.button_enter.setEnabled(false);
                    homepanel.text_field_password.setText(null);
                    homepanel.text_field_identifiant.setText(null);
                }
                else{
                   JOptionPane.showMessageDialog(null, "connexion échouée"); 
                }
            }
            
        });
        
    }
        
        
        
    // AddPiecesPanel's  FUNCTIONS
    public void insertionfuction(){
        
        // BUTTON "COMMENCER" OF Addpiecespanel TO CREATE THE TABLE AND START THE PIECES ADDING PROCESS...
        addpiecespanel.button_commencer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
          
                if(addpiecespanel.isAncestorOf(addpiecespanel.scrollpan))
                    addpiecespanel.remove(addpiecespanel.scrollpan);
                if(addpiecespanel.text_field_nombre.getText().replaceAll("\\s+", "").equals("")){
                    JOptionPane.showMessageDialog(null, "entrer le nombre de pièces à ajouter");
                }
                else{
                    addpiecespanel.line = Integer.parseInt(addpiecespanel.text_field_nombre.getText().replaceAll("\\s+", ""));
                    addpiecespanel.column = addpiecespanel.titles.length ;
                    
                    addpiecespanel.data = new Object[addpiecespanel.line][addpiecespanel.column];
                    addpiecespanel.table = new JTable(addpiecespanel.data, addpiecespanel.titles);

                    addpiecespanel.scrollpan = new JScrollPane(addpiecespanel.table);
                    addpiecespanel.add(addpiecespanel.scrollpan).setBounds(50, 100, 1200, 500);
                    
                }
                
                for(int i = 0; i < addpiecespanel.line; i++){
                    for(int j = 0; j < addpiecespanel.column; j++)
                        addpiecespanel.table.editCellAt(i, j);
                }
            }    
        });
        
        // BUTTON "COMMENCER" OF AddAchatsPieces TO INSERT ACHATS IN THE DATABASE...
        addachatspanel.button_commencer.addActionListener(new ActionListener(){            @Override
            public void actionPerformed(ActionEvent e) {
                if(addachatspanel.isAncestorOf(addachatspanel.scrollpan))
                    addachatspanel.remove(addachatspanel.scrollpan);
                if(addachatspanel.text_field_nombre.getText().replaceAll("\\s+", "").equals("") || addachatspanel.text_field_identifiant.getText().replaceAll("\\s+", "").equals("") || addachatspanel.text_field_date.getText().replaceAll("\\s+", "").equals("")){
                    JOptionPane.showMessageDialog(null, "entrer le nombre de pièces à ajouter, l'identifiant et la date !");
                }
                else{
                    addachatspanel.line = Integer.parseInt(addachatspanel.text_field_nombre.getText().replaceAll("\\s+", ""));
                    addachatspanel.column = addachatspanel.titles.length ;
                    
                    addachatspanel.data = new Object[addachatspanel.line][addachatspanel.column];
                    addachatspanel.table = new JTable(addachatspanel.data, addachatspanel.titles);

                    addachatspanel.scrollpan = new JScrollPane(addachatspanel.table);
                    addachatspanel.add(addachatspanel.scrollpan).setBounds(50, 100, 1200, 500);
                    
                }
                
                for(int i = 0; i < addachatspanel.line; i++){
                    for(int j = 0; j < addachatspanel.column; j++)
                        addachatspanel.table.editCellAt(i, j);
                }
            }
     
        });
        
        // BUTTON "COMMENCER" OF AddVentesPieces TO INSERT VENTES IN THE DATABASE...
        addventespanel.button_commencer.addActionListener(new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addventespanel.isAncestorOf(addventespanel.scrollpan))
                    addventespanel.remove(addventespanel.scrollpan);
                if(addventespanel.text_field_nombre.getText().replaceAll("\\s+", "").equals("") || addventespanel.text_field_date.getText().replaceAll("\\s+", "").equals("") || addventespanel.text_field_identifiant.getText().replaceAll("\\s+", "").equals("")){
                    JOptionPane.showMessageDialog(null, "entrer le nombre de pièces à ajouter, l'identifiant et la date !");
                }
                else{
                    addventespanel.line = Integer.parseInt(addventespanel.text_field_nombre.getText().replaceAll("\\s+", ""));
                    addventespanel.column = addventespanel.titles.length ;
                    
                    addventespanel.data = new Object[addventespanel.line][addventespanel.column];
                    addventespanel.table = new JTable(addventespanel.data, addventespanel.titles);

                    addventespanel.scrollpan = new JScrollPane(addventespanel.table);
                    addventespanel.add(addventespanel.scrollpan).setBounds(50, 100, 1200, 500);
                    
                }
                
                for(int i = 0; i < addventespanel.line; i++){
                    for(int j = 0; j < addventespanel.column; j++)
                        addventespanel.table.editCellAt(i, j);
                }
                
            }
     
        });
        
        // BUTTON "COMMENCER" OF AddUsersPieces TO INSERT USERS or UTILISATEURS IN THE DATABASE...
        adduserspanel.button_commencer.addActionListener(new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adduserspanel.isAncestorOf(adduserspanel.scrollpan))
                    adduserspanel.remove(adduserspanel.scrollpan);
                if(adduserspanel.text_field_nombre.getText().replaceAll("\\s+", "").equals("")){
                    JOptionPane.showMessageDialog(null, "entrer le nombre de pièces à ajouter");
                }
                else{
                    adduserspanel.line = Integer.parseInt(adduserspanel.text_field_nombre.getText().replaceAll("\\s+", ""));
                    adduserspanel.column = adduserspanel.titles.length ;
                    
                    adduserspanel.data = new Object[adduserspanel.line][adduserspanel.column];
                    adduserspanel.table = new JTable(adduserspanel.data, adduserspanel.titles);

                    adduserspanel.scrollpan = new JScrollPane(adduserspanel.table);
                    adduserspanel.add(adduserspanel.scrollpan).setBounds(50, 100, 1200, 500);
                    
                }
                
                for(int i = 0; i < adduserspanel.line; i++){
                    for(int j = 0; j < adduserspanel.column; j++)
                        adduserspanel.table.editCellAt(i, j);
                }
                
            }
     
        });
        
        
        
        // BUTTON "ANNULER" TO CANCEL THE USER ADDING PROCESS...
        adduserspanel.button_annuler.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                adduserspanel.table = null;
                if (adduserspanel.isAncestorOf(adduserspanel.scrollpan))
                    adduserspanel.remove(adduserspanel.scrollpan);
                    adduserspanel.revalidate();
                    adduserspanel.repaint(50, 100, 1200, 500);
                }
            
            
        });
        
        
        // BUTTON "ANNULER" TO CANCEL THE ACHATS ADDING PROCESS...
        addachatspanel.button_annuler.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                addachatspanel.table = null;
                if (addachatspanel.isAncestorOf(addachatspanel.scrollpan))
                    addachatspanel.remove(addachatspanel.scrollpan);
                    addachatspanel.revalidate();
                    addachatspanel.repaint(50, 100, 1200, 500);
                    
                    addachatspanel.text_field_nombre.setText(null);
                    addachatspanel.text_field_date.setText(null);
                    addachatspanel.text_field_identifiant.setText(null);
                }
            
            
        });
        
        
        // BUTTON "ANNULER" TO CANCEL THE PIECES ADDING PROCESS...
        addpiecespanel.button_annuler.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                addpiecespanel.table = null;
                if (addpiecespanel.isAncestorOf(addpiecespanel.scrollpan))
                    addpiecespanel.remove(addpiecespanel.scrollpan);
                    addpiecespanel.revalidate();
                    addpiecespanel.repaint(50, 100, 1200, 500);
                }
            
            
        });
        
        
        // BUTTON "ANNULER" TO CANCEL THE VENTES ADDING PROCESS...
        addventespanel.button_annuler.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                addventespanel.table = null;
                if (addventespanel.isAncestorOf(addventespanel.scrollpan))
                    addventespanel.remove(addventespanel.scrollpan);
                    addventespanel.revalidate();
                    addventespanel.repaint(50, 100, 1200, 500);
                    
                    
                    addventespanel.text_field_nombre.setText(null);
                    addventespanel.text_field_date.setText(null);
                    addventespanel.text_field_identifiant.setText(null);
                }
            
            
        });
        
        
        
        
        
        
        
        
        //BUTTON "AJOUTER" OF AddPiecesPanel TO COMPLETE DE ADDING PROCESS AFTER FILLING THE TABLE..
        addpiecespanel.button_ajouter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                con.connection(); // OPEN THE CONNECTION TO DATABASE...
                Statement statement = null;
                
                int  result = 0 ;
                String insert_statement;
                String id, name, quantite, prix_achat, premier_prix_vente, deuxieme_prix_vente;
                
                try {
                    
                    con.conn.setAutoCommit(false); // START TRANSACTION
                    statement = con.conn.createStatement();
                    
                    addpiecespanel.table.editCellAt(0, 0); // USE FOR THE LAST CELL IN TABLE TO BE CONSIDERED...
                    addpiecespanel.table.getCellEditor().stopCellEditing();
                    
                    for(int i = 0 ; i < addpiecespanel.line ; i++){
                        id = addpiecespanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                        name = addpiecespanel.table.getValueAt(i, 1).toString().replaceAll("\\s+$", "");
                        quantite = addpiecespanel.table.getValueAt(i, 2).toString().replaceAll("\\s+", "");
                        prix_achat = addpiecespanel.table.getValueAt(i, 3).toString().replaceAll("\\s+", "");
                        premier_prix_vente = addpiecespanel.table.getValueAt(i, 4).toString().replaceAll("\\s+", "");
                        deuxieme_prix_vente = addpiecespanel.table.getValueAt(i, 5).toString().replaceAll("\\s+", "");
                        
                        if((id.equals("") && name.equals("") && quantite.equals("") && prix_achat.equals("") && premier_prix_vente.equals("") && deuxieme_prix_vente.equals("")) || (id == null && name == null && quantite == null && prix_achat == null && premier_prix_vente == null && deuxieme_prix_vente == null))
                            continue;
                       
                        insert_statement = "INSERT INTO pieces VALUES ( '" + id + "', '" + name + "' ," + quantite + ", " + prix_achat + ", " + premier_prix_vente +  ", " + deuxieme_prix_vente + " ) ;";
                        result = statement.executeUpdate(insert_statement);
                        
                        
                    }
                    
                    con.conn.commit(); // CLOSE THE TRANSACTION...
                    
                    if(result == 1){
                        JOptionPane.showMessageDialog(null, "insertion réussie !");
                        if(addpiecespanel.isAncestorOf(addpiecespanel.scrollpan)){
                            addpiecespanel.remove(addpiecespanel.scrollpan);
                            addpiecespanel.revalidate();
                            addpiecespanel.repaint(50, 100, 1200, 500);
                        }
                    }
                    
                    statement.close();
                    con.conn.setAutoCommit(true); // RESET THE AUTO COMMIT TO TRUE FOR SECURITY SEAK...
                    con.conn.close();
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, " insertion échouée ! \n Le format d'un ou de plusieurs données est incorrect ! \n Ou certaine pieces existent déja ! \n Ou vous n'avez pas rempli toutes les cases \n Ou un prix de vente est plus grand que le prix d'achat !");
                    ex.printStackTrace();
                    try {
                        if(con.conn != null )
                            con.conn.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
                                
                }finally{
                
                    try{
                        if(statement != null)
                        statement.close();
                        
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }
                }
            }
        
            
        });
        
        
        
        
        //BUTTON "AJOUTER" OF AddAchatsPanel TO COMPLETE DE ADDING PROCESS AFTER FILLING THE TABLE..
        addachatspanel.button_ajouter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String table__save_achats_id_piece[] = new String[addachatspanel.line]; // table to save the id_pieces and use it later in updating the price and quantity of the pices table
                double table_save_achats_quantite[] = new double[addachatspanel.line]; // table to save the quantity and use it later in updating the price and quantity of the pices table
                int table_save_achats_prix[] = new int[addachatspanel.line]; // table to save the price and use it later in updating the price and quantity of the pices table
                
                double nouvelle_quantite; 
                int prix_max;
                
                String id_piece, prix_achat, quantite;
                
                String insert_statement, select_statement, update_statement;
                    
                String dates = addachatspanel.text_field_date.getText().replaceAll("\\s+", "");
                String id_acheteur = addachatspanel.text_field_identifiant.getText().replaceAll("\\s+", "");
               
                int result = 0;
                
                con.connection();
                Statement statement = null;
                ResultSet resultset;
                
                try {
                 
                    con.conn.setAutoCommit(false); // START TRANSACTION
                    statement = con.conn.createStatement();
                    
                    addachatspanel.table.editCellAt(0, 0); // USE FOR THE LAST CELL IN TABLE TO BE CONSIDERED...
                    addachatspanel.table.getCellEditor().stopCellEditing();
                    
                    for(int i = 0 ; i < addachatspanel.line ; i++){
                        
                        
                        
                        id_piece = addachatspanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                        prix_achat = addachatspanel.table.getValueAt(i, 1).toString().replaceAll("\\s+", "");
                        quantite = addachatspanel.table.getValueAt(i, 2).toString().replaceAll("\\s+", "");
                        
                        if((id_piece.equals("") && prix_achat.equals("") && quantite.equals("") || (id_piece == null) && prix_achat == null && quantite == null)){
                            table__save_achats_id_piece[i] = null;
                            table_save_achats_quantite[i] = 0.0;
                            table_save_achats_prix[i] = 0;
                        
                            continue;
                        }
                        
                        //COPYING NEW VALUES IN THEIR RESPECTIVE TABLES...
                        table__save_achats_id_piece[i] = id_piece;
                        table_save_achats_quantite[i] = Double.parseDouble(quantite);
                        table_save_achats_prix[i] = Integer.parseInt(prix_achat);
                        
                        insert_statement = "INSERT INTO achats VALUES ( DEFAULT, '" + id_piece + "', '" + id_acheteur + "' ," + prix_achat + ", " + quantite + ", '" + dates +  "' ) ;";
                        result = statement.executeUpdate(insert_statement);
                        
                    }  
                    
                    //UPDATING THE TABLE "PIECES"...
                    double ancienne_quantite = 0;
                    int ancien_prix_achat = 0;
                   
                    for(int i = 0; i < addachatspanel.line; i++){
                        
                        if(table_save_achats_quantite[i] == 0.0 && table__save_achats_id_piece[i] == null && table_save_achats_prix[i] == 0)
                            continue;
                        select_statement = "SELECT quantite, prixachat FROM pieces WHERE idpiece = '" + table__save_achats_id_piece[i] + "' ;";
                       
                        resultset = statement.executeQuery(select_statement);
                        
                        while(resultset.next()){
                            ancienne_quantite = resultset.getDouble(1);
                            ancien_prix_achat = resultset.getInt(2);
                        }
                        
                        nouvelle_quantite = ancienne_quantite + table_save_achats_quantite[i];
                        prix_max = table_save_achats_prix[i] > ancien_prix_achat ? table_save_achats_prix[i] : ancien_prix_achat;
                        
                        update_statement = "UPDATE pieces SET quantite = " + String.valueOf(nouvelle_quantite) + ", prixachat = " + String.valueOf(prix_max) + " WHERE idpiece = '" + table__save_achats_id_piece[i] + "' ;";
                        
                        statement.executeUpdate(update_statement);
                        
                        resultset.close();
                   }
                    
                   con.conn.commit(); // CLOSE THE TRANSACTION...
                   
                   if(result == 1){
                        JOptionPane.showMessageDialog(null, "insertion réussie !");
                        if(addachatspanel.isAncestorOf(addachatspanel.scrollpan)){
                            addachatspanel.remove(addachatspanel.scrollpan);
                            addachatspanel.revalidate();
                            addachatspanel.repaint(50, 100, 1200, 500);
                        }
                    }
                   
                    statement.close();
                    con.conn.setAutoCommit(true); // RESET THE AUTO COMMIT TO TRUE FOR SECURITY SEAK...
                    con.conn.close();
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, " insertion échouée ! \n le format d'un ou de plusieurs données est incorrect ! \n Ou certains utilisateurs existent déja ! \n Ou vous n'avez pas rempli toutes les cases \n Ou une ou plusieur(s) piecie(s) est(sont) nouvelle(s), ajouter le(s) d'abord");
                    ex.printStackTrace();
                    try {
                        if(con.conn != null )
                            con.conn.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
                }finally{
                
                    try{
                        if(statement != null)
                            statement.close();
                        
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }
                }
            }
        
            
        });
        


        //BUTTON "AJOUTER" OF AddVentesPanel TO COMPLETE DE ADDING PROCESS AFTER FILLING THE TABLE..
        addventespanel.button_ajouter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String table_save_ventes_id_piece[] = new String[addventespanel.line]; // table to save the id_pieces and use it later in updating the price and quantity of the pices table
                double table_save_ventes_quantite[] = new double[addventespanel.line]; // table to save the quantity and use it later in updating the price and quantity of the pices table
                
                double nouvelle_quantite;
                
                String id_piece, prix_vente, quantite;
                
                String insert_statement, select_statement, update_statement;
                    
                String dates = addventespanel.text_field_date.getText().replaceAll("\\s+", "");
                String id_vendeur = addventespanel.text_field_identifiant.getText().replaceAll("\\s+", "");
               
                int result = 0;
                
                con.connection();
                Statement statement = null;
                ResultSet resultset;
                
                try {
                 
                    con.conn.setAutoCommit(false); // START TRANSACTION
                    statement = con.conn.createStatement();
                    
                    addventespanel.table.editCellAt(0, 0); // USE FOR THE LAST CELL IN TABLE TO BE CONSIDERED...
                    addventespanel.table.getCellEditor().stopCellEditing();
                    
                    for(int i = 0 ; i < addventespanel.line ; i++){
                    
                        id_piece = addventespanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                        prix_vente = addventespanel.table.getValueAt(i, 1).toString().replaceAll("\\s+", "");
                        quantite = addventespanel.table.getValueAt(i, 2).toString().replaceAll("\\s+", "");
                        
                        if((id_piece.equals("") && prix_vente.equals("") && quantite.equals("")) || (id_piece == null && prix_vente == null && quantite == null)){
                            table_save_ventes_id_piece[i] = null;
                            table_save_ventes_quantite[i] = 0.0;
                            continue;
                        }
 
                        insert_statement = "INSERT INTO ventes VALUES ( DEFAULT, '" + id_piece + "', '" + id_vendeur + "' ," + prix_vente + ", " + quantite + ", '" + dates +  "' ) ;";
                        result = statement.executeUpdate(insert_statement);
                        
                        //COPYING NEW VALUES IN THEIR RESPECTIVE TABLES...
                        table_save_ventes_id_piece[i] = id_piece;
                        table_save_ventes_quantite[i] = Double.parseDouble(quantite);
                    }  
                    
                    //UPDATING THE TABLE "PIECES"...
                    double ancienne_quantite = 0;
                   
                    for(int i = 0; i < addventespanel.line; i++){
                        
                        if(table_save_ventes_id_piece[i] == null && table_save_ventes_quantite[i] == 0.0)
                            continue;
                     
                        select_statement = "SELECT quantite FROM pieces WHERE idpiece = '" + table_save_ventes_id_piece[i] + "' ;";
                       
                        resultset = statement.executeQuery(select_statement);
                        
                        while(resultset.next()){
                            ancienne_quantite = resultset.getDouble(1);
                        }
                        
                        nouvelle_quantite = ancienne_quantite - table_save_ventes_quantite[i];
                        
                        update_statement = "UPDATE pieces SET quantite = " + String.valueOf(nouvelle_quantite) + " WHERE idpiece = '" + table_save_ventes_id_piece[i] + "' ;";
                        
                        statement.executeUpdate(update_statement);
                        
                        resultset.close();
                   }
                    
                   con.conn.commit(); // CLOSE THE TRANSACTION...
                   
                   if(result == 1){
                        JOptionPane.showMessageDialog(null, "insertion réussie !");
                        if(addventespanel.isAncestorOf(addventespanel.scrollpan)){
                            addventespanel.remove(addventespanel.scrollpan);
                            addventespanel.revalidate();
                            addventespanel.repaint(50, 100, 1200, 500);
                        }
                    }
                   
                    statement.close();
                    con.conn.setAutoCommit(true); // RESET THE AUTO COMMIT TO TRUE FOR SECURITY SEAK...
                    con.conn.close();
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, " insertion échouée ! \n le format d'un ou de plusieurs données est incorrect ! \n Ou certaines ventes existent déja ! \n Ou vous n'avez pas rempli toutes les cases \n Ou une ou plusieur(s) piecie(s) est(sont) n'existent pas, ajouter le(s) d'abord");
                    ex.printStackTrace();
                    try {
                        if(con.conn != null )
                            con.conn.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
                }finally{
                
                    try{
                        if(statement != null)
                            statement.close();
                        
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }
                }
            }
        
            
        });
        
        
        
        
        //BUTTON "AJOUTER" OF AddUsersPanel TO COMPLETE DE ADDING PROCESS AFTER FILLING THE TABLE..
        adduserspanel.button_ajouter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                con.connection(); // OPEN THE CONNECTION TO DATABASE...
                Statement statement = null;
                
                int  result = 0 ;
                String insert_statement;
                String id_user, name, num_tel;
                
                try {
                    con.conn.setAutoCommit(false); // START TRANSACTION
                    
                    statement = con.conn.createStatement();
                    
                    adduserspanel.table.editCellAt(0, 0); // USE FOR THE LAST CELL IN TABLE TO BE CONSIDERED...
                    adduserspanel.table.getCellEditor().stopCellEditing();
                            
                    for(int i = 0 ; i < adduserspanel.line ; i++){
                       
                        id_user = adduserspanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                        name = adduserspanel.table.getValueAt(i, 1).toString().replaceAll("\\s+$", "");
                        num_tel = adduserspanel.table.getValueAt(i, 2).toString().replaceAll("\\s+", "");
                        
                        if((id_user.equals("") && name.equals("") && num_tel.equals("")) || (id_user == null && name == null && num_tel == null))
                            continue;
                       
                        insert_statement = "INSERT INTO personnes VALUES ( '" + id_user + "', '" + name + "', " + num_tel + " ) ;";
                        result = statement.executeUpdate(insert_statement);
                       
                    }
                    
                    con.conn.commit(); // CLOSE THE TRANSACTION...
                  
                    if(result == 1){
                        JOptionPane.showMessageDialog(null, "insertion réussie !");
                        if(adduserspanel.isAncestorOf(adduserspanel.scrollpan)){
                            adduserspanel.remove(adduserspanel.scrollpan);
                            adduserspanel.revalidate();
                            adduserspanel.repaint(50, 100, 1200, 500);
                        }
                    }
                    
                    statement.close();
                    con.conn.setAutoCommit(true); // RESET THE AUTO COMMIT TO TRUE FOR SECURITY SEAK... 
                    con.conn.close();
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, " insertion échouée ! \n le format d'un ou de plusieurs données est incorrect ! \n Ou certains utilisateurs existent déja ! \n Ou vous n'avez pas rempli toutes les cases");
                    ex.printStackTrace();
                    try {
                        if(con.conn != null )
                            con.conn.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
                }finally{
                
                    try{
                        if(statement != null)
                        statement.close();
                        
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }
                }
            }
        
            
        });
       
    }
    
    
    
    
    // DeletePanel's FUNCTION...
    public void deletefunction(){
        
        // BUTTON "COMMENCER" TO START THE DELETE PROCESS BY CREATING A TABLE...
        deletepanel.button_commencer.addActionListener(new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deletepanel.isAncestorOf(deletepanel.scrollpan))
                    deletepanel.remove(deletepanel.scrollpan);
                if(deletepanel.text_field_nombre.getText().replaceAll("\\s+", "").equals("")){
                    JOptionPane.showMessageDialog(null, "entrer le nombre de pièces à ajouter");
                }
                else{
                    deletepanel.line = Integer.parseInt(deletepanel.text_field_nombre.getText().replaceAll("\\s+", ""));
                    
                    if (deletepanel.radio_supprimer_achats.isSelected()){
                        
                        deletepanel.column = deletepanel.titles_supprimer_achats.length ;
                        deletepanel.data = new Object[deletepanel.line][deletepanel.column];
                        deletepanel.table = new JTable(deletepanel.data, deletepanel.titles_supprimer_achats);
                    }
                    else if (deletepanel.radio_supprimer_pieces.isSelected()){
                        
                           deletepanel.column = deletepanel.titles_supprimer_pieces.length ;
                           deletepanel.data = new Object[deletepanel.line][deletepanel.column];
                           deletepanel.table = new JTable(deletepanel.data, deletepanel.titles_supprimer_pieces);
                    }
                    else if (deletepanel.radio_supprimer_ventes.isSelected()){
                        
                        deletepanel.column = deletepanel.titles_supprimer_ventes.length ;
                        deletepanel.data = new Object[deletepanel.line][deletepanel.column];
                        deletepanel.table = new JTable(deletepanel.data, deletepanel.titles_supprimer_ventes);
                    }
                 

                    deletepanel.scrollpan = new JScrollPane(deletepanel.table);
                    deletepanel.add(deletepanel.scrollpan).setBounds(300, 200, 200, 300);
                    
                }
                
                for(int i = 0; i < deletepanel.line; i++){
                    for(int j = 0; j < deletepanel.column; j++)
                        deletepanel.table.editCellAt(i, j);
                }
            }
     
        });
        
        
        
        // RADIOBUTTONS TO REMOVE THE TABLE WHEN CHOSING ANOTHER OPTION OF DETETION...
        deletepanel.radio_supprimer_achats.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                deletepanel.table = null;
                if (deletepanel.isAncestorOf(deletepanel.scrollpan))
                    deletepanel.remove(deletepanel.scrollpan);
                    deletepanel.revalidate();
                    deletepanel.repaint(300, 200, 200, 300);
                deletepanel.text_field_nombre.setText("");
            }
        
            
        });
        
        deletepanel.radio_supprimer_pieces.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                deletepanel.table = null;
                if (deletepanel.isAncestorOf(deletepanel.scrollpan))
                    deletepanel.remove(deletepanel.scrollpan);
                    deletepanel.revalidate();
                    deletepanel.repaint(300, 200, 200, 300);
                deletepanel.text_field_nombre.setText("");
            }
        
            
        });
        
        
        deletepanel.radio_supprimer_ventes.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                deletepanel.table = null;
                if (deletepanel.isAncestorOf(deletepanel.scrollpan))
                    deletepanel.remove(deletepanel.scrollpan);
                    deletepanel.revalidate();
                    deletepanel.repaint(300, 200, 200, 300);
                deletepanel.text_field_nombre.setText("");
            }
            
            
        });
        
        
        
        // BUTTON "ANNULER" TO CANCEL THE DELETION PROCESS
        deletepanel.button_annuler.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                deletepanel.table = null;
                if (deletepanel.isAncestorOf(deletepanel.scrollpan))
                    deletepanel.remove(deletepanel.scrollpan);
                    deletepanel.revalidate();
                    deletepanel.repaint(300, 200, 700, 300);
                deletepanel.text_field_nombre.setText("");
                }
            
            
        });
        
        
        // BUTTON "SUPPRIMER" TO COMPLETE DE DELETION PROCESS AFTER FILLING THE TABLE...
        deletepanel.button_supprimer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String delete_statement = null, query_statement = null, update_statement = null; 
                String id_achat, id_piece, id_vente;
                int result = 0;
                
                String table_save_id_achat[] = new String[deletepanel.line];  // use to save the identifiers of the achats to be deleted...
                String table_save_id_vente[] = new String[deletepanel.line];  // use to save the identifiers of the ventes to be deleted...
                
                con.connection(); // open connection...
                Statement statement = null;
                ResultSet resultset = null;
                
                deletepanel.table.editCellAt(0, 0);
                deletepanel.table.getCellEditor().stopCellEditing();
                
                try{
                    con.conn.setAutoCommit(false);
                    statement = con.conn.createStatement();
                    
                    
                     //UPDATING THE TABLE "PIECES" BEFORE DELETION OF VENTES OR ACHATS...
                    double quantite_pieces = 0, quantite_achats = 0, quantite_ventes =0, nouvelle_quantite;
                    String id_piece_to_update = null;
                    
                    for(int i = 0; i < deletepanel.line; i++){
                        
                        id_achat = deletepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                        
                        if (deletepanel.radio_supprimer_achats.isSelected()){
                            
                            if(id_achat.equals("") || id_achat == null)
                                continue;
                            query_statement = "SELECT pieces.idpiece, pieces.quantite, achats.quantite FROM pieces, achats WHERE pieces.idpiece = achats.idpiece AND idachat = " +id_achat + " ;";
                            resultset = statement.executeQuery(query_statement);
                        
                            while(resultset.next()){
                                id_piece_to_update = resultset.getString(1);
                                quantite_pieces = resultset.getDouble(2);
                                quantite_achats = resultset.getDouble(3);
                            }
                        
                            nouvelle_quantite = quantite_pieces - quantite_achats;
                            update_statement = "UPDATE pieces SET quantite = " + String.valueOf(nouvelle_quantite) + " WHERE idpiece = '" + id_piece_to_update + "' ;";
                            statement.executeUpdate(update_statement);
                            resultset.close();
                        
                        }else if (deletepanel.radio_supprimer_ventes.isSelected()){
                        
                            id_vente = deletepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                            
                            if(id_vente.equals("") || id_vente == null)
                                continue;
                            
                            query_statement = "SELECT pieces.idpiece, pieces.quantite, ventes.quantite FROM pieces, ventes WHERE pieces.idpiece = ventes.idpiece AND idvente = " + id_vente + " ;";
                            resultset = statement.executeQuery(query_statement);
                        
                            while(resultset.next()){
                                id_piece_to_update = resultset.getString(1);
                                quantite_pieces = resultset.getDouble(2);
                                quantite_ventes = resultset.getDouble(3);
                            }
                        
                            nouvelle_quantite = quantite_pieces + quantite_ventes;
                            update_statement = "UPDATE pieces SET quantite = " + String.valueOf(nouvelle_quantite) + " WHERE idpiece = '" + id_piece_to_update + "' ;";
                            statement.executeUpdate(update_statement);
                            resultset.close();
                        }
                        
                        
                    }
                    
                    
                    //DELETIONS NOW... 
                    for (int i = 0; i < deletepanel.line; i++){
                        
                        if (deletepanel.radio_supprimer_pieces.isSelected()){
                            
                            id_piece = deletepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", ""); 
                            
                            if(id_piece.equals("") || id_piece == null)
                                continue;
                            
                            delete_statement = "DELETE FROM pieces WHERE idpiece = '" + id_piece + "' ;";
                            
                        }else if (deletepanel.radio_supprimer_achats.isSelected()){
                            
                            id_achat = deletepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                            
                            if(id_achat.equals("") || id_achat == null)
                                continue;
                            
                            delete_statement = "DELETE FROM achats WHERE idachat = " + id_achat + " ;";
                        }else if (deletepanel.radio_supprimer_ventes.isSelected()){
                            
                            id_vente = deletepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                            
                            if(id_vente.equals("") || id_vente == null)
                                continue;
                            
                            delete_statement = "DELETE FROM ventes WHERE idvente = " + id_vente + " ;";
                        }
                        
                        result = statement.executeUpdate(delete_statement);
                        
                    }
                    
                    con.conn.commit();
                    
                    if (result == 1){
                    
                        JOptionPane.showMessageDialog(null, "suppression réussie");
                        
                        deletepanel.table = null;
                        if (deletepanel.isAncestorOf(deletepanel.scrollpan))
                            deletepanel.remove(deletepanel.scrollpan);
                        deletepanel.revalidate();
                        deletepanel.repaint(300, 200, 700, 300);
                    }
                    
                    statement.close();
                    con.conn.setAutoCommit(true);
                    con.conn.close();
                    
                } catch(SQLException ex){
                    
                    JOptionPane.showMessageDialog(null, "suppression échouée ! \n Vos données sont mal écrites \n Ou Vous identifiants n'existent pas ");
                    ex.printStackTrace();
                    try{
                        if (con.conn != null)
                            con.conn.rollback();
                    } catch(SQLException sex){
                        sex.printStackTrace();
                    }
                    
                }finally{
                
                    try{
                        if (statement != null)
                            statement.close();
                        if (con.conn != null)
                            con.conn.rollback();
                    } catch(SQLException sex){
                        sex.printStackTrace();
                    }
                }
                
            }
        
            
        });
        
        
    }
    
    
    // UpdatePanel's FUNCTIONS...
    public void updatefunction(){
        
        // BUTTON "COMMENCER" TO START THE UPDATE PROCESS BY CREATING A TABLE...
        updatepanel.button_commencer.addActionListener(new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (updatepanel.isAncestorOf(updatepanel.scrollpan))
                    updatepanel.remove(updatepanel.scrollpan);
                if(updatepanel.text_field_nombre.getText().replaceAll("\\s+", "").equals("")){
                    JOptionPane.showMessageDialog(null, "entrer le nombre de pièces à ajouter");
                }
                else{
                    updatepanel.line = Integer.parseInt(updatepanel.text_field_nombre.getText().replaceAll("\\s+", ""));
                    
                    if (updatepanel.radio_modifier_prix_ventes.isSelected()){
                        
                        updatepanel.column = updatepanel.titles_modifier_prix_ventes.length ;
                        updatepanel.data = new Object[updatepanel.line][updatepanel.column];
                        updatepanel.table = new JTable(updatepanel.data, updatepanel.titles_modifier_prix_ventes);
                    }
                    else if (updatepanel.radio_modifier_tel_users.isSelected()){
                        
                           updatepanel.column = updatepanel.titles_numero_tel_user.length ;
                           updatepanel.data = new Object[updatepanel.line][updatepanel.column];
                           updatepanel.table = new JTable(updatepanel.data, updatepanel.titles_numero_tel_user);
                    }
                 
                    updatepanel.scrollpan = new JScrollPane(updatepanel.table);
                    updatepanel.add(updatepanel.scrollpan).setBounds(300, 200, 700, 300);
                    
                }
                
                for(int i = 0; i < updatepanel.line; i++){
                    for(int j = 0; j < updatepanel.column; j++)
                        updatepanel.table.editCellAt(i, j);
                } 
            }
     
        });
                
        
        // RADIOBUTTONS TO REMOVE THE TABLE WHEN CHOSING ANOTHER OPTION OF DETETION...
        updatepanel.radio_modifier_prix_ventes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updatepanel.table = null;
                if (updatepanel.isAncestorOf(updatepanel.scrollpan))
                    updatepanel.remove(updatepanel.scrollpan);
                    updatepanel.revalidate();
                    updatepanel.repaint(300, 200, 700, 300);
                updatepanel.text_field_nombre.setText(null);
            }
        
            
        });
        
        updatepanel.radio_modifier_tel_users.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                updatepanel.table = null;
                if (updatepanel.isAncestorOf(updatepanel.scrollpan))
                    updatepanel.remove(updatepanel.scrollpan);
                    updatepanel.revalidate();
                    updatepanel.repaint(300, 200, 700, 300);
                updatepanel.text_field_nombre.setText(null);
            }
            
            
        });
        
        
        
        // BUTTON "ANNULER" TO CANCEL THE MODIFICATION PROCESS
        updatepanel.button_annuler.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                updatepanel.table = null;
                if (updatepanel.isAncestorOf(updatepanel.scrollpan))
                    updatepanel.remove(updatepanel.scrollpan);
                    updatepanel.revalidate();
                    updatepanel.repaint(300, 200, 700, 300);
                }
            
            
        });
        
        
        // BUTTON "MODIFIER" TO COMPLETE THE UDATING PROCESS AFTER FILLING THE TABLE...
        updatepanel.button_modifier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                con.connection(); //    OPEN THE CONNECTION 
                Statement statement = null;
                
                String update_statement = null;
                String id_piece, premier_prix, deuxieme_prix; // for saving pieces data from the table...
                String id_user, num_tel; // for saving users data from the table... 
                
               int result = 0;
                
               try{
                   
                   con.conn.setAutoCommit(false);
                   statement = con.conn.createStatement();
                   
                   updatepanel.table.editCellAt(0, 0);
                   updatepanel.table.getCellEditor().stopCellEditing();
                   
                   for (int i = 0; i < updatepanel.line; i++){
                       
                       if(updatepanel.radio_modifier_prix_ventes.isSelected()){  
                           
                            id_piece = updatepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                            premier_prix = updatepanel.table.getValueAt(i, 1).toString().replaceAll("\\s+", "");
                            deuxieme_prix = updatepanel.table.getValueAt(i, 2).toString().replaceAll("\\s+", "");
                            
                            if((id_piece.equals("") && premier_prix.equals("") && deuxieme_prix.equals("")) || (id_piece == null && premier_prix == null && deuxieme_prix == null))
                                continue;
                        
                            update_statement = "UPDATE pieces SET pprixvente = " + premier_prix + ", dprixvente = " + deuxieme_prix + " WHERE idpiece = '" + id_piece + "' ;";
                        }else if (updatepanel.radio_modifier_tel_users.isSelected()){
                            
                            id_user = updatepanel.table.getValueAt(i, 0).toString().replaceAll("\\s+$", "");
                            num_tel = updatepanel.table.getValueAt(i, 1).toString().replaceAll("\\s+", "");
                            
                            if((id_user.equals("") && num_tel.equals("")) || (id_user == null && num_tel == null))
                                continue;
                            
                            update_statement = "UPDATE personnes SET numero = " + num_tel + " WHERE idpersonne = '" + id_user + "' ;";
                        }
                       
                        result = statement.executeUpdate(update_statement);
                    }
                   
                    con.conn.commit();
                    
                    if(result == 1){
                        JOptionPane.showMessageDialog(null, "modification reussie !");
                        updatepanel.table = null;
                        if (updatepanel.isAncestorOf(updatepanel.scrollpan))
                        updatepanel.remove(updatepanel.scrollpan);
                        updatepanel.revalidate();
                        updatepanel.repaint(300, 200, 700, 300);
                    }
                    
                    statement.close();
                    con.conn.setAutoCommit(true);
                    con.conn.close();
                   
               }catch(SQLException sex){
                   JOptionPane.showMessageDialog(null, "modofocation échouée ! \n Vos données sont mal écrites \n Ou Vous identifiants n'existent pas \n ou vos prix sont plus petit que le prix d'achat" );
                   try {
                       if(con.conn != null)
                           con.conn.rollback();
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }finally{
                  try{
                        if(statement != null)
                        statement.close();
                        
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    } 
               }
            }
        
            
        });
    }
    
    
    
    
    public void queryfunction(){
    
        // BUTTON "AFFICHER" OF ConsultPricePanel to consult the premierprix and deuxieme prix of a piece...
        consultpricepanel.button_afficher.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String query_statement;
                con.connection(); // open connection
                Statement statement = null;
                ResultSet resultset = null;
                
                boolean verifier = false; // check wheether the selection has succeded... 
               if (consultpricepanel.text_field_id_piece.getText().replaceAll("\\s+", "").equals("")){
                   JOptionPane.showMessageDialog(null, "entrer l'identifiant de la piece");
               }else{
                    try{
                        statement = con.conn.createStatement();
                   
                        String id_piece = consultpricepanel.text_field_id_piece.getText().replaceAll("\\s+$", "");
                        query_statement = "SELECT prixachat, pprixvente, dprixvente FROM pieces WHERE idpiece = '" + id_piece + "' ;";
                        resultset = statement.executeQuery(query_statement);
                        
                        while(resultset.next()){
                            consultpricepanel.text_field_prix_achat.setText(String.valueOf(resultset.getInt(1)));
                            consultpricepanel.text_field_premier_prix.setText(String.valueOf(resultset.getInt(2)));
                            consultpricepanel.text_field_deuxieme_prix.setText(String.valueOf(resultset.getInt(3)));
                            verifier = true;
                        }
                        
                        if (!verifier)
                            JOptionPane.showMessageDialog(null, "erreur ! l'identifiant n'existe pas");
                        resultset.close();
                        statement.close();
                        con.conn.close();
                   
                    }catch(SQLException ex){
                
                        JOptionPane.showMessageDialog(null, "erreur ! verifier l'identifiant de la piece");
                    
                    }finally{
                
                            try{
                                if (statement != null)
                                    statement.close();
                                if (con.conn != null)
                                    con.conn.close();
                            } catch(SQLException sex){
                                sex.printStackTrace();
                            }
                    }
               }
            }
        
            
        });
        
        
        // BUTTON "AFFICHER" TO CHECK OF BilanPanel to have the balance...
        bilanpanel.button_afficher.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String query_statement_vente_totale, query_statement_benefice, query_statement_achat_totale;
                
                String date;
                date = bilanpanel.text_field__date_debut.getText();
                
                con.connection(); // open connection
                Statement statement1 = null, statement2 = null, statement3 = null;
                ResultSet resultset1, resultset2, resultset3;
                
                if (date.equals("aaaa-mm-jj") || date.equals("    -  -  ")){
                    query_statement_vente_totale = "SELECT SUM(prixvente) FROM ventes ;";
                    query_statement_benefice = "SELECT SUM(ventes.quantite * (prixvente - prixachat)) FROM ventes, pieces WHERE pieces.idpiece = ventes.idpiece ;";
                    query_statement_achat_totale = "SELECT SUM(quantite * prixachat) FROM achats ;";
                }else{
                    query_statement_vente_totale = "SELECT SUM(ventes.quantite * prixvente) FROM ventes WHERE dates >= '" + date +"' ;";
                    query_statement_benefice = "SELECT SUM(ventes.quantite * (prixvente - prixachat)) FROM ventes, pieces WHERE pieces.idpiece = ventes.idpiece  AND dates >= '" + date + "' ;";
                    query_statement_achat_totale = "SELECT SUM(quantite * prixachat) FROM achats WHERE dates >= '" + date + "' ;";
                }
                
                try{
                
                    
                    statement1 = con.conn.createStatement();
                    statement2 = con.conn.createStatement();
                    statement3 = con.conn.createStatement();
                    
                    resultset1 = statement1.executeQuery(query_statement_vente_totale);
                    resultset2 = statement2.executeQuery(query_statement_benefice);
                    resultset3 = statement3.executeQuery(query_statement_benefice);
                    
                    while(resultset1.next() && resultset2.next() && resultset3.next()){
                        bilanpanel.text_field_vente_totale.setText(String.valueOf(resultset1.getInt(1)));
                        bilanpanel.text_field_benefice.setText(String.valueOf(resultset2.getInt(1)));
                        bilanpanel.text_field_depense_achats_totale.setText(String.valueOf(resultset3.getInt(1)));
                    }
                        
                    resultset1.close();
                    resultset2.close();
                    resultset3.close();
                    
                    statement1.close();
                    statement2.close();
                    con.conn.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "erreur ! verifier la date");
                    ex.printStackTrace();
                }finally{
                    try{
                        if(statement1 != null || statement2 != null || statement3 != null)
                            statement1.close();
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException sex){
                        sex.printStackTrace();
                    }
                }
            }
        
            
        });
        
        
        // BUTTON "AFFICHER" CHECK THE pieces restantes, the achats and ventes par date and par piece...
        autrespanel.button_afficher.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String query_statement = null;
                String title[] = null;
                
                con.connection(); // open connection...
                Statement statement1 = null, statement2 = null;
                ResultSet resultset1, resultset2;
                autrespanel.line = 0;
                
                if(autrespanel.radio_pieces_restantes.isSelected()){
                    query_statement = "SELECT idpiece, nom, quantite FROM pieces ORDER BY nom, idpiece;";
                    title = autrespanel.titles_autres_pieces_restantes;
                }else if(autrespanel.radio_achats_par_pieces.isSelected()){
                    query_statement = "SELECT achats.idpiece, nom, SUM(achats.quantite) FROM achats, pieces WHERE achats.idpiece = pieces.idpiece GROUP BY achats.idpiece, nom ORDER BY nom, achats.idpiece;";
                    title = autrespanel.titles_autres_achats_par_piece;
                }else if(autrespanel.radio_achats_par_date.isSelected()){
                   query_statement = "SELECT idachat, achats.idpiece, nom, achats.quantite, dates FROM achats, pieces WHERE achats.idpiece = pieces.idpiece ORDER BY dates, nom, achats.idpiece;"; 
                   title = autrespanel.titles_autres_achats_par_date;
                }else if(autrespanel.radio_ventes_par_piece.isSelected()){
                   query_statement = "SELECT ventes.idpiece, nom, SUM(ventes.quantite) FROM ventes, pieces WHERE ventes.idpiece = pieces.idpiece GROUP BY ventes.idpiece, nom ORDER BY nom, ventes.idpiece;"; 
                   title = autrespanel.titles_autres_ventes_par_piece;
                }else if(autrespanel.radio_ventes_par_date.isSelected()){
                    query_statement = "SELECT idvente, ventes.idpiece, nom, ventes.quantite, dates FROM ventes, pieces WHERE ventes.idpiece = pieces.idpiece ORDER BY dates, nom, ventes.idpiece;";
                    title = autrespanel.titles_autres_ventes_par_date;
                }
                
                try{
                
                    statement1 = con.conn.createStatement();
                    statement2 = con.conn.createStatement();
                    
                    resultset1 = statement1.executeQuery(query_statement);
                    
                    while(resultset1.next()){
                        autrespanel.line += 1;
                    }
                    resultset1.close();
                    resultset2 =  statement2.executeQuery(query_statement);
                    autrespanel.data = new String[autrespanel.line][title.length];
                    
                    for(int i = 0 ; i < autrespanel.line ; i++){
                        if(resultset2.next()){
                                for(int j = 0 ; j < resultset2.getMetaData().getColumnCount() ; j++ ){
                                    autrespanel.data[i][j] = resultset2.getObject(j+1).toString();
                                }
                            }
                        }
                    autrespanel.table = new JTable(autrespanel.data, title);
                    autrespanel.scrollpan = new JScrollPane(autrespanel.table);
        
                    autrespanel.scrollpan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    autrespanel.scrollpan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    
                    autrespanel.add(autrespanel.scrollpan).setBounds(50, 150, 1200, 500);
                    
                    resultset2.close();
                    
                    statement1.close();
                    statement2.close();
                    con.conn.close();
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "erreur !");
                    ex.printStackTrace();
                }finally{
                    try{
                        if(statement1 != null)
                            statement1.close();
                        if(statement2 != null)
                            statement2.close();
                        if(con.conn != null)
                            con.conn.close();
                    }catch(SQLException sex){
                        sex.printStackTrace();
                    }
                }
            }
        });
        
        
        
        //RADIOBUTTONS OF "AutresPanel" TO REMOVE THE TABLE WHEN CHOSING ANOTHER OPTION OF
        autrespanel.radio_achats_par_date.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 autrespanel.table = null;
                if (autrespanel.isAncestorOf(autrespanel.scrollpan))
                    autrespanel.remove(autrespanel.scrollpan);
                autrespanel.revalidate();
                autrespanel.repaint(50, 150, 1200, 500);
            }
        });
        
        autrespanel.radio_achats_par_pieces.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               autrespanel.table = null;
                if (autrespanel.isAncestorOf(autrespanel.scrollpan))
                    autrespanel.remove(autrespanel.scrollpan);
                autrespanel.revalidate();
                autrespanel.repaint(50, 150, 1200, 500);
            }
        });
        
        autrespanel.radio_pieces_restantes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if (autrespanel.isAncestorOf(autrespanel.scrollpan))
                    autrespanel.remove(autrespanel.scrollpan);
                autrespanel.revalidate();
                autrespanel.repaint(50, 150, 1200, 500); 
            }
        });
        
        autrespanel.radio_ventes_par_date.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (autrespanel.isAncestorOf(autrespanel.scrollpan))
                    autrespanel.remove(autrespanel.scrollpan);
                autrespanel.revalidate();
                autrespanel.repaint(50, 150, 1200, 500);
            }
        });
        
        autrespanel.radio_ventes_par_piece.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (autrespanel.isAncestorOf(autrespanel.scrollpan))
                    autrespanel.remove(autrespanel.scrollpan);
                autrespanel.revalidate();
                autrespanel.repaint(50, 150, 1200, 500);
            }
        });
    }
    
    
}   

    
    


    

