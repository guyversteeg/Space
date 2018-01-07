public class Rocket implements SpaceShip {
    // Rocket details
    int rocketCost;
    int weight;
    int maxWeight;
    int currentWeight;
    int cargoCarried;
    int cargoLimit;
    double chanceOfLaunchExplosion;
    double chanceOfLandingCrash;

    // launch() should always be true. Later it will be overwritten.
    public boolean launch() {
        return true;
    }

    // land() should always return true. Later it will be overwritten.
    public boolean land() {
        return true;
    }

    // The canCarry method here.
    public boolean canCarry(Item item) {
        // If weight + itemWeight < maxWeight return true.
        if (currentWeight < maxWeight) {
            currentWeight += item.weight;
            return true;
        }
        // If weight + itemWeight > maxWeight return false.
        else
            return false;
    }

    // The carry method here.
    public void carry(Item item) {
        // Add an item to the carry list.
        this.currentWeight += item.weight;
        System.out.println("The new total weight is: " + this.currentWeight);
    }
}
