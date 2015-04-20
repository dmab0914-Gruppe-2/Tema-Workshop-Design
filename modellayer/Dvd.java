package modellayer;
import java.util.ArrayList;

/**
 * a class which contains a list of copies within a specific dvd movie collection. I.e. you may have 5 jaws
 * movies which would be 5 copies of the dvd jaws.
 * 
 * @author Andreas Reng Mogensen 
 * @version 04/11-14
 */
public class Dvd
{
    private String barcode;
    private String title;
    private String artist;
    private String publicationDate;
    private ArrayList<Copy> copys;

    /**
     * Constructor for objects of class Dvd
     * 
     * @param b     the barcode located on the dvd
     * @param t     the title of the movie
     * @param a     the artist (or instructor) of the movie
     * @param p     the publication date of the movie.
     */
    public Dvd(String b, String t, String a, String p)
    {
        this.barcode = b;
        this.title = t;
        this.artist = a;
        this.publicationDate = p;
        copys = new ArrayList<Copy>();
    }
    
    /**
     * adds a copy to the dvd's container
     * 
     * @param Copy, a copy of a dvd
     */
    public void addCopy(Copy c)
    {
        copys.add(c);
    }

    /**
     * returns the copy with matching the specified serialnumber
     * 
     * @param   serialNumber  the desired serialNumber which is searched upon
     * @return  if found, the copy class, otherwise null
     */
    public Copy findSerialNumber(String serialNumber)
    {
        for(int i=0; i<copys.size(); i++)
        {
            if(copys.get(i).getSerialNumber().equals(serialNumber))
            {
                return copys.get(i);
            }
        }
        return null;
    }
    
    /**
     * remove copy based on serialNumber
     * @param serialnumber
     */
    public void removeCopy(Copy c)
    {
        copys.remove(c);
    }
    
    /**
     * returns the first available copy
     * 
     * @return copy of an available copy for rent
     */
    public Copy getAvailable()
    {
        for(int i=0; i<copys.size(); i++)//Copy c : copys)
        {
            if(copys.get(i).isAvailable() == true)
            {
                return copys.get(i);
            }
        }
        return null;
    }

    /**
     * getters
     */
    /**
     * returns the barcode of the dvd
     * @return barcode
     */
    public String getBarcode()
    {
        return barcode;
    }

    /**
     * returns the artist of the movie
     * @return artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * returns the date of publication
     * @return publicationDate
     */
    public String getPublicationDate()
    {
        return publicationDate;
    }

    /**
     * returns the title of the dvd
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * setters
     */
    /**
     * sets the barcode of the dvd
     * @param b the new barcode
     */
    public void setBarcode(String b)
    {
        this.barcode = b;
    }

    /**
     * sets the artist of the dvd
     * @param a, the new artist
     */
    public void setArtist(String a)
    {
        this.artist = a;
    }

    /**
     * sets the publicationDate of the dvd
     * @param d, the new publicationDate
     */
    public void setPublicationDate(String d)
    {
        this.publicationDate = d;
    }

    /**
     * sets the title of the dvd
     * @param t, the new title
     */
    public void setTitle(String t)
    {
        this.title = t;
    }
}
