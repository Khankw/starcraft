package starcraft;

abstract public class AirUnit extends Unit {
	protected boolean isFly = true;
	
	protected AirUnit(String name, int hp, int attack) {
		super(name, hp, attack);
	}

	abstract void fly();
}
