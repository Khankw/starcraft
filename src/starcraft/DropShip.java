package starcraft;

public class DropShip extends AirUnit implements Repairable {
	public DropShip(int index) {
		super("DropShip"+index, 120, 0);
	}

	@Override
	void fly() {
		isFly = !isFly;
		if(isFly)
			System.out.println(name + "이 이륙했습니다.");
		else
			System.out.println(name + "이 착륙했습니다.");
	}
}
