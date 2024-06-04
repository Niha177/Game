import java.util.ArrayList;
import java.util.Scanner;

public class Basement extends Room
{
	private boolean possible;
	
	public Basement()
	{
		super("You are now at the part of the mansion where it is possible to escape, the basement");
	}
	public boolean getPossible()
	{
		return possible;
	}
	
	
	
	//add shoot-out here
	
	
	public void examineObjects()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("You look around but there doesn't seem to be much here except for a painting, window, or door");
		System.out.println("What would you like to examine? (Type its name)");
		
		String input = scan.nextLine();
		boolean found = false;
		while(found==false)
		{
			if(input.equalsIgnoreCase("painting"))
			{
				boolean inner2=false;
				while(inner2==false)
				{
					System.out.println("Oh? It has hinges, meaning it can swing off this wall. Type \"pull\" to try it");
					input = scan.nextLine();
					
					if(input.equalsIgnoreCase("pull"))
					{
						System.out.println("Woah it opens! There's a lock and a set of keyholes here... Should I try putting them in?");
						
						
						boolean inner= false;
						while(inner == false)
						{
							
							if(input.equalsIgnoreCase("pull"))
							{
								System.out.println("Woah it opens! There's a lock and a set of keyholes here... Should I try putting them in?");
								input = scan.nextLine();
								
								boolean innervalid = false;
								while(innervalid ==false)
								{
									if(input.equalsIgnoreCase("yes"))
									{
										possible=true;
										innervalid=true;
										inner=true;
										found=true;
										break;
										
									}
									else
									{
										System.out.println("There is nothing else to do, should I place they keys");
										input = scan.nextLine();
									}
								}
							
							}
						}
						inner2=true;
					}
					else
					{
						System.out.println("[YOU]: What am I doing? I have to explore this painting");
						input = scan.nextLine();

					}
				}
				
				
				
			}
			else if(input.equalsIgnoreCase("window"))
			{
				System.out.println("Ugh, it's barricaded so there is nowhere for the keys to go or for you to get out. Try something else.");
				input = scan.nextLine();
			}
			else if(input.equalsIgnoreCase("door"))
			{
				System.out.println("This doesn't lead to anything except for a boiler and some pipes. Try something else.");
				input = scan.nextLine();
			}
			else
			{
				System.out.println("that is not available here");
				input = scan.nextLine();
			}
		}
	
		
		

	}
	
	public void fightSeq()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("The detective has found you and is trying to capture you! \n He wants to try to shoot you before you get away!");
		System.out.println("Type \"left\" to shoot or dodge to the left, \"straight\"  to shoot or dodge straight ahead, and  \"right\" to shoot or dodge to the right");
		System.out.println("You win if you hit the detective 8 times, and you lose if the detective hits you 4 times or if you miss 4 times, so make sure to not lose your lives");
		System.out.println("Think fast!");
		System.out.println("type \"start fight\" to begin");
		
		String input = scan.nextLine();
		boolean isPlayable =false;
		if(input.equalsIgnoreCase("start fight"))
		{
			isPlayable = true;
					
		}
		while(isPlayable==false)
		{
			System.out.println("[YOU]: What am I doing? I have to fight the detective");
			input = scan.nextLine();

			if(input.equalsIgnoreCase("start fight"))
			{
				isPlayable=true;
			}

		}
		
		if(isPlayable == true)
		{
			int chances = 4;
			int tries = 0;
			String turn = "Turn";
			while((chances>0) && (tries<16))
			{
				int where = (int)(Math.random()*3)+1;
				if(tries%2==0)
				{
					
					turn = "Detective Turn: He shot";
					if(where == 1)
					{
						
						System.out.println(turn + "left");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("right")||input.equalsIgnoreCase("straight"))
						{
							System.out.println("You dodged!");
						}
						else
						{
							chances--;
							System.out.println("You were shot! You now have "+ chances + " lives left :(");
						}
					}
					else if(where == 2)
					{
						
						System.out.println(turn + "straight");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("right")||input.equalsIgnoreCase("left"))
						{
							System.out.println("You dodged!");
						}
						else
						{
							chances--;
							System.out.println("You were shot! You now have "+ chances + " lives left :(");
						}
					}
					else if(where == 3)
					{
						
						System.out.println(turn + "right");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("left")||input.equalsIgnoreCase("straight"))
						{
							System.out.println("You dodged!");
						}
						else
						{
							chances--;
							System.out.println("You were shot! You now have "+ chances + " lives left :(");
						}
					}
				}
				else
				{
					turn = "Your Turn: Detective is";
					if(where == 1)
					{
					
						System.out.println(turn + "left");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("left"))
						{
							System.out.println("Great, you got him!");
						}
						else
						{
							chances--;
							System.out.println("You missed! You now have "+ chances + " lives left :(");
						}
					}
					else if(where == 2)
					{
						
						System.out.println(turn + "straight");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("straight"))
						{
							System.out.println("Great, you got him!");
						}
						else
						{
							chances--;
							System.out.println("You missed! You now have "+ chances + " lives left :(");
						}
					}
					else if(where == 3)
					{
						
						System.out.println(turn + "right");
						input = scan.nextLine();
						if(input.equalsIgnoreCase("right"))
						{
							System.out.println("Great, you got him!");
						}
						else
						{
							chances--;
							System.out.println("You missed! You now have "+ chances + " lives left :(");
						}
					}
				}
				tries++;
			}
			if(tries == 16)
			{
				System.out.println("Success! You stopped the detective... Now to get out of here");
				victory();
			}
			else if(chances == 0)
			{
				gameOver();
			}
		}
	}
	
	public void placeKey(ArrayList<Keys> myInventory)
	{
		int numKeys=0;
	
		for(int x =0; x<myInventory.size(); x++)
		{
			if(findKeys(myInventory,"Key")!=-1)
			{
				numKeys++;
			}
			
		}
		if(numKeys==4)
		{
			System.out.println("you have all you keys, you can now escape");
			System.out.println("wait, there is someone coming");
			
			System.out.println();
			System.out.println("[DETECTIVE]: Looks like you got caught");
			System.out.println("[YOU]: Oh no...");
			
			fightSeq();
		
		}
		else
		{
			System.out.println("you don't have all you keys...");
			System.out.println("I hear someone approach me");
			
			System.out.println();
			System.out.println("[DETECTIVE]: Looks like you got caught");
			System.out.println("[YOU]: Wha.. how???");
			System.out.println();
			System.out.println("[DETECTIVE]: seem's like you escape was not properly planned...you don't even have all they keys to escape");
			System.out.println("[DETECTIVE]: I guess this is the end for you");
			System.out.println("[YOU]: NOOOOO!!!!!!!");
			
			
			
			gameOver();
		}
		
	}
	public void victory()
	{
		System.out.println("yes!!! I succeeded on my plan, I am now free!!!");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("/        |/  |  /  |/        |      /        |/  \\  /  |/       \\ \r\n"
				+ "$$$$$$$$/ $$ |  $$ |$$$$$$$$/       $$$$$$$$/ $$  \\ $$ |$$$$$$$  |\r\n"
				+ "   $$ |   $$ |__$$ |$$ |__          $$ |__    $$$  \\$$ |$$ |  $$ |\r\n"
				+ "   $$ |   $$    $$ |$$    |         $$    |   $$$$  $$ |$$ |  $$ |\r\n"
				+ "   $$ |   $$$$$$$$ |$$$$$/          $$$$$/    $$ $$ $$ |$$ |  $$ |\r\n"
				+ "   $$ |   $$ |  $$ |$$ |_____       $$ |_____ $$ |$$$$ |$$ |__$$ |\r\n"
				+ "   $$ |   $$ |  $$ |$$       |      $$       |$$ | $$$ |$$    $$/ \r\n"
				+ "   $$/    $$/   $$/ $$$$$$$$/       $$$$$$$$/ $$/   $$/ $$$$$$$/  \r\n"
				+ "                                                                  ");
	}
	
	
	
	public int findKeys(ArrayList<Keys> n, String key)
	{
		
		for(int i = 0; i < n.size(); i++)
		{
			if(n.get(i).getName().contains(key))
			{
				return i;
			}
		}
		return -1;
	}
}