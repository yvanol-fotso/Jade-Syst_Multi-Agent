package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentVendeur extends Agent {

    protected void setup() {
        addBehaviour(new ProcessOrderBehaviour());
    }

    private class ProcessOrderBehaviour extends CyclicBehaviour {

        public void action() {
            ACLMessage message = receive();
            if (message != null) {
                if (message.getPerformative() == ACLMessage.REQUEST) {
                    String content = message.getContent();
                    if (content.equals("Ajout au panier")) {
                        // Traiter la commande et générer une facture
                        System.out.println("Traitement de la commande et génération de la facture");

                        // Communication avec l'agent de Livraison pour organiser la livraison
                        ACLMessage deliveryMessage = new ACLMessage(ACLMessage.REQUEST);
                        deliveryMessage.addReceiver(getAID("AgentLivraison"));
                        deliveryMessage.setContent("Organiser la livraison");
                        send(deliveryMessage);

                        // Communication avec les gestionnaires de la plateforme pour gérer les commandes et les stocks
                        ACLMessage platformMessage = new ACLMessage(ACLMessage.INFORM);
                        platformMessage.addReceiver(getAID("AgentsGestionPlateforme"));
                        platformMessage.setContent("Gérer les commandes et les stocks");
                        send(platformMessage);
                    }
                }
            } else {
                block();
            }
        }
    }
}

