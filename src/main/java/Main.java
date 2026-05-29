import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static void Delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Will run the game;
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Player player = new Player(3, 3, game);

        Map mapObj = new Map();
        char[][] map = mapObj.createEmptyMap(10, 10);

        player.SetPosition(player.column, player.row);

        Enemy enm1 = new Enemy(0, 0, 1, game);
        Enemy enm2 = new Enemy(0, 1, 2, game);
        Enemy enm3 = new Enemy(1, 0, 3, game);

        enm1.SetPosition(enm1.column, enm1.row);
        enm2.SetPosition(enm2.column, enm2.row);
        enm3.SetPosition(enm3.column, enm3.row);

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enm1);
        enemies.add(enm2);
        enemies.add(enm3);

        String coord = "";

        while (player.HP > 0) {
            System.out.println("*****NEW TURN*****");
            mapObj.displayMap(map);

            System.out.printf("Your HP: %d\n", player.HP);
            System.out.println("Where would you like to go?");
            System.out.print("> ");
            coord = scanner.nextLine();
            int row = Character.getNumericValue(coord.charAt(2));
            int column = Character.getNumericValue(coord.charAt(0));
            
            player.SetPosition(column, row);

            for (Enemy enemy : enemies) {
                enemy.SetPosition(enemy.column + 1, enemy.row + 1);
            }

            Delay(1);

            mapObj.displayMap(map);

            System.out.println("Where would you like to attack?");
            System.out.print("> ");
            coord = scanner.nextLine();
            row = Character.getNumericValue(coord.charAt(2));
            column = Character.getNumericValue(coord.charAt(0));

            Enemy targetEnemy = game.FindEnemyAtPosition(enemies, column, row);
            player.Attack(targetEnemy);

            if (targetEnemy.isDead()) {
                targetEnemy.Die();
                enemies.remove(targetEnemy);

            }
        }

        scanner.close();
        System.out.println();
    }
}