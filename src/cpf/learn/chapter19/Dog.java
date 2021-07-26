package cpf.learn.chapter19;

/**
 * @author CPF 创建于： 2021/7/23 14:14
 * @version 1.0
 */
public class Dog{
	public static String type = "犬科";
	public String color = "黄色";
	protected String talent = "看门";
	boolean isLive = true;
	private String name = "旺财";

	public static void staticMethod(){
		System.out.println("我是静态方法....");
	}

	public Dog(){
	}

	public Dog(String name){
		this.name = name;
	}

	public Dog(String name, String color){
		this.color = color;
		this.name = name;
	}

	protected Dog(boolean isLive){
		this.isLive = isLive;
	}

	private Dog(String name, boolean isLive){
		this.name = name;
		this.isLive = isLive;
	}

	public void cry(){
		/*System.out.println(name + "汪汪汪！");*/
	}

	public void purpose(){
		System.out.println(name + "想繁殖！");
	}

	private void hobby(){
		System.out.println(name + "爱啃骨头！");
	}

	@Override
	public String toString(){
		return "Dog{" +
				"color='" + color + '\'' +
				", talent='" + talent + '\'' +
				", isLive=" + isLive +
				", name='" + name + '\'' +
				'}';
	}
}
