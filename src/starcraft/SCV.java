package starcraft;

public class SCV extends GroundUnit implements Repairable, Attackable {
	public SCV(int index) {
		super("SCV" + index, 80, 5);
	}

	public void repair(Repairable unit) {
		if (unit instanceof Unit) {
			System.out.println("------------------------------------");
			Unit target = (Unit) unit;

			int repairCost = 10;
			String msg = "";
			while (target.hp < target.MAX_HP && repairCost > 0) {
				msg = String.format("%s가 %s 수리중... [%d/%d]", this.name, target.name, target.hp, target.MAX_HP);
				System.out.println(msg);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				target.hp++;
				repairCost--;
			}
			msg = String.format("%s가 %s 수리완료.  [%d/%d]\n", this.name, target.name, target.hp, target.MAX_HP);
			System.out.println(msg);

		}
	}

	@Override
	public void attack(Unit unit) {
		System.out.println("------------------------------------");
		if (unit instanceof AirUnit) {
			AirUnit target = (AirUnit) unit;
			if (target.isFly) {
				System.out.println(name + "이 " + target.name + "에게 공격시도 했지만 비행중이어서 실패합니다.\n");
				return;
			}
		}

		System.out.println(name + "이 " + unit.name + "를 공격했습니다.");
		unit.hp -= attack;
		if (unit.hp < 0)
			unit.hp = 0;
		System.out.println(unit.name + "의 HP는 " + unit.hp + "입니다.\n");
	}
}
