public class DirectWinBot extends P4PlayerDecorator {
    Puissance4 _puissance4;

    public DirectWinBot(P4Player player, Puissance4 p) {
        super(player);
        _puissance4 = p;
    }

    public int play() {
        for (int column = 0; column < Puissance4.WIDTH; ++column) {
            if (_puissance4.checkWin(column, this))
                return column;
        }
        return super.play();
    }
}
