package cpf.learn.oop.poly;

public class Dog extends Animal{

	public void bark(){
		System.out.println("汪汪汪...");
	}

	//构造器
	public Dog(){
	}

	public Dog(String name){
		super(name);
	}
}
