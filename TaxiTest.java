import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TaxiTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class TaxiTest
{
    private Taxi taxi;
    private Passenger passenger;
    private Location destination;
    private Location pickup;
    private Location taxiLocation;
    private TransportCompany company;
    //TODO
    //crear más campos (si es necesario) 
    /**
     * Default constructor for test class TaxiTest
     */
    public TaxiTest()
    {   
    }

    /**
     * Create a taxi.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        company = new TransportCompany("Compañía Taxis Cáceres");
        // Starting position for the taxi.
        taxiLocation = new Location(0, 0);
        // Locations for the passenger.
        pickup = new Location(1, 2);
        destination = new Location(5, 6);

        passenger = new Passenger(pickup, destination,"Kevin");
        taxi = new Taxi(company, taxiLocation,"T1");
        //TODO
        //Completar (si es necesario) este método
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        assertEquals(true, taxi.isFree());
    }

    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        //TODO implementar este método
        taxi.pickup(passenger);
        taxi.isFree();
    }
    
    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    @Test
    public void testOffload()
    {
        taxi.pickup(passenger);
        assertEquals (taxi.getPassenger(), passenger);
        taxi.offloadPassenger();
        assertTrue (taxi.getPassenger () == null);
        taxi.isFree();
    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    @Test
    public void testDelivery()
    {
        //TODO implementar este método
        taxi.setTargetLocation(passenger.getPickup());
        taxi.act();
        
    }
}

