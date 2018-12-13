package UserCode.pets;

import Framework.DisplayObject;

/**
 * OrangeFish contains all the behaviour and state to represent a Seahorse. It must swim diagonally bouncing of the edge of the
 * screen and always face the direction it is travelling.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Seahorse extends Pet
{
    /**
     * Constructor for objects of class Seahorse
     */
    public Seahorse()
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Seahorse.png", 0.4);
        _speed = random();
        // Initialise _facingDirectionX to -1:
        _facingDirectionX = -1;
        // Initialise _facingDirectionY to -1:
        _facingDirectionY = -1;
        // INITIALISE position
        translate(8,4);
        rotate(180,270);
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
        // set orientation via the orientation variables in the base class:
        this.rotateX = x;
        this.rotateY = y;
        this.rotateZ = z;
    }
    
    /**
     * METHOD: Controls swim behaviour of Seahorse, overides parent method
     *
     * @return     void
     */
    public void movement()
    {
        /* IF _facingDirectionX is equal to -1, fish moves left along the x-axis at the rate of "_speed"
         * IF _facingDirectionX is equal to 1, fish moves right along the x-axis at the rate of "_speed":
        */
        this.x = this.x + _speed * _facingDirectionX;
        /* IF _facingDirectionY is equal to -1, fish moves down along the y-axis at the rate of "_speed"
         * IF _facingDirectionY is equal to 1, fish moves up along the y-axis at the rate of "_speed":
        */
        this.y = this.y + _speed * _facingDirectionY;
        // IF the fish contacts the edge of the screen on the x-axis:
        if (this.x <= 1 || this.x >= 9)
        {
            // _facingDirectionX is reversed (this changes swim direction: line 87):
            _facingDirectionX = -_facingDirectionX;
            // IF the fish contacts the far left screen border:
            if (this.x <= 1)
            {
                // Change fish orientation so it appears to turn around:
                this.rotate(180,90,0);
            }
            // IF the fish contacts the far right screen border:
            if(this.x >= 9)
            {
                // Change fish orientation so it appears to turn around:
                this.rotate(180,270,0);
            }
        }
        // IF the fish contacts the edge of the screen on the y-axis:
        if (this.y <= 1 || this.y >= 7)
        {
            // _facingDirectionY is reversed (this changes swim direction: line 91):
            _facingDirectionY = -_facingDirectionY;
        }
    }
           
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {
        // Call "movement()" method responsible for swim behaviour:
        movement();
    }

}
