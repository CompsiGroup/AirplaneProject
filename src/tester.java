import java.util.Arrays;

public class tester
{
    public static void main(String[] args)
    {
        System.out.println("hi");
        Airplane plane = new Airplane();
        System.out.println(plane.getSeatingLayout());
        System.out.println(plane.getSeat(6, 5));
    }
}
