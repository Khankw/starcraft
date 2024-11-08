package starcraft;

abstract public class Unit {
	protected int MAX_HP;
	protected String name;
	protected int hp;
	protected int attack;

	protected Unit(String name, int hp, int attack) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		this.attack = attack;
	}
}
