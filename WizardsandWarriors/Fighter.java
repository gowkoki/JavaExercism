class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter{
   
    public String toString(){
        return "Fighter is a Warrior";
    }

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
            return fighter.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter{
    private boolean spell = false;
   
    public String toString(){
        return "Fighter is a Wizard";
    }

    public void prepareSpell(){
        this.spell = true;
    }

    @Override
    boolean isVulnerable() {
        return this.spell ? false :true;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
            return this.spell ? 12 : 3;
    }
}
