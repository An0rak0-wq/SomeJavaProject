public class Player {
    public int row;
    public int column;

    public Player(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setPosition(int column, int row) {
        if (Positions.positionIsOcupied(this.column, this.row)) {
            Positions.removePosition(this.column, this.row);
        }

        Positions.addPosition(column, row, 'P');

        this.row = row;
        this.column = column;
    }
}