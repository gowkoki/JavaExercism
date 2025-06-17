public class Say {

    String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
        };

        String[] multipliers = {
            "", "thousand", "million", "billion"
        };

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number out of range");
        }

        if(number == 0){
            return "zero";
        }
        
        StringBuilder result = new StringBuilder();
        int group = 0;

        while (number > 0) {
            int groupValue = (int)(number % 1000);
            if (groupValue != 0) {
                String groupText = sayLessThanThousand(groupValue);
                if (!multipliers[group].isEmpty()) {
                    groupText += " " + multipliers[group];
                }
                result.insert(0, groupText + " ");
            }
            number /= 1000;
            group++;
        }

        return result.toString().trim();
    }

    private String sayLessThanThousand(int number) {
        StringBuilder sb = new StringBuilder();

        if (number >= 100) {
            sb.append(units[number / 100]).append(" hundred");
            number %= 100;
            if (number > 0) sb.append(" ");
        }

        if (number >= 20) {
            sb.append(tens[number / 10]);
            if (number % 10 != 0) {
                sb.append("-").append(units[number % 10]);
            }
        } else if (number > 0) {
            sb.append(units[number]);
        }

        return sb.toString();
    }
}
