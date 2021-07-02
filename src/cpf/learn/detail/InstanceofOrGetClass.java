package cpf.learn.detail;

/**
 * 1.instanceof:
 * 1.1 object instanceof Class          判断某个对象的运行类型
 * 2.isInstance
 * 2.1 Class.class.isInstance(object)   判断某对象的运行类型，与上述过程相反
 * 3.getClass
 * 3.1 object.getClass() == Class.class
 */
public class InstanceofOrGetClass{
	public static void main(String[] args) throws ClassNotFoundException{
		/*
		Person person = new Person();
		Student wang = new Student();

		System.out.println(person.getClass());
		System.out.println(wang.getClass());
		System.out.println(Person.class);
		//System.out.println(Person);//不允许该语法出现

		//1.1
		System.out.println(person instanceof Student);//人类不是学生
		System.out.println(wang instanceof Person);//学生是人类 语法是符合逻辑的

		//2.1
		System.out.println(Student.class.isInstance(wang));

		//3.1
		System.out.println(Student.class == wang.getClass());
		System.out.println(wang.getClass() == Student.class);//true
		//System.out.println(wang.getClass() == Person.class);//不可以比较
		System.out.println(wang.getClass().equals(Person.class));//false
		System.out.println(wang.getClass().equals(String.class));//false
				*/
/*
		由此得出区别：
			instanceof可以做逻辑判断，他接受继承，学生 instanceof 人 结果为true
			object.getClass() == Class.class 可以同类比较，继承都不行
			object.getClass().equals(Class.class);无论什么类都可以比较，但只有同类返回true
		 */		/*

		*/
		Fish fish = new Fish();
		Person person = new Person();
		Student jack = new Student();
		System.out.println(jack.getClass());

		System.out.println(person.getClass() == Person.class);//true
		System.out.println(person.getClass() == jack.getClass());//false
		System.out.println(person.getClass() == Student.class);//false
		System.out.println(jack.getClass() == Student.class);
		//System.out.println(jack.getClass() == Person.class);//编译通过，运行错误
		//System.out.println(person.getClass() == Fish.class);//连编译都无法通过
		//System.out.println(Person.class == Fish.class);//编译无法通过
		//System.out.println(fish.getClass() == person.getClass());//编译无法通过

		System.out.println(jack.getClass() == Class.forName("cpf.learn.detail.Person"));

		System.out.println(jack.getClass().equals(Person.class));
		System.out.println(jack.getClass().equals(Fish.class));
		System.out.println(Person.class.equals(Fish.class));


	}
}

class Person{//人类
}
class Student extends Person{//学生继承人类
}
class Fish{//鱼类 无关系的第三方类
}
