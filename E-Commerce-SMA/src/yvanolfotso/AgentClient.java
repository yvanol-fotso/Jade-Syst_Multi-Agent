package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentClient extends Agent {

    protected void setup() {
        addBehaviour(new RequestProductBehaviour());
    }

    private class RequestProductBehaviour extends CyclicBehaviour {

        public void action() {
            ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
            message.addReceiver(getAID("AgentRecherche"));
            message.setContent("Recherche de produits");
            send(message);

            ACLMessage reply = receive();
            if (reply != null) {
                System.out.println("Résultats de recherche reçus : " + reply.getContent());

                // Envoi d'une demande d'ajout au panier à l'agent Vendeur
                ACLMessage addCartMessage = new ACLMessage(ACLMessage.REQUEST);
                addCartMessage.addReceiver(getAID("AgentVendeur"));
                addCartMessage.setContent("Ajout au panier");
                send(addCartMessage);

                // Communication avec l'agent de Paiement pour effectuer le paiement
                ACLMessage paymentMessage = new ACLMessage(ACLMessage.REQUEST);
                paymentMessage.addReceiver(getAID("AgentPaiement"));
                paymentMessage.setContent("Effectuer le paiement");
                send(paymentMessage);
            } else {
                block();
            }
        }
    }
}
