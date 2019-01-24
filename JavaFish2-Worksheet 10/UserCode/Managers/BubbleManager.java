package UserCode.Managers;

import Framework.Core;
import Framework.ICore;
import Framework.IDisplayObject;
import UserCode.pets.Bubble;
import UserCode.pets.IBubble;
import java.util.ArrayList;

/**
 * Write a description of class BubbleManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleManager implements IBubbleManager
{
    ICore _core;
    IBubble bubble;
    private ArrayList<IBubble> _bubbles;
    public BubbleManager(ICore pCore)
    {
        _core = pCore;
        _bubbles = new ArrayList<IBubble>();
    }
    
    public void spawnBubble(double pX, double pY)
    {
        bubble = new Bubble(pX,pY);
        _bubbles.add(bubble);
        _core.addDisplayObject((IDisplayObject)bubble);
    }
    
    public void update()
    {
        for (IBubble bubble: _bubbles)
        {
            if (bubble.requestReset() == true)
            {
                _core.removeDisplayObject((IDisplayObject)bubble);
            }
        }
    }
}