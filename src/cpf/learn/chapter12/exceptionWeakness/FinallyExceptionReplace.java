package cpf.learn.chapter12.exceptionWeakness;

/**
 * @author CPF 创建于： 2021/6/14 3:33
 */
public class FinallyExceptionReplace{
	public static void main(String[] args){
		try{
			try{
				throw new ArithmeticException();//这个会被finally中的异常抛出代替掉
			}finally{
				//由于finally优先于catch执行，执行完finally后就会catch到一个新的异常，
				//这个新异常new RuntimeException()覆盖了try内的异常
				throw new RuntimeException();//只会抛出这个异常
			}

		}catch(Exception e){
			System.out.println(e);
		}
	}
}
