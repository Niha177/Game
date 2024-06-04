import java.util.Scanner;

public class Kitchen extends Room
{
	private boolean chefInteracted;
    private boolean hasKey;
    private boolean achieved;
    private boolean pantryOpen;
    private boolean validObject;
    
    
    Scanner scanner = new Scanner(System.in);
    
    //our getters or setters we use throughout the game
    
    public boolean isAchieve()
    {
    	return achieved;
    }
    public boolean getvalidObject()
    {
    	return validObject;
    }
    //our introduction to the kitchen
	public Kitchen()
	{
		super("You are now in a Kitchen and see a chef");
		 chefInteracted = false;
	        hasKey = false;
	        achieved=false;
	}
	public void examineObjects() {
      //this allows the player to choose any object to observe.
	//right now, if the players tries to open the pantry, it is locked and they need to get the key from the chef
        

        System.out.println("You see a stove, a refrigerator,pantry, and a chef in the kitchen.");
        System.out.println("What would you like to examine? (Type the object name)");

        String input = scanner.nextLine().toLowerCase();
        boolean achieved = false;
        int chefEncounter=0;
        
        //this while loop makes it so that the player can go observe other things successively
        while(achieved ==false) 
        {
        	if (input.equalsIgnoreCase("stove")) {
                examineStove();
                input = scanner.nextLine();
            } else if (input.equalsIgnoreCase("refrigerator")) {
                examineRefrigerator();
                input = scanner.nextLine();
            } 
            else if (input.equalsIgnoreCase("pantry")) {
                examinePantry();
                input = scanner.nextLine();
            }
            else if (input.equalsIgnoreCase("chef")) 
            {
            	interactWithChef();
            	achieved=true;
         
            } else {
                System.out.println("[YOU]: That's not something you can examine in the kitchen.");
                input = scanner.nextLine();
            }
        }

        
    }
	//these are our methods that are used in the previous method to give the appropriate response 
    private void examineStove() {
        System.out.println("[YOU]: This is a stove. It looks like it's still hot.");
    }

    private void examineRefrigerator() {
        System.out.println("[YOU]: The refrigerator is stocked with food.");
    }
    private void examinePantry()
    {
    	//this is our pantry, we enabled it so that it can only open once the pantryOpen
    	//boolean variable is set to true, that acts as the key
    	if(pantryOpen==true)
    	{
    		System.out.println("looks like I can open the door!");
    		System.out.println("look...I found a key!");
    		
    		
    		//the goal of the level is to get to the pantry, so once they open it, the level is complete
    		achieved=true;
		
    	}
    	else
    	{
    		//this is what shoes up if the key is not set to true
    	 	System.out.println("***tries to open door***");
    	 	System.out.println("The door is locked, looks like I need a key");
    	}
   
    }
    
    //this is the method that allows us to interact with the chef
    //talking to the chef is how you get the key to the pantry

