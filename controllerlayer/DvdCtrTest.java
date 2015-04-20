package controllerlayer;
import modellayer.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DvdCtrTest.
 *
 * @author  Andreas Reng Mogensen   
 * @version 5/11-14
 */
public class DvdCtrTest
{
    private controllerlayer.DvdCtr dvdCtr1;

    /**
     * Default constructor for test class DvdCtrTest
     */
    public DvdCtrTest()
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
        dvdCtr1 = new controllerlayer.DvdCtr();

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

    @Test
    public void findAndGetAvailable()
    {
        dvdCtr1.createSet("123", "Jaws", "Michael Bay", "07-04-1994", "a123b456", "08-04-1994", 200.00);
        dvdCtr1.createSet("456", "James Bond", "Hans Jensen", "07-04-1999", "12345678", "01-01-2000", 199.99);
        dvdCtr1.createSet("12345657", "Guderne", "Gud", "i går", "jghsjfkldh4", "i dag", 2000);
        dvdCtr1.createDvd("0987654321", "Leben", "Stasi", "i forgaars");
        dvdCtr1.createCopy("uz74", "i dag", 131.33, dvdCtr1.findDvd("Guderne"));
        assertNotNull(dvdCtr1.findDvd("Jaws"));
        assertNotNull(dvdCtr1.getAvailable("Guderne"));
    }

    @Test
    public void removeCopy()
    {
        dvdCtr1.createSet("123", "Jaws", "Michael Bay", "07-04-1994", "a123b456", "08-04-1994", 200.00);
        dvdCtr1.createSet("456", "James Bond", "Hans Jensen", "07-04-1999", "12345678", "01-01-2000", 199.99);
        dvdCtr1.createSet("12345657", "Guderne", "Gud", "i går", "jghsjfkldh4", "i dag", 2000);
        dvdCtr1.createDvd("0987654321", "Leben", "Stasi", "i forgaars");
        dvdCtr1.createCopy("uz74", "i dag", 131.33, dvdCtr1.findDvd("Guderne"));
        dvdCtr1.removeCopy("a123b456");
        //assetEquals(true, dvdCtr1.removeCopy("uz74"));
    }
}

