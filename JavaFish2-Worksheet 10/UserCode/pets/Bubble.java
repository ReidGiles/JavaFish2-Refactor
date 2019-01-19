package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Bubble extends Pet
{ 
    IMovement wSwim;
    double startX;
    double startY;
    /**
     * Constructor for objects of class JavaFish
     */
    public Bubble(double[] pStartLocation)
    {
        // initialise instance variables
        super("sphere", "textures/javaFish/Bubble.png", 0.4);
        _speed = -0.020;
        _facingDirectionX = -1;
        _facingDirectionY = -1;
        double[] _startLocation = pStartLocation;
        wSwim = new WaveSwim(_speed, _facingDirectionX, _facingDirectionY);
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(0,90);
    }
    
    /**
     * METHOD: Controls move behaviour.
     * 
     * @return      void 
     */
    protected void movement()
    {
        wSwim.updateLocation(this.x, this.y);
        translate(wSwim.updateY(),wSwim.updateX());
        /*if (wSwim.bounce() == 4)
        {
            this.x = startX;
            this.y = startY;
        }/*/
    }
    
    /**
     * Updates '_x' and '_y' with the x and y position of method caller
     * 
     * @param  pX   x position of method caller
     * @param  pY   y position of method caller
     */
    public void updateLocation(double pX, double pY)
    {
        startX = pX;
        startY = pY;
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
