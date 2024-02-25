import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Main {

    public static void main(String[] args) {
        // Démarrer la plateforme JADE
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();

        p.setParameter(Profile.GUI, "true"); // Activer l'interface graphique

        AgentContainer container = rt.createMainContainer(p);

        try {
            // Démarrer les agents
            AgentController clientController = container.createNewAgent("Client","yvanolfotso.AgentClient", null);
            clientController.start();

            AgentController vendeurController = container.createNewAgent("Vendeur", "yvanolfotso.AgentVendeur", null);
            vendeurController.start();

            AgentController recommandationController = container.createNewAgent("Recommandation", "yvanolfotso.AgentRecommandation", null);
            recommandationController.start();

            AgentController rechercheController = container.createNewAgent("Recherche", "yvanolfotso.AgentRecherche", null);
            rechercheController.start();

            AgentController paiementController = container.createNewAgent("Paiement", "yvanolfotso.AgentPaiement", null);
            paiementController.start();

            AgentController livraisonController = container.createNewAgent("Livraison", "yvanolfotso.AgentLivraison", null);
            livraisonController.start();

            AgentController gestionPlateformeController = container.createNewAgent("GestionPlateforme", "yvanolfotso.AgentGestionPlateforme", null);
            gestionPlateformeController.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
