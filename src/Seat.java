/*
 * Has the different seats on an airplane and can check if it is occupied
 * @author Gene
 * @version 12.20.2021
 */
public class Seat
{
    private boolean isOccupied;
    private byte seatType;
    
    public static final byte WINDOW = 0;
    public static final byte AISLE = 1;
    public static final byte MIDDLE = 2;

    /*
     * Creates a new seat that is or is not occupied and has a seat type.
     * @param isOccupied true if seat is occupied, false if it is not
     * @param seatType this seat's type - window, middle or aisle.
     */
    public Seat(boolean isOccupied, byte seatType)
    {
        this.isOccupied = isOccupied;
        this.seatType = seatType;
    }

    /*
     * Gets the seat type
     * @return seatType, the type of seat
     */
    public byte getSeatType()
    {
        return seatType;
    }

    /*
     * Checks if the seat is occupied
     * @return isOccupied, if the seat is occupied
     */
    public boolean isOccupied()
    {
        return isOccupied;
    }

    /*
     *
     */
    public void occupy()
    {
        isOccupied = true;
    }

    /*
     * Overrides toString to return if a seat is occupied and the type of seat it is.
     * @return The seat type and if it is occupied 
     */
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
        if (seatType == AISLE)
        {
            return "A";
        }
        if (seatType == MIDDLE)
        {
            return "M";
        }
        return "O";
    }
}
