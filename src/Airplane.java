import java.util.Arrays;
import java.util.Iterator;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Stream;


public class Airplane {
    private Seat[][] FirstClassSeating = new Seat[5][4];
    private Seat[][] EconomyClassSeating = new Seat[35][6];

    private Seat[][] AllSeats;

    public Airplane()
    {
        for (int i = 0 ; i<5; i++)
        {
            FirstClassSeating[i][0] = new Seat(false, "window");
            FirstClassSeating[i][1] = new Seat(false, "aisle");
            FirstClassSeating[i][2] = new Seat( false, "aisle");
            FirstClassSeating[i][3] = new Seat(false, "window");
        }

        for (int j = 0; j<35; j++)
        {
            EconomyClassSeating[j][0] = new Seat(false, "window");
            EconomyClassSeating[j][1] = new Seat(false, "middle");
            EconomyClassSeating[j][2] = new Seat( false, "aisle");
            EconomyClassSeating[j][3] = new Seat(false, "aisle");
            EconomyClassSeating[j][4] = new Seat(false, "middle");
            EconomyClassSeating[j][5] = new Seat( false, "window");

        }


    }

    public Seat[][] getEconomyClassSeating()
    {
        return EconomyClassSeating;
    }

    public Seat[][] getFirstClassSeating()
    {
        return FirstClassSeating;
    }

    public Seat getSeat(int row, int column)
    {
        row-=1;
        column-=1;
        if (row >= 5)
        {
            row -=5;

            return EconomyClassSeating[row][column];
        }
        return FirstClassSeating[row][column];
    }

    public String getSeatingLayout()
    {
        String layout = "";
        for (int i = 0; i<FirstClassSeating.length; i++)
        {
            layout += "   "+Arrays.deepToString(FirstClassSeating[i]) +"\n";
        }
        for (int i = 0; i<EconomyClassSeating.length; i++)
        {
            layout += Arrays.deepToString(EconomyClassSeating[i]) +"\n";
        }
        return layout;
    }
}
