//package agent;


import java.io.IOException;
import jade.core.Agent;
import jade.core.AID;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;



public class machine_à_réparer extends Agent {
	private Object[] obj=null;
 

       protected void setup() {
          
		System.out.println(getLocalName()+" STARTED");
			try {
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());

			DFService.register(this, dfd);
			System.out.println(getLocalName()+" REGISTERED WITH THE DF");
			} catch (FIPAException e) {
			e.printStackTrace();
			}
           ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			msg.setContent("demande de liste des machines réparateurs");
			msg.addReceiver(new AID("machine_réparateur", AID.ISLOCALNAME));
			send(msg);
			System.out.println(getLocalName()+" demande la liste des machines réparateurs");

			addBehaviour(new CyclicBehaviour(this) {
			public void action() {
			ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
			if (msg != null) {
			try {
			ACLMessage reply = msg.createReply();
			reply.setContent("Merci");
			myAgent.send(reply);
			System.out.println(myAgent.getLocalName()+" a envoyé <merci>");
			obj=(Object[]) msg.getContentObject();
			ACLMessage msg1 = new ACLMessage(ACLMessage.INFORM);
			try {
			msg1.setContentObject(obj);
			msg1.addReceiver(new AID("opération_agent", AID.ISLOCALNAME));
			send(msg1);
			} catch (IOException e) {
			e.printStackTrace();
			}
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		System.out.println("la liste des machines réparateurs est : ");
			for(int i=0;i<obj.length;i++) {
				System.out.println(obj[i]);
			}
			
			doDelete();
			}
			else {
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
}