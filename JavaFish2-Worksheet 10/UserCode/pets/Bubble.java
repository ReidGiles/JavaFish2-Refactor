package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Bubble extends Pet implements IBubble
{ 
    IMovement bSwim;
    double startX;
    double startY;
    /**
     * Constructor for objects of class JavaFish
     */
    public Bubble(double pX, double pY)
    {
        // initialise instance variables
        super("sphere", "textures/javaFish/Bubble.png", 0.1);
        _speed = -0.020;
        _facingDirectionX = -1;
        _facingDirectionY = -1;
        bSwim = new BubbleSwim(_speed, _facingDirectionX, _facingDirectionY);
        // INITIALISE position
        translate(pX,pY);
        rotate(0,90);
    }
    
    /**
     * METHOD: Controls move behaviour.
     * 
     * @return      void 
     */
    protected void movement()
    {
        bSwim.updateLocation(this.x, this.y);
        translate(bSwim.updateY(),bSwim.updateX());        
    }
    
    /**
     * Updates '_x' and '_y' with the x and y position of method caller
     * 
     * @param  pX   x position of method caller
     * @param  pY   y position of method caller
     */
    public void updateLocation(double pX, double pY)
    {
        this.x = pX;
        this.y = pY;
    }
    
    public boolean requestReset()
    {
        if (bSwim.bounce() == 4)
        {
            return true;
        }
        else return false;
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {
        // Call "movement()" method of parent class:
        movement();
    }

}
