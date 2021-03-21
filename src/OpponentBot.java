public class OpponentBot extends P4PlayerDecorator {

    Puissance4 _puissance4;

    public OpponentBot(P4Player botPlayer, Puissance4 p) {
        super(botPlayer);
        _puissance4 = p;
    }

    public int play() {
        P4Player _opponent;
        if (_puissance4.getPlayer1() != this)
            _opponent = _puissance4.getPlayer1();
        else
            _opponent = _puissance4.getPlayer2();
        for (int column = 0; column < Puissance4.WIDTH; ++column) {
            if (_puissance4.checkWin(column, _opponent))
                return column;
        }
        return super.play();
    }
}

