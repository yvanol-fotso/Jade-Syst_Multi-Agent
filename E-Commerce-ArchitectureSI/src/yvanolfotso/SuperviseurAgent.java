package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SuperviseurAgent extends Agent {
    protected void setup() {
        // Comportement pour superviser le processus de transaction
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                // Supervision du processus de transaction, vérification des étapes et gestion des problèmes ou litiges
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Superviseur reçoit un message : " + msg.getContent());
                } else {
                    block();
                }
            }
        });
    }
}
