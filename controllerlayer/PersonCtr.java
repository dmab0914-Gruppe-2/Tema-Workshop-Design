package controllerlayer;
import modellayer.*;
import java.util.ArrayList;

/**
 * Write a description of class PersonCtr here.
 * 
 * @author Nicklas, 
 * @version 1.0
 */
public class PersonCtr
{
    // instance variables - replace the example below with your own
    private PersonContainer pCon;
    private Person person;
    /**
     * Constructor for objects of class PersonCtr
     */
    public PersonCtr()
    {
        // initialise instance variables
        pCon = PersonContainer.getPC();//singleton
    }

    public void createPerson(String name, String address, int postalCode, String city, String phone)
    {
        Person myPerson = new Person(name, address, postalCode, city, phone);
        pCon.addPerson(myPerson);
    }

    /**
     * Method findPerson
     *
     * @param phone A parameter of the phone number of the person your looking for
     * @return The return value the matching person for your result (returns null if notthing found)
     */
    public Person findPerson(String phone)
    {
        return pCon.findPerson(phone);
    }

    /**
     * Method deletePerson
     * 
     *  fp = found person
     *
     * @param phone A parameter of the phone number on the person you want to find and delete
     */
    public boolean deletePerson(String phone)
    {
        Person fp = findPerson(phone);
        boolean d = false;
        if(fp != null)
        {
            pCon.deletePerson(fp);
            d = true;
        }
        else
        {
            d = false;
        }

        if(d)
        {
            return d;
        }
        else
        { 
            return d;
        }
    }

    /**
     * Method updatePersonName
     *
     * @param searchPhone A parameter the phone number on the person you will change info on
     * @param name A parameter the new name 
     * @return The return value if change made
     */
    public boolean updatePersonName(String searchPhone, String name)
    {
        boolean succes = false;        
        Person fp = findPerson(searchPhone);        
        if(fp != null)
        {
            pCon.updatePersonName(fp,name);
            succes = true;
        }        
        return succes;
    }

    /**
     * Method updatePersonAddress
     *
     * @param searchPhone A parameter the phone number on the person you will change info on
     * @param address A parameter the new Address 
     * @return The return value if change made
     */
    public boolean updatePersonAddress(String searchPhone, String address)
    {
        boolean succes = false;        
        Person fp = findPerson(searchPhone);        
        if(fp != null)
        {
            pCon.updatePersonAddress(fp,address);
            succes = true;
        }        
        return succes;
    }

    /**
     * Method updatePersonPostalCode
     *
     * @param searchPhone A parameter the phone number on the person you will change info on
     * @param postalCode A parameter the new postalCode 
     * @return The return value if change made
     */
    public boolean updatePersonPostalCode(String searchPhone, int postalCode)
    {
        boolean succes = false;        
        Person fp = findPerson(searchPhone);        
        if(fp != null)
        {
            pCon.updatePersonPostalCode(fp,postalCode);
            succes = true;
        }        
        return succes;
    }

    /**
     * Method updatePersonCity
     *
     * @param searchPhone A parameter the phone number on the person you will change info on
     * @param city A parameter the new city 
     * @return The return value if change made
     */
    public boolean updatePersonCity(String searchPhone, String city)
    {
        boolean succes = false;        
        Person fp = findPerson(searchPhone);        
        if(fp != null)
        {
            pCon.updatePersonCity(fp,city);
            succes = true;
        }        
        return succes;
    }

    /**
     * Method updatePersonPhone
     *
     * @param searchPhone A parameter the phone number on the person you will change info on
     * @param city A parameter the new city 
     * @return The return value if change made
     */
    public boolean updatePersonPhone(String searchPhone, String phone)
    {
        boolean succes = false;        
        Person fp = findPerson(searchPhone);        
        if(fp != null)
        {
            pCon.updatePersonPhone(fp,phone);
            succes = true;
        }        
        return succes;
    }
}
