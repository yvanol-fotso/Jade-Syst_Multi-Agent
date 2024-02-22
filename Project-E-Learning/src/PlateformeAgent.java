import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
// Importez la classe AID
import jade.core.AID;


public class PlateformeAgent extends Agent {

    protected void setup() {
        System.out.println("Agent Plateforme est prêt.");

        // Ajouter le comportement de la plateforme
        addBehaviour(new PlateformeBehaviour());
    }

    protected void takeDown() {
        System.out.println("Agent Plateforme est terminé.");
    }

    private class PlateformeBehaviour extends CyclicBehaviour {

        public void action() {
            // Simuler l'envoi de messages aux agents
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.setContent("Demande de publication de devoir");

            //msg.addReceiver(getAgent("Enseignant")); // cette methode n'est pas valide pour envoyer un message il faut use AID
            // Dans la méthode PlateformeBehaviour.action()
            AID receiver = new AID("Enseignant", AID.ISLOCALNAME);
            msg.addReceiver(receiver);

            send(msg);

            // Simuler la réception de messages des agents
            ACLMessage msg2 = myAgent.receive();
            if (msg2 != null && msg2.getContent().equals("Nouveau cours disponible")) {
                System.out.println("Plateforme reçoit le message: " + msg2.getContent());
            }
        }
    }
}
