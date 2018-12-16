package UserCode.pets;
import java.util.Random;

/**
 * Write a description of class RoboSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboSwim
{
    Pet _pet;
    int _facingDirectionX;
    int _facingDirectionY;
    String _xySwitch;
    int _randomInt;
    Random _rndGen;
    /**
     * Constructor for objects of class RoboSwim
     */
    public RoboSwim(Pet javaFish, int pFacingDirectionX, int pFacingDirectionY)
    {
        _pet = javaFish;
        _rndGen = new Random();
        _facingDirectionX = pFacingDirectionX;
        _facingDirectionY = pFacingDirectionY;
    }
    
    protected void movement(double _speed)
    {
        _randomInt = _rndGen.nextInt(300);
        if (_xySwitch == "X")
        {
            _pet.translate(_speed * _facingDirectionX,0);
        }
        if (_xySwitch == "Y")
        {
            _pet.translate(0,_speed * _facingDirectionY);
        }                
        if (_pet.xBounce() == true)
        {
            _facingDirectionX *= -1;
            if (_facingDirectionX == 1)
            {
                _pet.rotate(0,270,0);
            }
            else _pet.rotate(0,90,0);
        }
        if (_pet.yBounce() == true)
        {
            _facingDirectionY *= -1;
            if (_facingDirectionY == 1)
            {
                _pet.rotate(90,90,0);
            }
            else _pet.rotate(-90,90,0);
        }
        
        switch (_randomInt)
        {
            case 1:
                // Fish Swims up:
                _facingDirectionY = 1;
                // _xySwitch is set to "Y":
                _xySwitch = "Y";
                // Fish faces up:
                _pet.rotate(90,90,0);
                break;
            case 2:
                // Fish Swims down:
                _facingDirectionY = -1;
                // _xySwitch is set to "Y":
                _xySwitch = "Y";
                // Fish faces down:
                _pet.rotate(-90,90,0);
                break;
            case 3:
                // Fish Swims left:
                _facingDirectionX = -1;
                // _xySwitch is set to "X":
                _xySwitch = "X";
                // Fish faces left:
                _pet.rotate(0,90,0);
                break;
            case 4:
                // Fish Swims right:
                _facingDirectionX = 1;
                // _xySwitch is set to "X":
                _xySwitch = "X";
                // Fish faces right:
                _pet.rotate(0,270,0);
                break;
        }
    }
}
