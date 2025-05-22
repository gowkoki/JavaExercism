public class GameMaster {

    public String describe(Character character){
        String charClass = character.getCharacterClass();
        int level = character.getLevel();
        int points = character.getHitPoints();
        return "You're a level "+level+" "+charClass+" with "+points+" hit points.";
    }

    public String describe(Destination destination){
        String name = destination.getName();
        int inhabitants = destination.getInhabitants();
        return "You've arrived at "+name+", which has "+inhabitants+" inhabitants.";
    }

     public String describe(TravelMethod method ){
         if(method == TravelMethod.WALKING){
             return "You're traveling to your destination by walking.";
         }else{
             return "You're traveling to your destination on horseback.";
         }
    }

    public String describe(Character character, Destination destination,TravelMethod method){
        String chara = describe(character);
        String dest = describe(destination);
        String travelMethod = describe(method);
        return chara+" "+travelMethod+" "+dest;
    }

    public String describe(Character character, Destination destination){
        String chara = describe(character);
        String dest = describe(destination);
        String travelMethod = describe(TravelMethod.WALKING);
        return chara+" "+travelMethod+" "+dest;
    }
}
