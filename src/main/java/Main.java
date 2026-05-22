import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Will run the game;
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(3, 3);

        player.setPosition(0, 0);

        Map mapObj = new Map();
        char[][] map = mapObj.createEmptyMap(5, 5);

        for (int i = 0; i < 1000; i++) {
            System.out.println("*****NEW TURN*****");
            mapObj.displayMap(map);

            System.out.println("Where would you like to go?");
            System.out.print("> ");
            String coord = scanner.nextLine();
            int row = Character.getNumericValue(coord.charAt(0));
            int column = Character.getNumericValue(coord.charAt(2));
            
            player.setPosition(column, row);

            mapObj.displayMap(map);
        }

        scanner.close();
        System.out.println();
    }
}