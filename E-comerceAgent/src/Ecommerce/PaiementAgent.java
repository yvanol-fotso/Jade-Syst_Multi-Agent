package Ecommerce;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class PaiementAgent extends Agent {
    protected void setup() {
        // Comportement pour gérer le processus de paiement
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                // Simulation du processus de paiement
                System.out.println("Paiement de la commande");
            }
        });
    }
}