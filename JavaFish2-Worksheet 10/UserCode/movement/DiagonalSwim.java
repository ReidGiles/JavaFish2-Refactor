package UserCode.movement;


/**
 * Write a description of class DiagonalSwim here.
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public class DiagonalSwim implements IMovement
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
    /**
     * DiagonalSwim Constructor
     *
     * @param pSpeed Passed speed
     * @param pFacingDirectionX Passed facingDirectionX
     * @param pFacingDirectionY Passed facingDirectionY
     */
    public DiagonalSwim(double pSpeed, int pFacingDirectionX, int pFacingDirectionY)
    {
        // INITIALISE _initialSpeed:
        _initialSpeed = pSpeed;
        // INITIALISE _facingDirectionX:
        _facingDirectionX = pFacingDirectionX;
        // INITIALISE _facingDirectionY:
        _facingDirectionY = pFacingDirectionY;
        // INITIALISE _speedX;
        _speedX = _initialSpeed * _facingDirectionX;
        // INITIALISE _speedY:
        _speedY = _initialSpeed * _facingDirectionY;
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
        if (_y <= 1 || _y >= 7)
        {
            _facingDirectionY *= -1;
            _speedY *= _facingDirectionY;
        }
        return _speedY;
    }
}
