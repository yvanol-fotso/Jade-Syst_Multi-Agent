import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class MyAgent extends Agent {
    protected void setup() {
        System.out.println("Je suis un agent JADE : " + getAID().getName());
        
        // Ajout d'un comportement qui affiche "Blink" toutes les 1000 ms
        addBehaviour(new TickerBehaviour(this, 1000) {
            protected void onTick() {
                System.out.println("Blink");
            }
        });
    }

    public static void main(String[] args) {
        // Création d'un agent et démarrage de la plateforme
        jade.core.Runtime rt = jade.core.Runtime.instance();
        rt.setCloseVM(true); // Ferme la JVM lorsque le conteneur est vide
        jade.wrapper.AgentContainer mainContainer = rt.createMainContainer(new jade.core.ProfileImpl());
        try {
            mainContainer.createNewAgent("myAgent", MyAgent.class.getName(), null).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
