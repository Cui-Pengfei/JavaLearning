package cpf.learn.chapter12.exceptionHandle;

import java.util.Scanner;

/**
 * @author CPF 创建于： 2021/6/13 18:53
 * try{
 *
 * }finally{
 *
 * }
 * 这相当于没有捕获异常，因此程序会直接崩溃掉，等效于直接把异常抛给jvm;
 * 应用场景：执行一段代码后，不管怎么样，我都要做一些善后工作，可以匹配一些业务逻辑，底层较常用
 */
public class TryFinally{
	public static void main(String[] args){
		int a = 99;
		int b = 999;
		Scanner scanner = new Scanner(System.in);
		try{
			a = scanner.nextInt();
			b = scanner.nextInt();
		}finally{
			scanner.close();
			System.out.println(b/(double)a);
			//这样的逻辑就是：一开始的初值就是默认值，输入失败就用默认值
		}
	}
}
