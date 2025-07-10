import java.util.*;

class Yacht {
    private int points;

    Yacht(int[] dice, YachtCategory category) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int total = 0;

        for (int die : dice) {
            frequency.put(die, frequency.getOrDefault(die, 0) + 1);
            total += die;
        }

        switch (category) {
            case ONES:
                points = frequency.getOrDefault(1, 0) * 1;
                break;
            case TWOS:
                points = frequency.getOrDefault(2, 0) * 2;
                break;
            case THREES:
                points = frequency.getOrDefault(3, 0) * 3;
                break;
            case FOURS:
                points = frequency.getOrDefault(4, 0) * 4;
                break;
            case FIVES:
                points = frequency.getOrDefault(5, 0) * 5;
                break;
            case SIXES:
                points = frequency.getOrDefault(6, 0) * 6;
                break;
            case FULL_HOUSE:
                if (frequency.size() == 2 && frequency.containsValue(3) && frequency.containsValue(2)) {
                    points = total;
                } else {
                    points = 0;
                }
                break;
            case FOUR_OF_A_KIND:
                for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
                    if (entry.getValue() >= 4) {
                        points = entry.getKey() * 4;
                        return;
                    }
                }
                points = 0;
                break;
            case LITTLE_STRAIGHT:
                if (new HashSet<>(Arrays.asList(Arrays.stream(dice).boxed().toArray(Integer[]::new)))
                        .containsAll(Set.of(1, 2, 3, 4, 5))) {
                    points = 30;
                } else {
                    points = 0;
                }
                break;
            case BIG_STRAIGHT:
                if (new HashSet<>(Arrays.asList(Arrays.stream(dice).boxed().toArray(Integer[]::new)))
                        .containsAll(Set.of(2, 3, 4, 5, 6))) {
                    points = 30;
                } else {
                    points = 0;
                }
                break;
            case CHOICE:
                points = total;
                break;
            case YACHT:
                if (frequency.size() == 1) {
                    points = 50;
                } else {
                    points = 0;
                }
                break;
            default:
                points = 0;
        }
    }

    public int score() {
        return points;
    }
}
