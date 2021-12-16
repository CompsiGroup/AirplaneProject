import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Airplane {
    private ArrayList<ArrayList<ArrayList<Seat>>> SeatingLayout = new ArrayList<ArrayList<ArrayList<Seat>>>();

    public Airplane()
    {
        ArrayList<ArrayList<Seat>> FirstClass = new ArrayList<ArrayList<Seat>>();
        for (int i = 1; i <= 5; i++)
        {
            ArrayList<Seat> row = new ArrayList<Seat>();
            row.add(new Seat(false, "window"));
            row.add(new Seat(false, "aisle"));
            row.add(new Seat(false, "aisle"));
            row.add(new Seat(false, "window"));
            FirstClass.add(row);
        }

        ArrayList<ArrayList<Seat>> EconomyClass = new ArrayList<ArrayList<Seat>>();
        for (int i = 1; i <= 20; i++)
        {
            ArrayList<Seat> row = new ArrayList<Seat>();
            row.add(new Seat(false, "window"));
            row.add(new Seat(false, "middle"));
            row.add(new Seat(false, "aisle"));
            row.add(new Seat(false, "aisle"));
            row.add(new Seat(false, "middle"));
            row.add(new Seat(false, "window"));
            FirstClass.add(row);
        }

        SeatingLayout.add(FirstClass);
        SeatingLayout.add(EconomyClass);
    }

    public ArrayList<ArrayList<ArrayList<Seat>>> getSeatingLayout()
    {
        return SeatingLayout;
    }
}
