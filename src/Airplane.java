import java.util.Arrays;

public class Airplane {
    private Seat[][] FirstClassSeating = new Seat[5][4];
    private Seat[][] EconomyClassSeating = new Seat[35][6];

    public static byte ALLSEATS = 0;
    public static byte FIRSTCLASS=1;
    public static byte ECONOMYCLASS=2;

    public Airplane()
    {
        for (int i = 0 ; i < 5; i++)
        {
            FirstClassSeating[i][0] = new Seat(false, Seat.WINDOW);
            FirstClassSeating[i][1] = new Seat(false, Seat.AISLE);
            FirstClassSeating[i][2] = new Seat( false, Seat.AISLE);
            FirstClassSeating[i][3] = new Seat(false, Seat.WINDOW);
        }

        for (int j = 0; j < 35; j++)
        {
            EconomyClassSeating[j][0] = new Seat(false, Seat.WINDOW);
            EconomyClassSeating[j][1] = new Seat(false, Seat.MIDDLE);
            EconomyClassSeating[j][2] = new Seat( false, Seat.AISLE);
            EconomyClassSeating[j][3] = new Seat(false, Seat.AISLE);
            EconomyClassSeating[j][4] = new Seat(false, Seat.MIDDLE);
            EconomyClassSeating[j][5] = new Seat( false, Seat.WINDOW);

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


    public Seat getSeat(int row, int column, byte seat)
    {
        assert seat == ALLSEATS || seat == FIRSTCLASS || seat == ECONOMYCLASS;
        row -= 1;
        column -= 1;
        if (seat == ALLSEATS)
        {
            if (row >= 5) {
                row -= 5;

                return EconomyClassSeating[row][column];
            }
            return FirstClassSeating[row][column];
        }
        else if (seat == FIRSTCLASS)
        {
            return FirstClassSeating[row][column];
        }
        else
        {
            return EconomyClassSeating[row][column];
        }
    }

    public String getFirstClassLayout()
    {
        String layout = "    0  1  2  3  4   \n";
        for (int i = 0; i < FirstClassSeating.length; i++)
        {
            if (i + 1 < 10)
            {
                layout += i + 1 + "     " + Arrays.deepToString(FirstClassSeating[i]) +"\n";
            }
            else
            {
                layout += i + 1 + "    " + Arrays.deepToString(FirstClassSeating[i]) + "\n";
            }
        }
        return layout;
    }

    public String getEconomyClassLayout()
    {
        String layout = "    1  2  3  4  5  6\n";
        for (int i = 0; i < EconomyClassSeating.length; i++)
        {
            if (i + 1 < 10)
            {
                layout += i + 1 + "  " + Arrays.deepToString(EconomyClassSeating[i]) + "\n";
            }
            else
            {
                layout += i + 1 + " " + Arrays.deepToString(EconomyClassSeating[i]) + "\n";
            }
        }
        return layout;
    }

    public String getSeatingLayout(byte seatSelection)
    {
        assert  seatSelection == ALLSEATS || seatSelection == ECONOMYCLASS || seatSelection == FIRSTCLASS;
        if (seatSelection == ALLSEATS)
        {
            String layout = "    1  2  3  4  5  6\n";
            for (int i = 0; i < FirstClassSeating.length; i++) {
                if (i + 1 < 10) {
                    layout += i + 1 + "     " + Arrays.deepToString(FirstClassSeating[i]) + "\n";
                } else {
                    layout += i + 1 + "    " + Arrays.deepToString(FirstClassSeating[i]) + "\n";
                }
            }
            for (int i = 0; i < EconomyClassSeating.length; i++) {
                if (i + 1 < 10) {
                    layout += 5 + i + "  " + Arrays.deepToString(EconomyClassSeating[i]) + "\n";
                } else {
                    layout += 5 + i + " " + Arrays.deepToString(EconomyClassSeating[i]) + "\n";
                }
            }
            return layout;
        }
        else if (seatSelection == ECONOMYCLASS)
        {
            String layout = "    1  2  3  4  5  6\n";
            for (int i = 0; i < EconomyClassSeating.length; i++)
            {
                if (i + 1 < 10)
                {
                    layout += i + 1 + "  " + Arrays.deepToString(EconomyClassSeating[i]) + "\n";
                }
                else
                {
                    layout += i + 1 + " " + Arrays.deepToString(EconomyClassSeating[i]) + "\n";
                }
            }
            return layout;
        }
        else
        {
            String layout = "    0  1  2  3  4   \n";
            for (int i = 0; i < FirstClassSeating.length; i++)
            {
                if (i + 1 < 10)
                {
                    layout += i + 1 + "     " + Arrays.deepToString(FirstClassSeating[i]) +"\n";
                }
                else
                {
                    layout += i + 1 + "    " + Arrays.deepToString(FirstClassSeating[i]) + "\n";
                }
            }
            return layout;
        }
    }
}
