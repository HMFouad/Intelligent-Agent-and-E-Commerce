import jade.core.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import jade.core.Runtime;
import jade.wrapper.*;
import jade.wrapper.AgentContainer;



public class Agent_Acheteur extends Agent {	
    
    public static void Jade() {
        	try {
					Runtime rt = Runtime.instance();
					ProfileImpl p = new ProfileImpl(false);
					AgentContainer container =rt.createAgentContainer(p); // get a container controller for creating new agents
					AgentController Agent=null;
					Agent = container.createNewAgent("Acheteur1", Agent_Acheteur.class.getName(), new Object[] {});
					Agent.start();
				} catch (Exception any) {
				any.printStackTrace();}
}
public class EnvoiMessage { //extends Behaviour {
private boolean finished=false;

public void action() {
ACLMessage message = new ACLMessage(ACLMessage.INFORM);
message.addReceiver(new AID("Mediateur", AID.ISLOCALNAME));
message.setContent("Dell");
 Etiq.setText("Dell");
send(message);
//Object[] replay=(Object[]) msg.getContentObject();
finished= true;
}
public boolean done() {
if (finished) {
Etiq.setText("Ca y est, le Message est envoyé !!");
Etiq2.setText("");
}
return finished;
}
} // fin de EnvoiMessage
public JLabel Etiq,Etiq2;
}