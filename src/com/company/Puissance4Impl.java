package com.company;

class Puissance4Impl implements Puissance4 {
    private P4Player [][] _tab;
    private boolean _finished;
    private int _freePlaces;
    private P4Player _player, _p1, _p2;

    public P4Player currentPlayer() {
        return _player;
    }

    public P4Player player1() {
        return _p1;
    }
    public P4Player player2() {
        return _p2;
    }
    public void init(P4Player p1, P4Player p2) {
        _p1 = p1;
        _p2 = p2;
        _player = _p1;
        _tab = new P4Player[WIDTH][HEIGHT];
        for (int i=0; i < WIDTH; ++i)
            for (int j=0; j < HEIGHT; ++j)
                _tab[i][j] = null;
        _finished = false;
        _freePlaces = WIDTH * HEIGHT;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("***************\n");
        for (int i=WIDTH-1; i >=0; --i) {
            str.append("|");
            for (int j=0; j < HEIGHT; ++j) {
                if (_tab[i][j] == _p1)
                    str.append("X");
                if (_tab[i][j] == null)
                    str.append(" ");
                if (_tab[i][j] == _p2)
                    str.append("O");
                str.append("|");
            }
            str.append("\n");
        }
        str.append("***************\n");
        return str.toString();
    }

    public boolean end() {
        return _finished;
    }

    public boolean isFree(int col) {
        if(_freePlaces <= 0) return false;
        if (col <0 || col >= WIDTH) return false;
        int i=0;
        while(i < HEIGHT && _tab[i][col] != null)
            ++i;
        if (i >= HEIGHT)
            return false;
        return true;

    }

    private P4Player switchPlayer() {
        if (_player == _p1)
            return _p2;
        else
            return _p1;
    }

    public void play(int col) {
        if (end()) return;
        --_freePlaces;
        int i=0;
        while(i < HEIGHT && _tab[i][col] != null)
            ++i;
        if (i >= HEIGHT) {
            //error
        }
        _tab[i][col] = _player;
        if (testwin(i, col)) {
            System.out.println("player " + _player + " win");
            _finished = true;
            return;
        }
        _player = switchPlayer();
    }

    public boolean testwin(int i, int col) {
        int l = 1 , h = 1, d1 = 1, d2 = 1;
        P4Player p = _tab[i][col];

        for (int x = i + 1; x < WIDTH && _tab[x][col] == p; ++x) ++l;
        for (int x = i - 1; x >=  0   && _tab[x][col] == p; --x) ++l;

        for (int x = col + 1; x < WIDTH && _tab[i][x] == p; ++x) ++h;
        for (int x = col - 1; x >=  0   && _tab[i][x] == p; --x) ++h;

        for (int x = i + 1, y = col + 1; x < WIDTH && y < HEIGHT && _tab[x][y] == p; ++x, ++y) ++d1;
        for (int x = i - 1, y = col - 1; x >= 0 && y >= 0 && _tab[x][y] == p; --x, --y) ++d1;

        for (int x = i + 1, y = col - 1; x < WIDTH && y >= 0     && _tab[x][y] == p; ++x, --y) ++d2;
        for (int x = i - 1, y = col + 1; x >= 0    && y < HEIGHT && _tab[x][y] == p; --x, ++y) ++d2;
        //System.out.println("res " +l + " " + h + " " + d1 +  " " +d2);
        if (l >3)  return true;
        if (h >3)  return true;
        if (d1 >3) return true;
        if (d2 >3) return true;
        return  false;
    }

    public boolean checkWin(int col, P4Player player) {
        if (!isFree(col)) return false;
        int i=0;
        while(i < HEIGHT && _tab[i][col] != null)
            ++i;
        _tab[i][col] = player;
        boolean result = testwin(i, col);
        _tab[i][col] = null;
        return result;
    }
}
