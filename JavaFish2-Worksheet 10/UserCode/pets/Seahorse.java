package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;

/**
 * OrangeFish contains all the behaviour and state to represent a Seahorse. It must swim diagonally bouncing of the edge of the
 * screen and always face the direction it is travelling.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Seahorse extends Pet
{
    IMovement dSwim;
    /**
     * Constructor for objects of class Seahorse
     */
    public Seahorse(double pSpeed, double[] pStartLocation)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Seahorse.png", 0.4);
        _speed = pSpeed;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(180,270);
        dSwim = new DiagonalSwim(_speed, _facingDirectionX, _facingDirectionY);
    }
    
    /**
     * METHOD: Controls swim behaviour of Seahorse, overides parent method
     *
     * @return     void
     */
    public void movement()
    {
        dSwim.updateLocation(this.x, this.y);
        translate(dSwim.updateX(),dSwim.updateY());
        if (dSwim.bounce() == 1)
        {
            rotate(180,90);
        }
        else if (dSwim.bounce() == 2)
        {
            rotate(180,270);
        }
    }
           
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {
        // Call "movement()" method responsible for swim behaviour:
        movement();
    }

}