    private void interactWithChef() {
        Scanner scanner = new Scanner(System.in);

        if (chefInteracted==false)
        {
        	System.out.println("[YOU]: Hello, chef! What are you cooking?");
            System.out.println("[CHEF]: I'm preparing a delicious meal for the guests.");
            System.out.println("You notice the chef has a key hanging from his apron.");
            System.out.println("Would you like to ask the chef about the key? (yes/no)");

            
            String input = scanner.nextLine();
            boolean hasachieved = false;
            while(hasachieved==false)
            {
            	if (input.equalsIgnoreCase("yes")) {
                    System.out.println("[YOU]: Excuse me, chef. What's the key for?");
                    System.out.println("[CHEF]: Ah, this key unlocks the pantry where we keep our secret ingredients.");
                    System.out.println("[You]: ***to yourself*** if I get the key to the pantry, there may be something inside");
                    System.out.println("should I ask him if I could have the key?");
                    
                    //this give the player the option of weather or not they want to see the key or not
                    //the player has a choice here, if they say no, they can still move on...
                    //but they will loose in the basement due to lack of keys
                    
                    input = scanner.nextLine();
                    
                    boolean inner = false;
                    while(inner==false)
                    {
                    	if(input.equalsIgnoreCase("yes"))
                    	{
                    		System.out.println("[YOU]: Could I have it?");
                            System.out.println("[CHEF]:yes, only after you help me");
                        
                            inner=true;
                            hasachieved=true;
                            chefInteracted=true;
                            
                            //if they player says yes to helping out the chef, it takes them to the mini game
                            miniChefGame();
                            achieved = true;
                            validObject=true;
                            break;
                    	}
                    	else
                    	{
                    		//this will allow the player to move on, but without they key
                    		System.out.println("[YOU]: Guess I should leave the chef alone");
                            achieved = true;
                            hasachieved=true;
                            input="no";
                            input = scanner.nextLine();
                            break;
                    	}
                    }
                    
                    
                 
                   
                } 
            	else if(input.equalsIgnoreCase("no")) {
                    System.out.println("[YOU]: Guess I should leave the chef alone");
                    achieved = true;
                    hasachieved=true;
                    input = scanner.nextLine();
                }
                else
                {
                	//this is what happens if user types anything else
                	System.out.println("[CHEF]: sorry, what was that?");
                	input = scanner.nextLine();
                }
           
            
            
        }
        }
            
    }
    public void miniChefGame()
    {
    	//this is out mini chef game that allows the player to get the key
    	boolean playable =false;
    	System.out.println("[CHEF]: depending on what food item you get, you either have to chop, slice, or dice the dish");
    	System.out.println("[CHEF]:you must slice the oranges, chop the potatoes, and dice the onions");
    	System.out.println("[CHEF]:you may face consequeces for doing it wrong, but I will give you two tries");
    	System.out.println("type START to begain");
    	
    	
    	boolean achived =false;
    	String input = scanner.nextLine();
    		while(achived==false)
    		{
    			
    			if(input.equalsIgnoreCase("start"))
        		{
        			playable=true;
        			achived=true;
        			//this is confirmation that the player is ready
        		}
    			else
    			{
    				System.out.println("[CHEF]:sorry what was that?");
    				input = scanner.nextLine();
    				
    			}
    		}
    		if(playable==true)
    		{
    			boolean validLoop = false;
    			boolean success=false;
    			int successCounter = 0;
    			int dangercount = 0;
    			//we gave the player 2 tries before game over
    			
    			while(validLoop==false&& successCounter<11&&dangercount<3)
    			{
    				int food = (int)(Math.random()*3);
    				//this randomly generates three numbers, each corresponding to three of our food items
    				//depending on what number is generated, it gives that vegetable
    				
    				
    				if(food==0&& successCounter<11&&dangercount<3)
    				{
    					System.out.println("you got an onion");
    					
    					boolean inner=false;
    					
    					while(inner==false&& successCounter<11&&dangercount<3)
    					{
    						
    						input = scanner.nextLine();
    						if(successCounter>11)
							{
    							//our success counter stops the game until they get 10 different food items
    							inner=true;
								validLoop = true;
								break;
							}
    						else if(input.equalsIgnoreCase("dice"))
    						{
    							successCounter++;
    							inner=true;
    						}
    						else
    						{
    							//if the wrong command is types, the danger count updates
    							//if it goes up to 2, then it is game over
    							dangercount++;
    							if(!(dangercount<3))
    							{
    								validLoop = true;
    								break;
    								//this game breaks the loop as once two tries are depleted, it is completely game over
    							}
    							System.out.print("[CHEF]:wrong! you have ");
    						System.out.print(3-dangercount);
    						System.out.print(" tries left");
    						
    							
    						}
    					}
    					continue;
    				}
    				//we used the same ideas above and used those principles for our other food item too
    				else if(food==1&& successCounter<11&&dangercount<3)
    				{
    					System.out.println("you got an orange");
    				
    					boolean inner=false;
    					
    					while(inner==false&& successCounter<11&&dangercount<3)
    					{
    						input = scanner.nextLine();
    						if(successCounter>11)
							{
    							inner=true;
								validLoop = true;
								break;
							}
    						else if(input.equalsIgnoreCase("slice"))
    						{
    							successCounter++;
    							inner=true;
    						}
    						else
    						{
    							dangercount++;

    							if(!(dangercount<3))
    							{
    								validLoop = true;
    								break;
    							}
    							System.out.print("[CHEF]:wrong! you have ");
    						System.out.print(3-dangercount);
    						System.out.print(" tries left");
    						
    							
    						}
    					}
    					continue;
    				}
    				//we used the same ideas above and used those principles for our other food item too
    				else if(food==2&& successCounter<11&&dangercount<3)
    				{
    					System.out.println("you got an potato");
    				
    					boolean inner=false;
    					
    					while(inner==false&& successCounter<11&&dangercount<3)
    					{
    						input = scanner.nextLine();
    						if(successCounter>11)
							{
    							inner=true;
								validLoop = true;
								break;
							}
    						else if(input.equalsIgnoreCase("chop"))
    						{
    							successCounter++;
    							inner=true;
    						}
    						else
    						{
    							dangercount++;

    							if(!(dangercount<3))
    							{
    								validLoop = true;
    								break;
    							}
    							System.out.print("[CHEF]:wrong! you have ");
    						System.out.print(3-dangercount);
    						System.out.print(" tries left");
    						
    							
    						}
    					}
    				}
    				continue;
    				
    			}
    			//these two statements are the final check to determine if the player succeeded or not
    				//this if statement happens when the two tries are used up
    				if(!(dangercount<3))
    				{
    					System.out.println("[CHEF]: How dare you mess up MY meal prep!");
    					System.out.println("[CHEF]: looks like this is the end...");
    					System.out.println("[CHEF]: You are going to be locked upstairs for your poor performance");
    					System.out.println();
    					System.out.println("[YOU]: NOOOOO!!!!!");
    					//this brings them to game over and the game ends(our bad ending)
        				gameOver();
    					
    				}
        			else
        			{
        				//this is what happens if the player succeeds
        				System.out.println("[CHEF]: Wow, I am impressed with you chopping skills");
        				System.out.println("Here is the key you wanted");
        				System.out.println();
        				System.out.println("looks like I have the key to the pantry, lets try opening it");
        				System.out.println("You still see a chef, refrigerator ,pantry and stove, why are you going to examine? (type object name)");
        				pantryOpen=true;
        				//this unlocks the pantry as the key is given t the player by the chef
        				 input = scanner.nextLine();
        				 //this level is not over yet, the player still has to go to the pantry to receive they actual key
        				 //for the last level
        				 
        				 boolean inachieved=false;
						while(inachieved ==false) 
        			        {
        			        	if (input.equalsIgnoreCase("pantry")) {
        			        		examinePantry();
        			        		//this bring them back to the pantry method, where this time, it will be unlcked
        			        		inachieved=true;

        			        		//we are not allowing the player to go back to the other items
        			        		//as they main mission now is to unlcok the pantry
        			            } else if (input.equalsIgnoreCase("refrigerator")) 
        			            {
        			            	System.out.println("[YOU]: I don't have enough time to go back to the refrigerator");
        			                input = scanner.nextLine();
        			            } else if (input.equalsIgnoreCase("chef")) 
        			            {
        			            	System.out.println("You already talked to the chef");
        			            	 input = scanner.nextLine();
        			            } 
        			            else if(input.equalsIgnoreCase("stove"))
        			            {
        			            	System.out.println("[YOU]: I don't have enough time to go back to the stove");
        			                input = scanner.nextLine();
        			            }
        			            else {
        			                System.out.println("[YOU]: That's not something you can examine in the kitchen.");
        			                input = scanner.nextLine();
        			            }
        			        }
        				
        				//this ends the game as there is nothing else for the player too expect to move on
        				playable=false;
        				
        				
        			}
    			
    			
    		}
    		
    	
    	
    }

    public boolean hasKey() {
        return hasKey;
    }
}