import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PassengerTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class PassengerTest
{
    
    private Passenger passenger;
    
    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
       passenger = new Passenger (new Location (3, 4), new Location (5, 6), "Peter");
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
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {
        assertTrue(passenger.getName().equals("Peter"));
        assertEquals (passenger.getPickup(), (new Location (3, 4)));
        assertEquals (passenger.getDestination(), new Location (5, 6));
        assertTrue (passenger.getTaxiName () == null);
    }

    /**
     * Test of the getTaxiName method.
     * Ensure that this method gets and returns the name of the taxi correctly.
     */
    @Test
    public void testGetTaxiName()
    {
        passenger.setTaxiName("BMW");
        assertEquals (passenger.getTaxiName (), "BMW"); 
    }

    /**
     * Test of the getPickupLocation method.
     * Ensure that this method gets and returns the pickup location correctly.
     */
    @Test
    public void testGetPickupLocation ()
    {
        assertEquals (passenger.getPickup(), new Location (3, 4));
    }
}
