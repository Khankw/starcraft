package starcraft;

public class Tank extends GroundUnit implements Repairable, Attackable {
	public Tank(int index) {
		super("Tank"+index, 150, 50);
	}

	@Override
	public void attack(Unit unit) {
		System.out.println("------------------------------------");
		if(unit instanceof AirUnit) {
			AirUnit target =(AirUnit) unit;
			if(target.isFly) {
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
