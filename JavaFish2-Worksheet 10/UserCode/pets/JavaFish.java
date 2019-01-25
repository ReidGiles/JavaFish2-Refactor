package UserCode.pets;

import Framework.DisplayObject;
import UserCode.movement.*;
import UserCode.UserException.*;
import UserCode.Managers.*;

/**
 * JavaFish contains all the behaviour and state to represent a JavaFish, it must swim back and fourth along the x axis, bounce of
 * the edge of the screen and alwaysface the direction it is traveling.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class JavaFish extends Pet
{ 
    // DECLARE a reference to the instance of IMovement, call it '_hSwim':
    private IMovement _hSwim;
    //DECLARE a referece to the instance of the IBubbleManager class, call it '_bubbleManager':
    private IBubbleManager _bubbleManager;
    // DECLARE a double[], call it _startLocation:
    double[] _startLocation;
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish(double pSpeed, double[] pStartLocation, IBubbleManager pBubbleManager)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", 0.4);
        // INITIALISE _bubbleManager, set it to pBubbleManager:
        _bubbleManager = pBubbleManager;
        // INITIALISE _speed:
        _speed = pSpeed;
        // INITIALISE _facingDirectionX to -1:
        _facingDirectionX = -1;
        // INITIALISE _startLocation to pLocation:
        _startLocation = pStartLocation;
        // Be prepared to catch an ArgumentOutOfBoundsException from _hSwim:
        try
        {
            _hSwim = new HorizontalSwim(_speed, _facingDirectionX);
        }
        catch (ArgumentOutOfBoundsException e)
        {
        }
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
        // Spawn new bubble at irregular intervals:
        if (_rndGen.nextInt(150) == 1)
        {
            _bubbleManager.spawnBubble(this.x,this.y);
        }
    }

}
