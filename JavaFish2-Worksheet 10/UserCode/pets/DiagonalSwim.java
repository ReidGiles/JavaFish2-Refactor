package UserCode.pets;


/**
 * Write a description of class DiagonalSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DiagonalSwim
{
    Pet _pet;
    int _facingDirectionX;
    int _facingDirectionY;
    public DiagonalSwim(Pet javaFish, int pFacingDirectionX, int pFacingDirectionY)
    {
        _pet = javaFish;
        _facingDirectionX = pFacingDirectionX;
        _facingDirectionY = pFacingDirectionY;
    }
    
    protected void movement(double _speed)
    {
        //_jFish.translate(_speed * _facingDirectionX,0);
        _pet.translate(_speed * _facingDirectionX,0);
        _pet.translate(0,_speed * _facingDirectionY);
        if (_pet.xBounce() == true)
        {
            _facingDirectionX *= -1;
            if (_facingDirectionX == 1)
            {
                _pet.rotate(180,90,0);
            }
            else _pet.rotate(180,270,0);
        }
        if (_pet.yBounce() == true)
        {
            _facingDirectionY *= -1;
        }
    }
}
