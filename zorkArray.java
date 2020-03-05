
public class zorkArray
{
    Battle battle = new Battle();    
    private static String[] attacks1 = {"Punch","Guard", "Scream", "Slash"};
    private static String[] attacks2 = {"Punch","Guard", "Scream"};
    public static boolean win;
    private static enemy enemy1 = new enemy(3, "Alien", 20, 4, 10, attacks1);
    private static enemy enemy2 = new enemy(5, "Buff Alien", 40, 1, 10, attacks1);
    private static enemy enemy3 = new enemy(1, "Vocal Alien", 30, 7, 10, attacks2);
    private static String[] bossAttacks = {"Galactic Punch", "Supersonic Scream", "Guard", "Punch"};
    private static enemy boss = new enemy(10, "Commander Davidson", 500, 13, 999, bossAttacks);
    private static character player = new character("Paul");
    //changed enemy count to enemyCount
    private static int enemyCount = 1;
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
    public static int[][] map = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
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
                            {1,36,0,0,0,0,8,0,0,0,33,33,33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,33,52,0,33,1,1,1,1,1,1,1},
                            {1,36,36,1,8,0,0,0,0,33,33,33,52,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,33,33,33,33,33,1,1,1,1,1,1,1},
                            {1,36,36,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,63,1,0,0,8,54,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,31,0,0,0,0,0,0,0,0,1,0,0,0,39,39,1},
                            {1,0,0,1,41,0,55,53,1,33,33,0,33,33,33,33,33,33,0,0,33,0,1,36,0,0,0,0,0,31,32,32,32,31,0,0,0,0,0,0,1,53,0,0,0,0,1},
                            {1,0,0,1,1,1,1,1,1,33,0,0,0,0,0,0,8,0,0,0,33,0,4,36,36,0,0,0,0,32,0,0,52,32,0,0,0,0,0,0,1,39,39,0,0,0,1},
                            {1,0,0,1,0,0,0,0,0,0,0,33,33,33,33,33,33,33,33,33,33,0,1,36,36,0,0,31,32,0,0,0,0,33,32,31,0,0,0,0,1,0,0,0,0,0,1},
                            {1,0,0,1,0,0,33,33,33,33,0,33,33,33,0,0,0,0,33,51,0,0,1,36,62,0,0,0,0,0,0,8,52,8,32,0,0,0,0,0,1,0,0,0,39,39,1},
                            {1,0,0,1,0,0,51,0,0,33,0,0,8,0,0,0,33,0,8,33,52,33,1,36,0,0,0,31,32,0,0,0,33,57,32,31,0,0,0,0,4,0,8,0,0,53,1},
                            {1,0,0,1,0,0,0,0,0,51,33,33,52,33,33,0,0,0,0,33,33,33,1,0,0,0,0,0,0,32,52,0,33,32,0,0,0,0,0,0,4,0,0,0,0,0,1},
                            {1,0,0,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,0,0,0,0,0,0,31,32,32,32,31,8,0,32,32,0,0,1,0,0,0,39,39,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,8,0,0,0,0,31,0,0,0,0,32,32,0,0,1,0,0,0,0,51,1},
                            {1,51,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,75,0,0,0,0,0,32,32,0,53,1,39,39,53,0,0,1},
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

