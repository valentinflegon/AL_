import model.Puissance4Builder;
import ui.TextBuilder;

public class Power4Game {
    private static Power4Game power4Game;

    private Power4Game(){}

    //synchronized method to control simultaneous access
    synchronized  public static Power4Game getInstance() {
        if (power4Game == null) {
            power4Game = new Power4Game();
        }
        return power4Game;
    }

    public static void run(Puissance4 p, Puissance4Builder bld) {
        while (!p.isFinish()) {
            p.buildPuissance4(bld);
            System.out.println(bld.getPuissance4());
            System.out.println("Player " + p.getCurrentPlayer() + " turn");
            p.play(p.getCurrentPlayer().play());
        }
        System.out.println(p);
    }

}
