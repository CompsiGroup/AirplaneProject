import java.io.IOException;

/**
 * Will test the Airplane, Seat and UserInterface classes
 * @author Gene, Aidan, Dakota
 * @version 12.20.2021
 */
public class tester
{
    public static void main(String[] args) throws IOException {
        Airplane plane = new Airplane();
        UserInterface ui = new UserInterface(plane);
        int amountOfPeople = ui.askForAmountOfPeople();
        System.out.println(plane.getAvailableSeats(Airplane.ALLSEATS));
        try
        {
            if (amountOfPeople != -1)
            {
                for (int i = 0; i < amountOfPeople; i++)
                {
                    if (plane.hasAvailableSeat(Airplane.ALLSEATS))
                    {
                        byte requestedSeating = ui.askForClass();
                        if (plane.hasAvailableSeat(requestedSeating))
                        {
                            Seat chosenSeat = ui.askForSeat(requestedSeating);
                            chosenSeat.occupy();
                        }
                        else
                        {
                            ui.displayClassFull(requestedSeating);
                        }
                    }
                    else
                    {
                        ui.displayClassFull(Airplane.ALLSEATS);
                        break;
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("canceled");
        }

        System.out.println(plane.getSeatingLayout(Airplane.ALLSEATS));
        System.out.println("done");
    }
}
