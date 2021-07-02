package cpf.learn.oop.poly;

/**
 * 主人要给动物喂食物
 */
public class Master{
	public String name;

	//喂食方法
	public void feed(Animal animal, Food food){
		System.out.println(this.name + "喂" + animal.name + "吃" + food.name);
	}

	//两个构造器
	public Master(){
	}
	public Master(String name){
		this.name = name;
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
}
