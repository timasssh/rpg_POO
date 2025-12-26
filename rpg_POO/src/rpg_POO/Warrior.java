package rpg_POO;

public class Warrior extends Character{

	public Warrior(String name) {
		super(name, 120, 10, 80, 10, "long-sword");
		
		Attack attack = new Attack(60f + this.getMagicalAbility(), 10 + this.getMagicalAbility(), this.getWeapon());
		this.setAttack(attack);
	}
	
	public void taunt() {
		System.out.println("* brandishing their wielded sword *");
	}
}
