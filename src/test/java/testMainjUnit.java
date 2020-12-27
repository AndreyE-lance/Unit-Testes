import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.Main;

public class testMainjUnit {
    @Test
    public void testGetString_validArgument_success() {
        //given
        final String original = "( 6 + 10 - 4 ) / ( 1 + 1 * 2 ) + 1";
        final String expected = "6 10 + 4 - 1 1 2 * + / 1 + ";

        final String original_1 = "5 * 2 + 10";
        final String expected_1 = "5 2 * 10 + ";
        Main m = new Main();

        //when
        final String result = m.getString(original);
        final String result_1 = m.getString(original_1);

        //then
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(expected_1, result_1);
        Assertions.assertNotEquals(result, expected_1);
    }
}
