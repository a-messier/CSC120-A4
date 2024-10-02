import java.util.ArrayList;


/**
 * Class interfacing Engine, Car, and Passenger classes to build a train with a 
 * certain engine type and multiple cars that passengers can board and get off of. 
 * Attributes: 
 *  engine: of type Engine representing fuel type 
 *  cars: ArrayList to hold multiple objects of class Car on the train 
 */
public class Train {
    private Engine engine; // engine 
    private ArrayList<Car> cars; // cars attached  

    /**
     * Constructor setting up attributes of Train class
     * @param fuelType of type FuelType representing the fuel type of the train's engine 
     * @param fuelCapacity of type double representing the maximum fuel capacity of the train's engine
     * @param nCars integer number of cars to be added to the train (placed in the cars ArrayList)
     * @param passengerCapacity integer maximum number of passengers that can be on any one car
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){

        this.engine = new Engine(fuelType, fuelCapacity); // new engine class
        this.cars = new ArrayList<>(); // initilizes cars array list
        for (int i = 0; i < nCars; i++) { // iterates over number of cars wanted, adds to car array 
            Car new_car = new Car(passengerCapacity); 
            this.cars.add(new_car); // adds cars with capacity passengerCapacity 
            
        }
    }

    /**
     * Accessor for engine type
     * @return type of engine assigned to train 
     */
    public Engine getEngine(){
        return this.engine; // returns engine type
    }
    /**
     * Accessor for getting a car at index i in the Train's cars ArrayList 
     * @param i integer representing index requested car is at in the Train's ArrayList
     * @return Car object located at index i in cars ArrayList
     */
    public Car getCar(int i){
        return this.cars.get(i); // gets ith car 
    }

    /**
     * Calculates maximum capacity of entire train by summing max capacity of all cars on train.
     * @return integer representing sum of capacities of all cars present in Train's cars ArrayList.
     */
    public int getMaxCapacity(){
        int max_capacity = 0;  // initilizes max capacity at 0 
        for(int i = 0; i < this.cars.size(); i++){ // iterates over cars on train 
            max_capacity += getCar(i).getCapacity(); // adds a single car's max capacity to max capacity
        }
        return max_capacity; // returns total capacity of all cars 
    }

    /**
     * Calculates number of seats remaining on the entire train by summing the remaining seats on all cars on the train. 
     * @return integer representing number of seats left on entire train 
     */
    public int seatsRemaining(){
        int remaining_seats = 0; // initializes number of seats left to 0 
        for(int i = 0; i < this.cars.size(); i++){ // iterates over all cars on the train
            remaining_seats += getCar(i).seatsRemaining(); // adds current car's current capacity to total current capacity
        }
        return remaining_seats; // returns total remaining seats of all cars 
    }

    /**
     * Prints the names of passengers on all cars on the train by iterating over 
     * each car on the train and printing the names of the passengers on that train 
     */
    public void printManifest(){
        for(int i = 0; i < this.cars.size(); i++){ // iterates over all cars on the train
            Car car = getCar(i); // gets car at index i in list 
            System.out.println("Car " + i + ": "); // prints current car index 
            car.printManifest(); // prints manifest for car 
        }
    }

// main to test all fucntions 
    public static void main(String[] args) {
        // train story to test everything~
        // creates train !
        Train train = new Train(FuelType.ELECTRIC, 10, 3, 2); 

        System.out.println("A(n) " + train.getEngine().fuelType + " train has arrived at the station!");
        System.out.println(""); // print space so looks nice 

         // checks total capacity of train 
         System.out.println("Checking max capacity....");
         int max_capacity = train.getMaxCapacity(); 
         System.out.println("Total capacity on train: " + max_capacity);
         System.out.println(""); // print space so looks nice 

        // adds some passengers to the train 
        Car car2 = train.getCar(1); // gets 2nd car 
        Passenger Pat = new Passenger("Pat");  // two passengers
        Passenger Sara = new Passenger("Sara");  // ""
        Pat.boardCar(car2); 
        Sara.boardCar(car2); 

        System.out.println("");

        System.out.println("Passengers on car 2: ");
        car2.printManifest(); 

        // checks how many seats left on car2
        int seatsleft_2 = car2.seatsRemaining(); 
        System.out.println("");
        System.out.println("Seats remaining in cart 2: "+ seatsleft_2);
        System.out.println(""); // print space so looks nice 

        // tries to add passenger to car 2 -> should say full! 
        Passenger Ash = new Passenger("Ash"); 
        Ash.boardCar(car2); 

        Car car3 = train.getCar(2); // ok lets get on a different car
        Ash.boardCar(car3); // puts Ash on different car 

        System.out.println("");
        System.out.println("All passengers account for?");

        train.printManifest(); // prints all passengers 
        System.out.println("");

        System.out.println("Leaving station!");

        // goes 
        Engine train_engine = train.getEngine();
        train_engine.refuel();
        while (train_engine.go()) { // runs untill empty 
        }
       
       System.out.println("Arriving at next station... depart train!");
       System.out.println("");

       Ash.getOffCar(car3); // all passengers get off the car 
       Sara.getOffCar(car2); 
       Pat.getOffCar(car2); 

       System.out.println("");
       System.out.println("Train should be empty... anyone still aboard?");

       train.printManifest(); // makes sure nobody is still on the train


    }

}
