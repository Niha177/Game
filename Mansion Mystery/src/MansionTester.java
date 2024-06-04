import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner; 
public class MansionTester 
{
	private Room[][]myRooms;
	private int xCoord;
	private int yCoord;
	private Room location;
	private static boolean intro;
	private static boolean part1;
	private static boolean part2;
	private static boolean part3;
	private static boolean part4;
	private long startTime;
	//private long startTime = System.currentTimeMillis();
	private long elapsedTime = 0L;
	//all of these parts are used so that the game will know when each level is complete
	private ArrayList<Keys> inventory = new ArrayList<Keys>();; 
	//this is the players inventory, it holds "keys" but is used to hold weapons too that can be created in the key'class

	// this is the constructor for the entire mansion 
	//the 2D array is used to build all of the rooms



	public MansionTester(Room[][] rooms)
	{
		myRooms=rooms;
	}
	//this is for navigation
	public int getXloc()
	{
		return xCoord;
	}
	public int getYloc()
	{
		return yCoord;
	}

	//this method is to add any item into the players inventory
	public void addItem(ArrayList<Keys> array, Keys thing)
	{

		inventory.add(thing);

	}
	public ArrayList<Keys> getInventory()
	{
		return inventory;
	}
	//these are to change the state of if the level is achievable if needed 
	public void setIntro(boolean state)
	{
		intro=state;
	}
	public void setPart1(boolean state)
	{
		part1=state;
	}
	public void setPart2(boolean state)
	{
		part2=state;
	}
	//this is to view your inventory so it prints out your stuff
	public void viewInventory()
	{
		if(inventory!=null)
		{
			for(int x=0; x<inventory.size();x++)
			{
				System.out.println(((Keys) inventory.get(x)).getName());
			}
		}
		else
			System.out.println("no items in inventory");

	}
	public void calculateTime()
	{
		while (elapsedTime <= 20*60*1000) 
		{
			elapsedTime = (new Date()).getTime() - startTime;
			if(elapsedTime > 1*60*1000)
			{
				System.out.println("Time's Up");
				rooms[0][0].gameOver();
				break;
			}
		}
		/*if(elapsedTime > 1*60*1000)
		{
			rooms[0][0].gameOver();
		}*/
	}
	public void startTime()
	{
		this.startTime= System.currentTimeMillis();
	}
	public long getElapsed()
	{
		long currentTime = System.currentTimeMillis();
		return currentTime-startTime;
	}


	Scanner scanner = new Scanner(System.in);
	//these are all of our rooms, each of the rooms inside is a subclass of room
	static Room[][] rooms = {{new Study(), new Bedroom()},
			{new Kitchen(),new Library()},
			{new Bathroom(), new Basement()}}; 


	//This is start of the game: introduced to the mansion and the scene of the crime

