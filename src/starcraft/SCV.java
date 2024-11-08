package starcraft;

public class SCV extends GroundUnit implements Repairable {
	public SCV() {
		super("SCV", 80);
	}

	public void repair(Repairable unit) {
		if (unit instanceof Unit) {
			Unit target = (Unit) unit;

			while (target.hp < target.MAX_HP) {
				String msg = String.format("%s 수리중... [%d/%d]", target.name, target.hp, target.MAX_HP);
				System.out.println(msg);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				target.hp++;
			}
			System.out.println(target.name + " 수리완료.");
		}
	}
}
