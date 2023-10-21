import java.util.*; 

/**
 * Write a description of class ComparadorDIstanciaTaxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorDistanciaTaxi implements Comparator<Taxi>
{
   public int compare (Taxi t1, Taxi t2) {
       if (t1.distanceToTheTargetLocation() > t2.distanceToTheTargetLocation()) {
           return 1;
       } else if (t1.distanceToTheTargetLocation() < t2.distanceToTheTargetLocation()) {
           return -1;
       } else {
           return t1.getName().compareTo(t2.getName());
       }
   }
}
