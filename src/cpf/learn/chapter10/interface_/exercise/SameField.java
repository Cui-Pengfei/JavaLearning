package cpf.learn.chapter10.interface_.exercise;

/**
 * 一个类可以继承类、实现接口。
 * 1>父类、接口拥有同名属性，一个类继承、实现他们，这个类继承哪一个呢？
 * 两个都会继承，在属性的不同域中，接口默认public static final,直接通过接口名引用它，
 * 父类通过super引用同名属性，这样就不会出错
 * 2>一个类实现多个接口，多个接口中有同名属性
 * 这个类会继承所有属性，引用时采取 接口名.属性名 来区别
 */
public class SameField{
	public static void main(String[] args){
		S s = new S();
		//Reference to 'x' is ambiguous, both 'F.x' and 'I.x' match
		//System.out.println(s.x);//出错信息如上
		s.pX();
	}//end main
}

interface I{
	int x = 0;
}

interface T{
	int x = 2;
}

class F{
	int x = 1;
}

class S extends F implements I{
	public void pX(){
		System.out.println(I.x);
		System.out.println(super.x);
	}

}

class Two implements I, T{
	public void pX(){
		System.out.println(I.x);
		System.out.println(T.x);
	}
}
