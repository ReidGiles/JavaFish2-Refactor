package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;
import UserCode.UserException.*;

/**
 * JavaFish contains all the behaviour and state to represent a JavaFish, it must swim back and fourth along the x axis, bounce of
 * the edge of the screen and alwaysface the direction it is traveling.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class JavaFish extends Pet
{ 
    IMovement hSwim;
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish(double pSpeed, double[] pStartLocation)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", 0.4);
        _speed = pSpeed;
        _facingDirectionX = -1;
        try
        {
            hSwim = new HorizontalSwim(_speed, _facingDirectionX);
        }
        catch (ArgumentOutOfBoundsException e)
        {
        }
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(0,90);       
    }
    
    /**
     * METHOD: Controls swim behaviour of children, moves the fish back and forth along the x axis, bouncing of walls and always
     * facing the direction it is moving.
     * 
     * @return      void 
     */
    protected void movement()
    {
        hSwim.updateLocation(this.x, this.y);
        translate(hSwim.updateX(),hSwim.updateY());
        if (hSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (hSwim.bounce() == 2)
        {
            rotate(0,90);
        }
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {        
        movement();
    }

}
