package dreieck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Eine einfache Klasse Dreieck mit Seiten im Bereich von int.
 * 
 * @author Michael Borko
 * @email mborko@tgm.ac.at
 * @version 20130425-1555
 *
 */
public class TestIstDreieck {

	private int seite_a;
	private int seite_b;
	private int seite_c;
	
	private Dreieck dreieck;

	/**
	 * Konstruktor verlangt drei Integer-Werte fuer die jeweiligen Kanten.
	 * @param _a
	 * @param _b
	 * @param _c
	 */
	@Before
	public void setUp(){
		dreieck = new Dreieck(seite_a,seite_b,seite_c);
	}
	
	@Test
	public void istDreieckSeiteANull() {
		dreieck.setSeite_a(0);
		dreieck.setSeite_b(1);
		dreieck.setSeite_c(2);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckSeiteBNull() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(0);
		dreieck.setSeite_c(2);
		
		assertFalse(dreieck.istDreieck());
	}

	@Test
	public void istDreieckSeiteCNull() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(0);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckSeiteAKleinerNull(){
		dreieck.setSeite_a(-5);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(4);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckSeiteBKleinerNull(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(-2);
		dreieck.setSeite_c(4);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckSeiteCKleinerNull(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(-4);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckAPlusBGleichC(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(7);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckAPlusCGleichB(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(12);
		dreieck.setSeite_c(7);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckBPlusCGleichA(){
		dreieck.setSeite_a(9);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(7);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckAPlusBKleiner0(){
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(Integer.MAX_VALUE);
		dreieck.setSeite_c(7);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckBPlusCKleiner0(){
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(1);
		dreieck.setSeite_c(Integer.MAX_VALUE);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckAPlusCKleiner0(){
		dreieck.setSeite_a(Integer.MAX_VALUE-10);
		dreieck.setSeite_b(1);
		dreieck.setSeite_c(11);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckAPlusBKleinerC(){
		dreieck.setSeite_a(2);
		dreieck.setSeite_b(1);
		dreieck.setSeite_c(11);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckAPlusCKleinerB(){
		dreieck.setSeite_a(2);
		dreieck.setSeite_b(11);
		dreieck.setSeite_c(1);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckCPlusBKleinerA(){
		dreieck.setSeite_a(11);
		dreieck.setSeite_b(1);
		dreieck.setSeite_c(1);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void istDreieckTrue(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(5);
		
		assertTrue(dreieck.istDreieck());
	}
	
	@Test
	public void gleichSeitigWennGleichSeitig(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(5);
		
		assertTrue(dreieck.gleichSeitig());
	}
	
	@Test
	public void gleichSeitigWennNichtGleichSeitigBUndC(){
		dreieck.setSeite_a(6);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(5);
		
		assertFalse(dreieck.gleichSeitig());
	} 
	
	@Test
	public void gleichSeitigWennKeinDreieck(){
		dreieck.setSeite_a(Integer.MAX_VALUE);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(5);
		
		assertFalse(dreieck.gleichSeitig());
	}
	
	@Test
	public void gleichSeitigWennNichtGleichSeitigAUndB(){
		dreieck.setSeite_a(6);
		dreieck.setSeite_b(6);
		dreieck.setSeite_c(5);
		
		assertFalse(dreieck.gleichSeitig());
	} 
	
	@Test
	public void gleichSchenkeligNicht(){
		dreieck.setSeite_a(6); 
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(4);
		
		assertFalse(dreieck.gleichSchenkelig());
	}
	
	@Test
	public void gleichSchenkeligWennKeinDreieck(){
		dreieck.setSeite_a(Integer.MAX_VALUE);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(4);
		
		assertFalse(dreieck.gleichSchenkelig());
	}
	
	@Test
	public void gleichSchenkeligAUndB(){
		dreieck.setSeite_a(6);
		dreieck.setSeite_b(6);
		dreieck.setSeite_c(4);
		
		assertTrue(dreieck.gleichSchenkelig());
	}
	
	@Test
	public void gleichSchenkeligBUndC(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(6);
		dreieck.setSeite_c(6);
		
		assertTrue(dreieck.gleichSchenkelig());
	}
	
	@Test
	public void gleichSchenkeligAUndC(){
		dreieck.setSeite_a(6);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(6);
		
		assertTrue(dreieck.gleichSchenkelig());
	}
	
	@Test
	public void rechtWinkeligNicht(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(5);
		
		assertFalse(dreieck.rechtWinkelig());
	}
	
	@Test
	public void rechtWinkeligBeiA(){
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(4);
		dreieck.setSeite_c(3);
		
		assertTrue(dreieck.rechtWinkelig());
	}
	
	@Test
	public void rechtWinkeligBeiB(){
		dreieck.setSeite_a(3);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(4);
		
		assertTrue(dreieck.rechtWinkelig());
	}
	
	@Test
	public void rechtWinkeligBeiCGleichA(){
		dreieck.setSeite_a(6);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(6);
		
		assertFalse(dreieck.rechtWinkelig());
	}
	
	@Test
	public void rechtWinkeligBeiC(){
		dreieck.setSeite_a(3);
		dreieck.setSeite_b(4);
		dreieck.setSeite_c(5);	
		
		assertTrue(dreieck.rechtWinkelig());
	}
	
	@Test
	public void rechtWinkeligPythagorasFalse(){
		dreieck.setSeite_a((int)Math.sqrt(Integer.MAX_VALUE)-1);
		dreieck.setSeite_b((int)Math.sqrt(Integer.MAX_VALUE)-1);
		dreieck.setSeite_c((int)Math.sqrt(Integer.MAX_VALUE));	
		
		assertFalse(dreieck.rechtWinkelig());
	}
	
	@Test
	public void keinDreieckBeirechtWinkelig(){
		dreieck.setSeite_a(3);
		dreieck.setSeite_b(Integer.MAX_VALUE);
		dreieck.setSeite_c(5);
		
		assertFalse(dreieck.rechtWinkelig());
	}
}
