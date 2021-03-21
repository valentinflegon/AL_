public class P4PlayerDecorator implements P4Player {

    private P4Player _botPlayer;
    private P4 _p;

    public P4PlayerDecorator(P4Player botPlayer) {
        _botPlayer = botPlayer;
    }

    @Override
    public int play() {
    	return 0;
    }

}
