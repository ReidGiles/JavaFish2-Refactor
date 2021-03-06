package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;
import UserCode.Managers.*;

/**
 * JavaFish contains all the behaviour ans state to represent a Piranha. It must randomly choose to swim along the x or y axis,
 * changing reguarly. It must bounce of the edge of the screen and always face the direction it is moving.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class Piranha extends Pet
{ 
    // DECLARE a reference to the instance of IMovement, call it '_rSwim':
    private IMovement _rSwim;
    //DECLARE a referece to the instance of the IBubbleManager class, call it '_bubbleManager':
    private IBubbleManager _bubbleManager;
    /**
     * Piranha Constructor
     *
     * @param pSpeed Random start speed
     * @param pStartLocation Random start location
     * @param pBubbleManager Reference to bubble manager
     */
    public Piranha(double pSpeed, double[] pStartLocation, IBubbleManager pBubbleManager)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/PiranhaGreen.png", 0.4);
        // INITIALISE _bubbleManager, set it to pBubbleManager:
        _bubbleManager = pBubbleManager;
        // INITIALISE _speed:
        _speed = pSpeed;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        _rSwim = new RoboSwim(_speed, _facingDirectionX, _facingDirectionY);
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
        // Pass x and y cord into movement class:
        _rSwim.updateLocation(this.x, this.y);
        // Move the fish based on return value of movement class:
        translate(_rSwim.updateX(),_rSwim.updateY());
        // If the fish hits a boundry, it turns around:
        if (_rSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (_rSwim.bounce() == 2)
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
        // Spawn new bubble at irregular intervals:
        if (_rndGen.nextInt(150) == 1)
        {
            _bubbleManager.spawnBubble(this.x,this.y);
        }
    }

}