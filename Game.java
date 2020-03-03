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
import java.util.*;
class Game 
{
    private Parser parser;
    public static int collectedFuses = 0;
    public static int collectedBombs = 0;
    private ArrayList<String> inv = ArrayList<>("Knife");
    public  ArrayList<String> story = ArrayList<>("Start Story", "Find Emma", "Go to comms", "Find Davidson", "Find Melissa", "Fuses", "Fix engine", "Bombs", "Build bomb", "Escape", "Choose");                                    
        
    //private static 
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
        boolean storyPrinted = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if (story.get(0).equals("Find Emma") && storyPrinted = false))
            {
                findEmma();
            }
            else if (story.get(0).equals("Go to comms" && storyPrinted = false))
            {
                goToComms();
            }
            else if (story.get(0).equals("Find Davidson" && storyPrinted = false))
            {
                findDavidson();
            }
            else if (story.get(0).equals("Find Melissa" && storyPrinted = false))
            {
                findMelissa();
            }
            else if (story.get(0).equals("Fuses" && storyPrinted = false))
            {
                fuses();
            }
            else if (story.get(0).equals("Fix Engine" && storyPrinted = false))
            {
                fixEngine();
            }
            else if (story.get(0).equals("Bombs" && storyPrinted = false))
            {
                bombs();
            }
            else if (story.get(0).equals("Build bomb" && storyPrinted = false))
            {
                buildBomb();
            }
            else if (story.get(0).equals("Escape" && storyPrinted = false))
            {
                escape();
            }
            else if (story.get(0).equals("Choose") && storyPrinted = false))
            {
                choose();
            }
            else if (story.get(0).equals("Start Story") && storyPrinted = false))
            {
                startStory();
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
        else if(commandWord.equals("w")){
            zorkArray.move(0, 1);
        }
        else if(commandWord.equals("a")){
            zorkArray.move(-1, 0);
        }
        else if(commandWord.equals("s")){
            zorkArray.move(1, 0);
        }
        else if(commandWord.equals("d")){
            zorkArray.move(0, -1);
        }
        else if(commandWord.equals("//stats")){
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
            printHelp();
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
    
    private static void startStory()
    {
        storyPrinted = true;
        //Ellie, implement story here
    }
    private static void findEmma() //called in zorkArray when 2 steps on 61
    {
        storyPrinted = true;
        //Ellie, implement story here
        
    }
    private static void goToComms() //called in zorkArray when 2 steps on 71 which is at map[37][38]
    {
        storyPrinted = true;
        //Ellie, implement story here
        zorkArray.map[37][38] = 71;
    }
    private static void findDavidson() //called here after the previous story mode prints
    {
        storyPrinted = true;
        //Ellie, implement story here
    }
    private static void findMelissa() //called in zorkArray when 2 steps on 62
    {
        storyPrinted = true;
        System.out.println("You see the tangled mass of a broken body beneath the boulders. \n You only know it's Commander Davidson by the broken dog tag hanging from his hand");
        System.out.println("'Commander Davidson?!' you ask frantically.\nWhat could have happened?! There was that... that crash... and now...");
        System.out.println("You swallow your fear and think rationally. What's the best thing to do?\nMaybe turning on the power. The ship's engineer, Melissa, should know how.\nNew Objective: find Melissa");
        storyPrinted = false;
    }
    private static void fuses() //called in zorkArray when 2 steps on 63
    {
        /*"Hi, Paul. You must've heard the crash. We need to restore power asap."
               "I need you to find 7 fuses for me. I'll be collecting so other parts and will meet you back in the engine room."
               "Don't panic, but be cautious. Think of it as a little game." Melissa joked
               "It could be fun!"
             */
         //new objective: collect 7 fuses
        //new objective: find Professor
        storyPrinted = true;
        
        while (collectedFuses != 10)
        {
            storyPrinted = true;
        }
        nextStory();
    }
    private static void fixEngine() //called here after player finds all fuses
    {
        storyPrinted = true;

        /*"You've found all the fuses..and Professor?"
              Professor Hidgens nods hello.
              "The door here is locked, though, so you need to find another way in."
              "Maybe the vent system? Take the fuses and repair the engine. It'll be pretty easy, I trust you can figure it out."
              */
              //new objective: find the vent in the cafeteria to get into the engine room
              //new objective: fix the engine
        zorkArray.map[17][16] = 72;

    }
    private static void bombs() //called in zorkArray after 2 steps on 72 which should be at map[17][16]
    {
        storyPrinted = true;
        /*Engine has been fixed.
        "Good job," Prof says from behind you.
        "We should defeat the aliens now. If you find the 10 bomb components, we can kill the source of their power"
        He gestures behind engine
        */
        //new objective, find bomb components
        while (collectedBombs != 10)
        {
            storyPrinted = true;
        }
        nextStory();
    }
    private static void buildBomb() //called here after player collects all bomb components
    {
        storyPrinted = true;
        /*Professor Hidgens speaks up again.
        "We can return to the engine now and finally get rid of the aliens."
        "Then we'll need to escape on an escape pod since the power has returned."
        You place the bomb down and set the timer.
        You decide to navigate back to the front of the station, to the escape pods. 
        Perhaps other survivors will be there, too.
        */
        zorkArray.map[1][16] = 73;

    }
    private static void escape() //called in zorkArray after 2 steps on 73 which should be at map[1][16]
    {
        storyPrinted = true;
        /*You arrive at the escape pod, no one in sight.
        Suddenly, another alien appears, this time more advanced than the others.
        You get ready for combat, but nore before realizing Hidgens has left you alone.
        Coward, you think to yourself before the fight starts.
        */
        zorkArray.map[52][11] = 74;

    private static void choose() //called in zorkArray after 2 steps on 74 which should be at map[52][11]
    {
        storyPrinted = true;
        /*You get ready to launch the escape pod when Emma and Melissa show up.
          They've both been helpful and kind to you since your arrival.
          Since there is only one extra space on the escape pod, you need to choose who comes with you.
          To decide, you've given them both a minute to persuade your decision.
        */
    }
    
    public static void nextStory()
    {
        story.remove(0);
        storyPrinted = false;
    }
}
