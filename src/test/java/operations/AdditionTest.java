package operations;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionTest {

    @Test
    public void test_validInteger_NotNull() {
        Assertions.assertTrue(Addition.validInteger(Integer.valueOf(1)));
    }

    @Test
    public void test_validInteger_Null() {
        Assertions.assertFalse(Addition.validInteger(null));
    }
}