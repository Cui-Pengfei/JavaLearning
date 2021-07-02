package cpf.learn.chapter10.exercise;

/**
 * @author CPF 创建于： 2021/6/11 18:50
 */
public class Exercise05{
	public static void main(String[] args){
		A a = new A("a");
		a.local();
	}//end main
}

class A{
	private final String NAME;

	public A(String NAME){
		this.NAME = NAME;
	}

	public void local(){
		class B{
			private final String NAME;

			public B(String NAME){
				this.NAME = NAME;
			}

			public void show(){
				System.out.println("B.NAME = " + NAME);
				System.out.println("A.NAME = " + A.this.NAME);
			}
		}//end B
		B b = new B("b");
		b.show();
	}
}
