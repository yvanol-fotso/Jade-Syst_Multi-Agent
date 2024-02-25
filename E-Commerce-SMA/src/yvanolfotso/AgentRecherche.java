package yvanolfotso;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentRecherche extends Agent {

    protected void setup() {
        addBehaviour(new SearchProductBehaviour());
    }

    private class SearchProductBehaviour extends CyclicBehaviour {

        public void action() {
            ACLMessage message = receive();
            if (message != null) {
                if (message.getPerformative() == ACLMessage.REQUEST) {
                    String searchQuery = message.getContent();
                    String searchResults = performSearch(searchQuery);

                    ACLMessage reply = message.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent(searchResults);
                    send(reply);
                } else {
                    block();
                }
            } else {
                block();
            }
        }

        private String performSearch(String query) {
            // Implémentation de la recherche dans la base de données des produits
            // Utilisation de la requête de recherche du client pour trouver des produits correspondants
            // Retourne les résultats de recherche sous forme de chaîne de caractères (liste de produits)

            // Implémentation factice de la recherche (à remplacer par l'accès à une base de données réelle)
            return "Résultats de la recherche pour '" + query + "': Product1, Product2, Product3";
        }
    }
}
