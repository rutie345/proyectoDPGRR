import java.util.*;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */

public class TransportCompany {
   
    private String name;  //name of the company
    private List <Taxi> vehicles; //list of the vehicles of the company
    private List <Passenger> passengers; //list of the passengers of the company
    private List <Passenger> assingments; //list of the passengers assigned to a taxi
    
    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany (String name) {
        
        this.name = name;
        vehicles = new ArrayList <Taxi> ();
        passengers = new ArrayList <Passenger> ();
        assingments = new ArrayList <Passenger> ();

    }

    /**
     * @return The name of the company.
     */
    public String getName() {
        return name;
    }
    
    /**
     * A vehicle has arrived at a passenger's destination.
     * @param vehicle The vehicle at the destination.
     * @param passenger The passenger being dropped off.
     */
    public void arrivedAtDestination(Taxi vehicle,
    Passenger passenger) {
        System.out.println (vehicle + " offloads " + passenger);
    }

    /**
     * @return The list of vehicles.
     */
    public List <Taxi> getVehicles () {       
        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List <Passenger> getPassengers () {
        return passengers;
    }

    /**
     * Adds a new vehicle to the list of vehicles
     * @param Add the new Vehicle.
     */
    public void addVehicle (Taxi vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger (Passenger passenger) {
       passengers.add(passenger);   
    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    public Taxi scheduleVehicle(Location location) { 
        
        /*
        Taxi aux = null;
        Taxi taxiMasCercano = null;
        int i;
        boolean encontrado = false;
        
        for (i = 0; i < vehicles.size() && !encontrado; i++) {
            if (vehicles.get(i).isFree()) {
                taxiMasCercano = vehicles.get(i);
                encontrado = true;
            }
        }
        
        if (encontrado) {
            for (i = i + 1; i < vehicles.size(); i++) {
                aux = vehicles.get(i); 
                if ((aux.getLocation().distance(location) < 
                    taxiMasCercano.getLocation().distance(location)) &&
                    aux.isFree()) {
                    taxiMasCercano = aux;
                }
            }
        }
        */
        Iterator <Taxi> it = vehicles.iterator();
        
        while (it.hasNext()) {
            Taxi t = it.next();
            t.setPickupLocation(location);
        }
        Collections.sort(vehicles, new ComparadorDistanciaTaxi ());
        
        Iterator <Taxi> it2 = vehicles.iterator();
        Taxi taxiMasCercano = null;
        
        while (it2.hasNext()) {
            Taxi t = it.next();
            if (t.isFree()) {
                taxiMasCercano = t;
            }
        }
        
        Iterator <Taxi> it3 = vehicles.iterator();
        while(it3.hasNext()) {
            Taxi t = it3.next();
            if (!t.isFree()) {
                t.setPickupLocation(t.getPassenger().getPickup());
            }
        }
        
        return taxiMasCercano;
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        boolean pickupCorrecto = true;
        Taxi taxiAsignado = scheduleVehicle (passenger.getPickup());
        
        if (taxiAsignado != null) {
            taxiAsignado.setPickupLocation (passenger.getPickup());
            assingments.add (passenger);
            taxiAsignado.setPassenger(passenger);
            passenger.setTaxiName(taxiAsignado.getName());
        } else {
            pickupCorrecto = false;
        }
        
        return pickupCorrecto;
    }

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
        Iterator <Passenger> it = assingments.iterator();
        boolean encontrado = false;
        Passenger p = null;
        
        while (it.hasNext() && !encontrado) {
            p = it.next();
            if (p.getTaxiName().equals(taxi.getName())) {
                it.remove();
                encontrado = true;
            }
        }
        
        taxi.pickup(p);
        
        System.out.println("<<<< "+taxi + " picks up " + taxi.getPassenger().getName());
        
    }
    
        /**
     * A vehicle has arrived at a passengers destination.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtDestination(Taxi taxi)
    {
        System.out.println("<<<< "+taxi + " picks up " + taxi.getPassenger().getName());
        
    }

}