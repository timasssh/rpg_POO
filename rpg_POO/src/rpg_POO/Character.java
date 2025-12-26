package rpg_POO;

import java.util.Random;

public abstract class Character {
	// stats
	private float lifePoints;
	private int manaPoints;
	private boolean alive;

	// character characteristic
	private float maxLifePoints;
	private int maxManaPoints;
	private boolean fullLife;
	private boolean fullMana;
	private String name;

	// combat specific info
	protected float shield;
	protected int dodgeChance;
	private String weapon;
	private int magicalAbility;
	private Attack attack;

	public float getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(float lifePoints) {
		this.lifePoints = lifePoints;
	}
	public int getManaPoints() {
		return manaPoints;
	}
	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	public boolean isAlive() {
		return this.alive;
	}
	public void setAlive(boolean livingStituation) {
		this.alive = livingStituation;
	}
	public float getMaxLifePoints() {
		return maxLifePoints;
	}
	public void setMaxLifePoints(float maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}
	public int getMaxManaPoints() {
		return maxManaPoints;
	}
	public void setMaxManaPoints(int maxManaPoints) {
		this.maxManaPoints = maxManaPoints;
	}
	public boolean isFullLife() {
		return fullLife;
	}
	public void setFullLife(boolean fullLife) {
		this.fullLife = fullLife;
	}
	public float getShield() {
		return shield;
	}
	protected void setShield(float shield) {
		this.shield = shield;
	}
	public boolean isFullMana() {
		return fullMana;
	}
	public void setFullMana(boolean fullMana) {
		this.fullMana = fullMana;
	}
	public int getDodgeChance() {
		return dodgeChance;
	}
	protected void setDodgeChance(int dodgeChance) {
		this.dodgeChance = dodgeChance;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public int getMagicalAbility() {
		return magicalAbility;
	}
	public void setMagicalAbility(int magicalAbility) {
		this.magicalAbility = magicalAbility;
	}
	public Attack getAttack() {
		return attack;
	}
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	protected Character(String name, int maxLifePoints, int maxManaPoints, int shield, int dodgeChance, String weapon, int magicalAbility) {
		this.name = name;
		
		this.maxLifePoints = maxLifePoints >= 0f ? maxLifePoints : 0f;
		this.lifePoints = maxLifePoints;
		
		this.maxManaPoints = maxManaPoints >= 0 ? maxManaPoints : 0;
		this.manaPoints = maxManaPoints;
		
		this.shield = shield >= 0 ? shield : 0;
		this.dodgeChance = dodgeChance >= 0 ? dodgeChance : 0;
		this.fullLife = true;
		this.fullMana = true;
		this.alive = this.lifePoints > 0f ? true : false;
		this.weapon = weapon;
		
		if(this.maxManaPoints <= 10) {
			this.magicalAbility = 10;
		}else if(this.maxManaPoints <= 20) {
			this.magicalAbility = 25;
		}else if(this.maxManaPoints <= 40) {
			this.magicalAbility = 45;
		}else if(this.maxManaPoints <= 60) {
			this.magicalAbility = 65;
		}else if(this.maxManaPoints <= 80) {
			this.magicalAbility = 90;
		}else if(this.maxManaPoints <= 90) {
			this.magicalAbility = 100; 
		}else if(this.maxManaPoints <= 100) {
			this.magicalAbility = 120;
		}
	}
	
	public void die() {
		if(!this.isAlive()) {
			System.err.println("Character is already dead!");
			return;
		}
		
		this.setAlive(false);
		this.setLifePoints(0f);
		
		System.out.println("This character died!");
	}
	public void ressurect() {
		if(this.isAlive()) {
			System.err.println("This character is already alive!");
			return;
		}
		
		this.setAlive(true);
		this.setLifePoints(1f);
		
		System.out.println("This character has been ressurected!");
	}
	
	public void hurt() {
		if(!this.isAlive()) {
			System.err.println("Character is already dead!");
			return;
		}
		
		this.setLifePoints(this.getLifePoints() - 1f);
		if(this.getLifePoints() <= 0f) {
			this.die();
		}
	}
	public void hurt(float damage) {
		if(!this.isAlive()) {
			System.err.println("Character is already dead!");
			return;
		}
		if(damage < 0f) {
			System.err.println("Invalid damage!");
			return;
		}
		
		this.setLifePoints(this.getLifePoints() - damage);
		if(this.getLifePoints() <= 0f) {
			this.die();
		}
	}
	
	public void heal() {
		if(!this.isAlive()) {
			System.err.println("This character is dead!");
			return;
		}
		if(this.getLifePoints() == this.getMaxLifePoints()) {
			System.err.println("This character is already full life!");
			return;
		}
		
		this.setLifePoints(this.getLifePoints() + 1f);
		if(this.isFullLife()) {
			this.setFullLife(true);
		}
	}
	public void heal(float healingValue) {
		if(!this.isAlive()) {
			System.err.println("This character is dead!");
			return;
		}
		if(this.getLifePoints() == this.getMaxLifePoints()) {
			System.err.println("This character is already full life!");
			return;
		}
		if(healingValue < 0) {
			System.err.println("Invalid heal value!");
			return;
		}
		
		this.setLifePoints(this.getLifePoints() + healingValue);
		if(this.isFullLife()) {
			this.setFullLife(true);
		}
	}
	
	public boolean drainMana() {
		if(this.getManaPoints() == 0) {
			System.err.println("This character ran out of mana!");
			return false;
		}
		
		this.setManaPoints(this.getManaPoints() - 1);
		this.setFullMana(false);
		
		return true;
	}
	public boolean drainMana(int drainingValue) {
		if(this.getManaPoints() == 0) {
			System.err.println("This character ran out of mana!");
			return false;
		}
		if(drainingValue < 0) {
			System.err.println("Invalid draining mana value!");
			return false;
		}
		
		this.setManaPoints(this.getManaPoints() - drainingValue);
		this.setFullMana(false);
		
		if(this.getManaPoints() <= 0) {
			this.setManaPoints(0);
		}
		
		return true;
	}
	public void absorveMana() {
		if(this.isFullMana()) {
			System.err.println("This character is already full of mana!");
			return;
		}
		
		this.setManaPoints(this.getManaPoints() + 1);
		
		if(this.getManaPoints() == this.getManaPoints()) {
			this.setManaPoints(this.getMaxManaPoints());
			this.setFullMana(true);
		}
	}
	public void absorveMana(int absorvingValue) {
		if(this.isFullMana()) {
			System.err.println("This character is already full of mana!");
			return;
		}
		if(absorvingValue < 0) {
			System.err.println("Invalid absorving mana value!");
			return;
		}
		
		this.setManaPoints(this.getManaPoints() + absorvingValue);
		
		if(this.getManaPoints() >= this.getManaPoints()) {
			this.setManaPoints(this.getMaxManaPoints());
			this.setFullMana(true);
		}
	}
	
	public void attack() {
		if(this.drainMana(this.getAttack().getManaCost())) {
			System.out.println("Attacking... dealing " + this.getAttack().getDamage() + " damage");
			return;
		}
		
		System.err.println("Insuficient mana...");
	}
	public void defend(Attack attack) {
		float defendedDamage = attack.getDamage() * (this.getShield() / 100);
		
		this.hurt(attack.getDamage() - defendedDamage);
		
		System.out.println("Defended damage: " + defendedDamage);
	}
	public void dodge(Attack attack) {
		Random dodgeDecision = new Random();
		if(dodgeDecision.nextInt(101) <= this.getDodgeChance()) {
			System.out.println("Dodging the attack...");
			return;
		}
		
		System.err.println("Dodge failed!");
		this.hurt(attack.getDamage());
	}
	
	public abstract void taunt();
}
