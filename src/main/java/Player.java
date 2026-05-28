public class Player {
    Game game = new Game();
    public int row = 0;
    public int column = 0;
    private int range = 2;

    public Player(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public void SetPosition(int column, int row) {
        if (game.SetPosition('P', String.format("%d,%d", column, row), String.format("%d,%d", this.column, this.row), range)) {
            this.column = column;
            this.row = row;
        }
    }
}