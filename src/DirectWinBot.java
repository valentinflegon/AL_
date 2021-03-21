public class DirectWinBot extends P4PlayerDecorator {
    P4 _puissance4;

    public DirectWinBot(P4Player player, P4 p) {
        super(player);
        _puissance4 = p;
    }

    public int play() {
        for (int column = 0; column < P4.WIDTH; ++column) {
            if (_puissance4.checkWin(column, this))
                return column;
        }
        return super.play();
    }
}
