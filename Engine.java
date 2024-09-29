public class Engine {

    public FuelType fuelType; // fueltype of class FuelType 
    double currentFuel; 
    double maxFuel; 

    public Engine(FuelType fuel_type, double maxfuel) { // other classes just need to read the Engine values, not change them, so private
        this.fuelType = fuel_type; 
        this.currentFuel = 0.; 
        this.maxFuel = maxfuel; 
    }

    public void refuel(){
        this.currentFuel = this.maxFuel; // resets current fuel level to max fuel , does not return anything
        System.out.println("Max fuel restored!");
    }
    
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
     public FuelType getFuelType(){
        return this.fuelType; 
     }

     public double getCurrentFuel(){
        return this.currentFuel; 
     }

     public double getMaxFuel(){
        return this.maxFuel; 
     }

}

