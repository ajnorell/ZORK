/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author:  Michael Kolling
 * Version: 1.1
 * Date:    March 2000
 * 
 * Modified by: April Schermann
 * Date:        October 2018
 * 
 *  This class is the main class of the "Zork" application. Zork is a very
 *  simple, text based adventure game.  Users can walk around some scenery.
 *  That's all. It should really be extended to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  routine.
 * 
 *  This main class creates and initializes all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates the
 *  commands that the parser returns.
 */

class Game 
{
    private Parser parser;
    int collectedFuses = 0;
    int totalFuses = 0;
    ArrayList<String> inv = ArrayList<String>();
    inv.add("Knife");
    ArrayList<String> story = ArrayList<String>();
    story.add("Find Emma").add("Go to comms").add("Find Davidson").add("Find Melissa").add("Fuses").add("Fix engine").add("Bombs").add("Build bomb").add("Escape").add("Choose");
        
    private static 
    /**
     * Create the game and initialize its internal map.
     */
    public Game() 
    {
        parser = new Parser();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if story.get(0).equals("Find Emma")
            {
                
            }
            else if story.get(0).equals("Go to comms")
            {
                
            }
            else if story.get(0).equals("Find Davidson")
            {
                
            }
            else if story.get(0).equals("Find Melissa")
            {
                
            }
            else if story.get(0).equals("Fuses")
            {
                
            }
            else if story.get(0).equals("Fix Engine")
            {
                
            }
            else if story.get(0).equals("Bombs")
            {
                
            }
            else if story.get(0).equals("Build bomb")
            {
                
            }
            else if story.get(0).equals("Escape")
            {
                
            }
            else if story.get(0).equals("Choose")
            {
                
            }
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Starship 15 A2! I'm your assistant, MegaGirl.");
        System.out.println("As you awaken from hypersleep, please be aware of your surroundings.\nTake a moment to look at the map and familiarize yourself with the ship.\n");
        System.out.println("When you're ready, use W,A,S,D to move about the ship.");
        System.out.println("Type '//help' if you need help.");
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        if(command.isUnknown())
        {
            System.out.println("<Unable to accept command>");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("//help"))
            printHelp();
        else if(commandWord.equals("w"){
            zorkArray.move(0, 1);
        }
        else if(commandWord.equals("a"){
            zorkArray.move(-1, 0);
        }
        else if(commandWord.equals("s"){
            zorkArray.move(1, 0);
        }
        else if(commandWord.equals("d"){
            zorkArray.move(0, -1);
        }
        else if(commandWord.equals("//stats"){
            System.out.println("Health: "+character.hp);
            System.out.println("Sp: "+character.sp);
            String inventory = "Inventory: < ";
            for (String s: inv){
                inventory += s+", ";
            }
            inventory.substring(0,inventory.length-1);
            inventory+=" >";
        }
        else if (commandWord.equals("//quit"))
        {
            if(command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
        }
        else if (commandWord.equals("//help"))
        {
            printHelp()
        }
        return false;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("\n\n\nYour command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     **/
    }
}
