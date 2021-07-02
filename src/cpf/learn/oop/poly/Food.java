package cpf.learn.oop.poly;

/**
 * 食物类
 */
public class Food{
	public String name;//食物有名字

	//构造器
	public Food(){
	}

	public Food(String name){
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
