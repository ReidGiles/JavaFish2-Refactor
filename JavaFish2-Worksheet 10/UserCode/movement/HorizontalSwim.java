package UserCode.movement;

/**
 * Abstract class HorizontalSwim - write a description of the class here
 *
 * @author Reid Giles
 * @version 20/12/2018
 */
public class HorizontalSwim implements IMovement
{
    double _x;
    double _y;
    double _speed = 0.005;
    double _facingDirectionX;
    public HorizontalSwim(double pSpeed, int pFacingDirectionX)
    {
        _speed = pSpeed;
        _facingDirectionX = pFacingDirectionX;
    }
    
    /**
     * Updates '_x' and '_y' with the x and y position of method caller
     * 
     * @param  pX   x position of method caller
     * @param  pY   y position of method caller
     */
    public void updateLocation(double pX, double pY)
    {
        _x = pX;
        _y = pY;
    }
    
    /**
     * Generates speed for the method caller
     *
     * @return     ?
     */
    public double update()
    {
        _speed *= _facingDirectionX;
        return _speed;
    }
}