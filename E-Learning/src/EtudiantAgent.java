import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class EtudiantAgent extends Agent {

    protected void setup() {
        System.out.println("Agent Étudiant " + getAID().getName() + " est prêt.");

        // Ajouter le comportement de l'étudiant
        addBehaviour(new EtudiantBehaviour());
    }

    protected void takeDown() {
        System.out.println("Agent Étudiant " + getAID().getName() + " est terminé.");
    }

    private class EtudiantBehaviour extends CyclicBehaviour {

        public void action() {
            // Recevoir les messages de la plateforme
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            ACLMessage msg = myAgent.receive(mt);
            if (msg != null) {
                // Traiter le message reçu
                System.out.println("Étudiant " + getAID().getName() + " reçoit le message: " + msg.getContent());

                // Simuler les actions de l'étudiant
                simulerActionsEtudiant(msg);
            } else {
                block();
            }
        }

        private void simulerActionsEtudiant(ACLMessage msg) {
            // Simuler quelques actions de l'étudiant
            if (msg.getContent().equals("Nouveau cours disponible")) {
                System.out.println("Étudiant consulte le nouveau cours.");

                // Répondre à la plateforme
                ACLMessage reponse = new ACLMessage(ACLMessage.INFORM);
                reponse.setContent("Cours consulté avec succès.");

                //reponse.addReceiver(getAgent("Plateforme")); // cette methode n'est pas valide pour envoyer un message il faut use AID

                // Dans la méthode simulerActionsEnseignant(ACLMessage msg)
                AID receiver = new AID("Plateforme", AID.ISLOCALNAME);
                reponse.addReceiver(receiver);

                send(reponse);
            }
        }
    }
}
