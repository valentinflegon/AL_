import ui.TextBuilder;
public class Main {

    public static void main(String[] argv) {

        Puissance4 p = new Puissance4Impl();

        P4Player p1 = new HumanPlayer(p);
        P4Player p2 = new OpponentBot(new OpponentBot(new RandomBot(p), p),p);

        p.init(p1, p2);

        TextBuilder txt = new TextBuilder();
        Power4Game.getInstance();
        Power4Game.run(p, txt);
    }
}
