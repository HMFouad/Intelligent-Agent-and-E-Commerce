import java.sql.*;

public class bdd2 extends javax.swing.JFrame{
 
private static void affiche(String message) {
System.out.println(message);
}
 
private static void arret(String message) {
System.err.println(message);
System.exit(99);
}
 
public static void main(java.lang.String[] args) {
Connection con = null;
ResultSet résultats = null;
String requete = "*";
 
// chargement du pilote
try {
Class.forName("org.apache.derby.jdbc.ClientDriver");
} catch (ClassNotFoundException e) {
arret("Impossible de charger le pilote jdbc:odbc");
}
 
//connection a la base de données
 
affiche("connexion a la base de données");
try {
 
String DBurl = "jdbc:derby://localhost:1527/Produits";
con = DriverManager.getConnection(DBurl);
} catch (SQLException e) {
arret("Connection à la base de données impossible");
}
 
//insertion d'un enregistrement dans la table client
affiche("creation enregistrement");
 
requete = "INSERT INTO produits VALUES (5,'AAA',10,15000,20000)";
try {
Statement stmt = con.createStatement();
int nbMaj = stmt.executeUpdate(requete);
affiche("nb mise a jour = "+nbMaj);
} catch (SQLException e) {
e.printStackTrace();
}
 
//creation et execution de la requete
affiche("creation et execution de la requête");
requete = "SELECT * FROM produits";
 
try {
Statement stmt = con.createStatement();
résultats = stmt.executeQuery(requete);
} catch (SQLException e) {
arret("Anomalie lors de l'execution de la requête");
}
 
//parcours des données retournées
affiche("parcours des données retournées");
try {
ResultSetMetaData rsmd = résultats.getMetaData();
int nbCols = rsmd.getColumnCount();
boolean encore = résultats.next();
 
while (encore) {
 
for (int i = 1; i <= nbCols; i++)
System.out.print(résultats.getString(i) + " ");
System.out.println();
encore = résultats.next();
}
 
résultats.close();
} catch (SQLException e) {
arret(e.getMessage());
}
 
affiche("fin du programme");
System.exit(0);
}
}