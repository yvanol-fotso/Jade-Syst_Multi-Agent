package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;



public class PaiementAgent extends Agent {
    protected void setup() {
        // Comportement pour gérer le processus de paiement
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                // Simulation du processus de paiement
                System.out.println("Paiement de la commande");

                // Envoyer un message au superviseur pour confirmer le paiement
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("superviseur", AID.ISLOCALNAME));
                msg.setContent("Paiement effectué pour la commande du produit X");
                send(msg);
            }
        });
    }
}
