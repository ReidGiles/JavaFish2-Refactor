package UserCode.pets;

import UserCode.movement.*;
import UserCode.Managers.*;

/**
 * JavaFish contains all the behaviour ans state to represent a OrangeFish. It must swim in a wave pattern along the x axis, bounce
 * of the side of the screen and always face the direction it is travelling.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class OrangeFish extends Pet
{ 
    // DECLARE a reference to the instance of IMovement, call it '_wSwim':
    private IMovement _wSwim;
    //DECLARE a referece to the instance of the IBubbleManager class, call it '_bubbleManager':
    private IBubbleManager _bubbleManager;
    /**
     * OrangeFish Constructor
     *
     * @param pSpeed Random start speed
     * @param pStartLocation Random start location
     * @param pBubbleManager Reference to bubble manager
     */
    public OrangeFish(double pSpeed, double[] pStartLocation, IBubbleManager pBubbleManager)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Orange_Fish.png", 0.4);
        // INITIALISE _bubbleManager, set it to pBubbleManager:
        _bubbleManager = pBubbleManager;
        // INITIALISE _speed:
        _speed = pSpeed;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        _wSwim = new WaveSwim(_speed, _facingDirectionX, _facingDirectionY);
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(0,90);
    }

    
    @Override
    protected void movement()
    {
        // Pass x and y cord into movement class:
        _wSwim.updateLocation(this.x, this.y);
        // Move the fish based on return value of movement class:
        translate(_wSwim.updateX(),_wSwim.updateY());
        // If the fish hits a boundry, it turns around:
        if (_wSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (_wSwim.bounce() == 2)
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
        //_bubbleManager.spawnBubble(this.x,this.y);
    }

}
