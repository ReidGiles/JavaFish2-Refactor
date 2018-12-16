package UserCode.pets;

/**
 * Abstract class HorizontalSwim - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class HorizontalSwim
{
    Pet _pet;
    int _facingDirectionX;
    public HorizontalSwim(Pet javaFish, int pFacingDirectionX)
    {
        _pet = javaFish;
        _facingDirectionX = pFacingDirectionX;
    }
    
    protected void movement(double _speed)
    {
        //_jFish.translate(_speed * _facingDirectionX,0);
        _pet.translate(_speed * _facingDirectionX,0);
        if (_pet.xBounce() == true)
        {
            _facingDirectionX *= -1;
            if (_facingDirectionX == 1)
            {
                _pet.rotate(0,270,0);
            }
            else _pet.rotate(0,90,0);
        }
    }
}
