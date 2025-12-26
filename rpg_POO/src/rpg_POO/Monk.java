package rpg_POO;

public class Monk extends Character{
	public Monk(String name) {
		super(name, 90, 90, 35, 35, "bare hands");
		
		Attack attack = new Attack(30.5f + this.getMagicalAbility(), 25 + this.getMagicalAbility(), this.getWeapon());
		this.setAttack(attack);
	}
	
	public void taunt() {
		System.out.println("* get in their fighting stance *");
		System.out.println(this.getName() + ": You are running out of time...");
	}
}
