/**
 * Write a description of class battle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Battle{
public static boolean battle(character c, enemy e){
        Scanner s = new Scanner(System.in);
        int turn = 1;
        int damage;
        boolean guard = false;
        while(c.tempHp > 0 && e.tempHp > 0){
            guard = false;
            boolean correct = false;
            while(correct == false){
                damage = 0;
                System.out.println("Turn " + turn);
                System.out.println("current hp:" + c.tempHp);
                System.out.println("current sp:" + c.tempSp);
                System.out.println("Please input a command");
                String input = s.nextLine().toLowerCase();
                if (input.equals("attack")){
                    damage = c.attack();
                    System.out.println(c.getName() + " has dealt " + damage + " damage.");
                    e.takeDamage(damage);
                    correct = true;
                }
                else if (input.equals("slash")){
                    damage = c.slash();
                    e.takeDamage(damage);
                    correct = true;
                }
                else if (input.equals("first aid") && c.firstAid == true){
                    c.firstAid();
                    correct = true;
                }
                else if (input.equals("plasma gun") && c.plasmaGun == true){
                    damage = c.plasmaGun();
                    e.takeDamage(damage);
                    correct = true;
                }
                else if (input.equals("sonar gun") && c.sonarGun == true){
                    damage = c.sonarGun();
                    e.takeDamage(damage);
                    correct = true;
                }
                else if (input.equals("flamethrower") && c.flamethrower == true){
                    damage = c.flamethrower();
                    e.takeDamage(damage);
                    correct = true;
                }
                else if (input.equals("plasma grenade") && c.plasmaGrenade == true){
                    damage = c.plasmaGrenade();
                    e.takeDamage(damage);
                    correct = true;
                }
                else if (input.equals("help")){
                    System.out.println("available commands:");
                    System.out.println("Attack");
                    System.out.println("Guard");
                    ArrayList<String> list = new ArrayList<String>();
                    list = c.getSkills();
                    for( int x=0; x < list.size(); x++){
                        String skill = list.get(x);
                        System.out.println(skill);
                    }
                    System.out.println("Slash sp cost: 2");
                    if(c.firstAid == true){
                        System.out.println("First aid sp cost: 10");
                    }
                    if(c.plasmaGun == true){
                        System.out.println("Plasma gun sp cost: 5");
                    }
                    if(c.sonarGun == true){
                        System.out.println("Sonar gun sp cost: 8");
                    }
                    if(c.flamethrower == true){
                        System.out.println("Flamethrower sp cost: 12");
                    }
                    if(c.plasmaGrenade == true){
                        System.out.println("Plasma grenade sp cost: 20");
                    }
                }
                else if(input.equals("guard")){
                    guard = c.guard();
                    correct = true;
                }
                else{
                    System.out.println("please type a proper input");
                }
            }
            if (e.tempHp > 0){
                if(guard == true){
                   damage = e.attack()/2;
                }
                else{
                damage = e.attack();
            }
                c.takeDamage(damage);
            }
            turn ++;
        }
        if(c.tempHp <= 0){
            System.out.println("Game Over");
            return false;
        }
        else if(e.tempHp <= 0){
            System.out.println("You won!");
            c.exp(e.getExp());
            e.tempHp = e.getHp();
        }
        else{
            System.out.println("An error has occured");
            return false;
        }
        c.tempHp = c.getHp();
        c.tempSp = c.getSp();  
        return true;     
    }    
}
