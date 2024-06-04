import java.util.Scanner;

public class Bedroom extends Room
{
	private String name;
	private boolean achievment;
	
	public Bedroom(String n)
	{
		super("You are looking at a" + n);
		name=n;

	}
	
	
	public Bedroom()
	{
		super("You are now inside a bedroom");
	}
	public boolean getAchieve()
	{
		return achievment;
	}
	
	public void lookObject()
	{
		System.out.println("[YOU]: This is a " + name +  " I wonder if there is anything under it");
		System.out.println("lets see if i can \"look under the " + name + "\"");
	}
	public void uncoverWrongObject()
	{
		System.out.println("[YOU]: Looks like there is nothing here");
	}
	public void uncoverCorrectObject()
	{
		System.out.println("[YOU]: Hey! I found something...");
		System.out.println("looks like a key");
		Keys key1 = new Keys("key1");
	}
	
	public void bedroomArea()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("You now see three pieces of furniture");
		System.out.println("A Bed, a closet, and a lamp...");
		System.out.println("you can now \"Look at the bed\",\"Look at the closet\"or \"Look at the lamp\"");
		String input = scanner.nextLine();
		
		
		boolean isPlayable =false;
		boolean key = false;
		boolean acheived = false;
		boolean valid = false;
		
		if(input.equalsIgnoreCase("Look at the bed")|| 
				input.equalsIgnoreCase("Look at the closet")|| 
				input.equalsIgnoreCase("Look at the lamp") )
		{
			valid = true;
		}

		while(valid==false)
		{
			System.out.println("you cannot perform this action");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("Look at the bed")|| 
					input.equalsIgnoreCase("Look at the closet")|| 
					input.equalsIgnoreCase("Look at the lamp") )
			{
				valid = true;
			}
		}


		while(acheived==false)
		{

			if (input.equalsIgnoreCase("Look at the bed")&&valid==true) 
			{
				boolean innerAcheive = false;

				Bedroom bed = new Bedroom("bed");
				bed.lookObject();
				input = scanner.nextLine();
				
				while(innerAcheive==false)
				{
					if (input.equalsIgnoreCase("look under the bed")) 
					{
						bed.uncoverWrongObject();
						input = scanner.nextLine();
						innerAcheive = true;
					} 
					else 
					{

						System.out.println("You cannot do that");
						input = scanner.nextLine();
					}
				}
				
				
				

			} 
			else if (input.equalsIgnoreCase("Look at the lamp")&&valid==true) 
			{
				boolean innerAcheive = false;
				
				Bedroom lamp = new Bedroom("lamp");
				lamp.lookObject();
				 input = scanner.nextLine();
		
				
				while(innerAcheive==false)
				{
					if (input.equalsIgnoreCase("look under the lamp")) 
					{
						lamp.uncoverWrongObject();
						input = scanner.nextLine();
						innerAcheive = true;
					} 
					else 
					{
						System.out.println("You cannot do that");
						input = scanner.nextLine();
					}
				}
				

			}
			else if (input.equalsIgnoreCase("Look at the closet")&&valid==true) 
			{
				Bedroom closet = new Bedroom("closet");
				closet.lookObject();
				input = scanner.nextLine();
				
				boolean innerAchieve = false;

				while (innerAchieve==false) 
				{
					if (input.equalsIgnoreCase("look under the closet")) 
					{
						closet.uncoverCorrectObject();
						innerAchieve = true;
						acheived = true;
						achievment = true;
					} 
					else 
					{
						System.out.println("You cannot do that");
						input = scanner.nextLine();
					}
				}
			}
			else 
			{
				System.out.println("you cannot perform this action");
				input = scanner.nextLine();

				if(input.equalsIgnoreCase("Look at the bed")|| 
						input.equalsIgnoreCase("Look at the closet")|| 
						input.equalsIgnoreCase("Look at the lamp") )
				{
					continue;
				}
			}
			
	
		}
		
	}
	
	
	
}
