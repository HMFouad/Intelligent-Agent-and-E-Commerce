import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;

public class bdd extends JFrame {
String [][] donnees ;



public bdd() {
super();

setTitle("Liste des produits");





try {
Class.forName("Apache Derby Network Client JDBC Driver") ;
System.out.println("DRIVER OK ! ");
Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Produits","HMFouad","12345") ;
System.out.println("Connection effective !");
Statement stmt = conn.createStatement() ;
ResultSet rst = stmt.executeQuery("Select * from Produits");
ResultSetMetaData metadata = rst.getMetaData();

while(rst.next()){



donnees =new String[rst.getRow()][metadata.getColumnCount()];


for(int i=0;i<rst.getRow();i++)
{

for(int j=1;j<metadata.getColumnCount();j++)
{

donnees [i][j]=rst.getString(j);
System.out.println(donnees[i][j]);
}
}}


String[] entetes = {"Identifiant","Nom", "Quantité", "Prix min", "Prix max"};

JTable tableau = new JTable(donnees, entetes);

getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
getContentPane().add(tableau, BorderLayout.CENTER);
pack();

}
catch (Exception e1) {
e1.printStackTrace();
}
}

public static void main(String[] args) {
new bdd().setVisible(true);
}} 