import model.Puissance4Builder;

public interface Puissance4 {
    int WIDTH = 7;
    int HEIGHT = 7;

    void init(P4Player p1, P4Player p2);

    P4Player getPlayer1();

    P4Player getPlayer2();

    P4Player getCurrentPlayer();

    boolean isFinish();

    void play(int col);

    String toString();

    void buildPuissance4(Puissance4Builder bld);

    boolean isFree(int col);

    boolean checkWin(int col, P4Player player);
}
