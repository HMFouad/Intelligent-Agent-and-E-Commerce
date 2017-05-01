//package agent;
import java.io.IOException;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author bureau
 */
public class machine_réparateur extends Agent {


protected void setup() {
		System.out.println(getLocalName()+" STARTED");

		try {
			// Création de desciprion de l'agent [Vendeur]
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());
			// Enregistrement de la description de l'agent dans DF (Directory Facilitator)
			DFService.register(this, dfd);
			System.out.println(getLocalName()+" REGISTERED WITH THE DF");
			} catch (FIPAException e) {
			e.printStackTrace();
			}
			addBehaviour(new CyclicBehaviour(this) {

			public void action() {
			ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			if (msg != null) {
			if (msg.getContent().equalsIgnoreCase("demande de liste des machines réparateurs"))
			{
			ACLMessage reply = msg.createReply();
           try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             Connection con=DriverManager.getConnection("jdbc:odbc:Produits_link");
             Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs;
             rs=sql.executeQuery("Select * From Liste_produits Where (Id=(5)");

            rs.first();
             Integer Id = rs.getInt("Id");
             String Nom_produit = rs.getString("Nom_produit");
             Integer Quantite = rs.getInt("Quantite");
             Double  prix_min = rs.getDouble("prix_min");
             Double  prix_max = rs.getDouble("prix_max");
            Object[] obj= {Id, Nom_produit, Quantite, prix_min, prix_max };
            reply.setContentObject(obj);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur de l' affichage des test\n" + e.getMessage());
            }
			myAgent.send(reply);
			System.out.println(getLocalName()+" a envoyé la liste des machines réparateurs");

			} else if (msg.getContent().equalsIgnoreCase("Merci")){
			ACLMessage reply = msg.createReply();
			reply.setContent(" de rien");
			myAgent.send(reply);
			System.out.println(getLocalName()+" a répondu <de rien>");
			doDelete();
			}
			}
			else {
			block();
			}
			}
		});
	}
	protected void takeDown() {
		try {
			DFService.deregister(this);
			System.out.println(getLocalName()+" DEREGISTERED WITH THE DF");
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}

}
