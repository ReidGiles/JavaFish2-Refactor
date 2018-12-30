package UserCode.pets;

import Framework.DisplayObject;
import java.util.Random;


/**
 * Pet is the parent class of all fish classes, it must contain all the common characteristics (fields, methods) required by
 * it's fish children to perform their required functionality.
 * 
 * @author Reid Giles 
 * @version 09/11/2018
 */
public abstract class Pet extends DisplayObject implements IPet
{
    // Instance variables
    // DECLARE a int to hold the horizontal fish direction, call it '_facingDirectionX':
    protected int _facingDirectionX;
    // DECLARE a int to hold the vertical fish direction, call it '_facingDirectionY':
    protected int _facingDirectionY;
    // DECLARE a double to hold the swim speed, call it '_speed':
    protected double _speed;
    // DECLARE a double to hold the y axis swim speed (used in fishySwim() to create oscillating swim behaviour, call it '_speedY':
    protected double _speedY;
    // DECLARE a float to control the oscillation speed within the fishySwim() method, call it '_timeCounter':
    protected float _timeCounter;
    // DECLARE a double to control oscillation on the y axis, call it '_rotationY':
    protected double _rotationY = Math.cos(_timeCounter);
    // DECLARE a String hold the movement state in snakeySwim(), call it '_xySwitch':
    protected String _xySwitch;
    // DECLARE a int to hold numbers generated using Random(), call it '_randomInt':
    protected int _randomInt;
    // DECLARE a double to store our random speed lower bound, call it "_randomLow":
    private double _randomLow;
    // DECLARE a double to store our random speed upper bounder, call it "_randomHigh":
    private double _randomHigh;
    // DECLARE a Random, call it '_rndGen':
    protected Random _rndGen;
    /**
     * Constructor for objects of class Pet
     */
    public Pet(String model, String tex, double scale)
    {
        super(model, tex, scale);
        // Initialise instance variables
        // Initialise _rndGen:
        _rndGen = new Random();
    }
    
    protected abstract void movement();
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  dx   a sample parameter for a method
     * @return
     */
    protected void translate(double dx, double dy, double dz)
    {
        this.x += dx;
        this.y += dy;
        this.z = dz;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  dx   a sample parameter for a method
     * @return
     */
    protected void translate(double dx, double dy)
    {
        translate(dx,dy,1);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  dx   a sample parameter for a method
     * @return
     */
    protected void rotate(double dx, double dy, double dz)
    {
        this.rotateX = dx;
        this.rotateY = dy;
        this.rotateZ = dz;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  dx   a sample parameter for a method
     * @return
     */
    protected void rotate(double dx, double dy)
    {
        rotate(dx,dy,0);
    }
    
    
    /**
     * METHOD: Return a random number between two doubles, used to randomize fish speed on startup.
     *
     * @return     a random number between the variables doubles "low" and "high"
     */
    protected double random()
    {
        // SET _randomLow to 0.005:
        _randomLow = 0.005;
        // SET _randomHigh to 0.05:
        _randomHigh = 0.05;
        // SET speed to a random number between _randomHigh and _randomLow.:
        _speed = _randomLow + (_randomHigh - _randomLow) * _rndGen.nextDouble();
        // Return _speed:
        return _speed;
    }
}