/**
 * Engine sets the engine type of a train, and stores relevant information 
 * about the fuel capacity of the engine. 
 * Attributes: 
 *  FuelType - type of fuel of instance FuelType 
 *  currentFuel - double representing the amount of fuel currently in the engine 
 *  maxFuel - double storing the maximum fuel an engine can store
 */

public class Engine {

    public FuelType fuelType; // fueltype of class FuelType 
    double currentFuel; 
    double maxFuel; 
/**
 * @param fuel_type, an instance of FuelType, which is one of four options from the FuelType class.
 * @param maxfuel, a double representing the maximum amount of fuel an engine can store. 
 
  Sets fuelType to an input fuel_type, the current fuel value to 0, and the maximum fuel to a user-input value
 */ 
    public Engine(FuelType fuel_type, double maxfuel) { // other classes just need to read the Engine values, not change them, so private
        this.fuelType = fuel_type; 
        this.currentFuel = 0.; 
        this.maxFuel = maxfuel; 
    }
/**
 * Sets the current fuel value equal to the maximum fuel of the engine and prints out a message. Does not return anything.
 */
    public void refuel(){
        this.currentFuel = this.maxFuel; // resets current fuel level to max fuel , does not return anything
        System.out.println("Max fuel restored!");
    }
    /**
     * Method to simulate train going. Initlizes a double corresponing to how much fuel it takes the train to 
     * "go" once. Depending on enigne type, the percent (independent of total max fuel input) of total fuel used each time the train goes 
     * is different. If the current fuel amount is less than the amount of fuel it takes to go, the 
     * method returns false, and alerts the user the train is out of fuel. If the train has 
     * enough fuel to keep going, the method "goes" by printing "choo choo!" and returns true. 
     * @return boolean indicating if the train "went"
     */
    public boolean go(){
        // lets have different engine effincies depending on engine type? 
        double fuel_to_go = 0; // initilizes fuel to go 
        if (this.fuelType == FuelType.ELECTRIC){ 
            fuel_to_go = 0.1 * this.maxFuel ; // go 10 times
         } 
        if (this.fuelType == FuelType.INTERNAL_COMBUSTION){ 
            fuel_to_go = 0.2 * this.maxFuel ; // go 5 times
         } 
        if (this.fuelType == FuelType.ELECTRIC){ 
            fuel_to_go = 0.05 * this.maxFuel ; // go 20 times
         } 
        else {
            fuel_to_go = 0.5 * this.maxFuel ; // go 2 times
        }

        if (this.currentFuel < fuel_to_go){ // makes sure enough fuel to go
            System.out.println("insufficient fuel! consider refueling");
            return false;
        } 
        else{
            System.out.println("choo choo!"); 
            this.currentFuel -= fuel_to_go; // subtracts go fuel 
            return true; // good to keep going 
        }
    }
    
     // accessors 
     /**
      * Fuel type accessor
      * @return returns fuel type (FuelType type)
      */
     public FuelType getFuelType(){
        return this.fuelType; 
     }
    /**
     * current fuel accessor
     * @return current fuel level (double)
     */
     public double getCurrentFuel(){
        return this.currentFuel; 
     }
     /**
      * accessor to get maximum fuel level
      * @return maximum fuel level (double)
      */
     public double getMaxFuel(){
        return this.maxFuel; 
     }

}

