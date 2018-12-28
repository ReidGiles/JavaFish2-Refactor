package UserCode.movement;


/**
 * Write a description of interface IMovement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IMovement
{
    double update();
    void updateLocation(double x, double y);
    int bounce();
}
