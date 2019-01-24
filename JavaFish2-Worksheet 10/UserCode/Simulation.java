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
    
    //DECLARE a double to store our randomised speed, call it "_speed":
    private double _speed;
    
    private int[] randomLocation;
    private int randomLocationX;
    private int randomLocationY;
    
    private int javaFishSpawn;   
    private int seahorseSpawn;    
    private int urchinSpawn;    
    private int orangeFishSpawn;    
    private int piranhaSpawn;    
    private int bubblerSpawn;
    
    private ArrayList<IDisplayObject> _displayObjects;
    
    //DECLARE a referece to the instance of the BubbleManager class, call it '_bubbleManager':
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
        // Initialise _rndGen:
        _rndGen = new Random();
        _displayObjects = new ArrayList<IDisplayObject>();
        javaFishSpawn = 2;
        seahorseSpawn = 2;
        urchinSpawn = 2;
        orangeFishSpawn = 2;
        piranhaSpawn = 2;
        bubblerSpawn = 1;
    }
    
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
        for (int i=0; i<javaFishSpawn; i++)
        {
            double[] startLocation = randomLocation();
            // Creates a JavaFish object namesd javaFish1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new JavaFish(random(), startLocation));
        }
        for (int i=0; i<seahorseSpawn; i++)
        {
            double[] startLocation = randomLocation();
            // Creates a Seahorse object namesd seahorse1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new Seahorse(random(), startLocation));
        }
        for (int i=0; i<urchinSpawn; i++)
        {
            double[] startLocation = randomLocation();
            // Creates a Urchin object namesd urchin1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new Urchin(random(), startLocation));
        }
        for (int i=0; i<orangeFishSpawn; i++)
        {
            double[] startLocation = randomLocation();
            // Creates a OrangeFish object namesd orangeFish1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new OrangeFish(random(), startLocation, _bubbleManager));
        }
        for (int i=0; i<piranhaSpawn; i++)
        {
            double[] startLocation = randomLocation();
            // Creates a Piranha object namesd piranha1, passes x-position, y-position and speed (provided via the return value of random():
            _displayObjects.add(new Piranha(random(), startLocation));
        }
        for (int i=0; i<bubblerSpawn; i++)
        {
            _displayObjects.add(new Bubbler());
        }
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
    
    private double[] randomLocation()
    {
        randomLocationX = (_rndGen.nextInt(9) + 1);
        randomLocationY = (_rndGen.nextInt(7) + 1);
        double[] randomLocation = {randomLocationX, randomLocationY};
        return randomLocation;
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
