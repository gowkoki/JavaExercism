class Proverb {
    private String rhyme;
    
    Proverb(String[] words) {
        if(words == null || words.length == 0){
            this.rhyme = "";
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int i =1;i<words.length;i++){
            sb.append("For want of a ").append(words[i-1]).append(" the ").append(words[i]).append(" was lost.\n");
        }
        
             sb.append("And all for the want of a ").append(words[0]).append(".");

        this.rhyme = sb.toString();
    }

    String recite() {
        return rhyme;
    }

}
