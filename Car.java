import java.util.ArrayList; // import the ArrayList class
/**
 * Class representing properties of a single car on a train. 
 * Attributes: 
 *  passengersAbord: ArrayList storing objects of class Passenger represeting the passengers currently on a car 
 *  maxCapacity: integer storing how many passengers can be on a car at any point 
 */
public class Car {

    public ArrayList<Passenger> passengersAbord; // want it to take a passenger object ?
    int maxCapacity; 

    /**
     * initilizes max capacity and an empty ArrayList to store passengers aboard car
     * @param max_capacity integer represetng max capacity of car
     */
    public Car(int max_capacity){
        this.maxCapacity = max_capacity; 
        this.passengersAbord = new ArrayList<>(); // how do I limit the size of this  
    }
    
    /**
     * acessor for cart maximum capacity
     * @return maximum capacity of a car
     */
    public int getCapacity(){
        return this.maxCapacity; 
    }
    /**
     * returns an integer representing how many seats are left on a cart 
     * number of seats left = maximum capacity - number of passengers already abord
     */
    public int seatsRemaining(){
        return this.maxCapacity - this.passengersAbord.size(); 
    }
    /**
     * method to add a passenger object to the car by adding the object to a car's passengersAbord ArrayList.
     * @param p: object of class Passenger to be added to the car 
     * @return boolean representing if the passenger was successfully added to the car
     */
    public boolean addPassenger(Passenger p){
        int seats_available = seatsRemaining(); // calls getter to check seats remaining 
        
        if (seats_available <= 0){ // if no space, return false 
            return false; 
        } 
        else{
            this.passengersAbord.add(p); // adds passenger to list 
            return true; // added passenger successfullt
        }
    }

    /**
     * method to remove a passenger object from a car by first checking if the passenger object is present in the 
     * car, and then removing the object from the car's passengersAbord ArrayList. 
     * @param p: object of class Pssenger to be removed from the car 
     * @return boolean representing if the passenger was successfully removed from the car.
     */
    public boolean removePassenger(Passenger p){
        if(this.passengersAbord.contains(p)){ // if passenger list contains the passenger in question, 
            this.passengersAbord.remove(p); // removes object 
            return true; // return true bc successful 
        }

        else{ // if passenger not on cart return false
            return false; 
        }
    }
    /**
     * Mehtod to print the names of every passenger on a car. 
     */
    public void printManifest(){
        for (int i=0; i<this.passengersAbord.size(); i++){ // iterate over passengers in list
            System.out.println(this.passengersAbord.get(i).name); // prints passenger 
        }
    }

}