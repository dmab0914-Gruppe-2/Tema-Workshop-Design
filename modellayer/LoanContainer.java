package modellayer;
import java.util.ArrayList;


/**
 * Container for all Loan objects.
 * 
 * @author (Jacob Pedersen) 
 * @version (06 Nov, 2014)
 */
public class LoanContainer
{
    // instance variables - replace the example below with your own
    private static LoanContainer loanContainer;
    private ArrayList <Loan> loans;

    /**
     * Constructor for objects of class LoanContainer
     */
    private LoanContainer()
    {
        loans = new ArrayList<Loan>();
    }

    /**
     * Makes a new LoanContainer object, if one doesn't allready exist. 
     * Else it will return the already created LoanCOntainer object.
     * 
     * @return     The LoanContainer 
     */
    public static synchronized LoanContainer getInstance()
    {
        if(loanContainer == null)
        {
            loanContainer = new LoanContainer();
        }
        return loanContainer;
    }
    
    /**
     * Adds a Loan object to the container.
     * 
     * @param   loan    Loan object to be added to the container.
     */
    public void addLoan(Loan loan)
    {
        loans.add(loan);
    }
    
    /**
     * Finds Loan that contains given Copy
     * 
     * @param   serialNumber    the copys serialNumber.
     * @return Loan which contains the selected copy
     */
    public Loan getLoanByCopy(String serialNumber)
    {
        for(int i = 0; i < loans.size(); i++)
        {
            if(loans.get(i).getCopy().getSerialNumber().equals(serialNumber))
            {
                return loans.get(i);
            }
        }
        return null;
    }
}
