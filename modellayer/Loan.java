package modellayer;


/**
 * Stores information about the loan of a dvd.
 * 
 * @author (Jacob Pedersen) 
 * @version (06 Nov, 2014)
 */
public class Loan
{
    private Person person;
    private Copy copy;
    private String borrowDate;
    private String period;
    private String state;
    
    /**
     * Constructor for objects of class Loan
     */
    public Loan(Person person, Copy copy, String borrowDate, String period)
    {
        this.person = person;
        this.copy = copy;
        this.borrowDate = borrowDate;
        this.period = period;
        this.state = "loaned";
    }
    
    /**
     * @return returns the Copy.
     */
    public Copy getCopy()
    {
        return copy;
    }
    
    /**
     * @param state the current loan state. (loaned or returned)
     */
    public void setState(String state)
    {
        this.state = state;
    }
}
