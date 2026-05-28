public class Map {

    /*private char toChar(int num) {
        return (char) ('0' + num);  // 0->0, 1->1, ... 9->9
    }
    */

    // ANSI Escape Codes
    String GREY = "\u001B[90m";
    String RESET = "\u001B[0m";

    public char[][] createEmptyMap(int rows, int cols) {
        char[][] map = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = '-';
            }
        }

        return map;
    }

    public void displayMap(char[][] map) {
        System.out.print("  ");
        
        for (int i = 0; i < map[0].length; i++){
            System.out.printf("%s%d%s ", GREY, i, RESET);
        }

        System.out.print("\n");

        for (int i = 0; i < map.length; i++) {
            System.out.printf("%s%d%s ", GREY, i, RESET);

            for (int j = 0; j < map[0].length; j++) {
                if (Positions.positionIsOcupied(j, i)) {
                    System.out.printf("%c ", Positions.charInPosition(j, i));
                } else {
                    System.out.printf("%c ", map[i][j]);
                }
            }

            System.out.print("\n");
        }
    }
}