import java.util.*;
import java.util.Collections;

class DnDCharacter {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    public DnDCharacter(){
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.hitpoints = 10+ modifier(this.constitution);
    }
    int ability(List<Integer> scores) {
        return scores.stream()
                 .sorted()
                 .skip(1)         
                 .mapToInt(Integer::intValue)
                 .sum();
    }

    List<Integer> rollDice() {
        List<Integer> dice = new ArrayList<>();
        Random random = new Random();
        for(int i =1;i<=4;i++){
            dice.add(random.nextInt(6)+1);
        }
        return dice;
    }

    int modifier(int input) {
        return Math.floorDiv((input-10),2);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return this.hitpoints;
    }
}
