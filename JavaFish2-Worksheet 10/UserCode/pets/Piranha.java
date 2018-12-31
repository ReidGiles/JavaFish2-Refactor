package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;

/**
 * JavaFish contains all the behaviour ans state to represent a Piranha. It must randomly choose to swim along the x or y axis,
 * changing reguarly. It must bounce of the edge of the screen and always face the direction it is moving.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Piranha extends Pet
{ 
    IMovement rSwim;
    /**
     * Constructor for objects of class Piranha
     */
    public Piranha(double pSpeed, double[] pStartLocation)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/PiranhaGreen.png", 0.4);
        _speed = pSpeed;
        _facingDirectionX = -1;
        _facingDirectionY = -1;
        rSwim = new RoboSwim(_speed, _facingDirectionX, _facingDirectionY);
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(0,90);
    }
    
    /**
     * METHOD: Controls swim behaviour of children, moves the fish back and forth along the x or y axix axis (chosen randomly),
     * bouncing of walls and always facing the direction it is moving.
     * 
     * @return      void 
     */
    protected void movement()
    {
        rSwim.updateLocation(this.x, this.y);
        translate(rSwim.updateX(),rSwim.updateY());
        if (rSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (rSwim.bounce() == 2)
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