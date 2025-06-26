import java.util.*;

class KindergartenGarden {
    private final String[] rows;
    private final List<String> STUDENTS = Arrays.asList(
        "Alice", "Bob", "Charlie", "David", "Eve", "Fred",
        "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"
    );
    
    KindergartenGarden(String garden) {
        rows = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        int index = STUDENTS.indexOf(student);
        if (index == -1 || rows.length != 2) {
            throw new IllegalArgumentException("Invalid student or garden format");
        }

        int position = index*2;
        List<Plant> list = new ArrayList<>();
        
        for(String r : rows){
            list.add(Plant.getPlant(r.charAt(position)));
            list.add(Plant.getPlant(r.charAt(position+1)));
        }                
        return list;
    }
}
