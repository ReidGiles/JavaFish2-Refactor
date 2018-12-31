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
    // DECLARE a double array to hold the start location, call it '_startLocation':
    private double[] _startLocation;
    /**
     * Constructor for objects of class Pet
     */
    public Pet(String model, String tex, double scale)
    {
        super(model, tex, scale);
        // Initialise instance variables
        // Initialise _rndGen:
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
}