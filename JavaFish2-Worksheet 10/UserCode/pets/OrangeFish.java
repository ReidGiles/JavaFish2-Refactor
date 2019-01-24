package UserCode.pets;

import UserCode.movement.*;
import UserCode.Managers.*;
import java.applet.*;
import java.net.*;

/**
 * JavaFish contains all the behaviour ans state to represent a OrangeFish. It must swim in a wave pattern along the x axis, bounce
 * of the side of the screen and always face the direction it is travelling.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class OrangeFish extends Pet
{ 
    IMovement wSwim;
    IBubbleManager _bubbleManager;
    AudioClip clip;
    /**
     * Constructor for objects of class OrangeFish
     */
    public OrangeFish(double pSpeed, double[] pStartLocation, IBubbleManager pBubbleManager)
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Orange_Fish.png", 0.4);
        _bubbleManager = pBubbleManager;
        _speed = pSpeed;
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        wSwim = new WaveSwim(_speed, _facingDirectionX, _facingDirectionY);
        double[] _startLocation = pStartLocation;
        // INITIALISE position
        translate(_startLocation[0],_startLocation[1]);
        rotate(0,90);
        
        try
        {
            clip = Applet.newAudioClip(new URL("http://formenmedia.ign.com/media/news/image/gear/bubblegurggle.wav"));
            clip.play();
        }
        catch (MalformedURLException murle) {
            System.out.println(murle);
        }
    }

    
    @Override
    protected void movement()
    {
        wSwim.updateLocation(this.x, this.y);
        translate(wSwim.updateX(),wSwim.updateY());
        if (wSwim.bounce() == 1)
        {
            rotate(0,270);
        }
        else if (wSwim.bounce() == 2)
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
        //_bubbleManager.spawnBubble(this.x,this.y);
    }

}
