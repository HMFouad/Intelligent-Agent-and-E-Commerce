package Jade;

import jade.lang.acl.ACLMessage;
import java.util.*;

public class ACLMessage_spec extends ACLMessage{
    public Vector contenu;
    public Vector reponce;
    public ACLMessage_spec(){
        super(ACLMessage.INFORM);
        contenu=new Vector();
        reponce=new Vector();
    }
    
}
