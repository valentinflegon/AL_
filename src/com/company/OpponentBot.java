package com.company;


class OpponentBot extends RandomBot {
    Puissance4 _p;
    public OpponentBot(Puissance4 p) {
        super(p);
        _p = p;
    }
    public int play() {
        P4Player _opponent;
        if (_p.player1() != this)
            _opponent = _p.player1();
        else
            _opponent = _p.player2();
        for (int i=0; i < Puissance4.WIDTH; ++i) {
            if (_p.checkWin(i, _opponent))
                return i;
        }
        return super.play();
    }
}
