package controllerlayer;
import modellayer.*;

/**
 * a class which controlls the dvd and copys
 * 
 * @author Andreas Reng Mogensen
 * @version 05/11-14
 */
public class DvdCtr
{
    private DvdContainer dCon;
    private Dvd dvd;
    private Copy copy;
    /**
     * Constructor for objects of class DvdCtr
     */
    public DvdCtr()
    {
        dCon = DvdContainer.getDvdContainer();
    }

    /**
     * creats a dvd and adds it to the dvdContainer
     * 
     * @param b, barcode
     * @param t, title
     * @param a, artist
     * @param pD, publicationDate
     */
    public void createDvd(String b, String t, String a, String pD)
    {
        Dvd d = new Dvd(b, t, a, pD);
        dCon.addDvd(d);
    }

    /**
     * creates a copy of a dvd and places it in the dvd's set
     * 
     * @param serial, serialnumber of the copy
     * @param pD, purchase date of the copy
     * @param pP, purchase price of the copy
     * @param d, the dvd to add the copy to.
     */
    public void createCopy(String serial, String pD, double pP, Dvd d)
    {
        if(dCon.copyDuplicationPrevention(serial) == true)
        {
            Copy c = new Copy(serial, pD, pP);
            d.addCopy(c);
        }else{
            System.out.println("ERROR: Duplication");
        }
    }

    /**
     * creates a set of dvd and a copy which is allocated to it.
     * @param b, barcode
     * @param t, title
     * @param a, artist
     * @param pD, publicationDate
     * @param serial, serialnumber of the copy
     * @param puD, purchase date of the copy
     * @param pP, purchase price of the copy
     * @param d, the dvd to add the copy to.
     */
    public void createSet(String b, String t, String a, String pD, String serial, String puD, double pP)
    {
        Dvd dvd = new Dvd(b, t, a, pD);
        Copy c = new Copy(serial, pD, pP);
        dCon.addDvd(dvd);
        dvd.addCopy(c);
    }

    /**
     * A method which finds the specific dvd based on title.
     * 
     * @param   title   the title which will be searched upon in the dvdcontainer class.
     * @return  dvd     the whole dvd object if found
     */
    public Dvd findDvd(String title)
    {
        return dCon.findDvd(title);
    }
    
    public Copy findCopy(String sNr)
    {
        return dCon.findCopy(sNr);
    }

    public Copy getAvailable(String title)
    {
        return dCon.findDvd(title).getAvailable();
    }

    /**
     * removes the specified dvd
     * @param title
     */
    public void removeDvd(String title)
    {
        Dvd fD = findDvd(title);
        if(fD != null)
        {
            dCon.removeDvd(fD);
        }else{
            System.out.println("No dvd found");
        }
    }

    /**
     * supposidly removes the desired copy
     */
    public void removeCopy(String sNr)
    {
        dCon.removeCopy(sNr);
    }
}
