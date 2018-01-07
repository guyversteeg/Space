public class U2 extends Rocket {
    // Random number generator.
    double randomNumber = Math.random();
    // Constructor of the U2 class.
    public U2() {
        this.rocketCost = 120; // In millions.
        this.weight = 18; // In tonnes.
        this.maxWeight = 29; // In tonnes.
        this.cargoLimit = this.maxWeight - this.weight;
        this.currentWeight = this.weight;
        this.chanceOfLaunchExplosion = 0.04 * (this.cargoCarried / this.cargoLimit);
        this.chanceOfLandingCrash = 0.08 * (this.cargoCarried / this.cargoLimit);
    }

    @Override
    public boolean launch() {
        // If chanceOfLaunchExplosion < 50% return true, else return false.
        //if (chanceOfLaunchExplosion < 50) {
            return true;
        //}
        //else
        //    return false;
    }

    @Override
    public boolean land() {
        // If chanceOfLandingCrash < 50% return true, else return false.
        //if (chanceOfLandingCrash < 50) {
            return true;
        //}
        //else
        //    return false;
    }
}

/*
Rocket cost = $120 Million
Rocket weight = 18 Tonnes
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)
double chanceOfLaunchExplosion = 0.04 * (cargoCarried / (maxWeight - weight));
double chanceOfLandingCrash = 0.08 * (cargoCarried / (maxWeight - weight));
 */