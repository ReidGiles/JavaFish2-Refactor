package UserCode.movement;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import UserCode.UserException.*;

/**
 * The test class HorizontalSwimTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 * 
 * Test Conditions:
 * HorizontalSwim(): throws ArgumentOutOfBoundsException if 0.005 < pSpeed < 0.05 is not true. Throws ArgumentOutOfBoundsException if pFacingDirectionX == (1 || -1) is not true.
 * updateLocation():
 * bounce():
 * 
 */
public class HorizontalSwimTest
{
    /**
     * Default constructor for test class HorizontalSwimTest
     */
    public HorizontalSwimTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    // ------------------------------------------ HorizontalSwim() ---------------------------------------------//
    // Test ArgumentOutOfBoundsException is thrown when pSpeed = -50, 0.004, 0.06, 50: 
    // Test ArgumentOutOfBoundsException is NOT thrown when pSpeed = 0.006, 0.01, 0.04: 
    // Test ArgumentOutOfBoundsException is thrown when pFacingDirectionX = -10, 0, 10: 
    // Test ArgumentOutOfBoundsException is NOT thrown when pFacingDirectionX = 1, -1: 
    /**
     * METHOD: Test condition HorizontalSwim(): throws ArgumentOutOfBoundsException if pSpeed=-50.
     * 
     */
    @Test
    public void HorizontalSwim_test1()
    {        
        // DECLARE a boolean to flag a test pass/failure, call it 'pass', initialise to false:
        boolean pass = false;       
        try
        {
            IMovement testHswim = new HorizontalSwim(-50,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            pass = true;
        }
        
        assertTrue("ArgumentOutOfBoundsException was not thrown when HorizontalSwim(0.02,1) was called", pass);
    }
    
    /**
     * METHOD: Test condition HorizontalSwim(): throws ArgumentOutOfBoundsException if pSpeed=0.004.
     * 
     */
    @Test
    public void HorizontalSwim_test2()
    {        
        // DECLARE a boolean to flag a test pass/failure, call it 'pass', initialise to false:
        boolean pass = false;       
        try
        {
            IMovement testHswim = new HorizontalSwim(0.004,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            pass = true;
        }
        
        assertTrue("ArgumentOutOfBoundsException was not thrown when HorizontalSwim(0.004,1) was called", pass);
    }
    
    /**
     * METHOD: Test condition HorizontalSwim(): throws ArgumentOutOfBoundsException if pSpeed=0.06.
     * 
     */
    @Test
    public void HorizontalSwim_test3()
    {        
        // DECLARE a boolean to flag a test pass/failure, call it 'pass', initialise to false:
        boolean pass = false;       
        try
        {
            IMovement testHswim = new HorizontalSwim(0.06,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            pass = true;
        }
        
        assertTrue("ArgumentOutOfBoundsException was not thrown when HorizontalSwim(0.06,1) was called", pass);
    }
    
    /**
     * METHOD: Test condition HorizontalSwim(): throws ArgumentOutOfBoundsException if pSpeed=50.
     * 
     */
    @Test
    public void HorizontalSwim_test4()
    {        
        // DECLARE a boolean to flag a test pass/failure, call it 'pass', initialise to false:
        boolean pass = false;       
        try
        {
            IMovement testHswim = new HorizontalSwim(50,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            pass = true;
        }
        
        assertTrue("ArgumentOutOfBoundsException was not thrown when HorizontalSwim(50,1) was called", pass);
    }
    
    /**
     * METHOD: Test condition HorizontalSwim(): DOES NOT throw ArgumentOutOfBoundsException if pSpeed=0.006.
     * 
     */
    @Test
    public void HorizontalSwim_test5()
    {            
        try
        {
            IMovement testHswim = new HorizontalSwim(0.006,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            fail("ArgumentOutOfBoundsException was thrown when HorizontalSwim(0.006,1) was called");
        }
    }
    
    /**
     * METHOD: Test condition HorizontalSwim(): DOES NOT throw ArgumentOutOfBoundsException if pSpeed=0.01.
     * 
     */
    @Test
    public void HorizontalSwim_test6()
    {            
        try
        {
            IMovement testHswim = new HorizontalSwim(0.01,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            fail("ArgumentOutOfBoundsException was thrown when HorizontalSwim(0.01,1) was called");
        }
    }
    
    /**
     * METHOD: Test condition HorizontalSwim(): DOES NOT throw ArgumentOutOfBoundsException if pSpeed=0.04.
     * 
     */
    @Test
    public void HorizontalSwim_test7()
    {            
        try
        {
            IMovement testHswim = new HorizontalSwim(0.04,1);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            fail("ArgumentOutOfBoundsException was thrown when HorizontalSwim(0.04,1) was called");
        }
    }
}
