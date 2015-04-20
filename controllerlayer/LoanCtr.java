package controllerlayer;
import modellayer.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Controller for loan related tasks. Controlls the modellayers LoanContainer and Loan classes.
 * 
 * @author (Jacob Pedersen) 
 * @version (06 Nov, 2014)
 */
public class LoanCtr
{
    private LoanContainer loanCon;
    private Person person;
    private Dvd dvd;
    private Copy copy;

    /**
     * Constructor for objects of class LoanCtrl
     */
    public LoanCtr()
    {
        this.loanCon = LoanContainer.getInstance(); //Retrieves the LoanContainer.
    }

    /**
     * Finds a person by number, and adds the person to the obejcts person variable.
     * 
     * @param   number   the phone number of the person to search for.
     * @return  Returns true if search found a person and false if not.
     */
    public boolean findPerson(String number)
    {
        person = new PersonCtr().findPerson(number);
        if(person != null)
        {
            return true;
        }
        return false;
    }

    /**
     * Finds a dvd by title, and ads the dvd to the objects dvd variable.
     * 
     * @param   title   the dvd title to search for.
     * @return  Returns true if search found a dvd and false if not.
     */
    public boolean findDvd(String title)
    {
        dvd = new DvdCtr().findDvd(title);
        if(dvd != null)
        {
            return true;
        }
        return false;
    }

    /**
     * Returns the title from the dvd.
     * 
     * @return  the dvd title.
     */
    public String getDvdTitle()
    {
        if(dvd != null)
        {
            return dvd.getTitle();
        }
        return null;
    }

    /**
     * Returns the artist name from the dvd.
     * 
     * @return  the Dvd artist.
     */
    public String getDvdArtist()
    {
        if(dvd != null)
        {
            return dvd.getArtist();
        }
        return null;
    }

    /**
     * Returns the publication date for the dvd.
     * 
     * @return  publication date.
     */
    public String getPublicationDate()
    {
        if(dvd != null)
        {
            return dvd.getPublicationDate();
        }
        return null;
    }

    /**
     * checks if there's an available Copy, and adds it the global varriable copy.
     * 
     * @return true if a Copy is available
     */
    public boolean findDvdAvailableCopy()
    {
        if(dvd != null)
        {
            copy = dvd.getAvailable();
            if(copy != null)
            {
                copy.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Method createLoan
     *
     * @param returnDate date for the loan to be returned formated dd-mm-yyyy
     * @return true if succeded and false if not.
     */
    public boolean createLoan(String returnDate)
    {
        if(this.person != null && this.copy != null)
        {
            String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
            loanCon.addLoan(new Loan(this.person, this.copy, currentDate, returnDate));
            return true;
        }
        return false;
    }
    
    /**
     * Method returnDvd
     *
     * @param serialNumber serialNumber of copy to be returned.
     * @return true if succeded and false if not.
     */
    public boolean returnDvd(String serialNumber)
    {
        Loan loan = loanCon.getLoanByCopy(serialNumber);
        if(loan != null)
        {
            loan.setState("Returned");
            loan.getCopy().setAvailable(true);
            return true;
        }
        return false;
    }
}
