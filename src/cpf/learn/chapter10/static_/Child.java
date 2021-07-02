package cpf.learn.chapter10.static_;

public class Child{
	private String name;
	public static int joinNum;

	public void join(){
		System.out.println(name + "加入了游戏...");
		joinNum++;
	}

	//constructor
	public Child(String name){
		this.name = name;
	}

	//set,get
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
}
