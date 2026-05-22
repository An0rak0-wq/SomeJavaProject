import java.util.HashMap;
import java.util.Map;

public class Positions {
    private static Map<String, Character> positionDic = new HashMap<>();

    public static void addPosition(int column, int row, char entity) {
        positionDic.put(String.format("%d, %d", column, row), entity);
    }

    public static boolean positionIsOcupied(int column, int row) {
        return positionDic.containsKey(String.format("%d, %d", column, row));
    }

    public static char charInPosition(int column, int row) {
        String coord = String.format("%d, %d", column, row);
        return positionDic.get(coord);
    }

    public static void clearDic() {
        positionDic.clear();
    }
}