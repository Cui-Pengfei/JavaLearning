package cpf.learn.oop.extend_;

/**
 * 介绍继承的本质
 */
public class ExtendsTheory{

	public static void main(String[] args){

		Son son = new Son();
		//当访问父类同名的属性时，规则是【就近原则】,不能访问就报错，因权限不能访问不会向上再找...
		//就算父类的同名属性是private，子类仍然具有这个属性，只是不能直接访问...
		System.out.println(son.name);
		System.out.println();

		//会报错，因为在Father中就找到了age，不会继续向上找，但由于Father中的是private访问不到就报错
		//System.out.println(son.age);

		//虽然是同名，但由于是不同类中的属性，并不会相互覆盖，而是都存在于son对象中，等待依靠方法来访问
		System.out.println(son.getGrandpaName());
		System.out.println(son.getGrandpaAge());
		System.out.println(son.hobby);
		System.out.println();

		System.out.println(son.getFatherName());
		System.out.println(son.getFatherAge());





	}//end main

}//end class

//Grandpa类
class Grandpa{//爷爷类
	public String name = "牛爷爷";
	public String hobby = "旅游";
	public int age = 66;

	public int getAge(){
		return age;
	}

}

//Father类
class Father extends Grandpa{
	public String name = "小头爸爸";
	private int age = 35;

	public String getFatherName(){
		return super.name;
	}

	public int getAge(){
		return age;
	}

	public int getFatherAge(){
		return super.getAge();
	}
}

//Son类
class Son extends Father{
	public String name = "大头儿子";

	public String getFatherName(){
		return super.name;
	}

	public String getGrandpaName(){
		return super.getFatherName();
	}

	public int getFatherAge(){
		return super.getAge();
	}

	public int getGrandpaAge(){
		return super.getFatherAge();
	}
}