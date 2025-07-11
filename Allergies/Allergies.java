import java.util.*;

class Allergies {
    private List<Allergen> allergiesList;
    
    Allergies(int score) {
        allergiesList = new ArrayList<>();
        
         for (Allergen allergen : Allergen.values()) {
            if ((score & allergen.getScore()) != 0) {
                allergiesList.add(allergen);
            }
        }
    }

    boolean isAllergicTo(Allergen allergen) {
        return allergiesList.contains(allergen);
    }

    List<Allergen> getList() {
        return allergiesList;
    }
}
