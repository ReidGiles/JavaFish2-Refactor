package UserCode.movement;

import java.util.Random;

/**
 * Write a description of class RoboSwim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoboSwim implements IMovement
{
    private double _x;
    private double _y;
    private double _initialSpeed;
    private double _speedX;
    private double _speedY;
    private int _facingDirectionX;
    private int _facingDirectionY;
    private int _randomInt;
    private Random _rndGen;
    public RoboSwim(double pSpeed, int pFacingDirectionX, int pFacingDirectionY)
    {
        _initialSpeed = pSpeed;
        _facingDirectionX = pFacingDirectionX;
        _facingDirectionY = pFacingDirectionY;
        _speedX = 0;
        _speedY = _initialSpeed * _facingDirectionY;
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
                System.out.println(_speedY);
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
