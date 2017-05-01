import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ReceiveAgent extends Agent {

class MaFenetre extends JFrame implements ActionListener
{ public MaFenetre ()
 { setTitle("Agent Bettaj");
   setBounds(100,100,250,100);
   Container contenu = getContentPane();
   contenu.setLayout(new FlowLayout() );
   	
   Etiq= new JLabel ("Hallo World! My name is "+getLocalName());
   Etiq2= new JLabel ("j'attends un message de l'agent ALI");
   contenu.add(Etiq);	
   contenu.add(Etiq2); 
   boutonCalcul= new JButton("Kill");
   contenu.add(boutonCalcul);
   boutonCalcul.addActionListener(this);
 
 }

public void actionPerformed (ActionEvent e)
{ if (e.getSource()==boutonCalcul) {
  doDelete();
  //this.dispose();
}else { 
    
}
 
} // fin du if

private JButton boutonCalcul;


} // fin de la classe MaFenetre


protected void setup() {
  	MaFenetre fen= new MaFenetre();
	fen.setVisible(true);
        doWait(10000);
	addBehaviour(new RecoiMessage());
  } 

public class RecoiMessage extends CyclicBehaviour {

public void action() {
ACLMessage msg ;

msg=receive();

if (msg != null){
		Etiq.setText ("j'ai re�u un message:");
		Etiq2.setText (msg.getContent());
		flag=true;
		
		
						
	        }

else {         if (flag==false){
				Etiq2.setText("je n'ai pas encore re�u de message");
	           	block();
								}
       }
}


} // fin de RecoiMessage





public JLabel Etiq,Etiq2;
Boolean flag=false;

}


