package bullsandcows;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final List<String> numberList;

    NumberGenerator() {
        numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(String.valueOf(i));
        }
    }

    public String generate(int length) {
        List<String> listToShuffle = new ArrayList<>(numberList);
        java.util.Collections.shuffle(listToShuffle);

        StringBuilder shuffledString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            shuffledString.append(listToShuffle.get(i));
        }
        return shuffledString.toString();
    }
}
