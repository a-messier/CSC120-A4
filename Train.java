import java.util.ArrayList;

public class Train {
    private Engine engine; // engine 
    private ArrayList<Car> cars; // cars attached  

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){

        this.engine = new Engine(fuelType, fuelCapacity); // new engine class
        this.cars = new ArrayList<>(); // initilizes cars array list
        for (int i = 0; i < nCars; i++) { // iterates over number of cars wanted, adds to car array 
            Car new_car = new Car(passengerCapacity); 
            this.cars.add(new_car); // adds cars with capacity passengerCapacity 
            
        }
    }

    // accessors 
    public Engine getEngine(){
        return this.engine; // returns engine type
    }

    public Car getCar(int i){
        return this.cars.get(i); // gets ith car 
    }

    public int getMaxCapacity(){
        int max_capacity = 0; 
        for(int i = 0; i < this.cars.size(); i++){
            max_capacity += getCar(i).getCapacity(); // adds car's max capacity to max capacity
        }
        return max_capacity; // returns total capacity of all cars 
    }

    public int seatsRemaining(){
        int remaining_seats = 0; 
        for(int i = 0; i < this.cars.size(); i++){
            remaining_seats += getCar(i).seatsRemaining(); // adds car's max capacity to max capacity
        }
        return remaining_seats; // returns total capacity of all cars 
    }

    public void printManifest(){
        for(int i = 0; i < this.cars.size(); i++){
            Car car = getCar(i); // gets car at index i in list 
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

       train.printManifest();


    }

}
