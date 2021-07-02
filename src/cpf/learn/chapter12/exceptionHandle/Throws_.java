package cpf.learn.chapter12.exceptionHandle;

/**
 * @author CPF 创建于： 2021/6/13 17:01
 * 1.异常要么在本地被捕获，要么向上级抛出，二选一；
 * 2.默认的是throws
 * 3.顶级的处理者是jvm，他不能再把异常抛出了，直接输出异常信息，退出程序
 * 4.若大家都没有使用throws关键字，那就是默认往顶层抛出，一旦有人明确使用throws，那么从此往上，
 *  都必须显性地使用throws才能抛出异常，否则就要承担捕获异常的责任，否则编译出错。
 */
public class Throws_{
	public static void main(String[] args){
		int a = 1;
		int b = 0;
		double result = divide(a, b);
		System.out.println(result);
	}

	public static double divide(int a, int b){
		try{
			return div(a, b);
		}catch(ArithmeticException e){
			e.printStackTrace();
		}finally{
			return 0.0;
		}
	}

	public static double div(int a, int b) throws Exception{
		return a / b;
	}
}
