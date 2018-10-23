package basics.inheritance;

public interface Person extends Animal, Human {

	default void walk() {
		Animal.super.walk();
	}
	
	
}
