package starcraft;

import java.util.Random;
import java.util.ArrayList;

public class StarcraftGame {
	private int TANK = 0;
	private int MARINE = 1;
	private int SCV = 2;
	private int DROPSHIP = 3;

	private Random ran = new Random();
	private ArrayList<Unit> units = new ArrayList<>();

	private StarcraftGame() {
	}

	private static StarcraftGame instance = new StarcraftGame();

	public static StarcraftGame getInstance() {
		return instance;
	}

	public void run() {
		setUnits();
		play();
	}

	private void setUnits() {
		int size = ran.nextInt(10) + 10;
		for (int i = 0; i < size; i++) {
			Unit unit = null;
			int type = ran.nextInt(4);
			if (type == TANK)
				unit = new Tank(i + 1);
			else if (type == MARINE)
				unit = new Marine(i + 1);
			else if (type == SCV)
				unit = new SCV(i + 1);
			else if (type == DROPSHIP)
				unit = new DropShip(i + 1);
			units.add(unit);
		}
	}

	private void play() {
		while (true) {
			int idx = ran.nextInt(units.size());
			int targetIdx = ran.nextInt(units.size());
			if (idx == targetIdx) {
				continue;
			}
			Unit unit = units.get(idx);
			Unit targetUnit = units.get(targetIdx);

			if (unit instanceof AirUnit) {
				int fly = ran.nextInt(2);
				if (fly == 0) {
					AirUnit airUnit = (AirUnit) unit;
					airUnit.fly();
				}
			}
			boolean attack = true;
			if (unit instanceof SCV) {
				int repair = ran.nextInt(2);
				if (repair == 0 && targetUnit instanceof Repairable) {
					SCV scv = (SCV) unit;
					Repairable repairUnit = (Repairable) targetUnit;
					if(targetUnit.hp < targetUnit.MAX_HP)
						scv.repair(repairUnit);
					attack = false;
				}
			}

			if (attack && unit instanceof Attackable) {
				Attackable attacker = (Attackable) unit;
				attacker.attack(targetUnit);
			}

			destroyUnit();

			if (units.size() == 1) {
				System.out.println("====================================");
				System.out.println("전쟁이 끝났습니다.");

				System.out.println(unit.name + "만이 살아남았습니다. 남은 HP : "+ unit.hp);
				break;
			} 

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void destroyUnit() {
		ArrayList<Unit> destroyUnits = new ArrayList<>();
		for (int i = 0; i < units.size(); i++) {
			Unit unit = units.get(i);
			if (unit.hp == 0)
				destroyUnits.add(unit);
		}
		for (int i = 0; i < destroyUnits.size(); i++) {
			Unit unit = destroyUnits.get(i);
			System.out.println("††††††††††††††††††††††††††††††††††††");
			System.out.println(String.format("†%14s(이)가 파괴되었습니다.    †", unit.name));
			System.out.println("††††††††††††††††††††††††††††††††††††\n");
			units.remove(unit);
		}
	}
}
