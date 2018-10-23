package basics.inheritance;

public class Capullo implements Human, Animal {

	public void walk() {
		Animal.super.walk();
	}

}
