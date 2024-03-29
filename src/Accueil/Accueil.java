package Accueil;

import Jade.Acheteur;
import Jade.Mediateur;
import Jade.Vendeur;
import Gestion_BDD.Gestion_BDD;
import Gestion_BDD.Liste_des_vendeurs;
import jade.Boot;
import jade.core.Runtime;
import jade.core.ProfileImpl;
import javax.swing.JOptionPane;
import Jade.Acheteur;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Accueil extends javax.swing.JFrame {
    public String Nom_produit_recherche1;
    public Integer Quantite_recherche1;
    public Double Prix_achat;

    public int i,j=0;
    Runtime rt;
    Runtime fr=Runtime.instance();
    ProfileImpl p=new ProfileImpl(false);
    jade.wrapper.AgentContainer Negociation=fr.createAgentContainer(p);
    AgentController Agent=null;
    
    
public Acheteur a=new Acheteur();
    /**
     * Creates new form Accueil
     */
    public Accueil() {
        setTitle("Accueil");

   //setBounds(593,100,384,100);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_liste_produits = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem7.setText("jMenuItem7");

        jMenuItem12.setText("jMenuItem12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setBounds(new java.awt.Rectangle(325, 150, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(600, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\E-commerce\\E-commerce\\Images\\icone-small-commerce.jpg")); // NOI18N
        jButton3.setText("Démarer la négociation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(450, 210, 220, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Desktop\\E-commerce\\E-commerce\\Images\\ecommerce-top-2.jpg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 0, 620, 185);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(500, 290, 0, 0);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(310, 210, 130, 20);

        jLabel1.setText("Entrer le nom du produit et la quantité que vous voulez l'acheter");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 190, 400, 20);

        Table_liste_produits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nom produit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_liste_produits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_liste_produitsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_liste_produits);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 220, 220, 140);

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setText("Liste des produits disponible:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 197, 140, 17);

        jButton1.setText("Lancer la plateforme Jade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 330, 180, 30);

        jButton2.setText("Créer un nouveau Acheteur");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(340, 293, 180, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(310, 240, 59, 20);

        jLabel5.setText("Nom produit:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(240, 210, 80, 20);

        jLabel6.setText("Quantité:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(240, 240, 60, 14);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(310, 270, 59, 20);

        jLabel7.setText("Prix");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(240, 270, 34, 14);

        jMenu1.setText("Fichier");

        jMenuItem1.setText("Quitter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edition");

        jMenuItem9.setText("couper");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("copier");
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("coller");
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Base de données");

        jMenuItem16.setText("Gestion de la base de données");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("A propos");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("A propos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String get_nom_produit(){
        return this.jTextField1.getText();
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
new A_propos().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
int r;
r=JOptionPane.showConfirmDialog(null,"Voulez vous quitter?","Exit",0,3);
if (r==1)
{
evt.notify();
}// TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
new Gestion_BDD().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
try{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    cnx = DriverManager.getConnection("jdbc:odbc:Produits_link");
    St = cnx.createStatement();

     dt = new DefaultTableModel();
       dt.addColumn("Id_produit");
     dt.addColumn("Nom_produit");
       Table_liste_produits.setModel(dt);
       Afficher_Produits();
       i = 0;

}catch (Exception e){
JOptionPane.showMessageDialog(null, "Erreur de connection\n"+e.getMessage());
}

    }//GEN-LAST:event_formWindowOpened

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

new Jade.Interface().main();
//new Jade.Acheteur().main();
//new Jade.Mediateur().main();
//new Jade.Vendeur().main();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


try {
					// Récupération du conteneur (Main Container) en cours d'execution de Jade					
					jade.core.Runtime rt = jade.core.Runtime.instance();
				
					// Création du profil par défault
					ProfileImpl p = new ProfileImpl(false);
					AgentContainer container1 =rt.createAgentContainer(p); // get a container controller for creating new agents
				
					// Agent controleur pour permettre la création des agents 
					AgentController Agent=null;		
				
					/* Création de l'agent Portail
					   cette commande est équivalente à la suivante: 
					   java jade.Boot Portail:JADE_exemple_personnel.Portail
					*/
                                        Agent = container1.createNewAgent("Mediateur", "Jade.Mediateur", null);
                                        Agent = container1.createNewAgent("Acheteur", "Jade.Acheteur", null);
                                        Agent = container1.createNewAgent("Vendeur", "Jade.Vendeur", null);
					Agent = container1.createNewAgent("Interface", "Jade.Interface", null);
					// Démarrage de l'agent Portail
					Agent.start();	
                                        
					} catch (Exception any) {
					any.printStackTrace();}

try {
    Agent = Negociation.createNewAgent("","jade.tools.rma.rma",null);
    Agent.start();
    
}catch (Exception e){
    e.printStackTrace();
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
Nom_produit_recherche1=jTextField1.getText();
Quantite_recherche1=Integer.parseInt (jTextField2.getText());
Prix_achat=Double.parseDouble(jTextField3.getText());
        try {
					// Récupération du conteneur (Main Container) en cours d'execution de Jade					
					jade.core.Runtime rt = jade.core.Runtime.instance();
				
					// Création du profil par défault
					ProfileImpl p = new ProfileImpl(false);
					AgentContainer container =rt.createAgentContainer(p); // get a container controller for creating new agents
				
					// Agent controleur pour permettre la création des agents 
					AgentController Agent=null;		
				
					/* Création de l'agent Portail
					   cette commande est équivalente à la suivante: 
					   java jade.Boot Portail:JADE_exemple_personnel.Portail
					*/
                                        String s=new String("Acheteur"+j);
					Agent = container.createNewAgent(s, "Jade.Acheteur", null);
                                        
				j++;
					// Démarrage de l'agent Portail
					Agent.start();	
                                        
					} catch (Exception any) {
					any.printStackTrace();}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Table_liste_produitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_liste_produitsMouseClicked
i = Table_liste_produits.getSelectedRow();
jTextField1.setText(dt.getValueAt(i, 1).toString());
    }//GEN-LAST:event_Table_liste_produitsMouseClicked

    
private void Afficher_Produits(){
try{
    dt.setRowCount(0);
    Rs = St.executeQuery("Select * From Liste_produits ") ;
    while (Rs.next()){
        Id = Rs.getInt("Id");
        Nom_produit = Rs.getString("Nom_produit");
        Object[] prd = {Id,Nom_produit};
        dt.addRow(prd);
    }

    
}catch (Exception e){
    JOptionPane.showMessageDialog(null,"Erreur affichage de la liste des produit\n"+e.getMessage());
}
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }
    

    private Connection cnx;
    private Statement St;
    private ResultSet Rs;
    private DefaultTableModel dt;
    private int Id;
    private String Nom_produit;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_liste_produits;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}