import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class LocationTest
{
    Location startLocation;
    Location destination;
    
        Location destination1;
        Location destination2;
        Location destination3;
        Location destination4;
        Location destination5;
    //TODO
    //crear más campos (si es necesario) 

    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
        
        destination1 = new Location(4, 5);
        destination2 = new Location(5, 4);
        destination3 = new Location(3, 3);
        
        destination4 = new Location(3, 2);
        Location destination5 = new Location(2, 2);
        Location destination6 = new Location(2, 2);
        
        //TODO
        //Completar (si es necesario) este método
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test the distance method of the Location class.
     */
    @Test
    public void testDistance()
    {
        assertEquals(startLocation.distance(new Location(5, 7)), 5);
        assertEquals(startLocation.distance(destination), 1);
        //Utilizando otra aserción:
        assertTrue(startLocation.distance(destination) == 1);
    }
    
    /**
     * Run tests of the nextLocation method of the Location class.
     */
    @Test
    public void testAdjacentLocations()
    {
        startLocation.nextLocation(destination);
        assertEquals(startLocation.distance(destination), 1);
        
        startLocation.nextLocation(destination2);
        assertEquals(startLocation.distance(destination), 1);
        
        startLocation.nextLocation(destination3);
        assertEquals(startLocation.distance(destination), 1);
        
        
        //TODO implementar este método
        // Testear la adyacencia entre dos localizaciones. Se puede hacer 
        // utilizando llamada al método "nextLocation".

    }
}
