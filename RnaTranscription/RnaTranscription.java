class RnaTranscription {

    String transcribe(String dnaStrand) {
        String result="";
        for(char c : dnaStrand.toCharArray()){
            result += dnaToRna(c);
        }
        return result;
    }

    String dnaToRna(char c){
        switch(c){
            case 'G' :
                return "C";
            case 'C' :
                return "G";
            case 'T' :
                return "A";
            case 'A' :
                return "U";
            default:
                return "";
        }
    }

}
