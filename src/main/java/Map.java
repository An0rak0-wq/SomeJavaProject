public class Map {
    public char[][] createEmptyMap(int rows, int cols) {
        char[][] map = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = '-';
            }
        }

        return map;
    }
}