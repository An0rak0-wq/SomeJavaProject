import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.logging.Logger;

public class MapTest {
    Random random = new Random();
    Logger logger = Logger.getLogger("MapTest");

    // ANSI Escpape Codes to make logger output stand out
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";

    private char toChar(int num) {
        return (char) ('0' + num);  // 0->0, 1->1, ... 9->9
    }

    @Test
    void createEmptyMapReturnsCorrectSizeMapForRandomInput() {
        Map mapObj = new Map();
        int randRows = random.nextInt(3, 11);
        int randColumns = random.nextInt(3, 11);
        char[][] map = mapObj.createEmptyMap(randRows, randColumns);

        logger.info(String.format("%s****************************************%s", YELLOW, RESET));
        logger.info(String.format("%sEXPECTED AMOUNT OF ROWS: %d%s", YELLOW, randRows, RESET));
        logger.info(String.format("%sEXPECTED AMOUNT OF COLUMNS: %d%s", YELLOW, randColumns, RESET));

        logger.info(String.format("%sAMOUNT OF ROWS: %d%s", YELLOW, map.length, RESET));
        assertEquals(randRows, map.length); // Checks there is the right amount of rows

        for (int i = 0; i < randRows; i++) {
            logger.info(String.format("%sAMOUNT OF COLUMNS IN ROW %d: %d%s", YELLOW, i, map[i].length, RESET));
            assertEquals(randColumns, map[i].length); // Checks there is the right amount of columns in the row
            for (int j = 0; j < randColumns; j++) {
                assertEquals('-', map[i][j]); // Checks each item is '-'
            }
        } 
    }

    @Test
    void formatMapFormatsMapCorrectlyForRandomInput() {
        Map mapObj = new Map();
        int randRows = random.nextInt(3, 11);
        int randColumns = random.nextInt(3, 11);

        char[][] map = mapObj.createEmptyMap(randRows, randColumns);
        map = mapObj.formatMap(map);

        logger.info(String.format("%s****************************************%s", YELLOW, RESET));
        logger.info(String.format("%sAMOUNT OF ROWS: %d%s", YELLOW, randRows, RESET));
        logger.info(String.format("%sAMOUNT OF COLUMNS: %d%s", YELLOW, randColumns, RESET));

        for (int i = 0; i < randColumns; i++) {
            logger.info(String.format("%s%d COLUMN OF ROW 1: %c%s", YELLOW, i, map[0][i], RESET));
            assertEquals(toChar(i), map[0][i]); // checks every column of the first row is numbered correctly
        }

        for (int i = 0; i < randRows; i++) {
            logger.info(String.format("%s1 COLUMN OF ROW %d: %c%s", YELLOW, i, map[i][0], RESET));
            assertEquals(toChar(i), map[i][0]); // checks the first column of each row is numbered correctly
        }
    }
}