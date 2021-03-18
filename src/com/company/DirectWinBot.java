package com.company;


class DirectWinBot extends OpponentBot {
    Puissance4 _p;
    public DirectWinBot(Puissance4 p) {
        super(p);
        _p = p;
    }
    public int play() {
        for (int i=0; i < Puissance4.WIDTH; ++i) {
            if (_p.checkWin(i, this))
                return i;
        }
        return super.play();
    }
}
