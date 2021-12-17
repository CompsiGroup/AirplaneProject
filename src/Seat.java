public class Seat
{
    private boolean isOccupied;
    private String seatType;

    public Seat(boolean isOccupied, String seatType)
    {
        this.isOccupied = isOccupied;
        this.seatType = seatType;
    }


    public String getSeatType()
    {
        return seatType;
    }

    public boolean isOccupied()
    {
        return isOccupied;
    }

    public void occupy()
    {
        isOccupied = true;
    }

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
