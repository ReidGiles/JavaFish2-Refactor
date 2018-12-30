package UserCode.movement;


/**
 * Write a description of class DiagonalSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DiagonalSwim implements IMovement
{
    double _x;
    double _y;
    double _initialSpeed;
    double _speedX;
    double _speedY;
    double _facingDirectionX;
    double _facingDirectionY;
    public DiagonalSwim(double pSpeed, int pFacingDirectionX, int pFacingDirectionY)
    {
        _initialSpeed = pSpeed;
        _facingDirectionX = pFacingDirectionX;
        _facingDirectionY = pFacingDirectionY;
        _speedX = _initialSpeed * _facingDirectionX;
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
