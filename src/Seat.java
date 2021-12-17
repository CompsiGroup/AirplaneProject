public class Seat
{
    private boolean isOccupied;
    private byte seatType;
    
    public static final byte WINDOW = 0;
    public static final byte AISLE = 1;
    public static final byte MIDDLE = 2;

    public Seat(boolean isOccupied, byte seatType)
    {
        this.isOccupied = isOccupied;
        this.seatType = seatType;
    }

    public byte getSeatType()
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
        if (seatType == WINDOW)
        {
            return "W";
        }
        else if (seatType == AISLE)
        {
            return "A";
        }
        else if (seatType == MIDDLE)
        {
            return "M";
        }
        return "O";
    }
}
