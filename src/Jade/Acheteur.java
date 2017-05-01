package Jade;

import Accueil.Accueil;
import java.io.IOException;
import java.util.*;
import jade.core.Agent;
import jade.core.AID;
import jade.core.ProfileImpl;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import javax.swing.*;

public class Acheteur extends Agent {
//Déclaration des variables:
    
public JTextField jTextField1=null;
String Nom_produit_recherche;
Integer Id,Quantite_demande;
Double prix_achat;
Vector Detailcommande,Detailvente;
	private Object[] obj=null;
    
	
	// Représent l'objet à envoyer dans le message vers l'agent Portail

	
	/** Cette méthode est appelé directement apèes la création de l'agent pour permettre
	  * l'initialisation et l'affectation des différents comportements à cet agent 
	  * */
	protected void setup() {
		System.out.println(getLocalName()+" STARTED");
		
			try {
			// Création de desciprion de l'agent [Acheteur]
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());
			// Enregistrement de la description de l'agent dans DF (Directory Facilitator)
			DFService.register(this, dfd);
			System.out.println(getLocalName()+" REGISTERED WITH THE DF");
			} catch (FIPAException e) {
			e.printStackTrace();
			}
			
		 

//Nom_produit_recherche=new Accueil().Nom_produit_recherche1;
//Quantite_demande=new Accueil().Quantite_recherche1;
//prix_achat=new Accueil().Prix_achat;

Nom_produit_recherche="Dell";
Quantite_demande=100;
                        /* Préparation du message à envoyer vers l'agent Vendeur
			   ce message contient la demande de la liste de produits
			*/
			ACLMessage_spec msg_commande = new ACLMessage_spec();
			// Remplissage de contenue du message
			msg_commande.contenu.add(Nom_produit_recherche);

			
			// Préciser les agents destinataires du message qui est l'agent Vendeur dans ce cas
			msg_commande.addReceiver(new AID("Mediateur", AID.ISLOCALNAME));
			
			// Envoyer le message à l'agent Vendeur	
			send(msg_commande);
			System.out.println(getLocalName()+" demande la liste des produits"); 
	
			addBehaviour(new CyclicBehaviour(this) {
			public void action() {
			
			// Attente de message (de l'agent Vendeur)
			ACLMessage_spec msg_liste_Id = (ACLMessage_spec)receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
                        
                        if (msg_liste_Id != null) {				
									
			try {
				
			// Agent Acheteur transmet la liste des Id à l'agent Interface				
                        Vector liste_Id=msg_liste_Id.reponce;
			ACLMessage_spec liste_IdI = new ACLMessage_spec();
			try {
			//liste_IdI.setContentObject(obj);
                        liste_IdI.reponce=liste_Id;
			liste_IdI.addReceiver(new AID("Interface", AID.ISLOCALNAME));
			send(liste_IdI);	
			} catch (Exception e) {				
			e.printStackTrace();
			}				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
                        
                        //Début de la négociation avec l'agent vendeur
                                //Envoie les détails de la commande à l'agent Vendeur
                                    Detailcommande = new Vector();
                                    Detailcommande.add(Nom_produit_recherche);
                                    Detailcommande.add(Quantite_demande);


                            ACLMessage_spec Detail_commande = new ACLMessage_spec();
                            Detail_commande.contenu=Detailcommande;
                            Detail_commande.addReceiver(new AID("Interface", AID.ISLOCALNAME));
                            send(Detail_commande);


                            //Reçoit les détails de vente de l'agent Vendeur
                            ACLMessage_spec Detail_vente = (ACLMessage_spec)receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
                                                        
                            //Envoie les détails vente à l'agent Interface
                            ACLMessage_spec Detail_venteI = new ACLMessage_spec();
                            Detail_venteI.contenu=Detail_vente.contenu;
                            Detail_venteI.addReceiver(new AID("Interface", AID.ISLOCALNAME));
                            send(Detail_venteI);
                            
                            


			// Suppression de l'agent [Acheteur]
			doDelete();					
			}
			else {
				//Pendant que le message n'est pas encore arrivé le comportement est bloqué
				block();
			}
			}
		});
	}

	protected void takeDown() {
		// Suppression de l'agent [Acheteur] depuis le DF
		try {
			DFService.deregister(this);
			System.out.println(getLocalName()+" DEREGISTERED WITH THE DF");
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}

    public void main() {
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
					Agent = container.createNewAgent("Acheteur", "Jade.Acheteur", null);
				
					// Démarrage de l'agent Portail
					Agent.start();	
                                        
					} catch (Exception any) {
					any.printStackTrace();}				
				}
    }
        
   
