public class Main {
    public static void main(String[] args) {
        // Will run the game;
        Map mapObj = new Map();
        char[][] map = mapObj.createEmptyMap(5, 5);

        System.out.println(map);
        System.out.println();
    }
}