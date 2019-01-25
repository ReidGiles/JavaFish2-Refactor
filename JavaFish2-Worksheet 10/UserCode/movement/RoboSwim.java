package UserCode.movement;

import java.util.Random;

/**
 * Write a description of class RoboSwim here.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class RoboSwim implements IMovement
{
    // DECLARE a double to store object x value, call it '_x':
    private double _x;
    // DECLARE a double to store object y value, call it '_y':
    private double _y;
    // DECLARE a double to store intitial speed, call it '_initialSpeed':
    private double _initialSpeed;
    // DECLARE a double to store speedX, call it '_speedX':
    private double _speedX;
    // DECLARE a double to store speedY, call it '_speedY':
    private double _speedY;
    // DECLARE an int to store _facingDirectionX, call it '_facingDirectionX':
    private int _facingDirectionX;
    // DECLARE an int to store _facingDirectionY, call it '_facingDirectionY':
    private int _facingDirectionY;
    private int _randomInt;
    // DECLARE a Random to generate a random seed for calculating our fish speeds, call it '_rndGen':
    private Random _rndGen;
    /**
     * RoboSwim Constructor
     *
     * @param pSpeed Passed speed
     * @param pFacingDirectionX Passed facingDirectionX
     * @param pFacingDirectionY Passed facingDirectionY
     */
    public RoboSwim(double pSpeed, int pFacingDirectionX, int pFacingDirectionY)
    {
        // INITIALISE _initialSpeed:
        _initialSpeed = pSpeed;
        // INITIALISE _facingDirectionX:
        _facingDirectionX = pFacingDirectionX;
        // INITIALISE _facingDirectionY:
        _facingDirectionY = pFacingDirectionY;
        // INITIALISE _speedX:
        _speedX = 0;
        // INITIALISE _speedY:
        _speedY = _initialSpeed * _facingDirectionY;
        // INITIALISE _rndGen:
        _rndGen = new Random();
    }
    
    /**
     * Updates '_x' and '_y' with the x and y position of method caller
     * 
     * @param  pX   x position of method caller
     * @param  pY   y position of method caller
     */
    public void updateLocation(double pX, double pY)
    {
        _randomInt = _rndGen.nextInt(200);
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
        if (_x >= 9)
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
        switch (_randomInt)
        {
            case 1:
                // Fish Swims left:
                _facingDirectionX = -1;
                _speedX = _initialSpeed *= _facingDirectionX;
                _speedY = 0;
                break;
            case 2:
                // Fish Swims right:
                _facingDirectionX = 1;
                _speedX = _initialSpeed *= _facingDirectionX;
                _speedY = 0;
                break;
        }
        
        if (_x <= 1 || _x >= 9)
        {
            _facingDirectionX *= -1;
            _speedX *= _facingDirectionX;
        }
        return _speedX;
    }
    
    /**
     * Generates speed for the method caller
     *
     * @return     ?
     */
    public double updateY()
    {
        switch (_randomInt)
        {
            case 3:
                // Fish Swims up:
                _facingDirectionY = 1;
                _speedY = _initialSpeed *= _facingDirectionY;
                _speedX = 0;
                break;
            case 4:
                // Fish Swims down:
                _facingDirectionY = -1;
                _speedY = _initialSpeed *= _facingDirectionY;
                _speedX = 0;
                break;
        }
        
        if (_y <= 1 || _y >= 7)
        {
            _facingDirectionY *= -1;
            _speedY *= _facingDirectionY;
        }
        return _speedY;
    }
}