     public static void bossBattle(){
         Battle.battle(player,boss);
        }
     public static void move(int v, int h){
         if (map[pY+v][pX+h]==1){
             v=0; h=0;
             System.out.println("You have run into a wall"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==31){
             v=0; h=0;
             System.out.println("A chair blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==32){
             v=0; h=0;
             System.out.println("A table blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==33){
             v=0; h=0;
             System.out.println("A box blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==34){
             v=0; h=0;
             System.out.println("You look out of a window. Outside, you see the vast emptiness of space. It's beautiful. And, yet, it's terrifying."); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==35){
             v=0; h=0;
             System.out.println("The ship's engine blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==36){
             v=0; h=0;
             System.out.println("An unscalable boulder blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==37){
             v=0; h=0;
             System.out.println("A kitchen stove blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==38){
             v=0; h=0;
             System.out.println("A toilet blocks your path. As you look at it, you can't help but wonder where the waste goes."); playerOn[1]=0;}
             //make a scanner gain input. If the player says "open" give them the cheat code: 5s26W$$nC*hpa,E
         else if (map[pY+v][pX+h]==39){
             v=0; h=0;
             System.out.println("A bed blocks your path"); playerOn[1]=0;}
         else if (map[pY+v][pX+h]==61)
         {
             v=0; h=0;
             map[pY+v][pX+h]=0;
             Game.nextStory();
             playerOn[1]=0;
         }
         else if (map[pY+v][pX+h]==62)
         {
             v=0; h=0;
             map[pY+v][pX+h]=0;
             Game.nextStory();
             playerOn[1]=0;
         }
         else if (map[pY+v][pX+h]==63)
         {
             v=0; h=0;
             map[pY+v][pX+h]=0;
             Game.nextStory();
             playerOn[1]=0;
         }
         else if (map[pY+v][pX+h]==64)
         {
             v=0; h=0;
             System.out.println("You find a 'kinda hot' man in a labcoat.");
             System.out.println("'Good God! You must be Paul. Emma told us to expect you today,' the man says.");
             System.out.println("'It's very unfortunate you came today, since it is the day of the invasion.'");
             System.out.println("'The... invasion?' you ask.");
             System.out.println("'Yes, my dear boy. I've spent years preparing for this. \nWe need to get to the escape pod and get out of this place!'");
             System.out.println("'Here, take this fuse I found earlier. In return, you will allow me to accompany you.'");
             Game.collectedFuses += 1;
             System.out.println("'I don't even know your name,' you say.");
             System.out.println("'Right, right. I'm Professor Hidgens. Now, off we go.'");
             map[pY+v][pX+h]=0;
             playerOn[1]=0;
         }
         else if (map[pY+v][pX+h]==71)
             System.out.println("Unfortunately for you, this door does not actually exist.");
         //implement all the 7's we have to step on

         else{
            if (map[pY+v][pX+h]==4){
                System.out.println("You enter the threshold to a new room");
                v*=2; pY+=v; v=0;
                h*=2; pX+=h; h=0;
                playerOn[1] = 0;
            }
            else if (map[pY+v][pX+h]==41){
                System.out.println("You are standing on a vent. \nYou crawl through to the other side, braving your way through cobwebs, bugs, and weird blue ooze.");
                if (pY+v==27)
                {
                    pY=37; pX=5; map[pY][pX]=2;
                }
                else
                {
                    pY=27; pX=5; map[pY][pX]=2;
                }
                v=0; h=0;
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==42){
                System.out.println("You find an old game console. Enter the cheat code to win: ");
                //add a scanner to check for the cheat code
                playerOn[1]=42;
            }
            else if (map[pY+v][pX+h]==51){
                System.out.println("You find a fuse");
                Game.collectedFuses+=1;
                map[pY+v][pX+h]=0;
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==52){
                System.out.println("You find a bomb component");
                Game.collectedBombs+=1;
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
                System.out.println("You encounter an alien leaking blue ooze. It attacks you without hesitation.");
                //start combat
                if(enemyCount == 1)
                    win = Battle.battle(player, enemy1);
                else if(enemyCount == 2)
                    win = Battle.battle(player, enemy2);
                else if(enemyCount == 3){
                     win = Battle.battle(player, enemy3);
                    enemyCount = 0;
                }
                else{
                    System.out.println("An error has occured");
                    win = false;
                }
                if(win == false){
                    Game.finished = false;
                }
                enemyCount++;
                pY+=v; v=0;
                pX+=h; h=0;
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==71)
            {
                Game.nextStory();
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==72)
            {
                Game.nextStory();
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==73)
            {
                Game.nextStory();
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==74)
            {
                Game.nextStory();
                playerOn[1]=0;
            }
            else if (map[pY+v][pX+h]==75)
            {
                Game.nextStory();
                playerOn[1]=0;
            }
            else{
                System.out.println("You take a step");
                playerOn[1]=0;
            if (Game.collectedFuses==7){
                Game.nextStory();
                Game.collectedFuses = 10;
            }
            if (Game.collectedBombs==10){
                Game.nextStory();
                Game.collectedBombs = 15;
            }
             
             map[pY][pX]=playerOn[0];
             playerOn[0]=playerOn[1];
             pY+=v;
             pX+=h;
             map[pY][pX]=2;
         }
     }
}
}
