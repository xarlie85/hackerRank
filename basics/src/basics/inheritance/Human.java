package basics.inheritance;

public interface Human {

	public default void walk() {
		System.out.println("human walking");
	}
	
}
