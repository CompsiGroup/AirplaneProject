import java.util.Arrays;
import java.util.HashMap;

/*
*Makes an Airplane with first class and economy seating
*@author Gene, Dakota, Aidan
*@version 12.20.2021
*/
public class Airplane {
    private Seat[][] FirstClassSeating = new Seat[5][4];
    private Seat[][] EconomyClassSeating = new Seat[35][6];

    public static byte ALLSEATS = 0;
    public static byte FIRSTCLASS = 1;
    public static byte ECONOMYCLASS = 2;
    private String economyClassFile;
    private String firstClassFile;

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
        economyClassFile = "occupiedSeatsEconomy.txt";
        firstClassFile = "occupiedSeatsFirst.txt";
    }
    /*
    public void writeToFile() throws IOException {

        File economyFile = new File(getEconomyClassFile());
        FileWriter economyWriter = new FileWriter(getEconomyClassFile(), true);
        File firstFile = new File(getFirstClassFile());
        FileWriter firstWriter = new FileWriter(getFirstClassFile(), true);
        for (int row = 0; row < getEconomyClassSeating().length; row ++)
        {
            for (int column = 0; column < getEconomyClassSeating()[0].length; column++)
            {
                if (getEconomyClassSeating()[row][column].isOccupied())
                {
                    economyWriter.write(row+ " "+column+"\n");
                }
            }
        }
        economyWriter.close();
        for (int row = 0; row < getFirstClassSeating().length; row ++)
        {
            for (int column = 0; column < getFirstClassSeating()[0].length; column++)
            {
                if (getFirstClassSeating()[row][column].isOccupied())
                {
                    firstWriter.write(row+ " "+column+"\n");
                }
            }
        }
        firstWriter.close();
    }

    public void readFromFile()
    {
        Scanner scEconomy = new Scanner(getEconomyClassFile());
        Scanner scFirst = new Scanner(getFirstClassFile());
        while (scEconomy.hasNextLine())
        {
            String line = scEconomy.nextLine();
            if (!line.equalsIgnoreCase(getEconomyClassFile()))
            {
                int indexOfSpace = line.indexOf(" ");
                System.out.println(line);
                int row = Integer.parseInt(line.substring(0, indexOfSpace));
                int column = Integer.parseInt(line.substring(indexOfSpace + 1));
                EconomyClassSeating[row][column].occupy();
            }
        }
        while (scFirst.hasNextLine())
        {
            String line = scFirst.nextLine();
            System.out.println(line);
            if (!line.equalsIgnoreCase(getFirstClassFile()))
            {
                int indexOfSpace = line.indexOf(" ");
                int row = Integer.parseInt(line.substring(0, indexOfSpace));
                int column = Integer.parseInt(line.substring(indexOfSpace + 1));
                FirstClassSeating[row][column].occupy();
                System.out.println("occupied "+row+" "+column);
            }
        }
    }
    */

    /**
     * Returns amount of vacant seats for the seating arrangement
     * @param seating The seating arrangement to search in
     * @return Amount of vacant seats
     */
    public int getAvailableSeats(byte seating)
    {
        int count = 0;
        if (seating == FIRSTCLASS)
        {
            for (Seat[] seats : FirstClassSeating)
            {
                for (Seat seat : seats)
                {
                    if (!seat.isOccupied())
                    {
                        count++;
                    }
                }
            }
        }
        else if (seating == ECONOMYCLASS)
        {
            for (Seat[] seats : EconomyClassSeating)
            {
                for (Seat seat : seats)
                {
                    if (!seat.isOccupied())
                    {
                        count++;
                    }
                }
            }
        }
        else if (seating == ALLSEATS)
        {
            count = getAvailableSeats(ECONOMYCLASS) + getAvailableSeats(FIRSTCLASS);
        }
        return count;
    }

    /**
     * Checks if the seating arrangemet has a vacant seat.
     * @param seating Seating arrangement to search in
     * @return true if there is a vacant seat. false if there is not
     */
    public boolean hasAvailableSeat(byte seating)
    {
        return getAvailableSeats(seating) > 0;
    }

    /**
     * Gets the seat at the row and column of the seating arrangment.
     * @param row the row
     * @param colum the column
     * @param seat the seating arrangement. (Airplane.ALLSEATS || Airplane.ECONOMYCLASS || Airplane.FIRSTCLASS)
     * @return the seat
     */
    public Seat getSeat(int row, String colum, byte seat)
    {

        assert seat == ALLSEATS || seat == FIRSTCLASS || seat == ECONOMYCLASS;
        HashMap<String, Integer> letterToInt = new HashMap<String, Integer>();
        String[] letters = new String[]{"A","B","C","D","E","F"};
        int[] col = new int[]{1,2,3,4,5,6};
        for (int i = 0; i<letters.length;i++)
        {
            letterToInt.put(letters[i], col[i]);
        }

        int column = letterToInt.get(colum);
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

    /**
     * Generates a layout of the seating arrangement
     * @param seatSelection the seating arrangement
     * @return the layout as a string.
     */
    public String getSeatingLayout(byte seatSelection)
    {
        assert  seatSelection == ALLSEATS || seatSelection == ECONOMYCLASS || seatSelection == FIRSTCLASS;
        if (seatSelection == ALLSEATS)
        {
            StringBuilder layout = new StringBuilder();
            for (int i = 0; i < FirstClassSeating.length; i++)
            {
                if (i + 1 < 10) {
                    layout.append(i + 1).append("     ").append(Arrays.deepToString(FirstClassSeating[i])).append("\n");
                } else {
                    layout.append(i + 1).append("    ").append(Arrays.deepToString(FirstClassSeating[i])).append("\n");
                }
            }
            for (int i = 0; i < EconomyClassSeating.length; i++)
            {
                if (i + 1 < 5) {
                    layout.append(6 + i).append("  ").append(Arrays.deepToString(EconomyClassSeating[i])).append("\n");
                } else {
                    layout.append(6 + i).append(" ").append(Arrays.deepToString(EconomyClassSeating[i])).append("\n");
                }
            }
            return layout.toString();
        }
        else if (seatSelection == ECONOMYCLASS)
        {
            StringBuilder layout = new StringBuilder("     A    B   C   D   E   F\n");
            for (int i = 0; i < EconomyClassSeating.length; i++)
            {
                if (i + 1 < 10)
                {
                    layout.append(i + 1).append("   ").append(Arrays.deepToString(EconomyClassSeating[i])).append("\n");
                }
                else
                {
                    layout.append(i + 1).append(" ").append(Arrays.deepToString(EconomyClassSeating[i])).append("\n");
                }
            }
            return layout.toString();
        }
        else
        {
            StringBuilder layout = new StringBuilder("        A   B   C   D   \n");
            for (int i = 0; i < FirstClassSeating.length; i++)
            {
                if (i + 1 < 10)
                {
                    layout.append(i + 1).append("     ").append(Arrays.deepToString(FirstClassSeating[i])).append("\n");
                }
                else
                {
                    layout.append(i + 1).append("    ").append(Arrays.deepToString(FirstClassSeating[i])).append("\n");
                }
            }
            return layout.toString();
        }
    }
}
