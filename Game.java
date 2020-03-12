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
    //zorkArray.map[52][14] = 81;
    private Parser parser;
    public static int collectedFuses = 0;
    public static int collectedBombs = 0;
    public static ArrayList<String> inv = new ArrayList<String>();
    public static String[] story = new String[]{"Find Emma","Go to comms","Find Davidson","Find Melissa","Fuses","Fix Engine","Bombs","Build Bomb","Escape","Choose"};
    public static String currentStory = "Find Emma";
    public static boolean storyPrinted = false;
    private static Battle battle = new Battle();
    public static boolean finished = false;
    public static boolean win = false;
  
        
    public Game() 
    {
        parser = new Parser();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {
        inv.add("Knife");
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if (currentStory.equals("Find Emma"))
            {
                findEmma();
            }
            else if (currentStory.equals("Go to comms"))
            {
                goToComms();
            }
            else if (currentStory.equals("Find Davidson"))
            {
                findDavidson();
            }
            else if (currentStory.equals("Find Melissa"))
            {
                findMelissa();
            }
            else if (currentStory.equals("Fuses"))
            {
                fuses();
            }
            else if (currentStory.equals("Fix Engine"))
            {
                fixEngine();
            }
            else if (currentStory.equals("Bombs"))
            {
                bombs();
            }
            else if (currentStory.equals("Build Bomb"))
            {
                buildBomb();
            }
            else if (currentStory.equals("Escape"))
            {
                escape();
            }
            else if (currentStory.equals("Choose"))
            {
                choose();
            }
        }
        if (win)
            win();
        else
            lose();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Starship 15 A2! I'm your assistant, Alexa.");
        System.out.println("As you awaken from hypersleep, please be aware of your surroundings.\nTake a moment to look at the map and familiarize yourself with the ship.\n");
        System.out.println("When you're ready, use W,A,S,D to move about the ship.");
        System.out.println("Enter any command to get started.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }
    
    public static void win()
    {
        System.out.println("You have won. The End");
    }
    
    private void lose()
    {
        System.out.println("System exited. Game Over.");
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
        String secondWord = command.getSecondWord();
        if (commandWord.equals("//help"))
            printHelp();
        else if(commandWord.equals("w")){
            zorkArray.move(-1, 0);
        }
        else if(commandWord.equals("a")){
            zorkArray.move(0, -1);
        }
        else if(commandWord.equals("s")){
            zorkArray.move(1, 0);
        }
        else if(commandWord.equals("d")){
            zorkArray.move(0, 1);
        }
        else if(commandWord.equals("open")){
            if((zorkArray.map[48][37] == 2) || (zorkArray.map[48][39] == 2))
                System.out.println("5s26W$$nC*hpa,E");
            else
                System.out.println("<Unable to accept command>");
        }
        else if (commandWord.equals("kick")){
            if (command.hasSecondWord()){
                String direction = command.getSecondWord();
                zorkArray.kick(direction);
            }
            else{
                System.out.println("<Unable to accept command>");
            }
        }
        else if(commandWord.equals("stats")){
            System.out.println("Health: "+character.hp);
            System.out.println("Sp: "+character.sp);
            String inventory = "Inventory: < ";
            for (String s: inv){
                inventory = inventory+s+", ";
            }
            inventory = inventory.substring(0,inventory.length()-2);
            inventory=inventory+" >";
            System.out.println(inventory);
            System.out.println("Collected Fuses: "+collectedFuses);
            System.out.println("Collected Bomb Components: "+collectedBombs);
            System.out.println("[Current Objective] "+currentStory);
        }
        else if (commandWord.equals("quit"))
        {
            if(command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
        }
        else if (commandWord.equals("help"))
        {
            printHelp();
        }
        else if (commandWord.equals("Alexa"))
        {
            Scanner cheat = new Scanner(System.in);
            System.out.print("Yes, Paul? \n > ");
            String alexaCode = cheat.nextLine();
            if (alexaCode.equals(zorkArray.getStoryline()))
            {
                zorkArray.storyTrue = true;
            }
            cheat.close();
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
    
    private static void findEmma() //called in zorkArray when 2 steps on 61
    {
        storyPrinted = true;
        System.out.println("As you look around, you see a large TV tuned to a news program \nThe reporter begins speaking.");
        System.out.println("'A space station known as Starship 15 A2 has been launched under the Galactic League of Extraterrestrial Exploration and \nhas been tasked with researching the Apotheosis Virus. \nThis is Dan with the Hatchetfield morning news. Back to you, Donna.'");
        System.out.println("You turn away from the TV, ready to start your dream job. \nAnd finding the captain of the ship is a good place to start");
        System.out.println("[New Objective] Head to the Cafeteria to find Emma.");
        currentStory = "wait1";
    }
    private static void goToComms() //called in zorkArray when 2 steps on 71 which is at map[37][38]
    {
        storyPrinted = true;
        System.out.println("You see Emma, the Captain of the ship.");
        System.out.println("'Hey! Paul, right?' she calls to you. 'We heard you'd be arriving soon. You're on the communications team with Commander Davidson.'");
        System.out.println("You find yourself smiling. Working regularly with Galactic League of Extraterrestrial Exploration had always been your dream job but Emma here made you even more at ease.");
        System.out.println("'Here, take a granola bar. They're a new formula to boost your immune system. Good luck, Paul! See you around.'");
        inv.add("Granola Bar");
        System.out.println("[New Objective] Go to the Communications Room");
        zorkArray.map[35][31] = 71;
        currentStory = "wait2";
    }
    private static void findDavidson() //called in zorkArray when 2 steps on 9;
    {
        storyPrinted = true;
        System.out.println("As you pass through the empty Control Room, you look around at the tables lined with monitors. All of them blink red.");
        System.out.println("You lean over to look at the monitors. A large, blinking dot moves closer to the outline of the ship.");
        System.out.println("As the dot collides with the ship, you hear a large crash. \nThe ship jerks around violently, throwing you to the ground. \nThen, everything goes dark.");
        System.out.println("Okay, don't panic. First things first. Find the Commander.");
        System.out.println("[New Objective] Find Commmander Davidson");
        setAliens();
        zorkArray.map[30][24] = 62;
        currentStory = "wait3";
    }
    private static void findMelissa() //called in zorkArray when 2 steps on 62
    {
        storyPrinted = true;
        System.out.println("You see the tangled mass of a broken body beneath the boulders. \nYou only know it's Commander Davidson by the broken dog tag hanging from his hand");
        System.out.println("'Commander Davidson??' You ask frantically.");
        System.out.println("'What the heck happened? There was that...that crash and now there's a mangled body here and...'");
        System.out.println("The power goes out. You try to not panic as you think of what to do.");
        System.out.println("I'll go back to the cafeteria to talk to Emma");
        System.out.println("Although... the engineer might be more helpful in this situation. I guess I'll check the engine room");
        System.out.println("[New Objective] Find Melissa");
        currentStory = "wait4";
    }
    private static void fuses() //called in zorkArray when 2 steps on 63
    {
        storyPrinted = true;
        System.out.println("Finally, you find Melissa. She waves you over frantically.");
        System.out.println("'Thank God I found you, Paul,' she says. \n'We need to restore the power as soon as possible or we'll asphyxiate. \nThe Engine Room is blocked by this rubble. \nIf you could find a way in and collect just 7 fuses for me, we could easily fix this.'");
        System.out.println("Melissa smiles awkwardly. 'Don't panic, but be cautious. Think of it as a game,' she jokes. \n'It could be fun!'");
        System.out.println("[New Objective] Find 7 fuses");
        currentStory = "wait5";
    }
    private static void fixEngine() //called here after player finds all fuses
    {
        storyPrinted = true;
        System.out.println("You pick up the last fuse. 'Great job!' the Professor says. \n'Now, we must return these to the engine. Do you know the way there?'");
        System.out.println("'Melissa said the door was blocked,' you reply.");
        System.out.println("'Hmm. Perhaps the ventilation system will do. \nMs. Melissa told me the easiest access to the vents is in the kitchen. Perhaps try there.'");
        System.out.println("[New Objective] Access the vents and install the fuses");
        zorkArray.map[17][16] = 72;
        currentStory = "wait6";
    }
    private static void bombs() //called in zorkArray after 2 steps on 72 which should be at map[17][16]
    {
        storyPrinted = true;
        collectedFuses = 0;
        System.out.println("'Amazing job, Paul! Now, I don't mean to put a damper on things, but there is one more task...' the Professor trails off.");
        System.out.println("You sigh in exasperation. 'What is it?'");
        System.out.println("'Well, the Apotheosis Virus must not spread. So we must--'");
        System.out.println("'Destroy the ship,' you finish.");
        System.out.println("'There should be some bomb components laying around. You may have found some already. \nWe need 10. How many do you currently have?'");
        System.out.println("'I've got "+collectedBombs+",' you reply.");
        System.out.println("'Right, then. Let's find the rest.'");
        System.out.println("[New Objective] Find the rest of the bomb components");
        currentStory = "wait7";
    }
    private static void buildBomb() //called here after player collects all bomb components
    {
        storyPrinted = true;
        System.out.println("'We're almost done here, Paul,' Professor Hidgens says. \n'All we have to do is attach the bomb to the back of the engine.'");
        System.out.println("'Right. Here we go,' you mutter.");
        System.out.println("[New Objective] Attach the bomb to the back of the engine");
        collectedBombs = 0;
        zorkArray.map[1][16] = 73;
        currentStory = "wait8";
    }
    private static void escape() //called in zorkArray after 2 steps on 73 which should be at map[1][16]
    {
        storyPrinted = true;
        System.out.println("After you attach the bomb, you move to arm it. \nSuddenly, the whole ship seems to shake and rattle. \nYou spin around and come face-to-face with Commander Davidson--back from the dead.");
        zorkArray.bossBattle();
        System.out.println("As you stand over Davidson's dead body, blue ooze leaking from his brain, the beeping of the bomb brings you back to reality.");
        System.out.println("'Paul?' Melissa's voice catches your attention. 'Paul, are you okay? You need to get out of here!'");
        System.out.println("'But... the bomb...' you try for words, but they don't come.");
        System.out.println("'It's okay. I'll arm it. Just go! We need at least one survivor.' \nMelissa turns you around and pushes you towards the exit. \nAs you leave, you catch a glimpse of blue ooze on Melissa's shoulder.");
        System.out.println("[New Objective] Get to the escape pod");
        zorkArray.map[52][11] = 74;
        currentStory = "wait9";
    }
    private static void choose() //called in zorkArray after 2 steps on 74 which should be at map[52][11]
    {
        storyPrinted = true;
        System.out.println("You get ready to launch the escape pod when Emma and Melissa show up.");
        System.out.println("'Melissa? Emma? I thought you both died.' They shake their head.");
        System.out.println("'I've been in the comms room. There isn't a signal anywhere...' Emma explains.");
        System.out.println("'I successfully armed the bomb. It should be going off any second now.'");
        System.out.println("Melissa gestures behind you. 'Is the escape pod ready?'");
        System.out.println("You nod, but realize there is only one extra spot on the escape pod.");
        System.out.println("They've both been helpful and kind to you since your arrival, but there's reason to be suspicious of both.");
        System.out.println("'Hurry,' Melissa urges, 'the bomb will go off very soon!'");
        System.out.println("You consider between the two. \nEmma, the captain of the ship, has been helpful since your arrival, providing you food and help from the beginning. \nMelissa, however, did help you start the power and arm the bomb. But that blue ooze matches the aliens perfectly.");
        System.out.println("After considering the options (and the possibility that either could be infected), you choose...");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        System.out.println(choice);
        System.out.println("Quickly, you grab her hand and pull her into the escape pod. \nThe door shuts behind you, leaving the space station behind as you blast into space.");
        System.out.println("You watch through the dusty window as Starship 15 A2 obliterates into nothing but rubble.");
        System.out.println("'We did it!' you shout. \nAs you turn to "+choice+", you see a drop of blue ooze dripping from her eyes.");
        System.out.println("'"+choice+"?' you ask. She turns to you slowly. \nThe voice that emanates from her mouth is not her own. \nWe will not be resisted, Paul.");
    }
    
    /*
    public static void nextStory()
    {
        story.remove(0);
        storyPrinted = false;
    }
    */
    
    public static void setAliens()
    {
        for (int i=0; i<40; i++)
        {
            int y = (int)(Math.random()*53+1);
            int x = (int)(Math.random()*46+1);
            while (zorkArray.map[y][x] != 0)
            {
                y = (int)(Math.random()*53+1);
                x = (int)(Math.random()*46+1);
            }
            zorkArray.map[y][x] = 8;
        }
        zorkArray.map[53][14] = 8;
        zorkArray.map[30][33] = 8;
    }
    
    public static void printMap(boolean obstacles){
        //System.out.print('\u000C');       clears terminal? not that helpful....
        for(int[] Y: zorkArray.map)
                    {
                       for(int X: Y)
                       {
                           if (X==2){
                               System.out.print("P ");
                            }
                           else if (X==1 || X== 11){
                                System.out.print("/ ");
                            }
                            else if (X==34){
                                System.out.print("~ ");
                            }
                            //else if (X==32 || X==33 || X==37 || X==39){
                            //    System.out.print("# ");
                            //}
                            else if (X==35){
                                System.out.print("% ");
                            }
                            else if ((X==32 || X==33 || X==36) && obstacles==true){
                                System.out.print("# ");
                            }
                            else if ((X==51 || X==52) && obstacles==true){
                                System.out.print("$ ");
                            }
                            else if ((X==61 || X==62 || X==63 || X==71 || X==72 || X==73 || X==74) && obstacles==true){
                                System.out.print("@ ");
                            }
                            else if ((X==8) && obstacles==true){
                                System.out.print("X ");
                            }
                            else{
                                System.out.print(". ");
                            }
                       }
                      System.out.println();
                    }
                }
}
