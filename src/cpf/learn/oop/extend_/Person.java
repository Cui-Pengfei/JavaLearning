package cpf.learn.oop.extend_;

/**
 * 作为人类，超类、父类
 */
public class Person{
	//属性
	public String name;
	public char gender;
	public int age;
	private String idCard;//身份证

	//构造器
	public Person(){
		System.out.println("Person类的无参构造器...");

	}

	public Person(String name, char gender, int age, String idCard){
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.idCard = idCard;
	}

	//说话方法
	public void say(){
		System.out.println("i am Person class...");
	}

	//get\set方法
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public char getGender(){
		return gender;
	}

	public void setGender(char gender){
		this.gender = gender;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public String getIdCard(){
		return idCard;
	}

	public void setIdCard(String idCard){
		this.idCard = idCard;
	}
}
