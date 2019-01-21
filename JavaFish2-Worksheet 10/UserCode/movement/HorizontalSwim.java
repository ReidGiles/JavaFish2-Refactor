package UserCode.movement;
import UserCode.UserException.*;

/**
 * Abstract class HorizontalSwim - write a description of the class here
 *
 * @author Reid Giles
 * @version 20/12/2018
 */
public class HorizontalSwim implements IMovement
{
    private double _x;
    private double _y;
    private double _initialSpeed;
    private double _speed;
    private int _facingDirectionX;
    public HorizontalSwim(double pSpeed, int pFacingDirectionX) throws ArgumentOutOfBoundsException
    {
        if (pSpeed > 0.005 && pSpeed < 0.05)
        {
            _initialSpeed = pSpeed;
        }
        else
        {
            throw new ArgumentOutOfBoundsException("speed parameter must be within range: 0.005 < pSpeed < 0.05");
        }
        if (pFacingDirectionX == 1 || pFacingDirectionX == -1)
        {
            _facingDirectionX = pFacingDirectionX;
        }
        else
        {
            throw new ArgumentOutOfBoundsException("_facingDirectionX parameter must be within range: 1 || -1");
        }
        _speed = _initialSpeed * _facingDirectionX;
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
    
    public int bounce()
    {
        if (_x <= 1)
        {
            return 1;
        }
        else if (_x >= 9)
        {
            return 2;
        }
        else return 0;
    }
    

    /**
     * Generates speed for the method caller
     *
     * @return     ?
     */
    public double updateX()
    {
        if (_x <= 1 || _x >= 9)
        {
            _facingDirectionX *= -1;
            _speed *= _facingDirectionX;
        }
        return _speed;
    }
    
    /**
     * Generates speed for the method caller
     *
     * @return     ?
     */
    public double updateY()
    {
        return 0;
    }
}