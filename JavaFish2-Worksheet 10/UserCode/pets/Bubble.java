package UserCode.pets;

import Framework.DisplayObject;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Bubble extends Pet
{ 
    double startX;
    double startY;
    /**
     * Constructor for objects of class JavaFish
     */
    public Bubble(double pX, double pY)
    {
        // initialise instance variables
        super("sphere", "textures/javaFish/Bubble.png", 0.4);
        _speed = random();
        _facingDirectionX = -1;
        _facingDirectionY = -1;
        startX = pX;
        startY = pY;
        // INITIALISE position
        translate(startX,startY);
        rotate(0,90);
    }
    
    /**
     * METHOD: Controls move behaviour.
     * 
     * @return      void 
     */
    protected void movement()
    {
        // Speed of rotation:
        _timeCounter += 0.15F;           
        _rotationY = Math.cos(_timeCounter);
        // Length of rotation on y axis:
        _speedY = (float)_rotationY * 0.03; 
        /* IF _facingDirectionX is equal to -1, fish moves left along the x-axis at the rate of "_speed"
         * IF _facingDirectionX is equal to 1, fish moves right along the x-axis at the rate of "_speed":
        */
        this.x = this.x - _speedY * _facingDirectionX;
        // The fish moves oscilates along the y axis:
        this.y = this.y - _speed * _facingDirectionY;
        if (this.y >= 7)
        {
            this.y = startY;
        }
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
