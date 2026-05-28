public class MovementValidation {
    // Controls validation

    public static boolean WithinRange(String position, String currentPosition, int range) {
        int targetColumn = Character.getNumericValue(position.charAt(0));
        int targetRow = Character.getNumericValue(position.charAt(2));

        int currentColumn = Character.getNumericValue(currentPosition.charAt(0));
        int currentRow = Character.getNumericValue(currentPosition.charAt(2));

        int maxColumn = currentColumn + range;
        int minColumn = currentColumn - range;

        int maxRow = currentRow + range;
        int minRow = currentRow - range;

        boolean columnInRange = false;
        boolean rowInRange = false;

        if (targetColumn >= minColumn && targetColumn <= maxColumn) {
            columnInRange = true;
        }

        if (targetRow >= minRow && targetRow <= maxRow) {
            rowInRange = true;
        }

        return columnInRange && rowInRange;
    }

    public static boolean Occupied(String position) {
        int column = Character.getNumericValue(position.charAt(0));
        int row = Character.getNumericValue(position.charAt(2));
        return Positions.positionIsOcupied(column, row);
    }
}