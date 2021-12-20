import java.util.Scanner;

public class UserInterface
{
	Airplane plane;
	Scanner in;
	
	public UserInterface(Airplane plane)
	{
		this.plane = plane;
		in = new Scanner(System.in);
	}
	
	public int askForAmountOfPeople()
	{
		System.out.println("How many people are seated together?");
		int out = in.nextInt();
		in.nextLine();
		return out;
	}
	
	public byte askForClass()
	{
		System.out.println("What class?");
		byte out = in.nextByte();
		in.nextLine();
		return out;
	}
	
	public Seat askForSeat(byte requestedSeating)
	{
		System.out.println("Which seat?");
		int row = in.nextInt();
		int column = in.nextInt();
		in.nextLine();
		return plane.getSeat(row, column, requestedSeating);
	}
}
