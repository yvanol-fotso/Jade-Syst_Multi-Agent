import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class Main {
    public static void main(String[] args) {
        // Démarrage de la plateforme JADE
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();

        p.setParameter(Profile.GUI, "true"); // Activer l'interface graphique

        AgentContainer mainContainer = rt.createMainContainer(p);

        try {

            // Création de l'agent RMA (Remote Management Agent) // a vu=isualiser sur le GUI

            //AgentController rmaController = mainContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
            //rmaController.start(); // creai l'erreur si l'agent a ete demarrer precedement


            // Création des agents
            AgentController clientController = mainContainer.createNewAgent("client", "yvanolfotso.ClientAgent", null);
            AgentController vendeurController = mainContainer.createNewAgent("vendeur", "yvanolfotso.VendeurAgent", null);
            AgentController paiementController = mainContainer.createNewAgent("paiement", "yvanolfotso.PaiementAgent", null);
            AgentController superviseurController = mainContainer.createNewAgent("superviseur", "yvanolfotso.SuperviseurAgent", null);

            // Démarrage des agents
            clientController.start();
            vendeurController.start();
            paiementController.start();
            superviseurController.start();

            // Attente pour observer les interactions
            Thread.sleep(5000); // Attente de 5 secondes pour observer les interactions

            // Arrêt de la plateforme JADE
            rt.shutDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
