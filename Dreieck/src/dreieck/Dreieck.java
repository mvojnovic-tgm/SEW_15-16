package dreieck;

/**
 * Eine einfache Klasse Dreieck mit Seiten im Bereich von int.
 * 
 * @author Michael Borko
 * @email mborko@tgm.ac.at
 * @version 20130425-1555
 *
 */
public class Dreieck {

	private int seite_a;
	private int seite_b;
	private int seite_c;

	/**
	 * Konstruktor verlangt drei Integer-Werte fuer die jeweiligen Kanten.
	 * @param _a
	 * @param _b
	 * @param _c
	 */
	public Dreieck(int _a, int _b, int _c) {
		seite_a = _a;
		seite_b = _b;
		seite_c = _c;
	}

	/**
	 * Einfache Ueberpruefung auf die Grundregeln eines Dreiecks:
	 * <br>
	 * seite_a == 0 || seite_b == 0 || seite_c == 0
	 * seite_a < 0 || seite_b < 0 || seite_c < 0
	 * Summe zweier Seiten darf nicht gleich dem Betrag der dritten Seite entsprechen
	 * Summe zweier Seiten darf nicht kleiner 0 sein
	 * Summe zweier Seiten darf nicht kleiner dem Betrag der dritten Seite entsprechen
	 * 
	 * @return true bei Regelkonformitaet
	 */
	public boolean istDreieck() {
		if (this.seite_a == 0
				|| this.seite_b == 0
				|| this.seite_c == 0) {
			return false;
		}
		if (this.seite_a < 0
				|| this.seite_b < 0
				|| this.seite_c < 0) {
			return false;
		}
		if ((this.seite_a + this.seite_b == this.seite_c)
				|| (this.seite_a + this.seite_c == this.seite_b)
				|| (this.seite_c + this.seite_b == this.seite_a)) {
			return false;
		}
		if (this.seite_a + this.seite_b < 0
				|| this.seite_b + this.seite_c < 0
				|| this.seite_a + this.seite_c < 0) {
			return false;
		}
		if ((this.seite_a + this.seite_b < this.seite_c)
				|| (this.seite_a + this.seite_c < this.seite_b)
				|| (this.seite_c + this.seite_b < this.seite_a)) {
			return false;
		}

		return true;
	}

	/**
	 * Ist das Dreieck gleichseitig wird ein true geliefert. Folgende Regel muss erfuellt sein:
	 * seite_a == seite_b && seite_b == seite_c
	 * @return
	 */
	public boolean gleichSeitig() {
		return this.istDreieck() && (this.seite_a == this.seite_b && this.seite_b == this.seite_c);
	}

	/**
	 * Ist das Dreieck gleichschenklig wird ein true geliefert. Folgende Regel muss erfuellt sein:
	 * Zwei Seiten muessen gleich lang sein
	 * 
	 * @return
	 */
	public boolean gleichSchenkelig() {
		return this.istDreieck()
				&& (this.seite_a == this.seite_b 
					|| this.seite_b == this.seite_c 
					|| this.seite_a == this.seite_c);
	}

	/**
	 * Ist das Dreieck rechtwinkelig wird ein true geliefert. Folgende Regel muss erfuellt sein:
	 * hypothenuse² == ankathete² + gegenkathete²
	 * wobei die hypothenuse immer laenger sein muss als jede einzelne kathete
	 * 
	 * @return
	 */
	public boolean rechtWinkelig() {
		if (this.istDreieck()) {

			int hypothenuse = 0;
			int kathete1 = 0;
			int kathete2 = 0;

			if (seite_a > seite_b 
					&& seite_a > seite_c) {
				hypothenuse = seite_a;
				kathete1 = seite_b;
				kathete2 = seite_c;
			} else if (seite_b > seite_a 
					&& seite_b > seite_c) {
				hypothenuse = seite_b;
				kathete1 = seite_a;
				kathete2 = seite_c;
			} else if (seite_c > seite_b 
					&& seite_c > seite_a) {
				hypothenuse = seite_c;
				kathete1 = seite_a;
				kathete2 = seite_b;
			} else {
				return false;
			}

			return (hypothenuse * hypothenuse == (kathete1 * kathete1 + kathete2 * kathete2));
 
		}
		return false;
	}

	public void setSeite_a(int seite_a) {
		this.seite_a = seite_a;
	}

	public void setSeite_b(int seite_b) {
		this.seite_b = seite_b;
	}

	public void setSeite_c(int seite_c) {
		this.seite_c = seite_c;
	}
}
