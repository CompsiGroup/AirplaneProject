import java.util.Arrays;

public class tester
{
    public static void main(String[] args)
    {
        System.out.println("hi");
        Airplane plane = new Airplane();
        System.out.println(plane.getSeatingLayout(Airplane.FIRSTCLASS));
        Seat sixFive = plane.getSeat(3, 4, Airplane.FIRSTCLASS);
        System.out.println(sixFive);
        sixFive.occupy();
        System.out.println(sixFive);
        System.out.println(plane.getSeatingLayout(Airplane.FIRSTCLASS));
    }
}
