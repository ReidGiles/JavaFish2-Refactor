package UserCode.pets;

import Framework.DisplayObject;
import UserCode.Managers.*;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class Bubbler extends Pet
{ 
    //DECLARE a referece to the instance of the IBubbleManager class, call it '_bubbleManager':
    private IBubbleManager _bubbleManager;
    /**
     * Constructor for objects of class Bubbler
     */
    public Bubbler(IBubbleManager pBubbleManager)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Bubbler.png", 0.4);
        // INITIALISE _bubbleManager, set it to pBubbleManager:
        _bubbleManager = pBubbleManager;
        // INITIALISE position
        translate(5,1);
        rotate(90,90);
    }
    
    /**
     * METHOD: Controls move behaviour.
     * 
     * @return      void 
     */
    protected void movement()
    {
        /*_rndNum = _random.nextInt(100);
        if (_rndNum == 25)
        {
            _core.addDisplayObject(new Bubble(this.x,this.y));
        }*/
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *Than
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
