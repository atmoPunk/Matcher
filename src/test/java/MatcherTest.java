import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatcherTest {

    @Test
    void correctMatches() {
        assertTrue(Matcher.matches("AAA", "A*"));
        assertTrue(Matcher.matches("ABABBAAAABABA", "(A|B)*"));
    }

    @Test
    void incorrectMatches() {
        assertFalse(Matcher.matches("BBBB", "A*"));
        assertFalse(Matcher.matches("BABA", "C"));
    }

    @Test
    void timeoutMatches() {
        assertThrows(TimedCharSequence.TimeoutException.class, () -> Matcher.matches(
                "A".repeat(10000), "(A+)*B", 100));
    }
}