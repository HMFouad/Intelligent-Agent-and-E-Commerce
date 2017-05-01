import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.lang.*;
import jade.core.Runtime;
import jade.wrapper.*;
import jade.wrapper.AgentContainer;

public class Agent_Mediateur extends Agent {
    
public static void Jade() {
        	try {
					Runtime rt = Runtime.instance();
					ProfileImpl p = new ProfileImpl(false);
					AgentContainer container =rt.createAgentContainer(p); // get a container controller for creating new agents
					AgentController Agent=null;
					Agent = container.createNewAgent("AAA", Agent_Mediateur.class.getName(), new Object[] {});
					Agent.start();
					} catch (Exception any) {
					any.printStackTrace();}

    } 
    
 

public class RecoiMessage{ // extends CyclicBehaviour {
//public String[2] s = new String["la reponse","la reponse"];
public void action() throws IOException {
    ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
    if (msg != null){
        if (msg.getContent().equalsIgnoreCase("Demande bien reçu"))
        {
    
    
    ACLMessage Nom_produit_Recu = receive();
    ACLMessage replay = msg.createReply();
    
                try{
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    cnx = DriverManager.getConnection("jdbc:odbc:Produits_link");
                    St = cnx.createStatement();
                    ResultSet Rs;
                    Rs=St.executeQuery("Select * From Liste_produits WHERE (Nom_produit=Nom_produit_Recu");
                    while (Rs.next()){
        Id = Rs.getInt("Id");
        Nom_produit = Rs.getString("Nom_produit");
        Quantite = Rs.getInt("Quantite");
        Prix_min = Rs.getDouble("Prix_min");
        Prix_max = Rs.getDouble("Prix_max");
        Object[] prd = {Id,Nom_produit,Quantite,Prix_min,Prix_max};
        replay.setContentObject(prd);
                    
                    }
                }catch(Exception e){}
    
    ACLMessage message = new ACLMessage(ACLMessage.INFORM);
    message.addReceiver(Nom_produit_Recu.getSender());
    message.setContentObject(replay);
    send(message);
        }
}
    } // fin de RecoiMessage

public Connection cnx;
private Statement St;
private ResultSet Rs;
private int i,Id,Quantite;
    private String Nom_produit;
    private double Prix_min,Prix_max;

Boolean flag=false;
}



}