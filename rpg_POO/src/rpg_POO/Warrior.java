package rpg_POO;

public class Warrior extends Character{

	public Warrior() {
		super(40, 30, 80, 10, "long-sword", 5);
		
		Attack attack = new Attack(60f + this.getMagicalAbility(), 10 + this.getMagicalAbility(), "long-sword");
		this.setAttack(attack);
	}
	
	public void taunt() {
		System.out.println("* brandishing them wielded sword *");
	}
}
