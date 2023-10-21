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
    Location location1;
    
    
    
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
        location1 = new Location(5, 3);
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
        assertEquals(destination.distance(startLocation), 0);
        
        
        startLocation.nextLocation(location1);
        assertEquals(startLocation.distance(location1), 2);
        
        startLocation.nextLocation(location1);
        assertEquals(startLocation.distance(location1), 1);
        
        startLocation.nextLocation(location1);
        assertEquals(startLocation.distance(location1), 0);
        
        startLocation.nextLocation(location1);
        assertEquals(startLocation.distance(location1), 0);
            
        //TODO implementar este método
        // Testear la adyacencia entre dos localizaciones. Se puede hacer 
        // utilizando llamada al método "nextLocation".

    }


    @Test
    public void testGetX()
    {
        assertEquals(5, location1.getX());
        assertEquals(2, destination.getX());
        assertEquals(1, startLocation.getX());
    }

    @Test
    public void testGetY()
    {
        assertEquals(3, location1.getY());
        assertEquals(2, destination.getY());
        assertEquals(2, startLocation.getY());
    }

    @Test
    public void testSetX()
    {
        location1.setX(6);
        assertEquals(6, location1.getX());
        destination.setX(1);
        assertEquals(1, destination.getX());
        startLocation.setX(3);
        assertEquals(3, startLocation.getX());
    }

    @Test
    public void testSetY()
    {
        location1.setY(1);
        assertEquals(1, location1.getY());
        destination.setY(4);
        assertEquals(4, destination.getY());
        startLocation.setY(7);
        assertEquals(7, startLocation.getY());
    }
}
