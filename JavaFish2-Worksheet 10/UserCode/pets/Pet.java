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
    // DECLARE a Random, call it '_rndGen':
    protected Random _rndGen;
    /**
     * Pet Constructor
     *
     * @param model Display model
     * @param tex Display texture
     * @param scale Display scale
     */
    public Pet(String model, String tex, double scale)
    {
        super(model, tex, scale);
        // Initialise instance variables
        // Initialise _rndGen:
        _rndGen = new Random();
    }
    
    /**
     * METHOD: Controls swim behaviour of children, moves the fish back and forth along the x axis, bouncing of walls and always
     * facing the direction it is moving. Also oscilates the fish along the x axis creating a wave like motion.
     * 
     * @return      void 
     */
    protected abstract void movement();
    
    /**
     * METHOD: Manipulates the x and y values of the caller, moving them across the aquarium. Core movement method.
     *
     * @param  dx   How far to move along the x axis
     * @param  dy   How far to move along the y axis
     * @param  dz   How far to move along the z axis
     * @return  void
     */
    protected void translate(double dx, double dy, double dz)
    {
        this.x += dx;
        this.y += dy;
        this.z = dz;
    }
    
    /**
     * METHOD: Manipulates the x,y and z position values of the caller, moving them across the aquarium. Core movement method.
     *
     * @param  dx   How far to move along the x axis
     * @param  dy   How far to move along the y axis
     * @return  void
     */
    protected void translate(double dx, double dy)
    {
        translate(dx,dy,1);
    }
    
    /**
     * METHOD: Manipulates the x,y and z values of the caller, rotating them. Core rotation method.
     *
     * @param  dx   How far to rotate on the x axis
     * @param  dy   How far to rotate on the y axis
     * @param  dz   How far to rotate on the z axis
     * @return  void
     */
    protected void rotate(double dx, double dy, double dz)
    {
        this.rotateX = dx;
        this.rotateY = dy;
        this.rotateZ = dz;
    }
    
    /**
     * METHOD: Manipulates the x,y and z values of the caller, rotating them. Core rotation method.
     *
     * @param  dx   How far to rotate on the x axis
     * @param  dy   How far to rotate on the y axis
     * @return  void
     */
    protected void rotate(double dx, double dy)
    {
        rotate(dx,dy,0);
    }
}