package bullsandcows;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @Test
    void testGenerate() {
        NumberGenerator generator = new NumberGenerator();
        int length = 4;
        String generatedNumber = generator.generate(length);

        assertEquals(generatedNumber.length(), length);

        int[] duplicateArray = new int[10];
        for (int i = 0; i < length; i++) {
            assertTrue(Character.isDigit(generatedNumber.charAt(i)));

            int number = generatedNumber.charAt(i) - '0';
            assertNotEquals(1, duplicateArray[number]);
            duplicateArray[number]++;
        }
    }
}