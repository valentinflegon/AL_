import java.util.Random;

public class RandomBot implements P4Player {
    P4 _p;

    public RandomBot(P4 p) {
        _p = p;
    }

    public int play() {
        Random random = new Random();
        int positionToPlay = random.nextInt(P4.WIDTH);
        while (!_p.isFree(positionToPlay))
            positionToPlay = random.nextInt(P4.WIDTH);
        return positionToPlay;
    }
}
