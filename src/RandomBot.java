import java.util.Random;

public class RandomBot implements P4Player {
    Puissance4 _p;

    public RandomBot(Puissance4 p) {
        _p = p;
    }

    public int play() {
        Random random = new Random();
        int positionToPlay = random.nextInt(Puissance4.WIDTH);
        while (!_p.isFree(positionToPlay))
            positionToPlay = random.nextInt(Puissance4.WIDTH);
        return positionToPlay;
    }
}
