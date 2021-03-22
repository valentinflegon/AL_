package core;
import model.P4Builder;

public interface P4 {
    int WIDTH = 7;
    int HEIGHT = 7;

    void init(P4Player p1, P4Player p2);

    P4Player getPlayer1();

    P4Player getPlayer2();

    P4Player getCurrentPlayer();

    boolean isFinish();

    void addChip(int col);

    String toString();

    void showGrid(P4Builder bld);

    boolean isFree(int col);

    boolean checkWin(int col, P4Player player);
}
