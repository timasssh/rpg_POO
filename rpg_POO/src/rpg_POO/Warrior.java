package rpg_POO;

import java.util.Random;

public class Warrior extends Character{

	public Warrior(int maxLifePoints, int maxManaPoints, String characterType) {
		super(maxLifePoints, maxManaPoints, characterType);
		this.setShield(90);
		this.setDodgeChance(20);
	}
	
	public void attack() {
		if(this.drainMana()) {
			System.out.println("Attacking...");
			return;
		}
	}
	public void defend() {
		System.out.println("Defending...");
	}
	public void dodge() {
		Random dodgeDecision = new Random();
		if(dodgeDecision.nextInt(100) <= this.getDodgeChance()) {
			System.out.println("Dodging the attack...");
			return;
		}
		
		System.out.println("Dodge failed!");
	}
}
