package stack_queue.animalShelter;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}

	@Override
	public String name() {
		return "Dog: "+name;
	}

}
