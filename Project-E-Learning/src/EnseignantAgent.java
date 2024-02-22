import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class EnseignantAgent extends Agent {

    protected void setup() {
        System.out.println("Agent Enseignant " + getAID().getName() + " est prêt.");

        // Ajouter le comportement de l'enseignant
        addBehaviour(new EnseignantBehaviour());
    }

    protected void takeDown() {
        System.out.println("Agent Enseignant " + getAID().getName() + " est terminé.");
    }

    private class EnseignantBehaviour extends CyclicBehaviour {

        public void action() {
            // Recevoir les messages de la plateforme ou des étudiants
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            ACLMessage msg = myAgent.receive(mt);
            if (msg != null) {
                // Traiter le message reçu
                System.out.println("Enseignant " + getAID().getName() + " reçoit le message: " + msg.getContent());

                // Simuler les actions de l'enseignant
                simulerActionsEnseignant(msg);
            } else {
                block();
            }
        }

        private void simulerActionsEnseignant(ACLMessage msg) {
            // Simuler quelques actions de l'enseignant
            if (msg.getContent().equals("Demande de publication de devoir")) {
                System.out.println("Enseignant publie un nouveau devoir.");
            }
        }
    }
}

