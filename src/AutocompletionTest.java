import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pavel Barmyonkov on 02.10.18.
 * pbarmenkov@gmail.com
 */
public class AutocompletionTest {

    private String input;
    private String prefix;
    private String prefixTwo;
    private String prefixThree;
    private String prefixFour;

    private List<String> actual;
    private List<String> actualTwo;
    private List<String> actualThree;


    @Before
    public void setUp() {
        input = "apple, apply, ajax, google, golang";
        prefix = "app";
        prefixTwo = "a";
        prefixThree = "gol";
        prefixFour = "not";

        actual = new ArrayList<>();
        actual.add("apple");
        actual.add("apply");

        actualTwo = new ArrayList<>();
        actualTwo.add("apple");
        actualTwo.add("apply");
        actualTwo.add("ajax");

        actualThree = new ArrayList<>();
        actualThree.add("golang");
    }


    @Test
    public void searchWordsByPrefix_APP() {

        List<String> expected = Autocompletion.searchWordsByPrefix(input, prefix);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchWordsByPrefix_A() {

        List<String> expectedTwo = Autocompletion.searchWordsByPrefix(input, prefixTwo);
        Assert.assertEquals(expectedTwo, actualTwo);
    }

    @Test
    public void searchWordsByPrefix_GOL() {

        List<String> expectedThree = Autocompletion.searchWordsByPrefix(input, prefixThree);
        Assert.assertEquals(expectedThree, actualThree);
    }

    @Test(expected=AssertionError.class)
    public void searchWordsByPrefix_NOT() {

        List<String> expectedThree = Autocompletion.searchWordsByPrefix(input, prefixFour);
        assertFalse(expectedThree.isEmpty());
    }

    @Test
    public void searchWordsByPrefix_NO_NULL() {

        String input = "apple, apply, ajax, google, golang";
        String prefix = "app";

        List<String> expected = Autocompletion.searchWordsByPrefix(input, prefix);

        Assert.assertNotNull(expected);
    }
}
