package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentLivraison extends Agent {

    protected void setup() {
        addBehaviour(new DeliverOrderBehaviour());
    }

    private class DeliverOrderBehaviour extends CyclicBehaviour {

        public void action() {
            ACLMessage message = receive();
            if (message != null) {
                if (message.getPerformative() == ACLMessage.REQUEST) {
                    String orderDetails = message.getContent();
                    boolean deliverySuccessful = deliverOrder(orderDetails);

                    ACLMessage reply = message.createReply();
                    if (deliverySuccessful) {
                        reply.setPerformative(ACLMessage.CONFIRM);
                        reply.setContent("Livraison effectuée avec succès.");
                    } else {
                        reply.setPerformative(ACLMessage.FAILURE);
                        reply.setContent("Échec de la livraison. Veuillez réessayer plus tard.");
                    }
                    send(reply);
                } else {
                    block();
                }
            } else {
                block();
            }
        }

        private boolean deliverOrder(String orderDetails) {
            // Implémentation de l'organisation de la livraison
            // Utilisation des détails de la commande pour organiser la livraison au domicile du client
            // Retourne true si la livraison est réussie, sinon false

            // Implémentation factice de l'organisation de la livraison (à remplacer par un service de livraison réel)
            return true; // Pour l'exemple, la livraison est toujours réussie
        }
    }
}

