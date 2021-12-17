import java.util.Arrays;

public class tester
{
    public static void main(String[] args)
    {
        System.out.println("hi");
        Airplane plane = new Airplane();
        System.out.println(plane.getSeatingLayout());
        Seat sixFive = plane.getSeat(6, 5);
        System.out.println(sixFive);
        sixFive.occupy();
        System.out.println(sixFive);
        System.out.println(plane.getSeatingLayout());
    }
}
