package cpf.learn.chapter10.innerClass;

/**
 * 匿名内部类的最佳实践：
 *      1.作为参数，属于软编码，灵活性更高，对于只用一次的代码很方便
 *
 *
 */
public class UseOfInnerClass{
	public static void main(String[] args){
		use(new IG(){
			@Override
			public void show(){
				System.out.println("我是匿名内部类，此时是参数，重写了show方法...");
			}
		});
	}//end main

	public static void use(IG ig){
		ig.show();
	}
}

interface IG{
	void show();
}
