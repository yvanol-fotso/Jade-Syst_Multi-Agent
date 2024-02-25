package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentRecommandation extends Agent {

    protected void setup() {
        addBehaviour(new RecommendProductBehaviour());
    }

    private class RecommendProductBehaviour extends CyclicBehaviour {

        public void action() {
            ACLMessage message = receive();
            if (message != null) {
                if (message.getPerformative() == ACLMessage.REQUEST) {
                    String recommendedProducts = generateRecommendedProducts(message.getContent());

                    ACLMessage reply = message.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent(recommendedProducts);
                    send(reply);
                } else {
                    block();
                }
            } else {
                block();
            }
        }

        private String generateRecommendedProducts(String clientPreferences) {
            // Implémentation de l'algorithme de recommandation
            // Utilisation des préférences d'achat précédentes du client pour recommander des produits
            // Retourne une liste de produits recommandés sous forme de chaîne de caractères

            // Implémentation factice de la recommandation (à remplacer par l'algorithme réel)
            return "Produit recommandé 1, Produit recommandé 2, Produit recommandé 3";
        }
    }
}

