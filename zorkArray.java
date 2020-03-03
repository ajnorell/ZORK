
public class zorkArray
{
    battle battle = new battle();    
    String[] attacks1 = {"Punch","Guard", "Scream", "Slash"};
    String[] attacks2 = {"Punch","Guard", "Scream"};
    enemy enemy1 = new enemy(3, "Alien", 20, 4, 10, attacks1);
    enemy enemy2 = new enemy(5, "Buff Alien", 40, 1, 10, attacks1};
    enemy enemy3 = new enemy(1, "Vocal Alien", 30, 7, 10, attacks2};
    character player = new character("Paul");
    int enemy count = 1;
    /* 

       Pick-ups:
       51 - fuse "51"
       52 - bomb component "52"
       53 - granola bar "53"
       54 - plasma gun "54"
       55 - plasma grenade "55"
       56 - flamethrower "56"
       57 - sonar gun ">"
     
       Obstacles:
       31 - chair     "31"
       32 - table     "32"
       33 - box       "33"
       34 - window    "34"
       35 - engine    "35"
       36 - boulder   "36"
       37 - stove     "37"
       38 - toilet    "38"
       39 - bed       "39"                      1                   2                   3                   4
       */ //                 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
    private static int[][] map = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,33,0,0,0,35,35,35,35,35,0,0,8,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,52,0,0,0,33,0,0,35,35,0,0,0,0,0,35,35,0,0,0,0,0,33,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,8,0,0,0,0,35,0,0,0,0,0,0,0,0,0,35,0,0,0,33,33,33,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,35,0,0,0,33,33,33,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,35,35,35,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,35,0,8,0,0,35,35,35,0,0,0,0,0,0,0,8,0,0,1,1,1,1,1,1,1},
                            {1,0,35,0,0,0,35,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,0,56,35,0,0,35,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,35,0,0,0,0,0,35,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,35,35,0,0,0,0,35,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,35,0,0,0,0,0,35,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,35,8,35,0,0,0,0,0,35,0,0,33,33,33,0,0,0,1,1,1,1,1,1,1},
                            {1,35,0,0,0,0,0,35,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,35,0,0,0,0,0,35,0,0,0,33,33,33,0,52,1,1,1,1,1,1,1},
                            {1,0,35,0,0,0,35,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,0,35,0,0,0,35,0,0,0,0,0,33,33,33,33,1,1,1,1,1,1,1},
                            {1,0,0,35,35,35,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,35,35,35,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,35,35,0,0,0,0,0,35,35,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,33,33,0,0,0,0,0,0,0,0,35,35,35,35,35,0,0,0,0,0,0,0,0,0,0,0,33,33,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,33,33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,33,33,33,33,0,0,8,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,33,33,33,33,0,0,0,0,0,0,33,1,1,1,1,1,1,1},
                            {1,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,33,0,0,0,0,0,0,0,0,33,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,33,33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,0,33,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,0,0,0,0,0,0,0,0,0,0,0,0,0,33,0,33,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,33,33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,33,33,0,33,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,8,0,0,0,33,33,33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,33,52,0,33,1,1,1,1,1,1,1},
                            {1,1,1,1,8,0,0,0,0,33,33,33,52,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,33,33,33,33,33,1,1,1,1,1,1,1},
                            {1,0,0,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,63,1,0,0,8,54,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,31,0,0,0,0,0,0,0,0,1,0,0,0,39,39,1},
                            {1,0,0,1,41,0,55,53,1,33,33,0,33,33,33,33,33,33,0,0,33,0,1,36,0,0,0,0,0,31,32,32,32,31,0,0,0,0,0,0,1,53,0,0,0,0,1},
                            {1,0,0,1,1,1,1,1,1,33,0,0,0,0,0,0,8,0,0,0,33,0,4,36,36,0,0,0,0,32,0,0,52,32,0,0,0,0,0,0,1,39,39,0,0,0,1},
                            {1,0,0,1,0,0,0,0,0,0,0,33,33,33,33,33,33,33,33,33,33,0,1,36,36,0,0,31,32,0,0,0,0,33,32,31,0,0,0,0,1,0,0,0,0,0,1},
                            {1,0,0,1,0,0,33,33,33,33,0,33,33,33,0,0,0,0,33,51,0,0,1,36,62,0,0,0,0,0,0,8,52,8,32,0,0,0,0,0,1,0,0,0,39,39,1},
                            {1,0,0,1,0,0,51,0,0,33,0,0,8,0,0,0,33,0,8,33,52,33,1,36,0,0,0,31,32,0,0,0,33,57,32,31,0,0,0,0,4,0,8,0,0,53,1},
                            {1,0,0,1,0,0,0,0,0,51,33,33,52,33,33,0,0,0,0,33,33,33,1,0,0,0,0,0,0,32,52,0,33,32,0,0,0,0,0,0,4,0,0,0,0,0,1},
                            {1,0,0,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,0,0,0,0,0,0,31,32,32,32,31,8,0,32,32,0,0,1,0,0,0,39,39,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,8,0,0,0,0,31,0,0,0,0,32,32,0,0,1,0,0,0,0,51,1},
                            {1,51,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,32,32,0,53,1,39,39,53,0,0,1},
                            {1,33,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,34,34,34,1,1},
                            {1,0,0,1,41,0,0,0,0,8,0,0,0,0,0,0,0,32,32,32,32,0,1,0,0,0,0,0,0,0,0,0,0,0,52,1,0,0,0,0,1,1,1,1,1,1,1},
                            {1,0,8,1,32,32,53,37,1,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,32,32,53,0,0,0,0,0,0,42,1,0,31,32,0,34,1,1,1,1,1,1},
                            {1,0,0,1,1,1,1,1,1,0,0,32,32,32,32,0,0,32,32,32,53,0,1,0,0,32,32,32,32,0,0,0,0,0,0,1,0,0,32,0,34,1,1,1,1,1,1},
                            {1,8,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,1,0,0,32,32,32,32,0,0,0,0,0,42,1,0,31,32,0,34,1,1,1,1,1,1},
                            {1,0,0,1,0,53,32,32,32,0,0,32,32,32,32,0,0,32,32,32,32,0,1,0,0,0,0,0,0,0,0,0,53,0,0,1,0,0,32,0,34,1,1,1,1,1,1},
                            {1,0,0,1,0,0,0,0,0,0,0,8,0,61,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,31,31,31,0,42,1,64,31,32,0,34,1,1,1,1,1,1},
                            {1,0,0,1,1,1,4,1,1,1,1,1,1,1,1,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,51,0,0,0,1,1,1,1,1,1,1},
                            {1,33,8,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,32,32,53,1,0,0,31,32,32,31,0,0,0,0,0,53,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,33,33,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,4,0,0,31,32,32,31,0,0,8,0,0,0,1,0,32,32,32,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,0,0,31,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,32,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,31,0,0,8,0,0,0,0,31,0,32,1,0,0,1,0,0,1,0,0,1,0,0,0,4,0,0,8,0,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,31,0,0,32,0,8,0,0,0,0,32,1,0,39,1,0,39,1,0,39,1,0,0,31,1,0,0,38,51,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,31,0,0,0,0,0,0,0,31,0,32,1,0,39,1,0,39,1,0,39,1,0,31,31,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,0,0,4,8,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,8,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,34,34,1,1,1,1,1,1,1,1,34,34,34,1,34,34,34,1,1,1,1,71,1,1,1,1,1,1,1,1,1,1,1,1,1,1} };
     private static int pX = 21;
     private static int pY = 52;
     private static int[] playerOn = {0,0};
     /*public static void main(String[] args){
         //w
         move(-1,0);
         //a
         move(0,-1);
         //s
         move(1,0);
         //d
         move(0,1);
     }*/
     
    
     public static void move(int v, int h){
         if (map[pY+v][pX+h]==1)
             System.out.println("You have run into a wall");
         else if (map[pY+v][pX+h]==31)
             System.out.println("A chair blocks your path");
         else if (map[pY+v][pX+h]==32)
             System.out.println("A table blocks your path");
         else if (map[pY+v][pX+h]==33)
             System.out.println("A box blocks your path");
         else if (map[pY+v][pX+h]==34)
             System.out.println("You look out of a window. Outside, you see the vast emptiness of space. It's beautiful. And, yet, it's terrifying.");
         else if (map[pY+v][pX+h]==35)
             System.out.println("The ship's engine blocks your path");
         else if (map[pY+v][pX+h]==36)
             System.out.println("An unscalable boulder blocks your path");
         else if (map[pY+v][pX+h]==37)
             System.out.println("A kitchen stove blocks your path");
         else if (map[pY+v][pX+h]==38)
             System.out.println("A toilet blocks your path. As you look at it, you can't help but wonder where the waste goes.");
             //make a scanner gain input. If the player says "open" give them the cheat code: 5s26W$$nC*hpa,E
         else if (map[pY+v][pX+h]==39)
             System.out.println("A bed blocks your path");
         else if (map[pY+v][pX+h]==61)
             System.out.println("You recognize Emma as the captain of the ship");

             /*"Needed something to eat? Here's a granola bar."
               Emma hands you a granola bar which you stash in your inventory. 
               "Paul, right? We heard you were going to be arriving soon. Glad to have you here."
               You find yourself smiling. Working regularly with Galactic League of Extraterrestrial Exploration had always been your dream job but Emma here made you even more at ease.
               You start to wonder if you'll see her around the ship when she starts speaking again.
               "You'll be on the communications team, helping out Commander Davidson. You might be able to find him in the comm room."
               "Good luck!"
               variable changes so whenever you interact with her, she says "You might be able to find Commander Davidson in the comm room."
             */
         
         else if (map[pY+v][pX+h]==62)
             Game.nextStory();
             // start objective
         
         else if (map[pY+v][pX+h]==63)
             System.out.println("You see Melissa, the ship's engineer");
             /*"Hi, Paul. You must've heard the crash. We need to restore power asap."
               "I need you to find 7 fuses for me. I'll be collecting so other parts and will meet you back in the engine room."
               "Don't panic, but be cautious. Think of it as a little game." Melissa joked
               "It could be fun!"
             */
         //new objective: collect 7 fuses
             if ((collectedFuses != totalFuses) && (storyline(0).equals("Find the Fuses"){
                System.out.println("You havent found all of the fuses yet! Keep Looking");  
             }
             else if (collectedFuses == totalFuses){
              /*"You've found all the fuses..and Professor?"
              Professor Hidgens nods hello.
              "The door here is locked, though, so you need to find another way in."
              "Maybe the vent system? Take the fuses and repair the engine. It'll be pretty easy, I trust you can figure it out."
              */
              //new objective: find the vent in the cafeteria to get into the engine room
              //new objective: fix the engine
             }
         else if (map[pY+v][pX+h]==64)
             System.out.println("A strange man introduces himself as Professor Hidgens.");
             /*"Good god! You must be Paul. Emma told us to expect you today."
               "It's unfortunate you came today, since it is the day of the invasion."
               --"The..invasion?"
               "Yes. I've spent years preparing for what happened earlier today. You need to get to the escape pod and get out of here now!"
               "I will accompany and help you out from here on out."
             */
            if storyline(0).equals("Find Fuses"){
                collectedFuses += 1;
            //variable so the professor disappears from away, new objective: return power to escape pod
                System.out.println("Good god! You must be Paul. Emma told us to expect you today.");
                System.out.println("You have attained a fuse from Professor Hidgens");
                System.out.println("PSA: Prof Higgins will now follow you around");
            }
         else if (map[pY+v][pX+h]==71)
             System.out.println("Unfortunately for you, this door does not exist.");

         else{
            if (map[pY+v][pX+h]==4){
                System.out.println("You enter the threshold to a new room");
                playerOn[1] = 4;
            }
            else if (map[pY+v][pX+h]==41){
                System.out.println("You are standing on a vent");
                playerOn[1]=41;
            }
            else if (map[pY+v][pX+h]==42){
                System.out.println("You find an old game console. Enter the cheat code to win: ");
                //add a scanner to check for the cheat code
                playerOn[1]=42;
            }
            else if (map[pY+v][pX+h]==51){
                System.out.println("You find a fuse");
                //add fuse to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==52){
                System.out.println("You find a bomb component");
                //add bomb component to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==53){
                System.out.println("You find a granola bar. This can increase your health when eaten.");
                player.firstAid = true;
                player.Skills();
                //add granola bar to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==54){
                System.out.println("You find a plasma gun. You pick it up and examine it. It's in working order.");
                player.plasmaGun = true;
                player.Skills();
                //add plasma gun to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==55){
                System.out.println("You find a handful of working plasma grenades. You pocket them for later use.");
                player.plasmaGrenade = true;
                player.Skills();
                //add plasma grenades to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==56){
                System.out.println("You find a crude flamethrower. Incredibly dangerous if the engine isn't working.");
                player.flamethrower = true;
                player.Skills();
                //add flamethrower to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==57){
                System.out.println("You find an old sonar gun. It's tuned so high, it could probably make someone deaf.");
                player.sonarGun = true;
                player.Skills();
                //add sonar gun to inventory
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==8){
                System.out.println("You encounter an alien aboard the ship. It attacks you without hesitation.");
                //start combat
                if(count == 1){
                    battle.battle(player, enemy1);
                }
                else if(count == 2){
                    battle.battle(player, enemy2);
                }
                else if(count == 3){
                    battle.battle(player, enemy3);
                    count = 0;
                else{
                    System.out.println("An error has occured");
                count ++;
                playerOn[1]=0;
            }
            else{
                System.out.println("You take a step");
                playerOn[1]=0;
             
             map[pY][pX]=playerOn[0];
             playerOn[0]=playerOn[1];
             pY+=v;
             pX+=h;
             map[pY][pX]=2;
         }
     }
}
