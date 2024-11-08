package starcraft;

public class Marine extends GroundUnit implements Attackable {
	public Marine() {
		super("Marine", 100, 5);
	}

	@Override
	public void attack(Unit unit) {
		System.out.println(name + "이 " + unit.name + "를 공격했습니다.");
		unit.hp -= attack;
		if (unit.hp < 0)
			unit.hp = 0;
		System.out.println(unit.name + "의 HP는 " + unit.hp + "입니다.");
	}
}
