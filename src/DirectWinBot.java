public class DirectWinBot extends P4PlayerDecorator{
    Puissance4 _p;

    public DirectWinBot(P4Player player, Puissance4 p) {
        super(player);
        _p = p;
    }

    public int play() {
        for (int i = 0; i < Puissance4.WIDTH; ++i) {
            if (_p.checkWin(i, this))
                return i;
        }
        return super.play();
    }
}
