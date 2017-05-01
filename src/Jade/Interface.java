package Jade;

import jade.core.Agent;
import jade.core.Runtime;
import jade.core.ProfileImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.wrapper.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Interface extends Agent {
    
Integer x=1000;
Vector Detailcommande,Detailvente;
    
			private JFrame jFrame = null;
			private JPanel jContentPane = null;
			private JPanel jPanel = null;
			private JPanel jPanel1 = null;
			private JPanel jPanel2 = null;
			private JTextArea jTextArea=null;
			private JButton jButton1,jButton2,jButton3 = null;
			private JScrollPane jScrollPane=null;
			private JLabel jLabel=null;
			
			/** Cette méthode est appelé directement apèes la création de l'agent pour permettre
			  * l'initialisation et l'affectation des différents comportements à cet agent 
			  * */
			public void setup() {
                            //Initialisation du temps

	    	getJFrame().setVisible(true);
	    	jTextArea.append("Agent "+getLocalName()+" est lancé "+"\n");
	    	System.out.println("Agent "+getLocalName()+" est lancé ");
                doWait(x);
                
	    	try {
			
	    		// Création de desciprion de l'agent [Portail]
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());
			
			// Enregistrement de la description de l'agent dans DF (Directory Facilitator)
			DFService.register(this, dfd);
			jTextArea.append("Agent "+getLocalName()+" est enregistré dans DF (Directory Facilitator) "+"\n");
			System.out.println("Agent "+getLocalName()+" est enregistré dans DF (Directory Facilitator) ");
                        jTextArea.append("\n");
                        doWait(x);
	    	} catch (FIPAException e) {
			e.printStackTrace();}
	    	
	    	addBehaviour(new CyclicBehaviour(this) {
	    		
			public void action() {
                            //Attente de message de l'agent Vendeur
                            ACLMessage msg_commandeI = receive();
                            String produit_recherche=msg_commandeI.getContent();
                            jTextArea.append("Acheteur ---> Médiateur: Le produit demandé est: "+produit_recherche+"  "+"\n");
                            jTextArea.append("\n");
                            doWait(x);

			// Attente de message de l'agent Acheteur)
			ACLMessage_spec liste_IdI = (ACLMessage_spec)receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			if (liste_IdI != null) {				
			try {
			
				// Création de l'objet [obj] à partir de du message reçu(de l'agent Acheteur)	
			Object[] obj=(Object[]) liste_IdI.getContentObject();
			int nb_v=liste_IdI.reponce.size();
			jTextArea.append("Message reçu: Demande de la liste des vendeurs qui ont le produit "+produit_recherche+"\n");
                        doWait(x);
                        jTextArea.append("Il existe "+nb_v+" vendeurs pour le produit recherché"+"\n");
                        doWait(x);
                        jTextArea.append("Médiateur ---> Acheteur: La liste des vendeurs est: "+"\n");

                        for(int i=0;i<nb_v;i++){
			jTextArea.append("                                                  Id"+(i+1)+"   =   "+liste_IdI.reponce.elementAt(i) +"\n");					
                        }
                        doWait(x);
			jTextArea.append("\n");
			jButton1.setText("done");
                        jButton2.setText("Quitter");
                        jButton3.setText("AAA");
			} catch (UnreadableException e) {
			e.printStackTrace();}
                        //Attente de message de l'agent Vendeur
                        ACLMessage_spec Detail_commandeI = (ACLMessage_spec)receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			jTextArea.append("Acheteur ---> Vendeur: Le produit demandé est commandeI:  "+Detail_commandeI.contenu.elementAt(0) +"\n");
			jTextArea.append("                              La quantité demandé est "+Detail_commandeI.contenu.elementAt(1) +"\n");
                        jTextArea.append("\n");
                        doWait(x);

                        //Attente de message de l'agent Acheteur
                        ACLMessage_spec Detail_venteI = (ACLMessage_spec)receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			//jTextArea.append("Vendeur ---> Acheteur: Le produit demandé est :  "+Detail_commandeI.contenu.elementAt(0) +"\n");
			jTextArea.append("                              La quantité demandé est venteI "+Detail_venteI.contenu.elementAt(0) +"\n");
                        jTextArea.append("                              Le prix de ce produit est "+Detail_venteI.contenu.elementAt(1) +"\n");
                        jTextArea.append("\n");
                        doWait(x);
                        
                        
                        jTextArea.append("Fin de traitement"+"\n");
			// Suppression de l'agent [Portail]
			
                        jTextArea.append("Agent "+getLocalName()+" est supprimé "+"\n");
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
					try {
					// Suppression de l'agent [Interface] depuis le DF
					DFService.deregister(this);
					jTextArea.append("Agent "+getLocalName()+" est terminé et supprimé depuis DF (Directory Facilitator) "+"\n");
					System.out.println("Agent "+getLocalName()+" est terminé et supprimé depuis DF (Directory Facilitator) ");
					} catch (FIPAException e) {
					e.printStackTrace();}
					}
						
			public JFrame getJFrame() {
				if (jFrame == null) {
					jFrame = new JFrame();
					jFrame.setSize(new java.awt.Dimension(800,500));
					Dimension tailleEcran =Toolkit.getDefaultToolkit().getScreenSize();
					int largeurEcran = tailleEcran.width;
					int hauteurEcran = tailleEcran.height;
					jFrame.setLocation((largeurEcran-800)/2,(hauteurEcran-500)/2);
					jFrame.setTitle("Agent interface.");
					jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);					
					jFrame.setContentPane(getJContentPane());
				}
				return jFrame;
			}

			private JPanel getJContentPane() {
				if (jContentPane == null) {
					jContentPane = new JPanel();		
					jContentPane.setLayout(new BorderLayout());
					jContentPane.add(getJPanel2(), java.awt.BorderLayout.NORTH);
					jContentPane.add(getJPanel1(), java.awt.BorderLayout.CENTER);
					jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
					}
				return jContentPane;
				}

			private JPanel getJPanel() {
				if (jPanel == null) {
					FlowLayout flowLayout = new FlowLayout();
					flowLayout.setAlignment(java.awt.FlowLayout.CENTER);
					jPanel = new JPanel();
					jPanel.setLayout(flowLayout);
					jPanel.add(getJButton1(), null);
                                        //jPanel.add(getJButton2(), null);
                                        //jPanel.add(getJButton3(), null);
					}
				return jPanel;
				}

			private JPanel getJPanel1() {
				if (jPanel1 == null) {
					jPanel1 = new JPanel();
					jPanel1.setLayout(new BorderLayout());
					jPanel1.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
					}
				return jPanel1;
				}

			private JTextArea getJTextArea() {
				if (jTextArea == null) {
					jTextArea = new JTextArea();
					}
				return jTextArea;
				}

			private JButton getJButton1() {
				if (jButton1 == null) {
					jButton1 = new JButton();
					jButton1.setText("Go");
					
					/** L'objectif de ce button et de créer les deux agents Vendeur et Acheteur
					  * et pour cela on doit premièrement récupérer le conteneur en cours (Container) de Jade
					  * puis créer deux agents Vendeur et Acheteur pour lancer le processu d'échange de message
					  * et cette partie représente la solution la plus robuste pour l'exploitation des agents  
					  * ansi que leurs service dans des classes java (Application, Applets, Servelets,etc...)
					  */
					jButton1.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
						try {
							
						// Récupération du conteneur (Main Container) en cours d'execution de Jade					
						Runtime rt = Runtime.instance();
						
						// Création du profil par défault
						ProfileImpl p = new ProfileImpl(false);
						AgentContainer container =rt.createAgentContainer(p);
						
						// Agent controleur pour permettre la création des agents 
						AgentController Agent=null;		
						
						/* Création de l'agent Médiateur
						   cette commande est équivalente à la suivante: 
						   java jade.Boot Vendeur:Jade.Mediateur
						*/
						Agent = container.createNewAgent("Mediateur", Jade.Mediateur.class.getName(), null);
						
						// Démarrage de l'agent Mediateur
						Agent.start();	
						jTextArea.append("Agent Mediateur est lancé "+"\n");
						
						/* Création de l'agent Acheteur
						   cette commande est équivalente à la suivante: 
						   java jade.Boot Acheteur:Jade.Acheteur
						*/
                                                    Agent = container.createNewAgent("Acheteur", Jade.Acheteur.class.getName(), null);
				
						// Démarrage de l'agent Acheteur
						Agent.start();
						jTextArea.append("Agent Acheteur est lancé "+"\n");
                                                
                                                /* Création de l'agent Vendeur
						   cette commande est équivalente à la suivante: 
						   java jade.Boot Vendeur:Jade.Vendeur
						*/
						Agent = container.createNewAgent("Vendeur", Jade.Vendeur.class.getName(), null);
						
						// Démarrage de l'agent Vendeur
						Agent.start();	
						jTextArea.append("Agent Vendeur est lancé "+"\n");
						
						} catch (Exception any) {
						any.printStackTrace();}
						}
					});
					}
				return jButton1;
				}
                        

			private JScrollPane getJScrollPane() {
				if (jScrollPane == null) {
					jScrollPane = new JScrollPane();
					jScrollPane.setViewportView(getJTextArea());
				}
				return jScrollPane;
				}

			private JPanel getJPanel2() {
				if (jPanel2 == null) {
					jLabel = new JLabel();
					jLabel.setText("Les agents intélligents et le commerce électronique");
					jLabel.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 18));
					jPanel2 = new JPanel();
					jPanel2.setBackground(java.awt.SystemColor.info);
					jPanel2.add(jLabel, null);
				}
				return jPanel2;
				}
		
			

    public void main() {
        try {
					// Récupération du conteneur (Main Container) en cours d'execution de Jade					
					Runtime rt = Runtime.instance();
				
					// Création du profil par défault
					ProfileImpl p = new ProfileImpl(false);
					AgentContainer container =rt.createAgentContainer(p); // get a container controller for creating new agents
				
					// Agent controleur pour permettre la création des agents 
					AgentController Agent=null;		
				
					/* Création de l'agent Portail
					   cette commande est équivalente à la suivante: 
					   java jade.Boot Portail:JADE_exemple_personnel.Portail
					*/
					Agent = container.createNewAgent("Interface", Jade.Interface.class.getName(), null);
				
					// Démarrage de l'agent Portail
					Agent.start();											
					} catch (Exception any) {
					any.printStackTrace();}				
				}
    }

