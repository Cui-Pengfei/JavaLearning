package cpf.learn.chapter12.exercise;

/**
 * @author CPF 创建于： 2021/6/14 17:47
 */
public class Exercise02{
	public static void main(String[] args){
		try{
			showException();
			System.out.println("A");
		}catch(RuntimeException e){
			System.out.println(e.getMessage());//1
			System.out.println("B");//2
		}finally{
			System.out.println("C");//3
		}

		System.out.println("D");//4
	}//end main

	/* 最终输出：
	运行时异常
	B
	C
	D
	 */

	public static void showException(){
		throw new RuntimeException("运行时异常");
	}
}
