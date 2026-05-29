import java.util.ArrayList;

public class Game {
    // Controls global event (movement)

    // ANSI Escpape Codes
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";

    public boolean SetPosition(char Entity,  String position, String currentPosition, int range) {
        if (MovementValidation.WithinRange(position, currentPosition, range)) {
            if (!(MovementValidation.Occupied(position))) {
                System.out.printf("%sYou can move here!%s\n", YELLOW, RESET);

                int column = Character.getNumericValue(currentPosition.charAt(0));
                int row = Character.getNumericValue(currentPosition.charAt(2));

                int newColumn = Character.getNumericValue(position.charAt(0));
                int newRow = Character.getNumericValue(position.charAt(2));

                Positions.removePosition(column, row);
                Positions.addPosition(newColumn, newRow, Entity);

                return true;
            } else {
                if (Entity == 'P') {
                    System.out.printf("%sThis position is occupied!%s\n", YELLOW, RESET);
                }
            }
        } else {
            if (Entity == 'P') {
                System.out.printf("%sThis position is out of your range!%s\n", YELLOW, RESET);
            }
        }

        return false;
    }

    public Enemy FindEnemyAtPosition(ArrayList<Enemy> enemies, int column, int row) {
        for (Enemy enemy : enemies) {
            if (enemy.column == column && enemy.row == row) {
                return enemy;
            }
        }
        return null;
    }
}