package starcraft;

public class Marine extends GroundUnit implements Attackable {
	private int lastTurn = 0;

	public Marine(int index) {
		super("Marine" + index, 100, 20);
	}

	public void healing(int turn) {
		if (hp == MAX_HP) {
			lastTurn= turn;
			return;
		}
		
		int elapsedTime = turn - lastTurn;
		int curHP=hp;
		hp += elapsedTime;
		if (hp > MAX_HP)
			hp = MAX_HP;

		System.out.println("------------------------------------");
		System.out.println(name + "이 "+ (hp-curHP) +"만큼 자가치유되었습니다.");
		
		lastTurn= turn;
	}

	@Override
	public void attack(Unit unit) {
		System.out.println("------------------------------------");
		System.out.println(name + "이 " + unit.name + "를 공격했습니다.");
		unit.hp -= attack;
		if (unit.hp < 0)
			unit.hp = 0;
		System.out.println(unit.name + "의 HP는 " + unit.hp + "입니다.\n");
	}
}
