import javax.swing.*;
import java.util.HashMap;

public class UserInterface
{
    Airplane thisplane;

    public UserInterface(Airplane plane)
    {
        thisplane = plane;
    }

    public Seat askForSeat(byte seating)
    {
        String input = JOptionPane.showInputDialog(thisplane.getSeatingLayout(seating));
        input = input.strip();
        if (!input.matches("\\w\\d"))
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid input. Make sure to input <letter><row>");
            return askForSeat(seating);
        }
        int spaceIndex = input.indexOf("\s");
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

    public int askForAmountOfPeople()
    {
        String input = JOptionPane.showInputDialog(
                "Welcome to the plane\n"
                +" how many people would you like to get seats for?");
        try
        {
            int amountOfPeople = Integer.parseInt(input);
            if (amountOfPeople > thisplane.getAvailableSeats(Airplane.ALLSEATS)) {
                JOptionPane.showMessageDialog(null,
                        "There arent enough seats to accomodate that many people. There are only "
                                + thisplane.getAvailableSeats(Airplane.ALLSEATS) + " vacant seats");
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

    public byte askForClass()
    {
        String input = JOptionPane.showInputDialog("Which class would you like to be seated in?");
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


    public void displayClassFull(byte seatingClassThatIsFull)
    {
        HashMap<Byte, String> dict = new HashMap<Byte, String>();

        dict.put(Airplane.FIRSTCLASS, "First Class ");
        dict.put(Airplane.ECONOMYCLASS, "Economy Class ");

        JOptionPane.showMessageDialog(null, dict.get(seatingClassThatIsFull) + "is full! pick again.");
    }
}
