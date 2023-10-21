/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Taxi 
{
    // The Taxi Company of this Taxi.
    private TransportCompany company;
    // Where the vehicle is.
    private Location location;     
    // Where the vehicle is headed.
    private  Location targetLocation;
    // Record how often the vehicle has nothing to do.
    private int idleCount;       
    //Name of the taxi.
    private String name; 
    //Taxi's passenger.
    private Passenger passenger;
    //Number of passengers trasported by the taxi.
    private int passengersTransported;

    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Taxi(TransportCompany company, Location location, String name)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.company = company;
        this.location = location;
        targetLocation = null;
        idleCount = 0;
        this.name = name;
        passenger = null;
        passengersTransported = 0;
        //TODO resto de inicializaciones pendientes
    }

    /**
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the name of the taxi
     * @param name Name del taxi.
     */
    public void setName( String name ){
        
        this.name = name;
    }
    
    /**
     * Get the location.
     * @return Where this taxi is currently located.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

     /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }
    
    /**
     * Has the vehicle a target Location?
     * @return Whether or not this vehicle has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }
    
    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }
    
    /**
     * Set how many steps this vehicle has been idle
     * @param pasoVacio Steps this vehicle has been idle.
     */
    public void setIdleCount(int pasoVacio)
    {
        this.idleCount = idleCount;
    }    
    
    /**
     * @return on how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }

    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Set the current passenger of the vehicle
     * @param passenger Passenger of the vehicle
     * @throws NullPointerException If location is null.
     */
    public void setPassenger (Passenger passenger){
        
        if(passenger != null) {
            this.passenger = passenger;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * @return the current passenger of the vehicle
     */
    public Passenger getPassenger (){
        
        return passenger;
    }    
    
    
    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    /*
    public String toString()
    {
        return getClass().getName() + " " +getName()+" at " + getLocation();
    }
    */
   
    public String toString()
    {
        return "Taxi " + this.getName() + " at location " + this.getLocation().getX() + "," + this.getLocation().getY()
        + " - passengers transported: " + this.passengersTransported() + " - non active for: " + this.getIdleCount() + " times.";
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        
        //TODO  implementar este método
        if( getPassenger() == null)
        return true;
        return false;
    }

    /**
     * Set the current company of the vehicle
     * @param company Company of the vehicle
     * @throws NullPointerException If location is null.
     */
    public void setCompany(TransportCompany company){
        
        if(company != null) {
            this.company = company;
        }
        else {
            throw new NullPointerException();
        }
    }    
    
    /**
     * @return the company associated with the vehicle.
     */
    public TransportCompany getCompany(){
        return company;
    }
    
    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        //TODO  implementar este método
        this.getCompany().arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at a passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
        //TODO  implementar este método
        this.company.arrivedAtDestination(this, passenger);
    }
    
    /**
     * Receive a passenger.
     * Set passenger's destination as its target location.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
        //TODO  implementar este método
        setPassenger(passenger);
        setTargetLocation(passenger.getDestination());
        passenger.setTaxiName(name);
    }

    /**
     * Offload the passenger.
     */
    public void offloadPassenger()
    {
        //TODO  implementar este método
        passenger = null;
        this.clearTargetLocation();
    }

    /**
     * @return how many passengers this vehicle has transported.
     */
    public int passengersTransported()
    {
        //TODO  implementar este método
        return passengersTransported;
    }
    
    /**
     * Increment the number of passengers this vehicle has transported.
     */
    protected void incrementPassengersTransported()
    {
        //TODO  implementar este método
        passengersTransported++;
    }

    /**
     * Get the distance to the target location from the current location.
     * @param distance Distance between the target and the vehicle
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        //TODO  implementar este método
        Location distance;
        distance = this.getLocation();

        return distance.distance(this.getTargetLocation());

    }

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        //TODO  implementar este método
        if(this.getTargetLocation() == null){
            incrementIdleCount(); 
        }else{
            if(this.getLocation().distance(this.getTargetLocation()) == 1){
                this.notifyPickupArrival();
            }else if(this.getLocation() == this.getTargetLocation() && this.isFree() == false){
                this.notifyPassengerArrival(passenger);
                this.offloadPassenger();
                this.incrementPassengersTransported();
            }else{
                this.setLocation(this.getLocation().nextLocation(this.getTargetLocation()));
            }
        }
    }
    
     /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String showFinalInfo()
    {
        //TODO  implementar este método
        /*
        System.out.println("Taxi " + this.getName() + " at location " + this.getLocation().getX() + "," + this.getLocation().getY()
        + " - passengers transported: " + this.passengersTransported() + " - non active for: " + this.getIdleCount() + " times.");
        */
        return toString();
    }

}
