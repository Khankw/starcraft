package starcraft;

abstract public class Unit {
	protected int MAX_HP;
	protected String name;
	protected int hp;

	protected Unit(String name, int hp) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
	}
}
