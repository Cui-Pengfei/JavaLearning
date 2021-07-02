package cpf.learn.chapter15.custom;

/**
 * @author CPF 创建于： 2021/6/30 0:24
 * 自定义泛型的细节：
 * 1. 普通成员也可以使用泛型
 * 2. 使用泛型的数组不能初始化 因为泛型 T 还不确定是什么类型，不能直接实例化；
 * 3. 静态方法中不能使用类的泛型
 *     因为泛型类型的确定是在实例化对象的时候，但是静态方法在类加载时就要加载静态域；
 * 4. 泛型类的类型是在创建对象的时候确定的（因为创建对象时，需要指定特定的类型）
 * 5.
 */
public class GenericCustom{
	public static void main(String[] args){

		Bag<String> bag = new Bag<>();



	}//end main
}

class Bag<T>{
	private T[] content;

	public int size(){
		return content == null ? 0 : content.length;
	}

	public void show(){
		if(content == null) return;
		System.out.print("bag{ ");
		for(int i = 0; i < content.length; i++){
			System.out.print(content[i] +" ");
		}
		System.out.println("}");
	}

	public boolean add(T t){
		if(content == null){

		}
		return true;
	}
}
