package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;
import UserCode.Managers.*;

/**
 * OrangeFish contains all the behaviour and state to represent a Seahorse. It must swim diagonally bouncing of the edge of the
 * screen and always face the direction it is travelling.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class Seahorse extends Pet
{
    // DECLARE a reference to the instance of IMovement, call it '_dSwim':
    private IMovement _dSwim;
    //DECLARE a referece to the instance of the IBubbleManager class, call it '_bubbleManager':
    private IBubbleManager _bubbleManager;
    /**
     * Seahorse Constructor
     *
     * @param pSpeed Random start speed
     * @param pStartLocation Random start location
     * @param pBubbleManager Reference to bubble manager
     */
    public Seahorse(double pSpeed, double[] pStartLocation, IBubbleManager pBubbleManager)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Seahorse.png", 0.3);
        // INITIALISE _bubbleManager, set it to pBubbleManager:
        _bubbleManager = pBubbleManager;
        // INITIALISE _speed:
        _speed = pSpeed;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(180,270);
        _dSwim = new DiagonalSwim(_speed, _facingDirectionX, _facingDirectionY);
    }
    
    /**
     * METHOD: Controls swim behaviour of Seahorse, overides parent method
     *
     * @return     void
     */
    public void movement()
    {
        // Pass x and y cord into movement class:
        _dSwim.updateLocation(this.x, this.y);
        // Move the fish based on return value of movement class:
        translate(_dSwim.updateX(),_dSwim.updateY());
        // If the fish hits a boundry, it turns around:
        if (_dSwim.bounce() == 1)
        {
            rotate(180,90);
        }
        else if (_dSwim.bounce() == 2)
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
        movement();
        // Spawn new bubble at irregular intervals:
        if (_rndGen.nextInt(150) == 1)
        {
            _bubbleManager.spawnBubble(this.x,this.y);
        }
    }

}
