package cpf.learn.oop.poly;

public class Cat extends Animal{

	public void miaow(){
		System.out.println("喵喵喵...");
	}

	//构造器
	public Cat(){
	}

	public Cat(String name){
		super(name);
	}
}
