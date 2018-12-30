package UserCode.movement;


/**
 * Write a description of class WaveSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WaveSwim implements IMovement
{
    private double _x;
    private double _y;
    private double _initialSpeed;
    private double _speedX;
    private double _speedY;
    private int _facingDirectionX;
    private int _facingDirectionY;
    private float _timeCounter;
    private double _rotationY;
    public WaveSwim(double pSpeed, int pFacingDirectionX, int pFacingDirectionY)
    {
        _initialSpeed = pSpeed;
        _facingDirectionX = pFacingDirectionX;
        _facingDirectionY = pFacingDirectionY;
        _speedX = _initialSpeed * _facingDirectionX;
        _speedY = _initialSpeed * _facingDirectionY;
        _rotationY = Math.cos(_timeCounter);
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
        // Speed of rotation:
        _timeCounter += 0.15F;           
        _rotationY = Math.cos(_timeCounter);
        // Length of rotation on y axis:
        _speedY = (float)_rotationY * 0.03;
        return _speedY;
    }
}