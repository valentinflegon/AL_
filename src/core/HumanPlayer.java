package core;
import java.util.Scanner;

public class HumanPlayer implements P4Player {
    P4 _puissance4;

    public HumanPlayer(P4 p) {
        _puissance4 = p;
    }

    public int play() {
        Scanner sc = new Scanner(System.in);
        int column = -1;//
        while (!_puissance4.isFree(column)) {
            System.out.println("Enter column :");
            try {
                String str = sc.nextLine();
                column = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("Bad width value");
            }
        }
        //sc.close();
        return column;
    }
}
