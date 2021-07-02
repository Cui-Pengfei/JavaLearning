package cpf.learn.chapter11.enum_;

/**
 * @author CPF 创建于： 2021/6/8 17:09
 * 枚举入门:
 * 1.枚举的英文enumeration,简写enum
 * 2.枚举是一种常量的集合
 * 3.可以理解为：枚举属于一种特殊的类，里面只包含一组有限的特定对象
 * 4.实现枚举的两种方式
 ****** 4.1 自定义类实现枚举
 ****** 4.2使用enum关键字实现枚举
 *
 *
 */
public class EnumIntro{
	public static void main(String[] args){
		System.out.println(Season.SPRING);
		System.out.println(Season.SUMMER);
		System.out.println(Season.AUTUMN);
		System.out.println(Season.WINTER);

		System.out.println("=======Season2========");
		System.out.println(Season2.SPRING);
		Season2.SUMMER.setName("夏夏");
		System.out.println(Season2.SUMMER);

	}//end main
}//end class

/*
演示自定义枚举实现:
1.把构造器私有化---->外部无法直接new对象
2.去掉set方法------>外部无法修改属性
3.在类这种创建实例，一般设置为public static final
(虽然此处static final并不能避免类的初始化，但是可以表明这个值是不可修改的)
4.规范：常量值，一般都是大写
 */
class Season{
	private String name;
	private String desc;

	static {
		System.out.println("Season2类的初始化...");
	}

	public static final Season SPRING = new Season("春天", "凉爽");
	public static final Season SUMMER = new Season("夏天", "炎热");
	public static final Season AUTUMN = new Season("秋天", "萧索");
	public static final Season WINTER = new Season("冬天", "寒冷");

	private Season(String name, String desc){
		this.name = name;
		this.desc = desc;
	}

	public String getName(){
		return name;
	}
	public String getDesc(){
		return desc;
	}

	@Override
	public String toString(){
		return "Season{" +
				"name='" + name + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}
}//end Season

/*
演示enum关键字实现枚举：
1.用关键字enum来代替class
2.枚举类的构造器默认private类型
3.枚举类实例的定义必须是枚举类体的第一行代码
4.枚举类实例的创建很特殊：实例名(构造器参数列表)
5.枚举类各个实例之间用逗号隔开，整句话有分号结束
6.枚举类内的事例属性，默认都是public static final的
 */

enum Season2{
	SPRING("春天", "温暖"),
	SUMMER("夏天", "炎热"),
	AUTUMN("秋天", "萧瑟"),
	WINTER("冬天", "寒冷"),
	TEST;
	//如果调用无参构造器，连括号都可以省略

	private String name;
	private String desc;

	static {
		System.out.println("Season类的初始化...");
	}

	//两个构造器
	Season2(){
		System.out.println("Season2无参构造器调用....");
	}
	Season2(String name, String desc){
		this.name = name;
		this.desc = desc;
		System.out.println("Season2有参构造器调用....");
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDesc(){
		return desc;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}

	@Override
	public String toString(){
		return "Season{" +
				"name='" + name + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}
}
