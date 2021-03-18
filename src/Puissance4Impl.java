import model.Puissance4Builder;

public class Puissance4Impl implements Puissance4 {
    private P4Player[][] _tab;
    private boolean _finished;
    private int _freePlaces;
    private P4Player _currentPlayer, _p1, _p2;

    public P4Player getCurrentPlayer() {
        return _currentPlayer;
    }

    public P4Player getPlayer1() {
        return _p1;
    }

    public P4Player getPlayer2() {
        return _p2;
    }

    public void init(P4Player p1, P4Player p2) {
        _p1 = p1;
        _p2 = p2;
        _currentPlayer = _p1;
        _tab = new P4Player[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; ++i)
            for (int j = 0; j < HEIGHT; ++j)
                _tab[i][j] = null;
        _finished = false;
        _freePlaces = WIDTH * HEIGHT;
    }

    public void buildPuissance4(Puissance4Builder bld) {
        
    	bld.createNewPuissance4();
        
        bld.beginRow();
        bld.addString("***************");
        bld.endRow();
        
        bld.beginTable();
        for (int i = WIDTH - 1; i >= 0; --i) {
            bld.addString("|");
            for (int j = 0; j < HEIGHT; ++j) {
                if (_tab[i][j] == _p1)
                    bld.addString("X");
                if (_tab[i][j] == null)
                    bld.addString(" ");
                if (_tab[i][j] == _p2)
                    bld.addString("O");
                bld.addString("|");
            }
            bld.endRow();
        }
        bld.beginRow();
        bld.addString("***************");
        bld.endRow();

        bld.finish();
    }


    public boolean isFinish() {
        return _finished;
    }

    public boolean isFree(int col) {
        if (_freePlaces <= 0) return false;
        if (col < 0 || col >= WIDTH) return false;
        int i = 0;
        while (i < HEIGHT && _tab[i][col] != null)
            ++i;
        return i < HEIGHT;

    }

    // switchCurrentPlayer()
    private P4Player switchPlayer() {
        if (_currentPlayer == _p1)
            return _p2;
        else
            return _p1;
    }

    public void play(int col) {
        if (isFinish()) return;
        --_freePlaces;
        int i = 0;
        while (i < HEIGHT && _tab[i][col] != null)
            ++i;
        // Exception ?
        if (i >= HEIGHT) {
        }
        _tab[i][col] = _currentPlayer;
        if (testwin(i, col)) {
            System.out.println("player " + _currentPlayer + " win");
            _finished = true;
            return;
        }
        _currentPlayer = switchPlayer();
    }

    // Stocker les jetons dans un tableau pour pas à avoir à les recalculer à chaque fois
    // Séparer en plusieurs sous-fonctions
    public boolean testwin(int i, int col) {
        int l = 1, h = 1, d1 = 1, d2 = 1;
        P4Player p = _tab[i][col];

        for (int x = i + 1; x < WIDTH && _tab[x][col] == p; ++x) ++l;
        for (int x = i - 1; x >= 0 && _tab[x][col] == p; --x) ++l;

        for (int x = col + 1; x < WIDTH && _tab[i][x] == p; ++x) ++h;
        for (int x = col - 1; x >= 0 && _tab[i][x] == p; --x) ++h;

        for (int x = i + 1, y = col + 1; x < WIDTH && y < HEIGHT && _tab[x][y] == p; ++x, ++y) ++d1;
        for (int x = i - 1, y = col - 1; x >= 0 && y >= 0 && _tab[x][y] == p; --x, --y) ++d1;

        for (int x = i + 1, y = col - 1; x < WIDTH && y >= 0 && _tab[x][y] == p; ++x, --y) ++d2;
        for (int x = i - 1, y = col + 1; x >= 0 && y < HEIGHT && _tab[x][y] == p; --x, ++y) ++d2;
        //System.out.println("res " +l + " " + h + " " + d1 +  " " +d2);
        if (l > 3) return true;
        if (h > 3) return true;
        if (d1 > 3) return true;
        return d2 > 3;
    }

    public boolean checkWin(int col, P4Player player) {
        if (!isFree(col)) return false;
        int i = 0;
        while (i < HEIGHT && _tab[i][col] != null)
            ++i;
        _tab[i][col] = player;
        boolean result = testwin(i, col);
        _tab[i][col] = null;
        return result;
    }
}
