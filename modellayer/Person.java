package modellayer;

/**
 * Write a description of class Person here. This class is for keeping all person/loaners in the system
 * 
 * @author Nicklas,
 * @version (1.0)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private String phone;

    /**
     * Constructor for objects of class Person
     *
     * @param name A parameter of the persons name
     * @param address A parameter of the persons address
     * @param postalCode A parameter of the persons postal code
     * @param city A parameter of the persons city
     * @param phone A parameter of the persons phone number
     */
    public Person(String name, String address, int postalCode, String city, String phone)
    {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }

    /**
     * Method getName
     *
     * @return The return value name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Method getAddress
     *
     * @return The return value address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Method postalCode
     *
     * @return The return value postalCode
     */
    public int getPostalCode()
    {
        return postalCode;
    }

    /**
     * Method getCity
     *
     * @return The return value city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Method getPhone
     *
     * @return The return value phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Method setName
     *
     * @param n A parameter of the new name
     */
    public void setName(String n)
    {
        this.name = n;
    }

    /**
     * Method setAddress
     *
     * @param a A parameter  of the new address
     */
    public void setAddress(String a)
    {
        this.address = a;
    }

    /**
     * Method setPostalCode
     * 
     * @param p A parameter of the new postal code
     */
    public void setPostalCode(int p)
    {
        this.postalCode = p;
    }

    /**
     * Method setCity
     *
     * @param c A parameter of the new city
     */
    public void setCity(String c)
    {
        this.city = c;
    }

    /**
     * Method setPhone
     *
     * @param p A parameter of the new phone
     */
    public void setPhone(String p)
    {
        this.phone = p;
    }
}
