import java.util.ArrayList; // import the ArrayList class

public class Car {

    public ArrayList<Passenger> passengersAbord; // want it to take a passenger object ?
    int maxCapacity; 

    public Car(int max_capacity){
        this.maxCapacity = max_capacity; 
        this.passengersAbord = new ArrayList<>(); // how do I limit the size of this  
    }
    
    //accessors 
    public int getCapacity(){
        return this.maxCapacity; 
    }

    public int seatsRemaining(){
        return this.maxCapacity - this.passengersAbord.size(); 
    }

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

    public boolean removePassenger(Passenger p){
        if(this.passengersAbord.contains(p)){ // if passenger list contains the passenger in question, 
            this.passengersAbord.remove(p); // removes object 
            return true; // return true bc successful 
        }

        else{ // if passenger not on cart return false
            return false; 
        }
    }

    public void printManifest(){
        for (int i=0; i<this.passengersAbord.size(); i++){ // iterate over passengers in list
            System.out.println(this.passengersAbord.get(i).name); // prints passenger 
        }
    }

}