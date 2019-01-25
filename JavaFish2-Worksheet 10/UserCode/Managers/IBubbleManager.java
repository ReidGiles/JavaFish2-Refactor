package UserCode.Managers;

/**
 * The IBubbleManager instance provides functionality for spawning bubbles at set cords, and running the update function that removes any bubbles that have left the aquarium from the simulation
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public interface IBubbleManager
{
    // Spawns a bubble at the cords passed in:
    public void spawnBubble(double pX, double pY);
    // Updates the manager, removing any bubbles that leave the aquarium:
    public void update();
}
