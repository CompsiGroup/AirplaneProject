import java.util.Arrays;

public class tester
{
    public static void main(String[] args)
    {
        System.out.println("hi");
        Airplane plane = new Airplane();
        UserInterface ui = new UserInterface(plane);

        int amountOfPeople = ui.askForAmountOfPeople();
        System.out.println(plane.getAvailableSeats(Airplane.ALLSEATS));
        try {
            if (amountOfPeople != -1) {
                for (int i = 0; i < amountOfPeople; i++) {
                    if (plane.hasAvailableSeat(Airplane.ALLSEATS)) {
                        System.out.println("works");
                        byte requestedSeating = ui.askForClass();
                        if (plane.hasAvailableSeat(requestedSeating)) {
                            Seat chosenSeat = ui.askForSeat(requestedSeating);
                            chosenSeat.occupy();
                        } else {
                            ui.displayClassFull(requestedSeating);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("canceled");
        }
        System.out.println("done");
    }
}
