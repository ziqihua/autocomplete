import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AutocompleteTest {

    private Autocomplete autocomplete;

    @Before
    public void setUp() {
        autocomplete = new Autocomplete();
    }

    @Test
    public void testAddWord() {
        autocomplete.addWord("apple", 100);
        assertEquals(1, autocomplete.countPrefixes("apple"));
    }

    @Test
    public void testBuildTrie() {
        autocomplete.buildTrie("test_words.txt", 2);
        assertEquals(1, autocomplete.countPrefixes("the"));
        assertEquals(1, autocomplete.countPrefixes("of"));
    }

    @Test
    public void testGetSubTrie() {
        autocomplete.addWord("apple", 100);
        Node node = autocomplete.getSubTrie("app");
        assertNotNull(node);
    }

    @Test
    public void testCountPrefixes() {
        autocomplete.addWord("apple", 100);
        autocomplete.addWord("application", 50);
        assertEquals(2, autocomplete.countPrefixes("appl"));
    }

    @Test
    public void testGetSuggestions() {
        autocomplete.addWord("apple", 100);
        autocomplete.addWord("application", 50);
        List<ITerm> suggestions = autocomplete.getSuggestions("app");
        assertEquals(2, suggestions.size());
        assertEquals("apple", suggestions.get(0).getTerm());
        assertEquals(100, suggestions.get(0).getWeight());
    }
}
