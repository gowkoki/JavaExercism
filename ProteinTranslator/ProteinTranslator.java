import java.util.*;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();
        boolean stopped =false;
        int i;
        for(i=0;i+2<rnaSequence.length();i+=3){
            String code = rnaSequence.substring(i,i+3);
            String acid = codeToAcid(code);

            if(acid.equals("STOP")){
                stopped = true;
                break;
            }
            result.add(acid);
        }

        if (!stopped && i < rnaSequence.length()) {
        throw new IllegalArgumentException("Invalid codon");
        }

        return result;
    }

    String codeToAcid(String code){
        switch(code){
            case "AUG":
                return "Methionine";
            case "UUU":
            case "UUC":
                return "Phenylalanine"; 
            case "UUA":
            case "UUG":
                return "Leucine";
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG":
                return "Serine";
            case "UAU":
            case "UAC":
                return "Tyrosine";
            case "UGU":
            case "UGC":
                return "Cysteine";
            case "UGG":
                return "Tryptophan";
            case "UAA":
            case "UAG":
            case "UGA":
                return "STOP";
            default:
                throw new IllegalArgumentException("Invalid codon");
        }
    }
}
