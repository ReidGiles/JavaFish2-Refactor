package UserCode.movement;
import UserCode.UserException.*;

/**
 * HorizontalSwim is a movement behaviour that can be use
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public class HorizontalSwim implements IMovement
{
    // DECLARE a double to store object x value, call it '_x':
    private double _x;
    // DECLARE a double to store object y value, call it '_y':
    private double _y;
    // DECLARE a double to store intitial speed, call it '_initialSpeed':
    private double _initialSpeed;
    // DECLARE a double to store speed, call it '_speed':
    private double _speed;
    // DECLARE an int to store _facingDirectionX, call it '_facingDirectionX':
    private int _facingDirectionX;
    /**
     * HorizontalSwim Constructor
     *
     * @param pSpeed Passed speed
     * @param pFacingDirectionX Passed facingDirectionX
     */
    public HorizontalSwim(double pSpeed, int pFacingDirectionX) throws ArgumentOutOfBoundsException
    {
        // IF pSpeed is within legal range, initialise _initialSpeed to pSpeed:
        if (pSpeed > 0.005 && pSpeed < 0.05)
        {
            _initialSpeed = pSpeed;
        }
        // ELSE throw an ArgumentOutOfBoundsException exception:
        else
        {
            throw new ArgumentOutOfBoundsException("speed parameter must be within range: 0.005 < pSpeed < 0.05");
        }
        // IF pFacingDirectionX is within legal range, initialise _facingDirectionX to pFacingDirectionX:
        if (pFacingDirectionX == 1 || pFacingDirectionX == -1)
        {
            _facingDirectionX = pFacingDirectionX;
        }
        // ELSE throw an ArgumentOutOfBoundsException exception:
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
    
    /**
     * METHOD: Notifies the caller when it leaves the aquarium boundries.
     *
     * @return An int that corrosponds with the boundry that was collided with
     */
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