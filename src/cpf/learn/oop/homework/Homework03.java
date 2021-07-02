package cpf.learn.oop.homework;

public class Homework03{
	public static void main(String[] args){
		Teacher teacher = new Teacher("王老师", 34, "主任" , 4900);
		teacher.introduce();

		Professor professor = new Professor("李教授", 66, "正教授", 8900);
		professor.introduce();
	}
}

class Teacher{
	private String name;
	private int age;
	private String post;
	private double salary;

	//输出基本信息，通过调用toString很简便不用自己写了
	public void introduce(){
		System.out.println("Teacher{" +
				"name='" + name + '\'' +
				", age=" + age +
				", post='" + post + '\'' +
				", salary=" + salary +
				'}');
	}

	//constructor
	public Teacher(){
	}
	public Teacher(String name, int age, String post, double salary){
		this.name = name;
		this.age = age;
		this.post = post;
		this.salary = salary;
	}

	//get、set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getPost(){
		return post;
	}
	public void setPost(String post){
		this.post = post;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
}

class Professor extends Teacher{
	@Override
	public void introduce(){
		setSalary(1.3 * getSalary());
		super.introduce();
	}

	//constructor
	public Professor(String name, int age, String post, double salary){
		super(name, age, post, salary);
	}
}
