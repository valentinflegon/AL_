package core;
import exception.P4Exception;
import model.P4Builder;

public class P4Impl implements P4 {

    private P4Player[][] _tab;
    private boolean _finished;
    private int _freePlaces;
    private P4Player _currentPlayer, _player1, _player2;

    public P4Player getCurrentPlayer() {
        return _currentPlayer;
    }

    public P4Player getPlayer1() {
        return _player1;
    }

    public P4Player getPlayer2() {
        return _player2;
    }

    public void init(P4Player p1, P4Player p2) {
        _player1 = p1;
        _player2 = p2;
        _currentPlayer = _player1;
        _tab = new P4Player[WIDTH][HEIGHT];
        for (int column = 0; column < WIDTH; ++column)
            for (int row = 0; row < HEIGHT; ++row)
                _tab[column][row] = null;
        _finished = false;
        _freePlaces = WIDTH * HEIGHT;
    }

    public void showGrid(P4Builder bld) {

        bld.createNewPuissance4();

        bld.beginRow();
        bld.beginHeader();
        bld.endRow();

        bld.beginTable();
        for (int i = WIDTH - 1; i >= 0; --i) {
            bld.addString("|");
            for (int j = 0; j < HEIGHT; ++j) {
                if (_tab[i][j] == _player1)
                    bld.addString("X");
                if (_tab[i][j] == null)
                    bld.addString(" ");
                if (_tab[i][j] == _player2)
                    bld.addString("O");
                bld.addString("|");
            }
            bld.endRow();
        }
        bld.beginRow();
        bld.beginHeader();
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

    private void switchCurrentPlayer() {
    	if (_currentPlayer == _player1)
    		_currentPlayer = _player2; 
		else
			_currentPlayer = _player1;
	}
    
    public void addChip(int col) {
        if (isFinish()) return;
        --_freePlaces;
        int i = 0;
        while (i < HEIGHT && _tab[i][col] != null)
            ++i;
        if (i >= HEIGHT) throw new P4Exception();
        _tab[i][col] = _currentPlayer;
        if (testWin(i, col)) {
            System.out.println("player " + _currentPlayer + " win");
            _finished = true;
            return;
        }
        switchCurrentPlayer();
    }

    // Stocker les jetons dans un tableau pour pas à avoir à les recalculer à chaque fois
    public boolean testWin(int i, int col) {
        boolean res1, res2, res3, res4 = false;

        res1 = testHorizontal(i, col);
        res2 = testVertical(i, col);
        res3 = testAscendingDiagonal(i, col);
        res4 = testDescendingDiagonal(i, col);
        if(res1==true) return true;
        if(res2==true) return true;
        if(res3==true) return true;
        return res4 == true;
    }
    
    public boolean testHorizontal(int i,int col){
        int l = 1;
        P4Player p = _tab[i][col];
    	for (int x = i + 1; x < WIDTH && _tab[x][col] == p; ++x) ++l;
        for (int x = i - 1; x >= 0 && _tab[x][col] == p; --x) ++l;
        return l>3;
    }
    
    public boolean testVertical(int i, int col) {
    	int h = 1;
    	P4Player p = _tab[i][col];
        for (int x = col + 1; x < WIDTH && _tab[i][x] == p; ++x) ++h;
        for (int x = col - 1; x >= 0 && _tab[i][x] == p; --x) ++h;
        return h>3;
    }
    
    public boolean testAscendingDiagonal(int i,int col){
        int d1 = 1;
        P4Player p = _tab[i][col];
        for (int x = i + 1, y = col + 1; x < WIDTH && y < HEIGHT && _tab[x][y] == p; ++x, ++y) ++d1;
        for (int x = i - 1, y = col - 1; x >= 0 && y >= 0 && _tab[x][y] == p; --x, --y) ++d1;
        return d1>3;
    }
    
    public boolean testDescendingDiagonal(int i,int col){
        int d2 = 1;
        P4Player p = _tab[i][col];
        for (int x = i + 1, y = col - 1; x < WIDTH && y >= 0 && _tab[x][y] == p; ++x, --y) ++d2;
        for (int x = i - 1, y = col + 1; x >= 0 && y < HEIGHT && _tab[x][y] == p; --x, ++y) ++d2;
        return d2>3;
    }

    public boolean checkWin(int col, P4Player player) {
        if (!isFree(col)) return false;
        int i = 0;
        while (i < HEIGHT && _tab[i][col] != null)
            ++i;
        _tab[i][col] = player;
        boolean result = testWin(i, col);
        _tab[i][col] = null;
        return result;
    }
}
