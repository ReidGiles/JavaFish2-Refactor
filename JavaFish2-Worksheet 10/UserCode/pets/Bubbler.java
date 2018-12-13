package UserCode.pets;

import Framework.DisplayObject;

/**
 * Bubble contains all the behaviour and state to represent a Bubble.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Bubbler extends Pet
{ 
    /**
     * Constructor for objects of class Bubbler
     */
    public Bubbler()
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Bubbler.png", 0.4);
        _speed = random();
        _facingDirectionX = -1;
        // INITIALISE position
        translate(5,1);
        rotate(90,90);
    }
    
    /**
     * METHOD: set the position of the fish within the aquarium
     *
     * @param  xpos   the position along the x axis
     * @param  ypos   the position along the y axis
     */
    public void setPosition(double xpos, double ypos)
    {
        // SET the position using the base class method:
        setPosition(xpos,ypos,1.0);
    }
    
    /**
     * METHOD: set the position of the fish in the aquarium
     * 
     * @param  x    the rqd position along the x axis
     * @param  y    the rqd position along the y axis
     * @param  z    the rqd position along the z axis
     * @return      void 
     */
    public void setPosition(double x, double y, double z)
    {
        // SET position via the position variables in the base class:
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    
    /**
     * METHOD: set the orientation of the fish in the aquarium
     * 
     * @param  x    orientation about the x axis
     * @param  y    orientation about the y axis
     * @param  z    orientation about the z axis
     * @return      void 
     */
    public void setOrientation(double x, double y, double z)
    {
        // SET orientation via the orientation variables in the base class:
        this.rotateX = x;
        this.rotateY = y;
        this.rotateZ = z;
    }
    
    /**
     * METHOD: Controls move behaviour.
     * 
     * @return      void 
     */
    protected void movement()
    {
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {
        // Call "movement()" method of parent class:
        movement();
    }

}
