/**
 * Class representing attributes of a passenger interacting with the 
 * Train class. 
 * Attributes 
 *  name : string representing a passenger's name
 */

public class Passenger {
    
    public String name;
    /**
     * Initilizes passenger's name
     * @param name user specified name = passenger's name 
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Method to add a passenger to a car 
     * @param c object of class Car representing the car object a passenger will be added to.
     * @return boolean that is true if the passenger was sucessfully added to the car, false if not
     */
    public boolean boardCar(Car c){
        boolean if_added = c.addPassenger(this); // takes boolean output from add passenger from the car class.
        if (if_added){ // if added successfully
            System.out.println("Passenger " + this.name + " has boarded car"); // prints a helpful message to let user know adding passenger was successful
        }
        else{ // if passenger was not added successfully 
            System.out.println("Car full! Try another cart, " + this.name); // car has too many seats taken, prints message telling user that
        }
        return if_added; // gives true/false if passenger has been added to car 
    }

    /**
     * method to remove a passenger from a car 
     * @param c car object passenger is to be removed from 
     * @return boolean true if successfully removed, false if the passenger is still on the car. 
     */
    public boolean getOffCar(Car c){
        boolean if_removed = c.removePassenger(this);  // checks if passenger can be removed from the car 
        if (if_removed){ // if successfully removed,
            System.out.println("Passenger " + this.name + " has gotten off the car"); // let the user know the passenger has been removed from the car 
        }
        else{ // if passenger not successfully removed
            System.out.println("Passenger " + this.name + " not found on car!"); // must be because passenger is not on the car, so lets user know
        }
        return if_removed;  
    }

}
