import java.util.*;

class Flattener {

    List<Object> flatten(List<?> list) {
         List<Object> result = new ArrayList<>();

        for(Object element : list){
            if(element == null){
                continue;
            }
            if(element instanceof List<?>){
                result.addAll(flatten((List<?>)element));
            }else{
                result.add(element);
            }
        }
        
        return result;
    }

}
