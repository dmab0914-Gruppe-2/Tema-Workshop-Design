package tuilayer;
import controllerlayer.*;
import modellayer.*;
import java.util.Scanner;

/**
 * the text based gui
 * 
 * @author Jacob Pedersen & Andreas Mogensen & Nicklas Welle
 * @version 04/11-14
 */
public class MainMenuUI
{
    // instance variables
    private DvdCtr dCtr;
    private PersonCtr pCtr;
    private LoanCtr loanCtr;

    /**
     * Constructor for objects of class MainMenuUI
     */
    public MainMenuUI()
    {
        pCtr = new PersonCtr();
        dCtr = new DvdCtr();
        //mainMenu();
    }

    /**
     * a method which initializes the specific submenu in this main menu.
     */
    public void mainMenu()
    {

        boolean exit = false;
        while(!exit)
        {
            System.out.println("*** Main Menu ***");
            System.out.println(" 1. Friends");
            System.out.println(" 2. DVD's");
            System.out.println(" 3. Loan");
            System.out.println(" 4. Close");
            System.out.println("    Make your Choice");
            System.out.print("Choice: ");

            int choice = menuInput(); //Retrieves input from user as integer.
            System.out.println();
            if(choice == 1)
            {
                //goto friends
                friendsMenu();
            }
            else if(choice == 2)
            {
                //goto DVD's
                dvdMenu();
            }
            else if(choice == 3)
            {
                //goto Loan
                loanMenu();
            }
            else if(choice == 4)
            {
                exit = true;
                System.exit(0); //Stops the virtual machine
            }
            else
            {
                exit = true;
                mainMenu(); //Reinitiates the menu on faulty input
            }
        }
    }

    /**
     * Waits for user input and returns input as integer.
     * 
     * @return      chosen menu from input as integer
     */
    private int menuInput()
    {
        Scanner keyboard = new Scanner(System.in);
        int returnValue = 0;
        String input = keyboard.next();
        if(isInt(input) == true) //Checks if input is integer
        {
            returnValue = Integer.parseInt(input);
        }
        return returnValue;
    }

    /**
     * Checks if String can be converted to integer.
     * 
     * @param   string  string to check if integer
     * @return  true if string can converted to integer, false if not.
     */
    private boolean isInt(String string)
    {
        try
        {
            int number = Integer.parseInt(string);
        }
        catch(NumberFormatException e) //catches error if parsing input to integer fails.
        {
            return false;
        }
        return true;
    }

    /**
     * friends menu utilized from main menu
     */
    private void friendsMenu()
    {
        boolean exit = false;
        while(!exit)
        {
            System.out.println("*** Friends Menu ***");
            System.out.println(" 1. Create");
            System.out.println(" 2. Read");
            System.out.println(" 3. Update");
            System.out.println(" 4. Delete");
            System.out.println(" 5. Back");
            System.out.println("    Make your Choice");
            System.out.print("Choice: ");

            int choice = menuInput(); //Retrieves input from user as integer.
            System.out.println();
            if(choice == 1)
            {
                createFriend();
            }
            else if(choice == 2)
            {
                Person p = findFriend();

                if(p != null)
                {
                    System.out.println("din vens navn er: "+ p.getName());
                    System.out.println("din vens addresse er: "+ p.getAddress() + " " + p.getCity() + " " + p.getPostalCode());
                }
                else
                {
                    System.out.println("no match");
                }
            }
            else if(choice == 3)
            {
                if(updateFriend())
                {
                    System.out.println("oplysninger er opdateret");
                }
                else
                {
                    System.out.println("ingen ven med dette nummer");
                }
            }
            else if(choice == 4)
            {
                if(deleteFriend())
                {
                    System.out.println("ven slettet");
                }
                else
                {
                    System.out.println("ingen ven med dette nummer");
                }
            }
            else if(choice == 5)
            {
                exit = true;
            }
            else
            {
                exit = true;
                friendsMenu(); //Reinitiates the menu on faulty input
            }
        }
    }

    /**
     * Method createFriend
     *  This method takes all the return variables and puts them togehter and create a person
     *    
     */
    private void createFriend()
    {
        String name = inputFriendName();
        String address = inputFriendAddress();
        int postal = inputFriendPostalCode();
        String city = inputFriendCity();
        String phone = inputFriendPhone();

        pCtr.createPerson(name, address, postal, city, phone);
    }

