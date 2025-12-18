package rpg_POO;

public abstract class Character {
	private int maxLifePoints;
	private int lifePoints;
	private int manaPoints;
	private int maxManaPoints;
	protected int shield;
	protected int dodgeChance;
	private boolean fullLife;
	private boolean fullMana;
	private String characterType;
	private boolean alive;
	
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
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
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	public void setMaxLifePoints(int maxLifePoints) {
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
	public String getCharacterType() {
		return characterType;
	}
	public void setCharacterType(String characterType) {
		this.characterType = characterType;
	}
	public int getShield() {
		return shield;
	}
	protected void setShield(int shield) {
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
	
	protected Character(int maxLifePoints, int maxManaPoints, String characterType) {
		this.maxLifePoints = maxLifePoints;
		this.lifePoints = maxLifePoints;
		
		this.maxManaPoints = maxManaPoints;
		this.manaPoints = maxManaPoints;
		
		this.shield = 0;
		this.dodgeChance = 0;
		this.fullLife = true;
		this.fullMana = true;
		this.characterType = characterType;
		this.alive = true;
	}
	
	public void die() {
		if(!this.isAlive()) {
			System.err.println("Character is already dead!");
			return;
		}
		
		this.setAlive(false);
		this.setLifePoints(0);
		
		System.out.println("This character died!");
	}
	public void ressurect() {
		if(this.isAlive()) {
			System.err.println("This character is already alive!");
			return;
		}
		
		this.setAlive(true);
		this.setLifePoints(1);
		
		System.out.println("This character has been ressurected!");
	}
	
	public void hurt() {
		if(!this.isAlive()) {
			System.err.println("Character is already dead!");
			return;
		}
		
		this.setLifePoints(this.getLifePoints() - 1);
		if(this.getLifePoints() <= 0) {
			this.die();
		}
	}
	public void hurt(int damage) {
		if(!this.isAlive()) {
			System.err.println("Character is already dead!");
			return;
		}
		if(damage < 0) {
			System.err.println("Invalid damage!");
			return;
		}
		
		this.setLifePoints(this.getLifePoints() - damage);
		if(this.getLifePoints() <= 0) {
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
		
		this.setLifePoints(this.getLifePoints() + 1);
		if(this.isFullLife()) {
			this.setFullLife(true);
		}
	}
	public void heal(int healingValue) {
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
	public void absorveManaint() {
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
	public void absorveManaint(int absorvingValue) {
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
	
	public abstract void attack();
	public abstract void defend();
	public abstract void dodge();
}
