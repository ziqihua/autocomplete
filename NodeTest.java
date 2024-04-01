import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testDefaultConstructor() {
        Node node = new Node();
        assertNotNull(node.getReferences());
        assertEquals("", node.getTerm().getTerm());
        assertEquals(0, node.getTerm().getWeight());
        assertEquals(0, node.getWords());
        assertEquals(0, node.getPrefixes());
    }

    @Test
    public void testConstructorWithValidArguments() {
        Node node = new Node("apple", 100);
        assertEquals("apple", node.getTerm().getTerm());
        assertEquals(100, node.getTerm().getWeight());
    }

    @Test
    public void testSetAndGetTerm() {
        Node node = new Node();
        Term term = new Term("banana", 200);
        node.setTerm(term);
        assertEquals("banana", node.getTerm().getTerm());
        assertEquals(200, node.getTerm().getWeight());
    }

    @Test
    public void testSetAndGetWords() {
        Node node = new Node();
        node.setWords(1);
        assertEquals(1, node.getWords());
    }

    @Test
    public void testSetAndGetPrefixes() {
        Node node = new Node();
        node.setPrefixes(1);
        assertEquals(1, node.getPrefixes());
    }

    @Test
    public void testSetAndGetReferences() {
        Node node = new Node();
        Node[] references = new Node[26];
        for (int i = 0; i < references.length; i++) {
            references[i] = new Node();
        }
        node.setReferences(references);
        assertNotNull(node.getReferences());
        assertEquals(26, node.getReferences().length);
        for (Node ref : node.getReferences()) {
            assertNotNull(ref);
        }
    }
}
