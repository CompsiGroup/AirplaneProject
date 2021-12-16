import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Airplane {
    private Seat[][] FirstClassSeating = new Seat[5][4];
    private Seat[][] EconomyClassSeating = new Seat[35][6];

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

    public void printSeatingLayout()
    {
        System.out.println(Arrays.deepToString(FirstClassSeating));
    }
}
