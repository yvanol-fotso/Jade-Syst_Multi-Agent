package Ecommerce;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class VendeurAgent extends Agent {
    protected void setup() {
        // Comportement pour gérer les demandes d'ajout au panier
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    // Vérification de la disponibilité du produit, préparation de la commande et envoi de la confirmation
                    System.out.println("Vendeur reçoit une demande d'ajout au panier, vérifie la disponibilité et envoie une confirmation de commande");
                } else {
                    block();
                }
            }
        });
    }
}