public class OpponentBot extends P4PlayerDecorator{
    
	P4 _p;
	
	public OpponentBot(P4Player botPlayer, P4 p) {
		super(p);
		_p = p;
	}

    public int play() {
        P4Player _opponent;
        if (_p.getPlayer1() != this)
            _opponent = _p.getPlayer1();
        else
            _opponent = _p.getPlayer2();
        for (int i = 0; i < P4.WIDTH; ++i) {
            if (_p.checkWin(i, _opponent))
                return i;
        }
        return super.play();
    }
}

