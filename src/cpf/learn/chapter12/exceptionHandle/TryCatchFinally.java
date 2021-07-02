package cpf.learn.chapter12.exceptionHandle;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author CPF 创建于： 2021/6/13 16:40
 *
 * try{
 *      1.怀疑会出现异常的代码;
 *      2.如果try有多条语句，从有异常的那条语句开始，下面的都不执行了
 *      3.如果没有异常，那么try会顺序执行，catch不执行
 * }catch(Exception e){
 *      1.若有异常出现，catch块才执行
 *      2.系统将异常随机应变地封装成不同的Exception对象e，传递给catch，程序员可以写自己的逻辑
 * }catch{
 *     1.可以有多个catch语句；
 *     2.这多个catch语句必须按照子类Exception在前，父类Exxception在后
 *     3.多个catch语句只会匹配一个，从上往下，匹配到哪个就不再往下匹配了
 * }
 * finally{
 *      0.finally内的程序执行顺序：是在catch的执行之后，在方法抛出异常之前
 *      1.不管是否捕获到异常，finally都要执行;
 *      2.一般处理try中资源关闭的步骤，因为如果不写入finally，一旦出现异常，
 *        程序便不会继续执行下去，这样被霸占的资源就失去了释放的机会，长此以往，消耗资源
 *      3.不管怎么样，finally都会执行，即使try catch语句块内有return语句，仍然会执行finally
 *      4.当try catch finally语句体内有retuurn语句时，分为多种情况，要谨慎小心：
 *        详情请查看：TryCatchFinallyReturn.java
 *
 * }
 */
public class TryCatchFinally{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int receive = 0;

		try{
			System.out.print("请输入整数：");
			receive = scanner.nextInt();//这句异常后，try便从这里结束，进入catch中
			System.out.println("如果输入异常，我是不会被输出的...");
		}catch(InputMismatchException e){
			System.out.println("输出匹配错误：");
			e.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("hello");
		}finally{
			System.out.println("finally执行...");
			scanner.close();
		}

	}
}
