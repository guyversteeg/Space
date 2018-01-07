import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList loadItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        File itemFile = new File ("C:\\Users\\Guy\\Documents\\Udacity\\Java\\Space Challenge\\src\\phase-1.txt");
        try (Scanner scanItems = new Scanner(itemFile)) {
            while (scanItems.hasNextLine()) {
                // Read line from the text file.
                String item = scanItems.nextLine();
                // Split the line at the "=".
                String[] details =  item.split("=");
                String name = details[0];
                int weight = (Integer.valueOf(details[1])) / 1000; // Divided by 1000 to get weight in tonnes.
                // Create a new item.
                Item newItem = new Item(name, weight);
                // Add this data to the ArrayList.
                System.out.println(newItem.name + " " + newItem.weight);
                items.add(newItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Method loadU1 which fills the U1 rocket with as much as possible items before creating a new U1 rocket.
    public ArrayList loadU1(ArrayList itemList) {
        // Read item list.
        ArrayList<Item> items;
        ArrayList<Rocket> U1Rockets = new ArrayList<>();
        items = itemList;
        // Create object of the U1 rocket class.
        U1 u1Rocket = new U1();
        U1Rockets.add(u1Rocket);
        // While loop to fill the U1 rocket.
        while (items.size() > 0) {
            Item anItem = items.get(0);
            if (u1Rocket.canCarry(anItem)) {
                u1Rocket.carry(anItem);
                items.remove(0);
            }
            else {
                U1Rockets.add(u1Rocket);
                u1Rocket = new U1();
            }
        }
        return U1Rockets;
    }

    // Method loadU2 which fills the U2 rocket with as much as possible items before creating a new U2 rocket.
    public ArrayList loadU2() {
        // Read the item list.
        ArrayList<Item> items;
        ArrayList<Rocket> U2Rockets = new ArrayList<>();
        items = this.loadItems();
        // Create an object of the U2 rocket class.
        U2 u2Rocket = new U2();
        // While loop to fill the U2 rocket.
        while (items.size() > 0) {
            Item anItem = items.get(0);
            if (u2Rocket.canCarry(anItem)) {
                u2Rocket.carry(anItem);
                items.remove(0);
            }
            else {
                U2Rockets.add(u2Rocket);
                u2Rocket = new U2();
            }
        }
        return U2Rockets;
    }

    public void runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;
        ArrayList loadU1Rockets = rockets;
        while (loadU1Rockets.size() > 0) {
            // Create current rocket.
            Rocket newU1Rocket = new U1();
            // Send rocket to space
            System.out.println("Launching U1 rocket!");
            totalBudget += newU1Rocket.rocketCost;
            if (newU1Rocket.launch()) {
                System.out.println("Rocket launched succesfully!");
                loadU1Rockets.remove(0);
            }
            // If launch failed, send new rocket.
            else {
                System.out.println("Rocket exploded during launch!");
            }
            // Print total budget to screen.
        }
        System.out.println("Total budget cost: " + totalBudget + " million dollars.");
    }
}
