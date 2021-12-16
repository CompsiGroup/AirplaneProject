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
        return "Seat{" +
                "isOccupied=" + isOccupied +
                ", seatType='" + seatType + '\'' +
                '}';
    }
}
