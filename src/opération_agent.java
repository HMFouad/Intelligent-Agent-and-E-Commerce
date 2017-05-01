//package agent;

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
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class opération_agent extends Agent {
    private Object[] obj=null;
			private JFrame jFrame = null;
			private JPanel jContentPane = null;
			private JPanel jPanel = null;
			private JPanel jPanel1 = null;
			private JPanel jPanel2 = null;
			private JTextArea jTextArea=null;
			private JButton jButton = null;
			private JScrollPane jScrollPane=null;
			private JLabel jLabel=null;

    public static void main() {
        	try {
					Runtime rt = Runtime.instance();
					ProfileImpl p = new ProfileImpl(false);
					AgentContainer container =rt.createAgentContainer(p); // get a container controller for creating new agents
					AgentController Agent=null;
					Agent = container.createNewAgent("opération_agent", "agent.opération_agent", null);
					Agent.start();
					} catch (Exception any) {
					any.printStackTrace();}

    }

			protected void setup() {
            
	    	getJFrame().setVisible(true);
             jTextArea.setFont(new java.awt.Font("Arial", 2, 14));
	    	jTextArea.append("Agent "+getLocalName()+" est lancé "+"\n");
	    	System.out.println("Agent "+getLocalName()+" est lancé ");
	    	try {

			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());

			// Enregistrement de la description de l'agent dans DF (Directory Facilitator)
			DFService.register(this, dfd);
			jTextArea.append("Agent "+getLocalName()+" est enregistré dans DF (Directory Facilitator) "+"\n");
			System.out.println("Agent "+getLocalName()+" est enregistré dans DF (Directory Facilitator) ");
	    	} catch (FIPAException e) {
			e.printStackTrace();}

	    	addBehaviour(new CyclicBehaviour(this) {

			public void action() {
			ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			if (msg != null) {
			try {
           
			jTextArea.append("Message reçu <la liste des machines réparateurs>"+"\n");
			jTextArea.append("Contenu de message {"+"\n");
            Object[] obj=(Object[]) msg.getContentObject();
			for(int i=0;i<obj.length;i=4){
			jTextArea.append("machine réparateur:       "+(String) obj[i]+"\n");
            jTextArea.append("opération:                       "+(String) obj[i+1]+"\n");
            jTextArea.append("prix de maintenance:     "+(String) obj[i+2]+"\n");
            jTextArea.append("temps:                           "+(String) obj[i+3]+"\n");
			}
			jTextArea.append("}"+"\n");
			jButton.setText("done");
            
			} catch (UnreadableException e) {
			e.printStackTrace();}
			jTextArea.append("Fin de traitement"+"\n");
			doDelete();
			}
			else {
			block();
				}
			}
	    	});

			}

			protected void takeDown() {
					try {
					// Suppression de l'agent [Portail] depuis le DF
					DFService.deregister(this);
					jTextArea.append("Agent "+getLocalName()+" est terminé et supprimé depuis DF (Directory Facilitator) "+"\n");
					System.out.println("Agent "+getLocalName()+" est terminé et supprimé depuis DF (Directory Facilitator) ");
					} catch (FIPAException e) {
					e.printStackTrace();}
					}

			public JFrame getJFrame() {
				if (jFrame == null) {
					jFrame = new JFrame();
					jFrame.setSize(new java.awt.Dimension(600,400));
					Dimension tailleEcran =Toolkit.getDefaultToolkit().getScreenSize();
					int largeurEcran = tailleEcran.width;
					int hauteurEcran = tailleEcran.height;
					jFrame.setLocation((largeurEcran-500)/2,(hauteurEcran-350)/2);
					jFrame.setTitle(" Appel d'offre des Agents.");
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
					jPanel.add(getJButton(), null);
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

			private JButton getJButton() {
				if (jButton == null) {
					jButton = new JButton();
					jButton.setText("Go");
					jButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
						try {

						// Récupération du conteneur (Main Container) en cours d'execution de Jade
						Runtime rt = Runtime.instance();

						// Création du profil par défault
						ProfileImpl p = new ProfileImpl(false);
						AgentContainer container =rt.createAgentContainer(p);
						AgentController Agent=null;
						Agent = container.createNewAgent("machine_réparateur", "agent.machine_réparateur", null);
						Agent.start();
						jTextArea.append("Agent machine_réparateur est lancé "+"\n");
						Agent = container.createNewAgent("machine_à_réparer", "agent.machine_à_réparer", null);
						Agent.start();
						jTextArea.append("Agent machine_à_réparer est lancé "+"\n");
						} catch (Exception any) {
						any.printStackTrace();}
						}
					});
                    
					}
                
                return jButton;




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
					jLabel.setText("e_maintenance");
					jLabel.setFont(new java.awt.Font("Perpetua", java.awt.Font.BOLD, 18));
					jPanel2 = new JPanel();
					jPanel2.setBackground(java.awt.SystemColor.info);
					jPanel2.add(jLabel, null);
				}
				return jPanel2;
				}
           
			


}
