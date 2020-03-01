
/**
 * Write a description of class enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class enemy
{
    private int strength;
    private String name;
    private int hp;
    public int tempHp;
    public int exp;
    public int voice;
    String[] attackList;
    private boolean guard = false;
//attacks that work are "Punch",
    public enemy(int s, String n, int h, int v, int e , String[] l){
        strength = s;
        name = n;
        hp = h;
        voice = v;
        tempHp = hp;
        exp = e;
        attackList = l;
    }
    public void takeDamage(int d){
        if(guard == true){
            d = d/2;
        }
        tempHp = tempHp - d;
        System.out.println(name + " has taken " + d + " damage.");
        if(tempHp < 0){
            tempHp = 0;
        }
        System.out.println(name + " has " + tempHp + " health left.");

    }
    public String getName(){
        return name;
    }
    public int getExp(){
        return exp;
    }
    public int getHp(){
        return hp;
    }    
    public int punch(){
        int power = strength;
        return power;
    }
    public int slash(){
        int power; 
            power = strength * 2;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;

    }
    public int scream(){
        int power; 
            power = voice * 2;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;

    }
    public int supersonicScream(){
        int power; 
            power = voice * 5;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;

    }
    public int galacticPunch(){
        int power; 
            power = strength * 5;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;

    }
    public boolean guard(){
        guard = true;
        System.out.println(name + " braced themselves");
        return guard;
    }
    public int attack(){
        int power;
        int n =(int)(Math.random() * attackList.length);
        guard = false;
        if(attackList[n].equals("Punch")){
            power = punch();
        }
        else if(attackList[n].equals("Slash")){
            power = slash();
        }
        else if(attackList[n].equals("Scream")){
            power = scream();
        }
        else if(attackList[n].equals("Guard")){
            guard();
            power = 0;
        }
        else if(attackList[n].equals("Galactic Punch")){
            power = galacticPunch();
        }
         else if(attackList[n].equals("Supersonic Scream")){
            power = supersonicScream();
        }
        else{
            power = 0;
        }
        return power;
    }
}

