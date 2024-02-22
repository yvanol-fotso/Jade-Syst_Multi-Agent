import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Main {
    public static void main(String[] args) {
        // Création du conteneur principal
        jade.core.Runtime rt = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.GUI, "true");
        AgentContainer mainContainer = rt.createMainContainer(profile);

        try {
            // Création et démarrage des agents
            AgentController clientController = mainContainer.createNewAgent("client", "Ecommerce.ClientAgent", null);
            clientController.start();

            AgentController vendeurController = mainContainer.createNewAgent("vendeur", "Ecommerce.VendeurAgent", null);
            vendeurController.start();

            AgentController paiementController = mainContainer.createNewAgent("paiement", "Ecommerce.PaiementAgent", null);
            paiementController.start();

            AgentController superviseurController = mainContainer.createNewAgent("superviseur", "Ecommerce.SuperviseurAgent", null);
            superviseurController.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
