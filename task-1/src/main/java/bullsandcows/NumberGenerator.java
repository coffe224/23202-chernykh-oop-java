package src.main.java.bullsandcows;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    NumberGenerator() {
        numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(String.valueOf(i));
        }
    }
    private final List<String> numberList;

    public String generate(int length) {
        List<String> list_to_shuffle = new ArrayList<>(numberList);
        java.util.Collections.shuffle(list_to_shuffle);

        StringBuilder shuffledString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            shuffledString.append(list_to_shuffle.get(i));
        }
        return shuffledString.toString();
    }
}
