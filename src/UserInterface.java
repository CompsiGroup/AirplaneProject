import javax.swing.*;
import java.util.HashMap;

/**
 * GUI for the Airplane project
 * @author Gene, Dakota, Aidan
 * @version 1.19.2022
 */
public class UserInterface
{
    Airplane thisplane;

    public UserInterface(Airplane plane)
    {
        thisplane = plane;
    }

    /**
     * Prompts the user for a seat
     * @param seating Seating arrangement, Economy or First
     * @return The Seat the user picked.
     */
    public Seat askForSeat(byte seating)
    {
        String input = JOptionPane.showInputDialog(thisplane.getSeatingLayout(seating));
        input = input.strip();
        if (!input.matches("\\w\\d+"))
        {
            if (input.equalsIgnoreCase("back"))
            {
                byte c = askForClass();
                return askForSeat(c);
            }
            JOptionPane.showMessageDialog(null,
                    "Invalid input. Make sure to input <letter><row> or 'back' if you would like to change your class");
            return askForSeat(seating);
        }
        int row = Integer.parseInt(input.substring(1));
        String column = input.substring(0,1);
        try
        {
            Seat chosenSeat = thisplane.getSeat(row, column, seating);
            if (chosenSeat.isOccupied())
            {
                JOptionPane.showMessageDialog(null,
                        "That seat is occupied. Please pick another.");
                return  askForSeat(seating);
            }
            JOptionPane.showMessageDialog(null,
                    "success. You have chosen seat "+column+row);
            return chosenSeat;
        }
        catch (Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    "Invalid seat. make sure to input numbers within the constraints of the seating arrangement");
            return askForSeat(seating);
        }
    }

    /**
     * Asks for the amount of people to be seated
     * @return the amount o people to be seated.
     */
    public int askForAmountOfPeople()
    {
        String input = JOptionPane.showInputDialog(
                "Welcome to the plane\n"
                +" how many people would you like to get seats for?");
        input = input.strip();
        try
        {
            int amountOfPeople = Integer.parseInt(input);
            if (amountOfPeople > thisplane.getAvailableSeats(Airplane.ALLSEATS))
            {
                JOptionPane.showMessageDialog(null,
                        "There arent enough seats to accomodate that many people. There are only "
                                + thisplane.getAvailableSeats(Airplane.ALLSEATS) + " vacant seats");
                return askForAmountOfPeople();
            }
            else if (amountOfPeople <= 0)
            {
                JOptionPane.showMessageDialog(null,
                        "please input a positive integer");
                return askForAmountOfPeople();
            }
            return amountOfPeople;
        }
        catch (Exception e)
        {
            if (input == null)
            {
                return -1;
            }
            JOptionPane.showMessageDialog(null,
                    "Input an integer please.");
            return askForAmountOfPeople();
        }
    }
    
    /*
    *Prints seating information
    */
    public void showSeats()
    {
        JOptionPane.showMessageDialog(null,thisplane.getSeatingLayout(Airplane.ALLSEATS));
    }

    /**
     * Asks for the class the person wants to be seated in.
     * @return the corresponding class.
     */
    public byte askForClass()
    {
        String input = JOptionPane.showInputDialog("Which class would you like to be seated in?");
        input = input.strip();
        if (input.equalsIgnoreCase("first"))
        {
            return Airplane.FIRSTCLASS;
        }
        else if (input.equalsIgnoreCase("economy"))
        {
            return Airplane.ECONOMYCLASS;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid input. Make sure to say \"first\" or \"economy\"");
            return askForClass();
        }
    }


    /**
     * Displays when the chosen class has no vacant seats.
     * @param seatingClassThatIsFull the chosen class
     */
    public void displayClassFull(byte seatingClassThatIsFull)
    {
        HashMap<Byte, String> dict = new HashMap<Byte, String>();

        dict.put(Airplane.FIRSTCLASS, "First Class ");
        dict.put(Airplane.ECONOMYCLASS, "Economy Class ");
        dict.put(Airplane.ALLSEATS, "The plane");
        JOptionPane.showMessageDialog(null, "There are no vacant seats in " + dict.get(seatingClassThatIsFull));
    }
}
