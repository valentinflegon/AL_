import ui.TextBuilder;

public class Main {

    public static void main(String[] argv) {

        P4 p = new P4Impl();

        P4Player p1 = new HumanPlayer(p);
        P4Player p2 = new OpponentBot(new DirectWinBot(new RandomBot(p), p), p);

        p.init(p1, p2);

        TextBuilder txt = new TextBuilder();
        P4Game.getInstance();
        P4Game.run(p, txt);
    }
}
