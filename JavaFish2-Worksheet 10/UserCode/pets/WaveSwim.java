
package UserCode.pets;

/**
 * Write a description of class WaveSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WaveSwim
{
    Pet _pet;
    int _facingDirectionX;
    int _facingDirectionY;
    float _timeCounter;
    double _rotationY;
    double _speedY;
    /**
     * Constructor for objects of class WaveSwim
     */
    public WaveSwim(Pet javaFish, int pFacingDirectionX, int pFacingDirectionY)
    {
        _pet = javaFish;
        _facingDirectionX = pFacingDirectionX;
        _facingDirectionY = pFacingDirectionY;
        _rotationY = Math.cos(_timeCounter);
    }
    
    protected void movement(double _speed)
    {
        // Speed of rotation:
        _timeCounter += 0.15F;           
        _rotationY = Math.cos(_timeCounter);
        // Length of rotation on y axis:
        _speedY = (float)_rotationY * 0.03; 
        /* IF _facingDirectionX is equal to -1, fish moves left along the x-axis at the rate of "_speed"
         * IF _facingDirectionX is equal to 1, fish moves right along the x-axis at the rate of "_speed":
        */
        _pet.translate(_speed * _facingDirectionX,0);
        _pet.translate(0,_speedY * _facingDirectionY);
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
