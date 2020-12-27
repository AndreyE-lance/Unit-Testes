import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import task1.Main;

public class testMainHamcrest {
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
        assertThat(result,is(expected));
        assertThat(result_1,is(expected_1));
        assertThat(result,not(expected_1));
        
        assertThat(result, Matchers.anything());
        assertThat(m, Matchers.instanceOf(Main.class));


    }
}
