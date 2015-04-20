package controllerlayer;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import modellayer.*;

/**
 * The test class testUnit.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testUnit
{
    private controllerlayer.PersonCtr personCt1;

    /**
     * Default constructor for test class testUnit
     */
    public testUnit()
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
        personCt1 = new controllerlayer.PersonCtr();
        personCt1.createPerson("batman", "the Cave", 4321, "Gotham", "11223344");
        personCt1.createPerson("supermand", "rummet", 1234, "smallville", "99887766");
        personCt1.createPerson("nicklas", "børsen", 9800, "hjørring", "22403382");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        personCt1.deletePerson("11223344");
        personCt1.deletePerson("99887766");
        personCt1.deletePerson("22403382");
    }

    @Test
    public void testCreatePerson()
    {
        controllerlayer.PersonCtr personCt2 = new controllerlayer.PersonCtr();
        personCt2.createPerson("nicklas", "børsen", 9800, "hjørring", "22403382");
        personCt2.createPerson("supermand", "rummet", 1234, "smallville", "99887766");
        personCt2.createPerson("batman", "the Cave", 4321, "Gotham", "11223344");
    }

    @Test
    public void testFindNegativ()
    {
        assertEquals(null, personCt1.findPerson("supermand"));
    }

    @Test
    public void testFindPerson()
    {
        Person myfound = personCt1.findPerson("99887766");
        
        assertEquals("supermand", myfound.getName());
        assertEquals("smallville", myfound.getCity());
    }

    @Test
    public void testUpdateOnAllFields()
    {
        assertEquals(true, personCt1.updatePersonAddress("22403382", "ny vej 19"));
        assertEquals(true, personCt1.updatePersonCity("22403382", "aalborg"));
        assertEquals(true, personCt1.updatePersonName("22403382", "nyt navn"));
        assertEquals(true, personCt1.updatePersonPostalCode("22403382", 9000));
        assertEquals(true, personCt1.updatePersonPhone("22403382", "12345678"));
        
        assertEquals(true, personCt1.updatePersonPhone("12345678", "22403382")); // reverse change
    }

    @Test
    public void testUpdateOnAllFieldsOnNoPersonFound()
    {
        assertEquals(false, personCt1.updatePersonAddress("12345678", "ny vej 19"));
        assertEquals(false, personCt1.updatePersonCity("12345678", "aalborg"));
        assertEquals(false, personCt1.updatePersonName("12345678", "nyt navn"));
        assertEquals(false, personCt1.updatePersonPostalCode("12345678", 9000));
        assertEquals(false, personCt1.updatePersonPhone("12345678", "22403382"));
    }

    @Test
    public void testDeletePerson()
    {
        Person myfound = personCt1.findPerson("22403382");
        
        assertEquals("nicklas", myfound.getName());
        assertEquals("hjørring", myfound.getCity());
        
        personCt1.deletePerson("22403382");
        
        assertEquals(null, personCt1.findPerson("22403382"));
    }
}






