public class Main {
    public static void main(String[] args) {
        // Will run the game;
        Map mapObj = new Map();
        char[][] map = mapObj.createEmptyMap(10, 5);

        mapObj.displayMap(map);

        System.out.println();
    }
}