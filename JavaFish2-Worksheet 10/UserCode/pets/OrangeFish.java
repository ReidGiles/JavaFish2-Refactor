package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;

/**
 * JavaFish contains all the behaviour ans state to represent a OrangeFish. It must swim in a wave pattern along the x axis, bounce
 * of the side of the screen and always face the direction it is travelling.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class OrangeFish extends Pet
{ 
    IMovement wSwim;
    /**
     * Constructor for objects of class OrangeFish
     */
    public OrangeFish()
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Orange_Fish.png", 0.4);
        _speed = random();
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        wSwim = new WaveSwim(_speed, _facingDirectionX, _facingDirectionY);
        // INITIALISE position
        translate(8,2);
        rotate(0,90);
    }
    
    /**
     * METHOD: Controls swim behaviour of children, moves the fish back and forth along the x axis, bouncing of walls and always
     * facing the direction it is moving. Also oscilates the fish along the x axis creating a wave like motion.
     * 
     * @return      void 
     */
    protected void movement()
    {
        wSwim.updateLocation(this.x, this.y);
        translate(wSwim.updateX(),wSwim.updateY());
        if (wSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (wSwim.bounce() == 2)
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
