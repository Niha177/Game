import java.util.Scanner;

public class Bathroom extends Room {
	private String achievementUnlocked;
	private boolean achieve;
	private boolean failAchieve;
	
	public boolean getAchieve()
	{
		return achieve;
	}
	public boolean failAchieve()
	{
		return failAchieve;
	}
	public Bathroom() {
		super("You are now inside a bathroom");
		achievementUnlocked = "No achievment has been unlocked!";
	}
	
	//this is the method that allows the user to observe any object they want
	
	public void examineObjects() {
		Scanner scanner = new Scanner(System.in);
		//this allows the player to observe each of the objects listed

		System.out.println("You see a sink, a bathtub, and a toilet in the bathroom.");
		System.out.println("What would you like to examine? (Type the object name)");

		String input = scanner.nextLine().toLowerCase();
		
		boolean achieve=false;
		//this allows the player to keep looking until they stumble upon the right object
		while(achieve==false)
		{
			if (input.equalsIgnoreCase("sink")) {
				System.out.println("[YOU]: This is a sink. Maybe there's something inside it?");
				
				//this is the intended object the player must stumble on in order to make progress
				
				examineSink();
				achieve=true;
			} else if (input.equalsIgnoreCase("bathtub")) {
				System.out.println("[YOU]: The bathtub looks clean. Nothing suspicious here.");
				input = scanner.nextLine();
			} else if (input.equalsIgnoreCase("toilet")) {
				System.out.println("[YOU]: This is a toilet. Let's take a look inside.");
				examineToilet();
				input = scanner.nextLine();
			} else {
				System.out.println("[YOU]: That's not something you can examine in the bathroom.");
				input = scanner.nextLine();
			}
		}

		}
	private void examineToilet() {
		//gives player option to look inside where nothing is found
		System.out.println("[YOU]: You look inside the toilet. Gross, there's nothing there.");
		
	}

		//the sink is where the player will find the puzzle
	private void examineSink() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Would you like to look under the sink? (yes/no)");

		String input = scanner.nextLine();
	

		if (input.equalsIgnoreCase("yes")) {
			System.out.println("wow there are so many pipes,they really need to be \"organized\"");
			//the "organized" gives the player a hint on what to type
			System.out.println("looks like there is a sequence with a bunch of random numbers!");
			
			System.out.println();

			sinkMiniGame();
			
			
		} else {
			//if the player moves on, they can still move on, but they do not get the key
			System.out.println("[YOU]: You decided not to look under the sink.");
			
			//this makes sure the player does not get the key in the main mansion class
			failAchieve=true;
			
		}
	}
	public void sinkMiniGame()
	{
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("what should I do with this keypad sequence?");
		
		int[]sequence = new int[7];
		randSeq(sequence);
	
		showArr(sequence);
		//the sequence is random to give some variance
		
		
		String input = scanner.nextLine();
		
		boolean valid = false;
		while(valid==false)
		{
			if(input.equalsIgnoreCase("organize")||input.contains("sort"))
			{
				//if the player catches the right idea about organizing, the code will unscramble
				
				System.out.println("sorting.....");
				System.out.println();
				
				//allows for the sequence to be displayed and unscrambled
				selectionSort(sequence);
				showArr(sequence);
				
				
				System.out.println();
				System.out.println("something is unlocking...");
				System.out.println("[YOU]: You found a key under the sink!");
				achievementUnlocked = "Achievement has been unlocked!";
				//Signals that this level is over and ends the level with these boolean flags
				achieve=true;
				valid=true;
				
			}
			else
			{
				//this will keep showing up until the player types the right word
				System.out.println("hmm...doing that won't help");
				input = scanner.nextLine();
			}
		}
	}
	
	//these are the methods dealing with the sequences

	public void randSeq(int[]nums)
	{
		//loads random numbers in code for variance
		
		for(int x =0; x<nums.length;x++)
		{
			int rand = (int)(Math.random()*11);
			nums[x]= rand;
		}
	
	}
	public void showArr(int[]arr)
	{
		//allows for the code to be displayed
		for(int x =0; x<arr.length;x++)
		{
			System.out.print(arr[x]+" ");
		}
	}
	public void selectionSort(int[]arr)
	{
		//the actual sort that unscrambles sequence
		int n = arr.length;
		for (int x = 0; x < n-1; x++) {

			int minindex = x;
			for (int j = x+1; j < n; j++)
				if (arr[j] < arr[minindex])
					minindex = j;


			int temp = arr[minindex];
			arr[minindex] = arr[x];
			arr[x] = temp;
		}

	}
	
	
	
	

	public String isAchievementUnlocked() {
		return achievementUnlocked;
	}
}