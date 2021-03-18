package com.company;

/**
 * Activité renversé Architecture logicielle
 *
 * Analyser le code si dessous pour proposer d'y intégrer des designs pattern vu en cours.
 * 1- Définir une liste de design pattern à implémenter
 * 2- Proposez une grille d'évaluation du travail
 * 3- Implémentez une solution
 * 4- Evaluez la solution d'un autre groupe en utilisant votre grille d'évaluation
 */

public class Power4Game {

    public static void run(Puissance4 p) {
        while(!p.end()) {
            System.out.println(p);
            System.out.println("Player " + p.currentPlayer() +  " turn");
            p.play(p.currentPlayer().play());
        }
        System.out.println(p);
    }
    public static void main(String argv[]) {
        Puissance4 p = new Puissance4Impl();
        P4Player p1 = new HumanBot(p);
        P4Player p2 = new DirectWinBot(p);
        p.init(p1, p2);
        run(p);
    }

}
