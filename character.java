
/**
 * Write a description of class character here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class character{
    private int strength;
    private static int hp;
    public int tempHp;
    private int firepower;
    private int sp;
    public int tempSp;
    private String name;
    private int level;
    private int exp;
    private boolean guard;
    public boolean slash = true;
    public boolean firstAid = false;
    public boolean plasmaGun = false;
    public boolean sonarGun = false;
    public boolean flamethrower = false;
    public boolean plasmaGrenade = false;
    private ArrayList<String> skills = new ArrayList<String>();
    public character(String n){
        strength = 5;
        name = n;
        hp = 20;
        tempHp = hp;
        firepower = 7;
        sp = 20;
        tempSp = sp;
        level = 1;
        exp = 0;
        skills = Skills();
    }
    public ArrayList Skills(){
        ArrayList<String> list = new ArrayList<String>();
        if(slash == true){
            list.add("Slash");
        }
        if(firstAid == true){
            list.add("First aid");
        }
        if (plasmaGun == true){
            list.add("Plasma Gun");
        }
        if (sonarGun == true){
            list.add("Sonar Gun");
        }
        if (flamethrower == true){
            list.add("Flamethrower");
        }
        if (plasmaGrenade == true){
            list.add("Plasma Grenade");
        }
        return list;
    }
    public ArrayList getSkills(){
        return skills;
    }
    public void information(){
        System.out.println(name);
        System.out.println("Level: " + level);
        System.out.println("Strength: " + strength);
        System.out.println("Skills:");        
        for( int x=0; x < skills.size(); x++){
            String skill = skills.get(x);
            System.out.println(skill);
        }
    }
    public int attack(){
        int power = strength;
        System.out.println(name + " has dealt " + power + " damage.");
        return power;
    }
    public void takeDamage(int d){
        tempHp = tempHp - d;
        if(d > 0){
            System.out.println(name + " has taken " + d + " damage.");
        }
        if(tempHp < 0){
            tempHp = 0;
        }
        System.out.println(name + " has " + tempHp + " health left.");

    }
    public int slash(){
        int power; 
        if(tempSp >= 2){
            tempSp -= 2;
            power = strength * 2;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;
        }
        else{
            System.out.println("You do not have enough sp you idiot");
            return 0;
        }
    }
    public int plasmaGun(){
        int power; 
        if(tempSp >= 5){
            tempSp -= 5;
            power = firepower * 3;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;
        }
        else{
            System.out.println("You do not have enough sp you idiot");
            return 0;
        }
    }
    public int sonarGun(){
        int power; 
        if(tempSp >= 8){
            tempSp -= 8;
            power = firepower * 5;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;
        }
        else{
            System.out.println("You do not have enough sp you idiot");
            return 0;
        }
    }
    public int flamethrower(){
        int power; 
        if(tempSp >= 12){
            tempSp -= 12;
            power = firepower * 7;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;
        }
        else{
            System.out.println("You do not have enough sp you idiot");
            return 0;
        }
    }
    public void firstAid(){
        int power; 
        if(tempSp >= 10){
            tempSp -= 10;
            tempHp = hp;
            System.out.println(name + "'s wounds have been healed");
        }
        else{
            System.out.println("You do not have enough sp you idiot");
        }
    }
    public int plasmaGrenade(){
        int power; 
        if(tempSp >= 20){
            tempSp -= 20;
            power = firepower * 10;
            System.out.println(name + " has dealt " + power + " damage.");
            return power;
        }
        else{
            System.out.println("You do not have enough sp you idiot");
            return 0;
        }
    }
    public boolean guard(){
        guard = true;
        System.out.println(name + " braced themselves");
        return guard;
    }
    public int getLevel(){
        return level;
    }
    public int getHp(){
        return hp;
    }
    public int getSp(){
        return sp;
    }
    public String getName(){
        return name;
    }
    public void exp(int e){
        exp += e;
        if(exp >= level * 10){
            strength += 2;
            firepower += 3;
            hp += 10;
            tempHp = hp;
            sp += 10;            
            tempSp = sp;
            level += 1;
            System.out.println(name + " has leveled up!");
            exp = 0;
        }
    }
}
