package rpg_POO;

public class Attack {
	private float damage;
	private int manaCost;
	private String weapon;
	
	public float getDamage() {
		return damage;
	}
	public void setDamage(float damage) {
		this.damage = damage;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public Attack(float damage, int manaCost, String weapon) {
		this.damage = damage <= 0f ? 0f : damage;
		this.manaCost = manaCost <= 0 ? 0 : manaCost;;
		this.weapon = weapon;
	}
}
