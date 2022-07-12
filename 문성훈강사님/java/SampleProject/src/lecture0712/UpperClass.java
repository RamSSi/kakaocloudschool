package lecture0712;

public abstract class UpperClass {
	// field
	String name;
	int age;
	
	// method
	public abstract void printAll();	// Abstract method
	
}

class subClass extends UpperClass {
	public void printAll() {
	}
}