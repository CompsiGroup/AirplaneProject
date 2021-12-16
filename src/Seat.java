public class Seat
{
    private boolean isOccupied;
    private String seatType;

    public Seat(boolean isOccupiedd, String seat)
    {
        isOccupied = isOccupiedd;
        seatType = seat;
    }

    public String getSeatType()
    {
        return seatType;
    }

    public boolean getIsOccupied()
    {
        return isOccupied;
    }

    @Override
    public String toString()
    {
        if (isOccupied)
        {
            return "X";
        }
        if (seatType.equalsIgnoreCase("window"))
        {
            return "W";
        }
        else if (seatType.equalsIgnoreCase("aisle"))
        {
            return "A";
        }
        else if (seatType.equalsIgnoreCase("middle"))
        {
            return "M";
        }
        return "O";
    }
}
