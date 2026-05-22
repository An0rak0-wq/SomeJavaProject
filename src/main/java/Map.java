public class Map {
    private char toChar(int num) {
        return (char) ('0' + num);  // 0->0, 1->1, ... 9->9
    }

    public char[][] createEmptyMap(int rows, int cols) {
        char[][] map = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = '-';
            }
        }

        return map;
    }

    public char[][] formatMap(char[][] map) {
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = toChar(i); // Numbers every column of the first row
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = toChar(i); // Numbers the first column of every row
        }
        
        return map;
    }

    public void displayMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }

            System.out.print("\n");
        }
    }
}