package UserCode.pets;

import Framework.DisplayObject;

/**
 * JavaFish contains all the behaviour ans state to represent a Piranha. It must randomly choose to swim along the x or y axis,
 * changing reguarly. It must bounce of the edge of the screen and always face the direction it is moving.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Piranha extends Pet
{ 
    /**
     * Constructor for objects of class Piranha
     */
    public Piranha()
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/PiranhaGreen.png", 0.4);
        _speed = random();
        _facingDirectionX = -1;
        // INITIALISE position
        translate(5,5);
        rotate(0,90);
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
     * METHOD: Controls swim behaviour of children, moves the fish back and forth along the x or y axix axis (chosen randomly),
     * bouncing of walls and always facing the direction it is moving.
     * 
     * @return      void 
     */
    protected void movement()
    {
        // _randomInt is set to a random number between 0 and 300:
        _randomInt = _rndGen.nextInt(300);
        if (_xySwitch == "X")
        {
            /* IF _facingDirectionX is equal to -1, fish moves left along the x-axis at the rate of "_speed"
             * IF _facingDirectionX is equal to 1, fish moves right along the x-axis at the rate of "_speed":
            */
            this.x = this.x + _speed * _facingDirectionX;
        }
        else if (_xySwitch == "Y")
        {
            /* IF _facingDirectionY is equal to -1, fish moves down along the y-axis at the rate of "_speed"
             * IF _facingDirectionY is equal to 1, fish moves up along the y-axis at the rate of "_speed":
            */
            this.y = this.y + _speed * _facingDirectionY;
        }
        if (this.x <= 1 || this.x >= 9)
        {
            // _facingDirectionX is reversed (this changes swim direction: line 78):
            _facingDirectionX = -_facingDirectionX;
            // IF the fish contacts the far left screen border:
            if (this.x <= 1)
            {
                // Change fish orientation so it appears to turn around:
                rotate(0,270,0);
            }
            // IF the fish contacts the far right screen border:
            if(this.x >= 9)
            {
                // Change fish orientation so it appears to turn around:
                rotate(0,90,0);
            }
        }
        // IF the fish contacts the edge of the screen on the y-axis:
        if (this.y <= 1 || this.y >= 7)
        {
            // _facingDirectionY is reversed (this changes swim direction: line 91):
            _facingDirectionY = -_facingDirectionY;
            // The fish texture turns around on the x axis
            this.rotateX = -this.rotateX;
        }
        /* IF _randomInt equals 1, the fish swims annd faces up. If it equals 2, the fish swims and faces down.
         * If it equals 3, the fish swims and faces left. If it equals 4, the fish swims and faces right.
        */
        switch (_randomInt)
        {
            case 1:
                // Fish Swims up:
                _facingDirectionY = 1;
                // _xySwitch is set to "Y":
                _xySwitch = "Y";
                // Fish faces up:
                this.rotateX = 90;
                break;
            case 2:
                // Fish Swims down:
                _facingDirectionY = -1;
                // _xySwitch is set to "Y":
                _xySwitch = "Y";
                // Fish faces down:
                this.rotateX = -90;
                break;
            case 3:
                // Fish Swims left:
                _facingDirectionX = -1;
                // _xySwitch is set to "X":
                _xySwitch = "X";
                // Fish faces left:
                rotate(0,90,0);
                break;
            case 4:
                // Fish Swims right:
                _facingDirectionX = 1;
                // _xySwitch is set to "X":
                _xySwitch = "X";
                // Fish faces right:
                rotate(0,270,0);
                break;
        }
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {
        // Call "snakeySwim()" method of parent class:
        movement();
    }

}