	public void introduction()
	{
		System.out.println("You have currently found youself inside a mansion (where you are \"working\")");
		System.out.println(" where you have spent days planning to steal a magical orb ");
		System.out.println("that will give you unlimited power");
		System.out.println();
		System.out.println("you glance at the magical orb");
		System.out.println();
		System.out.println("Try picking it up by typing \"grab\"");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		startTime();
		
		boolean invalid = false;
		while(invalid==false)
		{
			
			
			if(input.equalsIgnoreCase("grab"))
			{
				Keys knife = new Keys("Magical Orb");
				inventory.add(knife);
				invalid = true;
			}
			else
			{
				System.out.println("hurry up! grab the orb so you can finish your mission");
				input = scanner.nextLine();
			}
		}
		System.out.println("[MANSION MASTER]: Hey! who are you??? that orb is MINE");
		System.out.println();
		
		System.out.println("quick you need to get away from the mansion master");
		
		System.out.println("type \"attack\" to make a quick getaway");

		 input = scanner.nextLine();
		boolean isPlayable =false;
		if(input.equalsIgnoreCase("attack"))
		{
			isPlayable = true;
		}
		//the while loop allows the player to keep trying until they type the correct input
		while(isPlayable==false)
		{
			System.out.println("[YOU]: What am I doing? I have to complete my task");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("attack"))
			{
				isPlayable=true;
			}

		}
		if(input.equalsIgnoreCase("attack"))
		{
			isPlayable=true;
			System.out.println("you have succeeded, you must escape...NOW");
			intro=true;
		}


	}
	//this is the part where the player enters the next room
	public void part1()
	{
		System.out.println();
		System.out.println("SOME TIME LATER");
		System.out.println();
		System.out.println("[ASSISTANT]:something horrible has happened!!!! what happened to the master?");
		System.out.println("And someone has stolen the orb from us");
		System.out.println( "[CHEF]: we need a detective to solve this.");
		

		System.out.println("[YOU]: to yourself... Let's see what the victim says");
		System.out.println("type \"victim\" to talk to victim");
		String input = scanner.nextLine();
		boolean playable =false;

		//this is to make sure the player talks to the npc victim
		if(input.equalsIgnoreCase("victim"))
		{
			playable = true;
			System.out.println(((Study)rooms[0][0]).victim());

		}
		while(playable==false)
		{
			System.out.println("You have to talk to the master before the detective does!!");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("victim"))
			{
				playable =true;
				System.out.println(((Study)rooms[0][0]).victim());
			}

		}
		
		System.out.println("[YOU]: to yourself... I need to talk to the detective and see if he suspects me!");
		System.out.println("type \"detective\" to talk to detective");

		boolean play =false;
		input = scanner.nextLine();
		//this is to make sure the player talks to the npc detective
		if(input.equalsIgnoreCase("detective"))
		{
			play = true;
			System.out.println(((Study)rooms[0][0]).getDetective());
			System.out.println("[YOU]: I'll help you too!");
			System.out.println("[DETECTIVE]: We need to split up and find out who stole the orb...");
		}
		else {
			
	
		while(play==false)
		{
			
			//input = scanner.nextLine();
			if(input.equalsIgnoreCase("detective"))
			{
				play =true;
				System.out.println(((Study)rooms[0][0]).getDetective());
				System.out.println("[YOU]: I'm just pondering who could have done this");
				System.out.println("[DETECTIVE]: If you say so...");
				System.out.println("[YOU]: You know what, I'll help you find the theif!");
			}
			else
			{
				System.out.println("You have to make sure the detective trusts you!! type \"detective\" to talk to detective");
				System.out.println("[DETECTIVE]: You're acting really suspicious back there...");
				input = scanner.nextLine();
			}


		}
		}
		
		System.out.println("[YOU]:to yourself... I must escape now");
		System.out.println();
		System.out.println("Where would you like to go?");
		System.out.println("North,East,South,West");
		
		
	 input = scanner.nextLine();
		boolean isPlayable =false;
		boolean key = false;
		boolean acheived = false;

		//this is to make sure the player goes in the right direction. right now, they can only go east
		if(input.equalsIgnoreCase("East"))
		{
			isPlayable = true;
		}
		while(isPlayable==false)
		{
			System.out.println("Sorry, you are not allowed to go there yet");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("East"))
			{
				isPlayable=true;
			}

		}
		if(input.equalsIgnoreCase("East"))
		{
			//after the player goes in the correct location, this is getting the general info for our room
			xCoord=1;
			location = rooms[0][1];
			System.out.println(rooms[0][1].getDescription());
			//this is ensuring the player does not skip any steps of the game
			isPlayable=true;
			key = true;

		}
		//this is to safeguard the player from entering the room before the actually go in the right direction

		if(key)
		{
			((Bedroom) rooms[0][1]).bedroomArea();

		}
		//there is a method getAnchive that is only set to true when they players completes everything that is requires
		//they can only move on if the variable inside the class is set to true

		if(((Bedroom) rooms[0][1]).getAchieve() ==true)
		{
			System.out.println("Would you like to take the object?");

			input = scanner.nextLine();
			boolean innerAchieve = false;

			//this allows the player to either take the key or not
			//HINT: player wont succeed if they don't collect all keys
			//this way, it is setting up for two distinct endings

			while (innerAchieve==false) 
			{
				if (input.equalsIgnoreCase("yes"))
				{
					addItem(inventory, new Keys("Key1"));


					System.out.println("you can now type \"view inventory\" to view your stuff after pressing any key to continue");
					//we want they to press any key to continue so the screen is not filled with commands

					innerAchieve = true;
					input = scanner.nextLine();

				}
				else if(input.equalsIgnoreCase("no"))
				{
					System.out.println("ok...press any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();
				}

				else
				{
					//this is what will happen if they type something besides yes or no
					System.out.println("Sorry, I do not understand");
					input = scanner.nextLine();

					if(input.equalsIgnoreCase("yes")|| 
							input.equalsIgnoreCase("no"))
					{
						continue;
					}
				}
			}
			if(innerAchieve==true)
			{
				System.out.println("I'm glad I did not get caught, time to move to the next room");
				System.out.println("press any key to continue");
				part1=true;
				input = scanner.nextLine();
			}

			//if player decides to see their stuff, they can use this method
			if(input.equalsIgnoreCase("view inventory"))
			{
				viewInventory();
			}


		}

	}
	public void part2()
	{
		//this is all the same directional parts from the first part, only the direction changed
		System.out.println("You now have to escape from the bedroom to the next room");

		System.out.println("Where would you like to go?");
		System.out.println("North,East,South,West");


		System.out.println();
	

		String input = scanner.nextLine();
		boolean isPlayable =false;
		boolean key = false;
		boolean acheived = false;

		if(input.equalsIgnoreCase("south"))
		{
			isPlayable = true;
		}
		while(isPlayable==false)
		{
			System.out.println("Sorry, you are not allowed to go there yet");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("south"))
			{
				isPlayable=true;
			}

		}
		if(input.equalsIgnoreCase("south"))
		{
			xCoord=1;
			location = rooms[1][1];
			System.out.println(rooms[1][1].getDescription());
			isPlayable=true;
			key = true;

		}
		//same code from the first part
		if(key)
		{
			((Library) rooms[1][1]).librarySpace();
			//this starts the game in the library

		}
		//this communicates with the library class' boolean variable to determine if everything in that class is complete
		if(((Library) rooms[1][1]).getAchieve() ==true&&rooms[1][1].getLock() ==false)
		{
			System.out.println("Would you like to take the object?");

			input = scanner.nextLine();
			boolean innerAchieve = false;
			//the following is the same code from the previous part that allows player to take and place key in inventory
			while (innerAchieve==false) 
			{
				if (input.equalsIgnoreCase("yes"))
				{
					addItem(inventory, new Keys("Key2"));


					System.out.println("you can now type \"view inventory\" to view your stuff after pressing any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();

				}
				else if(input.equalsIgnoreCase("no"))
				{
					System.out.println("ok...press any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();
				}

				else
				{
					System.out.println("Sorry, I do not understand");
					input = scanner.nextLine();

					if(input.equalsIgnoreCase("yes")|| 
							input.equalsIgnoreCase("no"))
					{
						continue;
					}
				}
			}
			//this allows the player to move on to the next part
			if(innerAchieve==true)
			{
				System.out.println("Oh no, I hear someone coming, I guess I have to run");
				System.out.println("press any key to continue");
				part2=true;
				input = scanner.nextLine();
			}


			if(input.equalsIgnoreCase("view inventory"))
			{
				viewInventory();
			}

			part2=true; 
		}



	}
	public void part3()
	{
		//this is all the same directional parts from the first part, only the direction changed
		System.out.println("You now have to escape from the library to the next room");

		System.out.println("Where would you like to go?");
		System.out.println("North,East,South,West");


		System.out.println();
		

		String input = scanner.nextLine();
		boolean isPlayable =false;
		boolean key = false;
		boolean acheived = false;

		if(input.equalsIgnoreCase("west"))
		{
			isPlayable = true;
		}
		while(isPlayable==false)
		{
			System.out.println("Sorry, you are not allowed to go there yet");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("west"))
			{
				isPlayable=true;
			}

		}
		if(input.equalsIgnoreCase("west"))
		{
			xCoord=1;
			location = rooms[1][0];
			System.out.println(rooms[1][0].getDescription());
			isPlayable=true;
			key = true;

		}

		if(key)
		{
			((Kitchen) rooms[1][0]).examineObjects();
			//this once again communicates to the kitchen class

		}
		if(((Kitchen) rooms[1][0]).isAchieve() ==true&&rooms[1][0].getLock() ==false)
		{
			System.out.println("Would you like to take the object?");

			input = scanner.nextLine();
			boolean innerAchieve = false;

			while (innerAchieve==false) 
			{
				if (input.equalsIgnoreCase("yes"))
				{
					addItem(inventory, new Keys("Key3"));


					System.out.println("you can now type \"view inventory\" to view your stuff after pressing any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();

				}
				else if(input.equalsIgnoreCase("no"))
				{
					System.out.println("ok...press any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();
				}

				else
				{
					System.out.println("Sorry, I do not understand");
					input = scanner.nextLine();

					if(input.equalsIgnoreCase("yes")|| 
							input.equalsIgnoreCase("no"))
					{
						continue;
					}
				}
				
				
			}
			if(innerAchieve==true)
			{
				System.out.println("I've now decived the chef into giving me the key, my plan to escape is coming together");
				System.out.println("press any key to continue");
				part2=true;
				input = scanner.nextLine();
			}


			if(input.equalsIgnoreCase("view inventory"))
			{
				viewInventory();
			}

			part3=true; 
		}

	}

	public void part4()
	{
		
		 System.out.println("You now have to escape from the kitchen to the next room");
		 System.out.println();
		System.out.println("[YOU]: hmm... it would be bad if I was caught with the orb");
		System.out.println("I have to drop it into the vent to hide it!"); 
		System.out.println("type\"drop\" to hide the orb");
		String input = scanner.nextLine();
		//this is referring to the knife the players picked up in the first part 
		
		boolean dropvalid=false;
		while(dropvalid==false)
		{
			if(input.equalsIgnoreCase("drop"))
			{
				
				//the knife is the first thing the player must pick off, now we are removing it from the inventory
				
				System.out.println("you just dropped off the " + inventory.remove(0).getName());
				dropvalid=true;
			}
			else
			{
				System.out.println("quickly! get  rid of your evidence");
				input = scanner.nextLine();
			}
					
		}

		System.out.println("Now that that's over, Where would you like to go?");
		
		//String input = scanner.nextLine();
		System.out.println("North,East,South,West");


		System.out.println();
	

		input = scanner.nextLine();
		boolean isPlayable =false;
		boolean key = false;
		boolean acheived = false;
		//this is the same directing code
		if(input.equalsIgnoreCase("south"))
		{
			isPlayable = true;
		}
		while(isPlayable==false)
		{
			System.out.println("Sorry, you are not allowed to go there yet");
			input = scanner.nextLine();

			if(input.equalsIgnoreCase("south"))
			{
				isPlayable=true;
			}

		}
		if(input.equalsIgnoreCase("south"))
		{
			xCoord=1;
			location = rooms[2][0];
			System.out.println(rooms[2][0].getDescription());
			isPlayable=true;
			key = true;

		}

		if(key)
		{
			((Bathroom) rooms[2][0]).examineObjects();

		}
		if(((Bathroom) rooms[2][0]).getAchieve() ==true)
		{
			System.out.println("Would you like to take the object?");

			input = scanner.nextLine();
			boolean innerAchieve = false;

			while (innerAchieve==false) 
			{
				if (input.equalsIgnoreCase("yes"))
				{
					addItem(inventory, new Keys("Key4"));


					System.out.println("you can now type \"view inventory\" to view your stuff after pressing any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();

				}
				else if(input.equalsIgnoreCase("no"))
				{
					System.out.println("ok...press any key to continue");
					innerAchieve = true;
					input = scanner.nextLine();
				}

				else
				{
					System.out.println("Sorry, I do not understand");
					input = scanner.nextLine();

					if(input.equalsIgnoreCase("yes")|| 
							input.equalsIgnoreCase("no"))
					{
						continue;
					}
				}
			}
			if(innerAchieve==true)
			{
				System.out.println("looks like I'm nearly done, so close to going home!");
				System.out.println("press any key to continue");
				part2=true;
				input = scanner.nextLine();
			}


			if(input.equalsIgnoreCase("view inventory"))
			{
				viewInventory();
			}

			part4 =true;
		}
		else if(((Bathroom) rooms[2][0]).failAchieve() ==true)
		{
			System.out.println("you have nothing to collect");
			part4 =true;
		}


	}
	//this is the final part of the game
	//this is where all you keys are place
	//if not all they keys are not there, it is game over
	//otherwise, if all the keys are there, there is a final fight sequence
	//you must win that in order to win
	public void part5()
	{
		System.out.println("[YOU]: whew... I did not get caught yet, I have to move to a more secure location");
		System.out.println("[YOU]:I know where no one will find me....");
		System.out.println("[YOU]: the basement....");
		System.out.println("where would you like to go (type the location)");
		String input = scanner.nextLine();
		boolean valid = false;
		while(valid==false)
		{
			//this time, the player must type in and go to the basement, as this is the final location to get to
			if(input.equalsIgnoreCase("Basement"))
			{
				System.out.println(rooms[2][1].getDescription());
				
				((Basement) rooms[2][1]).examineObjects();

				if(((Basement) rooms[2][1]).getPossible()==true)
				{
					//if player uncovers the right object, they can finally place they keys, and that method will decide
					//weather or not the players has all the neccesary keys
					((Basement) rooms[2][1]).placeKey(inventory);
					
					//possible game endings, based on the amount of time taken to play, you get a set number of stars
					long totalTime = getElapsed();
					
					
					
					if(rooms[2][1].getLock()==false)
					{
						if(totalTime>10*60*1000)
						{
							System.out.println("0 STARS");
						}
						else if((totalTime<=10*60*1000)&&(totalTime>7*60*1000))
						{
							System.out.println("1 STAR");
						}
						else if((totalTime<=7*60*1000)&&(totalTime>4*60*1000))
						{
							System.out.println("2 STARS");
						}
						else if((totalTime<=4*60*1000))
						{
							System.out.println("3 STARS");
						}
					}
				}
				valid = true;
			}
			else
			{
				//this makes sure the player does not go to any other location
				//since our map has a set path
				System.out.println("going there won't be such a good idea....");
				input = scanner.nextLine();
			}
		}
		
		/*
		if(elapsedTime<=6*60*1000)
		{
			System.out.println("3 Stars");
		}
		else if (elapsedTime>6*60*1000 && elapsedTime<=8*60*1000)
		{
			System.out.println("2 Stars");
		}
		else if (elapsedTime>8*60*1000 && elapsedTime<=11*60*1000)
		{
			System.out.println("1 Star");
		}
		else if (elapsedTime>11*60*1000 && elapsedTime<=20*60*1000)
		{
			System.out.println("0 Stars");
		}
		*/

	}
	




	public static void main(String[] args)
	{
		//this is out main method where we connect each of our parts together depending on 
		//if the previous method is completed
		//the lock method ensures that if the game over method is called, it does not move on to any other part

		MansionTester mansion = new MansionTester(rooms);
		Room r = new Room("");

		mansion.introduction();
		if(intro==true&&r.getLock()==false)
		{
			mansion.part1();
			if(part1==true&&r.getLock()==false)
			{
				mansion.part2();
				if(part2==true&&r.getLock()==false)
				{
					mansion.part3();
				}
				if(part3==true&&r.getLock()==false)
				{
					mansion.part4();
				}
				if(part4==true&&r.getLock()==false)
				{
					mansion.part5();
				}
			}
		}

	}
}