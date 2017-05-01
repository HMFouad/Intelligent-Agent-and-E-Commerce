package Gestion_BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author  compaq
 */
public class Liste_des_vendeurs extends javax.swing.JFrame {

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
setVisible(false);        // TODO add your handling code here:
    }
    /** Creates new form bd */
    public Liste_des_vendeurs() { 
       
       
        
        
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabletest = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liste des vendeurs");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

tabletest.setBackground(new java.awt.Color(255, 255, 204));
tabletest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
tabletest.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
tabletest.setForeground(new java.awt.Color(51, 102, 255));
tabletest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nom vendeur", "Sexe",
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabletest.setGridColor(new java.awt.Color(134, 186, 167));
        jScrollPane1.setViewportView(tabletest);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("                La liste des vendeurs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    try
    {
        // connexion avec base de donnÃ©e bd1
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conx=DriverManager.getConnection("jdbc:odbc:Produits_link");
        stm=conx.createStatement();
        
        dt=new DefaultTableModel();
        dt.addColumn("Id");
        dt.addColumn("Nom vendeur");
        dt.addColumn("Sexe");
        tabletest.setModel(dt);
        affichertest();
    }
    catch(Exception e)
    {
     JOptionPane.showMessageDialog(null, "erreur de connexion\n"+e.getMessage());
    }
}//GEN-LAST:event_formWindowOpened
     // Procedure qui affiche les tests
     private void affichertest() {
             try
                {
                 dt.getRowCount();
                 rsl = stm.executeQuery("Select * From Liste_vendeurs ") ;
                 while (rsl.next() )
                         {
                             Id = rsl.getInt("Id_vendeur");
                             Nom_vendeur = rsl.getString("Nom_vendeur");
                             Sexe = rsl.getString("Sexe");
                             Object[] tst = {Id,Nom_vendeur,Sexe};
                             dt.addRow(tst);
                         }
                         tabletest.setModel(dt);
                }
                catch (Exception e)
                    { 
                     JOptionPane.showMessageDialog(null, "erreur de l' affichage des test\n"+e.getMessage());
                     }
                }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Liste_des_vendeurs().setVisible(true);
                
                
                
            }
        });
    }

private javax.swing.JButton jButton1;
    private Connection conx;
    private Statement  stm;
    private ResultSet  rsl; 
    private DefaultTableModel dt;
    private Integer Id,Quantite;
    private String Nom_vendeur,Sexe;
    //private Double Prix_min,Prix_max; 
    private int i;                     

    
   
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabletest;
   
   
}
