public class Player {
    private Game game;
    public int row = 0;
    public int column = 0;
    public int HP = 30;
    private int attackPower = 5;

    private int range = 2;

    public Player(int column, int row, Game game) {
        this.row = row;
        this.column = column;
        this.game = game;
    }

    public void SetPosition(int column, int row) {
        if (game.SetPosition('P', String.format("%d,%d", column, row), String.format("%d,%d", this.column, this.row), range)) {
            this.column = column;
            this.row = row;
        }
    }

    public void Attack(Enemy enemy) {
        enemy.HP -= this.attackPower;
        System.out.printf("You attacked enemy %d and dealt %d damage. Their HP is now %d\n", enemy.iD, attackPower, enemy.HP);
    }
}