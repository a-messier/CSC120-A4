public class Passenger {
    
    public String name;

    public Passenger(String name) {
        this.name = name;
    }

    public boolean boardCar(Car c){
        boolean if_added = c.addPassenger(this); // boards car?
        if (if_added){ // if true
            System.out.println("Passenger " + this.name + " has boarded car");
        }
        else{
            System.out.println("Car full! Try another cart, " + this.name);
        }
        return if_added; // gives true/false if passenger has been added to car 
    }

    public boolean getOffCar(Car c){
        boolean if_removed = c.removePassenger(this); 
        if (if_removed){
            System.out.println("Passenger " + this.name + " has gotten off the car");
        }
        else{
            System.out.println("Passenger " + this.name + " not found on car!");
        }
        return if_removed; 
    }

}
