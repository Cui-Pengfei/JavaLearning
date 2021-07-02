package cpf.learn.oop.extend_;

public class Teacher extends Person{
	private double salary;

	@Override
	public void say(){
		System.out.println("Teacher override Person...");
	}

	public void teach(){
		System.out.println("Teacher.teach()方法...");
	}
}
