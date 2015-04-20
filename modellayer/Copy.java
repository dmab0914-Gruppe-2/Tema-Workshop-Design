package modellayer;


/**
 * a unique copy of a dvd
 * 
 * @author Andreas Reng Mogensen
 * @version 04/11-14
 */
public class Copy
{
    private String serialNumber;
    private String purchaseDate;
    private double purchasePrice;
    private boolean available = true;

    /**
     * Constructor for objects of class Copy
     * 
     * @param s, Serialnumber
     * @param pD, purchaseDate
     * @param pP, purchasePrice
     */
    public Copy(String s, String pD, double pP)
    {
        this.serialNumber = s;
        this.purchaseDate = pD;
        this.purchasePrice = pP;
        this.available = true;
    }
    
    
    /**
     * Getters
     */
    /**
     * returns wether or not the specific copy is available.
     */
    public boolean isAvailable()
    {
        return available;
    }
    /**
     * returns the specific copys serialnumber
     */
    public String getSerialNumber()
    {
        return serialNumber;
    }
    /**
     * Returns the definied purchasedate
     */
    public String getPurchaseDate()
    {
        return purchaseDate;
    }
    /**
     * returns the definied price at purchase
     */
    public double getPurchasePrice()
    {
        return purchasePrice;
    }
    
    /**
     * Setters
     */
    /**
     * sets the availability of available
     */
    public void setAvailable(boolean a)
    {
        this.available = a;
    }
    /**
     * sets the serialNumber
     */
    public void setSerialNumber(String s)
    {
        this.serialNumber = s;
    }
    /**
     * sets the date of purchase
     */
    public void setPurchaseDate(String d)
    {
        this.purchaseDate = d;
    }
    /**
     * Sets the price at purchase
     */
    public void setPurchasePrice(double p)
    {
        this.purchasePrice = p;
    }
}
