package featuremethods;

public interface Animal {
	public void eat();

	default void defaultMethod() {
		System.err.println("this is default method");
	}

	static void staticMethod() {
		System.err.println("this is static method");
	}

}

class Human implements Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Human human = new Human();
		human.defaultMethod();
		Animal.staticMethod();
	}

}