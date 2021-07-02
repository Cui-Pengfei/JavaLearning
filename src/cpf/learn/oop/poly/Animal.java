package cpf.learn.oop.poly;

/**
 * 动物类
 */
public class Animal{
	public String name;//动物都有名字

	//构造器
	public Animal(){
	}

	public Animal(String name){
		this.name = name;
	}

	//get\set方法
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
}
