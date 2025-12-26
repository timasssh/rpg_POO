package rpg_POO;

public class Mage extends Character{
	public Mage(String name) {
		super(name, 60, 130, 25, 40, "magical staff/wand");
		
		Attack attack = new Attack(30.5f + this.getMagicalAbility(), 25 + this.getMagicalAbility(), this.getWeapon());
		this.setAttack(attack);
	}
	
	public void taunt() {
		System.out.println(this.getName() + ": I'll burn you");
	}
}
