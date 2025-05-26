import java.util.Map;
import java.util.HashMap;

public class DialingCodes {

    private final Map<Integer, String> dialcode= new HashMap<>();

    public Map<Integer, String> getCodes() {
       return new HashMap<>(dialcode);
    }

    public void setDialingCode(Integer code, String country) {
        if(code == null || country == null) return;
        dialcode.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialcode.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
         if(!dialcode.containsKey(code) && !dialcode.containsValue(country)){
             dialcode.put(code, country);
         }
    }

    public Integer findDialingCode(String country) {
        for(Integer key : dialcode.keySet()){
            if(dialcode.get(key) == country){
                return key;
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
       Integer key = findDialingCode(country);
        if(key != null){
            dialcode.remove(key);
        }
        setDialingCode(code,country);
    }
}
