package UserCode.pets;

import Framework.DisplayObject;

/**
 * Urchin contains all the behaviour and state to represent a Urchin. it must swim back and fourth along the x axis, bounce of
 * the edge of the screen and alwaysface the direction it is traveling.
 * 
 * @author Reid Giles
 * @version 16/11/2018
 */
public class Urchin extends Pet
{
    HorizontalSwim hSwim;
    /**
     * Constructor for objects of class Urchin
     */
    public Urchin()
    {
        // initialise instance variables
        super("models/billboard/billboard.obj", "textures/javaFish/Urchin.png", 0.4);
        _speed = random();
        _facingDirectionX = -1;
        hSwim = new HorizontalSwim(this, _facingDirectionX);
        // INITIALISE position
        translate(5,1);
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
        hSwim.movement(_speed);
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
