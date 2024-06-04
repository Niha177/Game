import java.util.Scanner;

public class Study extends Room
{
	private String name;
	private NPC detective, victim;
	
	public Study()
	{
		super("You have now entered a large mansion and find yourself in a study");
		detective = new NPC("DETECTIVE", "Who did this?!?! I will find and imprison them!");
		victim = new NPC("VICTIM", "something was stolen...it was... *incoherent*");
	}
	public String getDetective()
	{
		return detective.interact();
	}
	public String victim()
	{
		return victim.interact();
	}
	
	
	
	public void grabweapon()
	{
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		if(input.equalsIgnoreCase("grab"))
		{
			Keys knife = new Keys("Knife");
		}
		
	}
}