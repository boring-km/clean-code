import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ComparisonCompactorTest {

    @Test
    public void testMessage() {
        String failure = new ComparisonCompactor(0, "b", "c").formatCompactedComparison("a");
        assertEquals("a expected:<[b]> but was:<[c]>", failure);
    }
}
