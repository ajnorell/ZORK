
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;


public class test
{
    public static void main(String[]args){
        character player = new character("Dante");
        player.information();
        String[] attacks = {"Punch","Slash","Guard","Scream","Galactic Punch", "Supersonic Scream"};
        enemy test = new enemy(1,"test", 51, 2, 10, attacks);
        battle fight = new battle();
        fight.battle(player, test);
        fight.battle(player, test);
    }
}
