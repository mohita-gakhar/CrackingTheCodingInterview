package stack_queue.animalShelter;

import java.util.LinkedList;

public class AnimalQueue {
	
	private LinkedList<Cat> cats = new LinkedList<>();
	private LinkedList<Dog> dogs = new LinkedList<>();
	private int order;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Dog) {
			dogs.addLast((Dog)a);
		}else if(a instanceof Cat){
			cats.addLast((Cat) a);
		}
	}
	
	public Animal dequeueAny() {
		if(dogs.size() ==0) {
			return dequeueCat();
		}else if (cats.size() ==0) {
			return dequeueDog();
		}
		
		Cat cat = cats.peek();
		Dog dog = dogs.peek();
		if(dog.isOlderThan(cat)) {
			return dogs.poll();
		}else {
			return cats.poll();
		}			
	}
	
	public Animal peek() {
		if(dogs.size() ==0) {
			return peekCat();
		}else if(cats.size() ==0) {
			return peekDog();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)) {
			return dog;
		}else {
			return cat;
		}
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
	
	public Dog dequeueDog() {
		return dogs.poll();
	}
	
	public int size() {
		return dogs.size()+cats.size();
	}
	
	public Dog peekDog() {
		return dogs.peek();
	}
	
	public Cat peekCat() {
		return cats.peek();
	}

	public static void main(String[] args) {
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("Callie"));
		animals.enqueue(new Cat("Kiki"));
		animals.enqueue(new Dog("Fido"));
		animals.enqueue(new Dog("Dora"));
		animals.enqueue(new Cat("Kari"));
		animals.enqueue(new Dog("Dexter"));
		animals.enqueue(new Dog("Dobo"));
		animals.enqueue(new Cat("Copa"));
		
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog("Dapa"));
		animals.enqueue(new Cat("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}

}
