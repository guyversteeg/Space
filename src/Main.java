import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// Create simulation instance
        Simulation simulation = new Simulation();
        ArrayList items = simulation.loadItems();
        ArrayList u1Rockets = simulation.loadU1(items);
        System.out.println("Amount of U1 rockets needed : " + u1Rockets.size());
        //ArrayList u2Rockets = simulation.loadU2();
        //System.out.println("Amount of U2 rockets needed : " +u2Rockets.size());

        simulation.runSimulation(u1Rockets);
    }
}
