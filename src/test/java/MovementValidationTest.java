import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.Random;
import java.util.logging.Logger;

public class MovementValidationTest {
    @Test
    void WithinRangeReturnsTrueForPositionInRange() {
        assertTrue(MovementValidation.WithinRange("1,1", "2,2", 1));
    }

    @Test
    void WithinRangeReturnsFalseForPositionOutOfRange() {
        assertFalse(MovementValidation.WithinRange("4,4", "0,0", 1));
    }
}