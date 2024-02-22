package Ecommerce;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class ClientAgent extends Agent {
    protected void setup() {
        // Comportement pour simuler l'action du client
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                // Simulation de la navigation, de la recherche de produit, de l'ajout au panier et du paiement
                System.out.println("Client navigue sur la plateforme, recherche un produit, ajoute au panier et effectue le paiement");
            }
        });
    }
}