package UserCode.pets;

import Framework.DisplayObject;
import Framework.Core;
import Framework.ICore;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Bubbler extends Pet
{ 
    ICore _core;
    /**
     * Constructor for objects of class Bubbler
     */
    public Bubbler(ICore pCore)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Bubbler.png", 0.4);
        _core = pCore;
        // INITIALISE position
        translate(5,1);
        rotate(90,90);
        
        _core.addDisplayObject(new Bubble(this.x,this.y));
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
        // Call "movement()" method of parent class:
        movement();
    }

}
