package UserCode.pets;

import UserCode.movement.*;
import java.applet.*;
import java.net.*;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public class Bubble extends Pet implements IBubble
{ 
    // DECLARE a reference to the instance of IMovement, call it '_bSwim':
    private IMovement _bSwim;
    // DECLARE a reference to the instance of AudioClip, call it '_clip':
    private AudioClip _clip;
    /**
     * Constructor for objects of class JavaFish
     */
    public Bubble(double pX, double pY)
    {
        // initialise instance variables
        super("sphere", "textures/javaFish/Bubble.png", 0.1);
        // INITIALISE _speed:
        _speed = -0.020;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        _bSwim = new BubbleSwim(_speed, _facingDirectionX, _facingDirectionY);
        // INITIALISE position
        translate(pX,pY);
        rotate(0,90);
        
        try
        {
            _clip = Applet.newAudioClip(new URL("http://formenmedia.ign.com/media/news/image/gear/bubblegurggle.wav"));
        }
        catch (MalformedURLException murle) {
            System.out.println(murle);
        }
    }
    
    /**
     * METHOD: Controls move behaviour.
     * 
     * @return      void 
     */
    protected void movement()
    {
        // Pass x and y cord into movement class:
        _bSwim.updateLocation(this.x, this.y);
        // Move the fish based on return value of movement class:
        translate(_bSwim.updateY(),_bSwim.updateX());        
    }
    

    
    public boolean requestReset()
    {
        if (_bSwim.bounce() == 4)
        {
            return true;
        }
        else return false;
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
