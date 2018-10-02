import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Pavel Barmyonkov on 02.10.18.
 * pbarmenkov@gmail.com
 */
public class Autocompletion {

    public static void main(String[] args) {

        System.out.println("Enter words separated by commas: ");

        try (Scanner scanner = new Scanner(System.in)) {

            String strWords;
            String prefix;

            if (scanner.hasNextLine()) {
                strWords = scanner.nextLine();

                if (!strWords.isEmpty()) {

                    System.out.println("Enter prefix to search: ");

                    if (scanner.hasNextLine()) {
                        prefix = scanner.next();
                        System.out.println("Found words: " + searchWordsByPrefix(strWords, prefix).toString());
                    }

                } else {
                    System.out.println("You entered an empty string!");
                }
            }
        }
    }

    public static List<String> searchWordsByPrefix(String input, String prefix) {

        List<String> resultStrings = new ArrayList<>();

        Stream<String> stringStream = Pattern.compile(",|;|\\s")
                .splitAsStream(input)
                .filter(str -> str.length() > 0);

        stringStream.forEach(s -> {
            if (s.trim().startsWith(prefix)) {
                resultStrings.add(s);
            }
        });

        return resultStrings;
    }

}
