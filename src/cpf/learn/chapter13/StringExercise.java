package cpf.learn.chapter13;
/**
 * @author CPF 创建于： 2021/6/20 21:21
 */
public class StringExercise{
	public static void main(String[] args){
		String s1 = "cpf";
		Animal a = new Animal(s1);
		Animal b = new Animal(s1);//两个不同的Animal对象
		System.out.println(a == b);//false
		System.out.println(a.equals(b));//false Animal没有重写equals
		System.out.println(a.name == b.name);//true 两个name都指向常量池中的"cpf"

		String s4 = new String("cpf");//堆中的"cpf"
		String s5 = "cpf";//池中的"cpf"
		System.out.println(s1 == s4);//false
		System.out.println(s4 == s5);//false
		String t1 = "hello" + s1;
		//由于不都是字面量，运行时会调用StringBuilder来拼接，因此会new String
		String t2 = "hellocpf";
		System.out.println(t1 == t2);//false
		System.out.println(t1.intern() == t2);//true

	}//end main
}

class Animal{
	String name;

	public Animal(String name){
		this.name = name;
	}
}