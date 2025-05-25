package bullsandcows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.BadLengthException;
import exceptions.DuplicateDigitException;
import exceptions.NotANumberException;
import org.junit.jupiter.api.Test;

public class InputScannerTest {
    @Test
    public void testRightInput() {
        String inputData = "1234\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        InputScanner scanner = new InputScanner();
        String scannedNumber = scanner.scanNumber(4);

        assertEquals(scannedNumber, "1234");
    }

    @Test
    public void testBadLengthInput() {
        String inputData = "12345\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        InputScanner scanner = new InputScanner();

        assertThrows(BadLengthException.class, () -> scanner.scanNumber(4));
    }

    @Test
    public void testNotANumberInput() {
        String inputData = "12-4\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        InputScanner scanner = new InputScanner();

        assertThrows(NotANumberException.class, () -> scanner.scanNumber(4));
    }

    @Test
    public void testDuplicateDigitsInput() {
        String inputData = "1233\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(inputStream);

        InputScanner scanner = new InputScanner();

        assertThrows(DuplicateDigitException.class, () -> scanner.scanNumber(4));
    }
}