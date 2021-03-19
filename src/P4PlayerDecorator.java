
public class P4PlayerDecorator implements P4Player{

	P4Player _botPlayer;
	public P4PlayerDecorator(P4Player botPlayer) {
		_botPlayer = botPlayer;
	}
	@Override
	public int play() {
		return 0;
	}

}
