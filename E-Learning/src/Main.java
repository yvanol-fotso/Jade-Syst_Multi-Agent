import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;

public class Main {

    public static void main(String[] args) {
        // Démarrer JADE
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true"); // Afficher l'interface graphique de JADE
        ContainerController cc = rt.createMainContainer(p);

        try {
            // Démarrer les agents
            AgentController enseignantAgent = cc.createNewAgent("Enseignant", EnseignantAgent.class.getName(), null);
            AgentController etudiantAgent = cc.createNewAgent("Etudiant", EtudiantAgent.class.getName(), null);
            AgentController plateformeAgent = cc.createNewAgent("Plateforme", PlateformeAgent.class.getName(), null);

            enseignantAgent.start();
            etudiantAgent.start();
            plateformeAgent.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
