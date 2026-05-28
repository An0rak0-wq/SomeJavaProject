import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Will run the game;
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(3, 3);
        // Game game = new Game();

        Map mapObj = new Map();
        char[][] map = mapObj.createEmptyMap(5, 5);

        player.SetPosition(3, 3);
        Positions.addPosition(1, 1, 'E');

        String coord = "";

        while (coord != "e") {
            System.out.println("*****NEW TURN*****");
            mapObj.displayMap(map);

            System.out.println("Where would you like to go?");
            System.out.print("> ");
            coord = scanner.nextLine();
            int row = Character.getNumericValue(coord.charAt(2));
            int column = Character.getNumericValue(coord.charAt(0));
            
            player.SetPosition(column, row);
        }

        scanner.close();
        System.out.println();
    }
}