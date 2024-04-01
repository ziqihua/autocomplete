import org.junit.Test;

import static org.junit.Assert.*;

public class TermTest {

    @Test
    public void compareTo() {
        // Test equal terms
        ITerm term1 = new Term("apple", 100);
        ITerm term2 = new Term("apple", 200);
        assertTrue("Terms with equal strings should compare equal", term1.compareTo(term2) == 0);

        // Test term1 < term2 (lexicographically)
        ITerm term3 = new Term("apple", 100);
        ITerm term4 = new Term("banana", 100);
        assertTrue("apple should come before banana", term3.compareTo(term4) < 0);

        // Test term1 > term2 (lexicographically)
        ITerm term5 = new Term("banana", 100);
        ITerm term6 = new Term("apple", 100);
        assertTrue("banana should come after apple", term5.compareTo(term6) > 0);
    }

    @Test
    public void testToString() {
        Term term1 = new Term("apple", 100);
        assertEquals("100\tapple", term1.toString());

        // Test with zero weight
        Term term2 = new Term("banana", 0);
        assertEquals("0\tbanana", term2.toString());

        // Test with a large weight
        Term term3 = new Term("carrot", 1000000);
        assertEquals("1000000\tcarrot", term3.toString());
    }

    @Test
    public void getWeight() {
        Term term1 = new Term("apple", 100);
        assertEquals(100, term1.getWeight());
    }

    @Test
    public void getTerm() {
        Term term1 = new Term("apple", 100);
        assertEquals("apple", term1.getTerm());

    }

    @Test
    public void setWeight() {
        Term term1 = new Term("apple", 100);
        term1.setWeight(200);
        assertEquals(200, term1.getWeight());
    }

    @Test
    public void setTerm() {
        Term term1 = new Term("apple", 100);
        term1.setTerm("appl");
        assertEquals("appl", term1.getTerm());
    }
}