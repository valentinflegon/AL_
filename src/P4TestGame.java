

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class P4TestGame {

	P4 p;
	P4Player p1;
	P4Player p2;
	boolean res;

	@BeforeEach
	void setUp() throws Exception {
		p = new P4Impl();
		p1 = new HumanPlayer(p);
	    p2 = new HumanPlayer(p);

	    p.init(p1, p2);
	}

	@Test
	void testGame() {
		assertNotNull(p);
	}	
	
	@Test
	void testWin() {
        p.play(0);
        p.play(0);
		p.play(1);
		p.play(1);
		p.play(2);
		p.play(2);
		res = p.checkWin(3, p1);
		System.out.println(res);
		assertEquals(res,true);
	}
	
	@Test
	void testMove() {
		for (int i = 0; i < P4.HEIGHT ; i++) {
			p.play(0);
		}
		res = p.isFree(0);
		System.out.println(res);
		assertEquals(false,res);
	}
}