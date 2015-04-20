package modellayer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * a container class which contains the tools for finding and controlling the Dvd collection
 * 
 * @author Andreas Reng Mogensen
 * @version 04/11-14
 */
public class DvdContainer
{
    private static DvdContainer dC;
    private ArrayList <Dvd> dvds;
    /**
     * Constructor for objects of class DvdContainer
     */
    private DvdContainer()
    {
        dvds = new ArrayList<Dvd>();
    }

    /**
     * A method to make sure that theres only one instance of this class.
     */
    public static synchronized DvdContainer getDvdContainer()
    {
        if(dC == null)
        {
            dC = new DvdContainer();
        }
        return dC;
    }

    /**
     * Adds a dvd to the arraylist
     */
    public void addDvd(Dvd d)
    {
        dvds.add(d);
    }

    public Dvd findDvd(String title)
    {
        boolean found=false;
        int i=0;
        while(!found&&i<dvds.size())
        {
            if(dvds.get(i).getTitle().equals(title))
            {
                found = true;
            }else{
                i++;
            }
        }

        if(found)
        {
            return dvds.get(i);
        }else{
            return null;
        }
    }
    
    public Copy findCopy(String sNr)
    {
        boolean f = false;
        int i=0;
        while(!f && i<dvds.size())
        {
            //dvds.get(i).findSerialNumber(sNr);
            return dvds.get(i).findSerialNumber(sNr);
        }
        
        if(f)
        {
            return dvds.get(i).findSerialNumber(sNr);
        }else{
            return null;
        }
    }

    /**
     * deletes the selected dvd
     * @param Dvd, a parameter used to define the object to be deleted
     */
    public void removeDvd(Dvd dvd)
    {
        Iterator<Dvd> i = dvds.iterator();
        while(i.hasNext())
        {
            Dvd d = i.next();
            if(d.getTitle().equals(dvd.getTitle()))
            {
                i.remove();
            }
        }
    }

    /**
     * removes the specified copy
     * @param serialNumber
     */
    public void removeCopy(String sNr)
    {
        for(int i=0; i<dvds.size(); i++)
        {
            //dvds.get(i).findSerialNumber(sNr);
            dvds.get(i).removeCopy(dvds.get(i).findSerialNumber(sNr));
        }
        //System.out.println("NF");
        //dCon.deleteCopy(sNr);
    }
    
    public boolean copyDuplicationPrevention(String sNr)
    {
        for(int i=0; i<dvds.size(); i++)
        {
            if(dvds.get(i).findSerialNumber(sNr) != null)
            {
                return false;
            }
        }
        return true;
    }
}
