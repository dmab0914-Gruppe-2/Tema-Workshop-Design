package modellayer;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class PersonContainer here.
 * 
 * @author Nicklas
 * @version 1.0
 */
public class PersonContainer
{
    // instance variables - replace the example below with your own
    private ArrayList<Person> persons;
    private static PersonContainer pC; 

    /**
     * Constructor for objects of class PersonContainer
     */
    private PersonContainer()
    {
        // initialise instance variables
        persons = new ArrayList<Person>();
    }

    /**
     * Method getPC, add new person container in singleton
     *
     * @return The return value a container
     */
    public static synchronized PersonContainer getPC() // singleton
    {
        if(pC == null)
        {
            pC = new PersonContainer();
        }

        return pC;
    }

    /**
     * Method addPerson 
     * 
     *  adds a person to the list of persons
     *
     * @param p A parameter of a Person object
     */
    public void addPerson(Person p)
    {
        persons.add(p);
    }

    /**
     * Method findPerson
     *
     * @param p A parameter of the phone number on the person you want to find
     * @return The return value the matching person to the phone number
     */
    public Person findPerson(String p)
    {
        int i=0;
        boolean found = false;
        while(!found && i<persons.size())
        {
            if(p.equals(persons.get(i).getPhone()))
            {
                found = true;
            }
            else
            {
                i++;
            }
        }

        if(found)
        {
            return persons.get(i);
        }
        else
        {
            return null;
        }
    }

    /**
     * Method deletePerson
     *  this method is used by PersonCtr to delete a person
     *
     * @param person A parameter object on the person you want to delete 
     */
    public void deletePerson(Person person)
    {
        Iterator<Person> it = persons.iterator();
        while(it.hasNext())
        {
            Person p = it.next();
            if(p.getPhone().equals(person.getPhone()))
            {
                it.remove();
            }
        }
    }

    /**
     * Method updatePerson
     *  this method is used by PersonCtr to update name on a person
     *
     * @param name A parameter of what a persons name is to be
     */
    public void updatePersonName(Person fp, String name)
    {
        fp.setName(name);
    }
    
    /**
     * Method updatePerson
     *  this method is used by PersonCtr to update address on a person
     *
     * @param address A parameter of what a persons address is to be
     */
    public void updatePersonAddress(Person fp, String address)
    {
        fp.setAddress(address);
    }
    
    /**
     * Method updatePerson
     *  this method is used by PersonCtr to update postalCode on a person
     *
     * @param postalCode A parameter of what a persons postalCode is to be
     */
    public void updatePersonPostalCode(Person fp, int postalCode)
    {
        fp.setPostalCode(postalCode);
    }
    
    /**
     * Method updatePerson
     *  this method is used by PersonCtr to update postalCode on a person
     *
     * @param city A parameter of what a persons city is to be
     */
    public void updatePersonCity(Person fp, String city)
    {
        fp.setCity(city);
    }
    
    /**
     * Method updatePerson
     *  this method is used by PersonCtr to update postalCode on a person
     *
     * @param phone A parameter of what a persons phone is to be
     */
    public void updatePersonPhone(Person fp, String phone)
    {
        fp.setPhone(phone);
    }
}
