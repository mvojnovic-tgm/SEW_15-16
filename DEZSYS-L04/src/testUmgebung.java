
public class testUmgebung {

	public static void main(String[] args){
		Windradrechner g1 = new Windradrechner();
		try {
			g1.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Windradrechner g2 = new Windradrechner();
		try {
			g2.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Windradrechner g3 = new Windradrechner();
		try {
			g3.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parkrechner p1 = new Parkrechner();
		try {
			p1.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parkrechner p2 = new Parkrechner();
		try {
			p2.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parkrechner p3 = new Parkrechner();
		try {
			p3.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
