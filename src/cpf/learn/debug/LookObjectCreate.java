package cpf.learn.debug;

/**
 * 1.用断点调试来看一下类是如何创建的，包含构造器
 * 2.用断点调试看动态绑定机制的运行
 */
public class LookObjectCreate{
	public static void main(String[] args){

		Animal animal = new Animal();

		Animal a = new Fish();
		a.move();

	}
}

class Animal{
	public String name;
	public String talent;

	public void move(){
		System.out.println("i can move...");
	}

	//两个构造器
	public Animal(){
		name = "animal";
		talent = "canMove";
	}
	public Animal(String name, String talent){
		this.name = name;
		this.talent = talent;
	}
}

class Fish extends Animal{

	public Fish(){
		name = "fish";
		talent = "swim";
	}

	@Override
	public void move(){
		System.out.println("i can swim...");
	}
}

