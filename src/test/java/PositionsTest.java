import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.logging.Logger;

public class PositionsTest {
    Random random = new Random();
    Logger logger = Logger.getLogger("MapTest");

    // ANSI Escpape Codes to make logger output stand out
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";

    @Test
    void positionIsOccupiedReturnsTrueForCoordinateInDictionary() {
        int randRow = random.nextInt(3, 11);
        int randColumn = random.nextInt(3, 11);

        Positions.addPosition(randColumn, randRow, '@');
        assertEquals(true, Positions.positionIsOcupied(randColumn, randRow));
    }

    @Test
    void positionIsOccupiedReturnsFalseForCoordinateNotInDictionary() {
        int randRow = random.nextInt(3, 11);
        int randColumn = random.nextInt(3, 11);

        assertEquals(false, Positions.positionIsOcupied(randColumn, randRow));
    }

    @Test
    void positionIsOccupiedReturnsCorrectChar() {
        int randRow = random.nextInt(3, 11);
        int randColumn = random.nextInt(3, 11);

        Positions.addPosition(randColumn, randRow, '@');
        assertEquals('@', Positions.charInPosition(randColumn, randRow));
    }

    @Test
    void removePositionRemovesPosition() {
        int randRow = random.nextInt(3, 11);
        int randColumn = random.nextInt(3, 11);

        Positions.addPosition(randColumn, randRow, '@');
        Positions.removePosition(randColumn, randRow);

        assertFalse(Positions.positionIsOcupied(randColumn, randRow));
    }
}