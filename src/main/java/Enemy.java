import java.util.HashMap;
import java.util.Map;

public class Enemy {
    private Game game;
    private static Map<String, Character> enemyDic = new HashMap<>();
    public int column;
    public int row;
    public int iD;
    public int HP = 10;
    private int range = 1;

    public Enemy(int column, int row, int iD, Game game) {
        this.column = column;
        this.row = row;
        this.game = game;
        this.iD = iD;
    }

    public boolean isDead() {
        return this.HP <= 0;
    }

    public void Die() {
        Positions.removePosition(this.column, this.row);
    }

    public void SetPosition(int column, int row) {
        if (game.SetPosition('E', String.format("%d,%d", column, row), String.format("%d,%d", this.column, this.row), range)) {
            enemyDic.put(String.format("%d,%d", column, row), 'E');
            this.column = column;
            this.row = row;
        }
    }


}