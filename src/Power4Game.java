import model.Puissance4Builder;
import ui.TextBuilder;

// Faire un singleton 
//Duplication ?
public class Power4Game {

    public static void run(Puissance4 p, Puissance4Builder bld) {
        while (!p.isFinish()) {
            p.buildPuissance4(bld);
            System.out.println(bld.getPuissance4());
            System.out.println("Player " + p.getCurrentPlayer() + " turn");
            p.play(p.getCurrentPlayer().play());
        }
        System.out.println(p);
    }

    public static void main(String[] argv) {

        Puissance4 p = new Puissance4Impl();

        P4Player p1 = new HumanBot(p);
        P4Player p2 = new DirectWinBot(p);

        p.init(p1, p2);

        TextBuilder txt = new TextBuilder();
        run(p, txt);
    }

}
