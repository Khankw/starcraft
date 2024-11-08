package starcraft;

public class DropShip extends AirUnit implements Repairable {
	public DropShip() {
		super("DropShip", 120, 0);
	}

	@Override
	void fly() {
		isFly = !isFly;
		if(isFly)
			System.out.println(name + " Fly!");
		else
			System.out.println(name + " Landing!");
	}
}
