/**
 * Model a location in a city.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
import java.lang.Math;

public class Location
{
    private int x;  //TODO cambiar a private
    private int y;  //TODO cambiar a private

    /**
     * Model a location in the city.
     * @param x The x coordinate. Must be positive.
     * @param y The y coordinate. Must be positive.
     * @throws IllegalArgumentException If a coordinate is negative.
     */
    public Location(int x, int y)
    {
        if(x < 0) {
            throw new IllegalArgumentException(
                "Negative x-coordinate: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException(
                "Negative y-coordinate: " + y);
        }        
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return The y coordinate.
     */
    public int getY()
    {    
        return y;
    }
    
    /**
     * set the X coordinate
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * set the Y coordinate
     */
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * Generate the next location to visit in order to
     * reach the destination.
     * @param destination Where we want to get to.
     * @return A location in a direct line from this to
     *         destination.
     */
    public Location nextLocation(Location destination)
    {
        int valueX;
        int valueY;
        
        if(!equals(destination)){
            valueX = destination.getX();
            valueY = destination.getY();
            
            if(valueX == this.x){
                if(valueY < this.y){
                    destination.setX(this.y - 1);
                }
                if(valueY > this.y){
                    destination.setX(this.y + 1);
                }
            }
            else if(valueX > this.x){
                if(valueY > this.y){
                    destination.setX(this.x + 1);
                    destination.setY(this.y + 1);
                }
                if(valueY < this.y){
                    destination.setX(this.x + 1);
                    destination.setY(this.y - 1);
                }
            }
            else{
                if(valueY < this.y){
                    destination.setX(this.x - 1);
                    destination.setY(this.y - 1);
                }
                if(valueY > this.y){
                    destination.setX(this.x - 1);
                    destination.setY(this.y + 1);
                }
            }
            
        }
        return destination;
    }
    
    /**
     * Determine the number of movements required to get
     * from here to the destination.
     * @param destination The required destination.
     * @return the number of movement steps.
     */
    public int distance(Location destination)
    {
        int valueX;
        int valueY;
        
        valueX = 0;
        valueY = 0;
        
        //Restamos para obtener distancia
        valueX = destination.getX() - this.x;
        valueY = destination.getY() - this.y;
        
        //sacamos valor 
        valueX = Math.abs(valueX);    
        valueY = Math.abs(valueY);
        
        if(valueX > valueY) {
        
            return valueX;
        } else{
            
            return valueY;
        }
    }
    

    /**
     * Implement content equality for locations.
     * @return true if this location matches the other, false otherwise.
     */
    public boolean equals(Object other)
    {
        if(other instanceof Location) {
            Location otherLocation = (Location) other;
            return x == otherLocation.getX() &&
            y == otherLocation.getY();
        }
        else {
            return false;
        }
    }

    /**
     * @return A representation of the location.
     */
    public String toString()
    {
        return "location " + x + "," + y;
    }

    /**
     * Use the top 16 bits for the y value and the bottom for the x.
     * Except for very big grids, this should give a unique hash code
     * for each (x, y) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (y << 16) + x;
    }
}
