package com.company;


import java.util.Random;

class RandomBot implements P4Player {
    Puissance4 _p;
    public RandomBot(Puissance4 p) {
        _p = p;
    }
    public int play() {
        Random r = new Random();
        int res = r.nextInt(Puissance4.WIDTH);
        while(!_p.isFree(res))
            res = r.nextInt(Puissance4.WIDTH);
        return res;
    }
}
