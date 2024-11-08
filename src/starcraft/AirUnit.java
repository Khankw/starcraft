package starcraft;

abstract public class AirUnit extends Unit {
	protected AirUnit(String name, int hp) {
		super(name, hp);
	}

	abstract void fly();
}
