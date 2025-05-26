import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
    Set<String> myExtras = new HashSet<>(myCollection);
    myExtras.removeAll(theirCollection);

    Set<String> theirExtras = new HashSet<>(theirCollection);
    theirExtras.removeAll(myCollection);

    return !myExtras.isEmpty() && !theirExtras.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> result = new HashSet<>(collections.get(0));
        for (int i = 1; i < collections.size(); i++) {
            result.retainAll(collections.get(i));
        }
        return result;
    }

    static Set<String> allCards(List<Set<String>> collections) {
         Set<String> all = new HashSet<>();
        for(Set<String> s: collections){
            all.addAll(s);
        }
        return all;
    }
}
