package Ecommerce;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import jade.core.behaviours.TickerBehaviour;

public class SuperviseurAgent extends Agent {
    protected void setup() {
        // Comportement pour superviser le processus de transaction
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                // Supervision du processus de transaction, vérification des étapes et gestion des problèmes ou litiges
                System.out.println("Superviseur vérifie le déroulement de la transaction");
            }
        });

        //on modifie le comportement du superviseur toute les 5s

        // Comportement pour superviser le processus de transaction à intervalles réguliers


//        addBehaviour(new TickerBehaviour(this, 5000) { // Vérifier toutes les 5 secondes
//            protected void onTick() {
//                // Supervision du processus de transaction, vérification des étapes et gestion des problèmes ou litiges
//                System.out.println("Superviseur vérifie le déroulement de la transaction");
//            }
//        });


    }
}