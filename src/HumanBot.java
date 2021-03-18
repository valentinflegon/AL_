import java.util.Scanner;

public class HumanBot implements P4Player {
	Puissance4 _p;
	public HumanBot(Puissance4 p) {
		_p = p;
	}
	public int play() {
		Scanner sc = new Scanner(System.in);
		int w = -1;
		while (!_p.isFree(w)) {
			System.out.println("Enter column :");
			try {
				String str = sc.nextLine();
				w = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.println("Bad width value");
			}
		}
		//sc.close();
		return w;
	}
}
