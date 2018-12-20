package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;

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
    public JavaFish()
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", 0.4);
        _speed = random();
        _facingDirectionX = -1;
        // INITIALISE position
        translate(8,6);
        rotate(0,90);
        hSwim = new HorizontalSwim(_speed, _facingDirectionX);
    }
    
    /**
     * METHOD: Controls swim behaviour of children, moves the fish back and forth along the x axis, bouncing of walls and always
     * facing the direction it is moving.
     * 
     * @return      void 
     */
    protected void movement()
    {
        //hSwim.movement(_speed);
        
        hSwim.updateLocation(this.x, this.y);
        translate(hSwim.update(),0);
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
