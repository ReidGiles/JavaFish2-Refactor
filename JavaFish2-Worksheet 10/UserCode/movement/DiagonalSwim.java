package UserCode.movement;


/**
 * Write a description of class DiagonalSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DiagonalSwim
{
    double _x;
    double _y;
    double _initialSpeed;
    double _speed;
    double _facingDirectionX;
    double _facingDirectionY;
    public DiagonalSwim(double pSpeed, int pFacingDirectionX)
    {
        _initialSpeed = pSpeed;
        _facingDirectionX = pFacingDirectionX;
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
        else if (_y <= 1)
        {
            return 3;
        }
        else if (_y >= 9)
        {
            return 4;
        }
        else return 0;
    }
    

    /**
     * Generates speed for the method caller
     *
     * @return     ?
     */
    public double update()
    {
        if (_x <= 1 || _x >= 9)
        {
            _facingDirectionX *= -1;
            _speed *= _facingDirectionX;
        }
        if (_y <= 1 || _y >= 9)
        {
            _facingDirectionY *= -1;
        }
        return _speed;
    }
}
