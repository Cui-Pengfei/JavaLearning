package cpf.learn.chapter12.exception_;

/**
 * @author CPF 创建于： 2021/6/12 11:56
 */
public class ExceptionQuickStart{
	public static void main(String[] args){
		int a = 10;
		int b = 0;

		//int res = a / b;  //ArithmeticException
		/*
		1.出现异常，可以使用异常捕获，
		2.快捷键：选中要捕获的代码，ctrl + alt + t 再选中 try catch
		3.进行异常处理后，即使程序出现了异常，会输出异常信息，程序仍然会继续执行下去
		4.默认的异常处理e.printStackTrace();仍然会出现程序崩溃时的输出画面，可以改成
			println(e.getMessage())就很舒服了

		 */
		try{
			int res = a / b;
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("异常！原因：" + e.getMessage());
		}

		System.out.println("我输出了...");

	}//end main
}
