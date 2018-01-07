public class U1 extends Rocket {
    // Random number generator.
    double randomNumber = Math.random();
    // Constructor of the U1 class.
    public U1() {
        this.rocketCost = 100; // In millions.
        this.weight = 10; // In tonnes.
        this.maxWeight = 18; // In tonnes.
        this.cargoLimit = this.maxWeight - this.weight;
        this.currentWeight = this.weight;
        this.cargoCarried = this.currentWeight - this.weight;
        this.chanceOfLaunchExplosion = (0.05 * (cargoCarried / cargoLimit)) * 100;
        this.chanceOfLandingCrash = 0.01 * (cargoCarried / cargoLimit);
    }

    @Override
    public boolean launch() {
        // If chanceOfLaunchExplosion < randomNumber return true, else return false.
        if (this.chanceOfLaunchExplosion < randomNumber) {
            System.out.println("Current weight is: " + this.currentWeight);
            System.out.println("Weight is " + this.weight);
            System.out.println(this.cargoCarried);
            System.out.println(this.cargoLimit);
            // Print the launch chances to screen.
            System.out.println("The chance of exploding is: " + this.chanceOfLaunchExplosion + " and the random number is " + randomNumber);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean land() {
        // If chanceOfLandingCrash < randomNumber return true, else return false.
        if (chanceOfLandingCrash < randomNumber)
            return true;
        else
            return false;
    }

}

/*
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)
double chanceOfLaunchExplosion = 0.05 * (cargoCarried / (maxWeight - weight));
double chanceOfLandingCrash = 0.01 * (cargoCarried / (maxWeight - weight));
 */