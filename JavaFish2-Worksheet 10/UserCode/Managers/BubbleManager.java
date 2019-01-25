package UserCode.Managers;

import Framework.Core;
import Framework.ICore;
import Framework.IDisplayObject;
import UserCode.pets.Bubble;
import UserCode.pets.IBubble;
import java.util.ArrayList;

/**
 * Bubble manager is responsible for creating and deleting bubbles.
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public class BubbleManager implements IBubbleManager
{
    // DECLARE a reference to the instance of the ICore interface, call it '_core':
    private ICore _core;
    // DECLARE a reference to the instance of the IBubble interface, call it '_bubble':
    private IBubble bubble;
    //DECLARE an ArrayList of type IBubble, call it '_bubbles':
    private ArrayList<IBubble> _bubbles;
    public BubbleManager(ICore pCore)
    {
        // INITIALISE _core:
        _core = pCore;
        // INITIALISE _bubbles:
        _bubbles = new ArrayList<IBubble>();
    }
    
    public void spawnBubble(double pX, double pY)
    {
        // SET bubble to an instance of a new bubble, pass in pX and pY:
        bubble = new Bubble(pX,pY);
        // ADD bubble to the bubbles array list:
        _bubbles.add(bubble);
        // ADD the bubble to the aquarium, cast as display object:
        _core.addDisplayObject((IDisplayObject)bubble);
    }
    
    public void update()
    {
        // FOR every bubbles in _bubbles
        for (IBubble bubble: _bubbles)
        {
            // IF the bubble leaves the aquarium:
            if (bubble.requestReset() == true)
            {
                // REMOVE the bubble from the aquarium:
                _core.removeDisplayObject((IDisplayObject)bubble);
            }
        }
    }
}