    /**
     * Method inputFriendName
     *  this is a method to pass on name to createFriend()
     *
     * @return The return value friend name
     */
    private String inputFriendName()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Angiv navn:  ");
        String name = keyboard.nextLine();
        return name;
    }

    /**
     * Method inputFriendAddress
     *  this is a method to pass on name to createFriend()
     * @return The return value friend address
     */
    private String inputFriendAddress()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Angiv address:  ");
        String address = keyboard.nextLine();
        return address;
    }

    /**
     * Method inputFriendPostalCode
     *  this is a method to pass on postal code to createFriend()
     *      This method is making sure that the input will be a int(number)
     *      if it isn't a number will keep trying until a number is entered
     * @return The return value friend postal code
     */
    private int inputFriendPostalCode()
    {
        boolean ok = false;
        int nr = 0;
        while(!ok)
        {
            // makes an object keyboard to have input from the console
            Scanner keyboard = new Scanner(System.in);
            System.out.println(" Angiv post nr:  ");
            try{
                nr = keyboard.nextInt();
                ok = true;
            }
            catch (Exception e)
            {
                System.out.println("Input skal vaere et tal - prov igen");
                String input = keyboard.nextLine();
            }
        }//end while
        return nr;
    }

    /**
     * Method inputFri
     *  this is a method to pass on city to createFriend()
     * @return The return value friend city
     */
    private String inputFriendCity()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Angiv by:  ");
        String city = keyboard.nextLine();
        return city;
    }

    /**
     * Method inputFriendPhone
     *  this is a method to pass on phone to createFriend()
     *  Also used in findFriend()
     *  
     * @return The return value friend phone
     */
    private String inputFriendPhone()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Angiv tlf nr:  ");
        String phone = keyboard.nextLine();
        return phone;
    }

    /**
     * Method findFriend
     * 
     *  actually have a parameter of phone number to do the search by
     *
     * @return The return value the matching friend on the searched phone number
     */
    private Person findFriend()
    {
        String phone = inputFriendPhone();
        Person p = (pCtr.findPerson(phone));
        return p;
    }

    /**
     * Method updateFriend
     *  actually have a parameter of phone number to do the search by
     *  
     * @return The return value if friend has been found and updated
     */
    private boolean updateFriend()
    {
        String phone = inputFriendPhone();
        Person p = (pCtr.findPerson(phone));
        boolean updated = false;

        if(p == null) 
        {
            return updated; // if no one found on searched number it will just return false
        }
        else
        {
            String name = inputFriendName();
            String address = inputFriendAddress();
            int postal = inputFriendPostalCode();
            String city = inputFriendCity();
            String newPhone = inputFriendPhone();

            p.setName(name);
            p.setAddress(address);
            p.setPostalCode(postal);
            p.setCity(city);
            p.setPhone(newPhone);
            updated = true;
            return updated;
        }

    }

    /**
     * Method deleteFriend
     *  actually have a parameter of phone number to do the search by
     *  
     * @return The return value true/false if the person has been deleted
     */
    private boolean deleteFriend()
    {
        String phone = inputFriendPhone();
        boolean ok = pCtr.deletePerson(phone);

        return ok;
    }

    /**
     * DVD menu utilized from mainMenu
     */
    private void dvdMenu()
    {
        boolean exit = false;
        while(!exit)
        {
            System.out.println("*** DVD Menu ***");
            System.out.println(" 1. Create");
            System.out.println(" 2. Read");
            System.out.println(" 3. Update");
            System.out.println(" 4. Delete");
            System.out.println(" 5. Back");
            System.out.println("    Make your Choice");
            System.out.print("Choice: ");

            int choice = menuInput(); //Retrieves input from user as integer.
            System.out.println();
            if(choice == 1)
            {
                System.out.println("Create a DVD or Copy");
                System.out.println("");
                System.out.println("1. Create DVD");
                System.out.println("2. Create Copy");
                System.out.println("3. Create Set");
                System.out.print("Choice: ");
                int c = menuInput(); //Retrieves input from user as integer.
                System.out.println();

                if(c == 1)
                {
                    createDvd();
                }else if(c == 2){
                    createCopy();
                }else if(c == 3){
                    createSet();
                }
            }
            else if(choice == 2)
            {
                System.out.println("Read a DVD or Copy");
                System.out.println("");
                System.out.println("1. Read DVD");
                System.out.println("2. Read Copy");

                int c = menuInput(); //Retrieves input from user as integer.
                System.out.println();

                if(c == 1)
                {
                    Dvd d = findDvd();
                    if(d != null)
                    {
                        System.out.println("Title               : "+ d.getTitle());
                        System.out.println("Artist              : "+ d.getArtist());
                        System.out.println("Available           : "+ d.getAvailable());
                        System.out.println("Barcode             :" + d.getBarcode());
                        System.out.println("Publication date    : "+ d.getPublicationDate());
                    }
                    else
                    {
                        System.out.println("Dvd not found");
                    }
                }else if(c == 2){
                    Copy copy = findCopy();
                    if(copy != null)
                    {
                        System.out.println("Serial          : "+ copy.getSerialNumber());
                        System.out.println("Purchase Price  : "+ copy.getPurchasePrice());
                        System.out.println("Purchase Date   : "+ copy.getPurchaseDate());
                    }
                    else
                    {
                        System.out.println("didnt find the copy");
                    }
                }

            }
            else if(choice == 3)
            {
                System.out.println("Update a DVD or Copy");
                System.out.println("");
                System.out.println("1. Read DVD");
                System.out.println("2. Read Copy");

                int cc = menuInput(); //Retrieves input from user as integer.
                System.out.println();
                if(cc == 1)
                {
                    if(updateDvd())
                    {
                        System.out.println("Information updated");
                    }else{
                        System.out.println("Searchstring not found!");
                    }
                }else if(cc == 2){
                    if(updateDvd())
                    {
                        System.out.println("Information updated");
                    }else{
                        System.out.println("Searchstring not found!");
                    }
                }
            }
            else if(choice == 4)
            {
                System.out.println("Remove a DVD or Copy");
                System.out.println("");
                System.out.println("1. Delete DVD");
                System.out.println("2. Delete Copy");

                int ccc = menuInput(); //Retrieves input from user as integer.
                System.out.println();
                if(ccc == 1)
                {
                    deleteDvd();
                }else if(ccc == 2){
                    deleteCopy();
                }//goto delete
            }
            else if(choice == 5)
            {
                exit = true;
            }
            else
            {
                exit = true;
                dvdMenu(); //Reinitiates the menu on faulty input
            }
        }
    }

    private void deleteDvd()
    {
        String title = inputTitle();
        //boolean ok = 
        dCtr.removeDvd(title);

        //return ok;
    }

    private void deleteCopy()
    {
        String sNr = inputSerialNumber();
        //boolean ok = 
        dCtr.removeCopy(sNr);

        //return ok;
    }

    private boolean updateDvd()
    {
        String title = inputTitle();
        Dvd d = (dCtr.findDvd(title));
        boolean updated = false;

        if(d == null) 
        {
            return updated; // if no one found on searched number it will just return false
        }
        else
        {
            String t = inputTitle();
            String a = inputArtist();
            String b = inputBarcode();
            String pD = inputPublicationDate();

            d.setTitle(t);
            d.setArtist(a);
            d.setBarcode(b);
            d.setPublicationDate(pD);
            updated = true;
            return updated;
        }
    }

    private boolean updateCopy()
    {
        String sNr = inputSerialNumber();
        Copy c = (dCtr.findCopy(sNr));
        boolean updated = false;

        if(c == null) 
        {
            return updated; // if no one found on searched number it will just return false
        }
        else
        {
            String s = inputSerialNumber();
            String pD = inputPurchaseDate();
            int pP = inputPurchasePrice();

            c.setSerialNumber(s);
            c.setPurchaseDate(pD);
            c.setPurchasePrice(pP);
            updated = true;
            return updated;
        }
    }

    private Dvd findDvd()
    {
        String title = inputTitle();
        Dvd d = (dCtr.findDvd(title));
        return d;
    }

    private Copy findCopy()
    {
        String sNr = inputSerialNumber();
        Copy c = (dCtr.findCopy(sNr));
        return c;
    }

    private void createSet()
    {
        String sNr = inputSerialNumber();
        String pD = inputPurchaseDate();
        int pP = inputPurchasePrice();
        // String d = inputDvd();
        String b = inputBarcode();
        String t = inputTitle();
        String a = inputArtist();
        String puD = inputPublicationDate();
        dCtr.createSet(b, t, a, pD, sNr, puD, pP);
    }

    private void createDvd()
    {
        String b = inputBarcode();
        String t = inputTitle();
        String a = inputArtist();
        String pD = inputPublicationDate();

        dCtr.createDvd(b, t, a, pD);
    }

    private void createCopy()
    {
        String sNr = inputSerialNumber();
        String pD = inputPurchaseDate();
        int pP = inputPurchasePrice();
        String d = inputDvd();
        dCtr.createCopy(sNr, pD, pP, dCtr.findDvd(d));

    }

    private String inputBarcode()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define barcode: ");
        String b = keyboard.nextLine();
        return b;
    }

    private String inputTitle()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define Title: ");
        String t = keyboard.nextLine();
        return t;
    }

    private String inputArtist()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define Artist: ");
        String a = keyboard.nextLine();
        return a;
    }

    private String inputPublicationDate()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define publication date: ");
        String pD = keyboard.nextLine();
        return pD;
    }

    private String inputSerialNumber()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define Serialnumber: ");
        String sNr = keyboard.nextLine();
        return sNr;
    }

    private String inputPurchaseDate()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define Purchasedate: ");
        String pD = keyboard.nextLine();
        return pD;
    }

    private int inputPurchasePrice()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define Purchaseprice: ");
        int pP = menuInput();
        return pP;
    }

    private String inputDvd()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" Define DVD           : ");
        String d = keyboard.nextLine();
        return d;
    }

    /**
     * loan menu utilized from main menu
     */
    private void loanMenu()
    {
        boolean exit = false;
        while(!exit)
        {
            System.out.println("*** Loan Menu ***");
            System.out.println(" 1. Create");
            System.out.println(" 2. return DVD");
            System.out.println(" 3. Back");
            System.out.println("    Make your Choice");
            System.out.print("Choice: ");

            int choice = menuInput(); //Retrieves input from user as integer.
            System.out.println();
            if(choice == 1)
            {
                loanCtr = new LoanCtr();
                System.out.println("Loan a DVD.");
                if(loanFindPerson())
                {
                    if(loanFindDvd())
                    {
                        printLoanDvd();
                        System.out.println();
                        loanCtr.createLoan(input("Return Date (dd-mm-yyyy)"));
                    }
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                loanCtr = new LoanCtr();
                System.out.println("Return a DVD");
                if(loanCtr.returnDvd(input("Your copy's Serial Number")))
                {
                    System.out.println("The DVD have sucessfully been returned.");
                }
                else
                {
                    System.out.println("Couldn't find any DVD with that serial number.");
                }
            }
            else if(choice == 3)
            {
                exit = true;
            }
            else
            {
                exit = true;
                loanMenu(); //Reinitiates the menu on faulty input
            }
            System.out.println();
        }
    }

    /**
     * Method input
     *  this is a method to wait for user input.
     *
     * @return The input when received
     */
    private String input(String string)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(" " + string + ": "); //Some preformating with the input String.
        String input = keyboard.nextLine();
        System.out.println();
        return input;
    }

    /**
     * Handles the UI part of finding the given person by phone number.
     * 
     * @return true if finding the personen succeded and false if not.
     */
    private boolean loanFindPerson()
    {
        boolean person = false;
        String input = input("Phone Number");
        person = loanCtr.findPerson(input);
        if(person != true)
        {
            System.out.println("Couldn't find any registered user with that phone number.");
        }
        return person;
    }

    /**
     * Handles the UI part of finding the given DVD by title, and if there's a copy home.
     * 
     * @return true if finding an available DVD succeded and false if not.
     */
    private boolean loanFindDvd()
    {
        boolean dvd = false;
        String input = input("DVD Title");
        dvd = loanCtr.findDvd(input);
        if(!dvd)
        {
            System.out.println("Couldn't find any registered DVD with that title.");
        }
        else if(loanCtr.findDvdAvailableCopy() == false)
        {
            System.out.println("There isn't any DVD's left with that title aviable");
            dvd = false;
        }
        return dvd;
    }

    /**
     * Prints information about the DVD
     */
    private void printLoanDvd()
    {
        System.out.println("Dvd Information");
        System.out.println("Title: " + loanCtr.getDvdTitle());
        System.out.println("Artist: " + loanCtr.getDvdArtist());
        System.out.println("Publication Date: " + loanCtr.getPublicationDate());
    }
}
