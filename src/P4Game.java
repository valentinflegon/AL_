import model.P4Builder;

public class P4Game {
    private static P4Game power4Game;

    private P4Game() {
    }

    //synchronized method to control simultaneous access (ThreadSafe)
    synchronized public static P4Game getInstance() {
        if (power4Game == null) {
            power4Game = new P4Game();
        }
        return power4Game;
    }

    public static void run(P4 p, P4Builder builder) {
        while (!p.isFinish()) {
            p.showGrid(builder);
            System.out.println(builder.getPuissance4());
            System.out.println("Player " + p.getCurrentPlayer() + " turn");
            p.addChip(p.getCurrentPlayer().play());
        }
        System.out.println(p);
    }

}
