package starcraft;

public class DropShip extends AirUnit implements Repairable {
	public DropShip() {
		super("DropShip", 120);
	}

	@Override
	void fly() {
		System.out.println(name + " Fly!");
	}
}
