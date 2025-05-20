public class LogLevels {
    
    public static String message(String logLine) {
        int find = logLine.indexOf(":");
        String res = logLine.substring(find+2, logLine.length());
        String result ="";
        if(res.contains("[,\\s\\.]")){
            String[] arr = res.split("[,\\s\\.]");
            for (String s1 : arr) {
               if(s1.trim() != ""){
                result+=s1;            
               }
           }
            return result;
        }
        return res.trim();
    }

    public static String logLevel(String logLine) {
        int find = logLine.indexOf(":");
        String res = logLine.substring(1, find-1);
        return res.toLowerCase().trim();
    }

    public static String reformat(String logLine) {
        int find = logLine.indexOf(":");
        String info = logLine.substring(1, find-1).toLowerCase().trim();
        String content = logLine.substring(find+2, logLine.length()).trim();
        String result = content;
        result+=" (";
        result += info;
        result += ")";
        return result;
    }
}
