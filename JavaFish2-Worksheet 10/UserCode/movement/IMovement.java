package UserCode.movement;


/**
 * Write a description of interface IMovement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IMovement
{
    // Receive x axis speed from the movement class:
    double updateX();
    // Receive y axis speed from the movement class:
    double updateY();
    // Give x a y location to the movement class:
    void updateLocation(double x, double y);
    // Determine if the display object has made contact with a screen border:
    int bounce();
}
