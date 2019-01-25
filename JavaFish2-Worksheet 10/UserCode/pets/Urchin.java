package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;
import UserCode.UserException.*;

/**
 * Urchin contains all the behaviour and state to represent a Urchin. it must swim back and fourth along the x axis, bounce of
 * the edge of the screen and alwaysface the direction it is traveling.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class Urchin extends Pet
{
    // DECLARE a reference to the instance of IMovement, call it '_hSwim':
    private IMovement _hSwim;
    /**
     * Urchin Constructor
     *
     * @param pSpeed Random start speed
     * @param pStartLocation Random start location
     */
    public Urchin(double pSpeed, double[] pStartLocation)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Urchin.png", 0.3);
        // INITIALISE _speed:
        _speed = pSpeed;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        try
        {
            _hSwim = new HorizontalSwim(_speed, _facingDirectionX);
        }
        catch (ArgumentOutOfBoundsException e)
        {
        }
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],1);
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
        // Pass x and y cord into movement class:
        _hSwim.updateLocation(this.x, this.y);
        // Move the fish based on return value of movement class:
        translate(_hSwim.updateX(),_hSwim.updateY());
        // If the fish hits a boundry, it turns around:
        if (_hSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (_hSwim.bounce() == 2)
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
