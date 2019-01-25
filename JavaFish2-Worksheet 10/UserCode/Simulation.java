package UserCode;
///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import UserCode.pets.*;
import env3d.Env;
import Framework.Core;
import Framework.ICore;
import UserCode.Managers.*;
import Framework.IDisplayObject;
import java.util.Random;
import java.util.ArrayList;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author Reid Giles & Marc Price
 * @version 16/11/2018
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private ICore _core;
    
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    // DECLARE a Random to generate a random seed for calculating our fish speeds, call it '_rndGen':
    private Random _rndGen;
    
    // DECLARE a double to store our random speed lower bound, call it "_randomLow":
    private double _randomLow;
    
    // DECLARE a double to store our random speed upper bounder, call it "_randomHigh":
    private double _randomHigh;
    
    // DECLARE a double to store our randomised speed, call it "_speed":
    private double _speed;
    // DECLARE an int[] to store a randomised location, call it '_randomLocation':
    private int[] _randomLocation;
    // DECLARE an int to store an x value, call it '_randomLocationX':
    private int _randomLocationX;
    // DECLARE an int to store an y value, call it '_randomLocationY':
    private int _randomLocationY;
    // DECLARE an int, call it '_javaFishSpawn':
    private int _javaFishSpawn; 
    // DECLARE an int, call it '_seahorseSpawn':
    private int _seahorseSpawn;  
    // DECLARE an int, call it '_urchinSpawn':
    private int _urchinSpawn;    
    // DECLARE an int, call it '_orangeFishSpawn':
    private int _orangeFishSpawn;    
    // DECLARE an int, call it '_piranhaSpawn':
    private int _piranhaSpawn;    
    // DECLARE an int, call it '_bubblerSpawn':
    private int _bubblerSpawn;
    
    //DECLARE an ArrayList of type IDisplayObject, call it '_displayObjects':
    private ArrayList<IDisplayObject> _displayObjects;
    
    //DECLARE a referece to the instance of the IBubbleManager class, call it '_bubbleManager':
    private IBubbleManager _bubbleManager;
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        // _core:
        _core = new Core();
        // _bubbleManager, pass it an reference to _core:
        _bubbleManager = new BubbleManager(_core);
        // INITIALISE _rndGen:
        _rndGen = new Random();
        // INITIALISE _displayObjects:
        _displayObjects = new ArrayList<IDisplayObject>();
        // INITIALISE _javaFishSpawn:
        _javaFishSpawn = 2;
        // INITIALISE _seahorseSpawn:
        _seahorseSpawn = 2;
        // INITIALISE _urchinSpawn:
        _urchinSpawn = 2;
        // INITIALISE _orangeFishSpawn:
        _orangeFishSpawn = 2;
        // INITIALISE _piranhaSpawn:
        _piranhaSpawn = 2;
        // INITIALISE _bubblerSpawn:
        _bubblerSpawn = 1;
    }
    
    
    /**
     * METHOD: Main
     *
     */
    public static void main()
    {
        Simulation sim = new Simulation();
        // Call the populate() method, spawns fish into the environment:
        sim.populate();
        sim.run();
    }
    
    /**
     * METHOD: populate the scene with fish, randomise their start speeds.
     *
     * @return      void 
     */
    public void populate()
    {
        for (int i=0; i<_javaFishSpawn; i++)
        {
            // Creates a JavaFish object namesd javaFish1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new JavaFish(random(), _randomLocation(), _bubbleManager));
        }
        for (int i=0; i<_seahorseSpawn; i++)
        {
            // Creates a Seahorse object namesd seahorse1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new Seahorse(random(), _randomLocation(), _bubbleManager));
        }
        for (int i=0; i<_urchinSpawn; i++)
        {
            // Creates a Urchin object namesd urchin1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new Urchin(random(), _randomLocation()));
        }
        for (int i=0; i<_orangeFishSpawn; i++)
        {
            // Creates a OrangeFish object namesd orangeFish1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new OrangeFish(random(), _randomLocation(), _bubbleManager));
        }
        for (int i=0; i<_piranhaSpawn; i++)
        {
            // Creates a Piranha object namesd piranha1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new Piranha(random(), _randomLocation(), _bubbleManager));
        }
        for (int i=0; i<_bubblerSpawn; i++)
        {
            _displayObjects.add(new Bubbler(_bubbleManager));
        }
        // Add each display object in _displayObjects to the aquarium:
        for (int i=0; i<_displayObjects.size(); i++)
        {
            _core.addDisplayObject(_displayObjects.get(i));
        }
    }
    
    /**
     * METHOD: Return a random number between two doubles, used to randomize fish speed on startup.
     *
     * @return     a random number between the variables doubles "low" and "high"
     */
    private double random()
    {
        // SET _randomLow to 0.005:
        _randomLow = 0.005;
        // SET _randomHigh to 0.05:
        _randomHigh = 0.05;
        // SET speed to a random number between _randomHigh and _randomLow.:
        _speed = _randomLow + (_randomHigh - _randomLow) * _rndGen.nextDouble();
        // Return _speed:
        return _speed;
    }
    
    /**
     * METHOD: Return a double[] containing two random x and y cords that will place an object at a random position within the aquariums boundaries:
     *
     * @return _randomLocation
     */
    private double[] _randomLocation()
    {
        // SET _randomLocationX to a number between 1 and 10:
        _randomLocationX = (_rndGen.nextInt(9) + 1);
        // SET _randomLocationY to number between 1 and 8:
        _randomLocationY = (_rndGen.nextInt(7) + 1);
        double[] _randomLocation = {_randomLocationX, _randomLocationY};
        return _randomLocation;
    }

    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run()
    {
        // CREATE the environment:
        _world = _core.createWorld();
        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_world.getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
                        
            // UPDATE: the environment
            _core.updateWorld();
            //UPDATE: BubbleManager, cleans up bubbles that leave the aquarium
            _bubbleManager.update();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();
    }

}
