package basics.statics;

public interface Person extends Animal<String>, Human<String> {

	default String walk(String s) {
		return Animal.super.walk(s);
	}
	
}
