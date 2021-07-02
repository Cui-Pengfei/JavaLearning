package cpf.learn.chapter10.exercise;
/**
 * @author CPF 创建于： 2021/6/11 18:17
 */
public interface Animal{
	public static void main(String[] args){
		Animal dog  = new Dog();
		Animal cat = new Cat();
		dog.shout();
		cat.shout();
	}
	public abstract void shout();
}

class Dog implements Animal{
	@Override
	public void shout(){
		System.out.println("小狗汪汪叫...");
	}
}

class Cat implements Animal{
	@Override
	public void shout(){
		System.out.println("小猫喵喵叫...");
	}
}
