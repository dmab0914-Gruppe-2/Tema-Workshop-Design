package controllerlayer;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LoanCtrTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LoanCtrTest
{
    /**
     * Default constructor for test class LoanCtrTest
     */
    public LoanCtrTest()
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

    @Test
    public void createLoan()
    {
        controllerlayer.LoanCtr loanCtr1 = new controllerlayer.LoanCtr();
        controllerlayer.DvdCtr dvdCtr1 = new controllerlayer.DvdCtr();
        controllerlayer.PersonCtr personCtr1 = new controllerlayer.PersonCtr();
        personCtr1.createPerson("John", "JohnsonStreet 2", 9000, "JohnStrup", "88888888");
        dvdCtr1.createDvd("ewho235iw", "Guderne", "Gud", "2 uger siden");
        dvdCtr1.createCopy("we9f98392", "5 dage siden", 32750, dvdCtr1.findDvd("Guderne"));
        assertEquals(true,loanCtr1.findPerson("88888888"));
        assertEquals(true,loanCtr1.findDvd("Guderne"));
        assertEquals(true, loanCtr1.findDvdAvailableCopy());
        assertEquals(true, loanCtr1.createLoan("07-11-2014"));
    }
    
    @Test
    public void returnLoan()
    {
        controllerlayer.LoanCtr loanCtr1 = new controllerlayer.LoanCtr();
        controllerlayer.DvdCtr dvdCtr1 = new controllerlayer.DvdCtr();
        controllerlayer.PersonCtr personCtr1 = new controllerlayer.PersonCtr();
        personCtr1.createPerson("John", "JohnsonStreet 2", 9000, "JohnStrup", "88888888");
        dvdCtr1.createDvd("ewho235iw", "Guderne", "Gud", "2 uger siden");
        dvdCtr1.createCopy("we9f98392", "5 dage siden", 32750, dvdCtr1.findDvd("Guderne"));
        assertEquals(true,loanCtr1.findPerson("88888888"));
        assertEquals(true,loanCtr1.findDvd("Guderne"));
        assertEquals(true, loanCtr1.findDvdAvailableCopy());
        assertEquals(true, loanCtr1.createLoan("07-11-2014"));
        assertEquals(true, loanCtr1.returnDvd("we9f98392"));
    }

    @Test
    public void getMethods()
    {
        controllerlayer.LoanCtr loanCtr1 = new controllerlayer.LoanCtr();
        controllerlayer.DvdCtr dvdCtr1 = new controllerlayer.DvdCtr();
        controllerlayer.PersonCtr personCtr1 = new controllerlayer.PersonCtr();
        personCtr1.createPerson("John", "JohnsonStreet 2", 9000, "JohnStrup", "88888888");
        dvdCtr1.createDvd("ewho235iw", "Guderne", "Gud", "2 uger siden");
        dvdCtr1.createCopy("we9f98392", "5 dage siden", 32750, dvdCtr1.findDvd("Guderne"));
        assertEquals(true,loanCtr1.findPerson("88888888"));
        assertEquals(true,loanCtr1.findDvd("Guderne"));
        assertEquals(true, loanCtr1.findDvdAvailableCopy());
        assertEquals(true, loanCtr1.createLoan("07-11-2014"));
        assertEquals("Gud", loanCtr1.getDvdArtist());
        assertEquals("Guderne", loanCtr1.getDvdTitle());
        assertEquals("2 uger siden", loanCtr1.getPublicationDate());
    }
}


