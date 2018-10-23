package basics.inheritance;

public interface Animal {

	public default void walk() {
		System.out.println("animal walking");
	}
}
