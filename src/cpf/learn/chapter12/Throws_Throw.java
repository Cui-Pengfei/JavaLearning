package cpf.learn.chapter12;

/**
 * @author CPF 创建于： 2021/6/14 15:47
 * throws VS throw:
 * 1.throws是异常处理的一种方式（抛出异常），位于【方法声明处】，后面跟【异常类型】
 * 2.throw是手动生成异常对象的关键字，位于【方法体中】，后面跟【异常对象】
 */
public class Throws_Throw{
	public static void main(String[] args) throws Exception{
		int a = -1;
		int aa = 1;
		int b = 1;
		int bb = 10;
		int c = 1;


		isTriangle(a,b,c);


	}

	//由于这个异常无法判断是否是运行时异常，所以必须显示地抛出
	private static void isTriangle(int a, int b, int c) throws Exception{
		if(a < 0 || b < 0 || c < 0){
			throw new Exception("三条边不能为负数");
		}
		if(!(a + b > c || a + c > b || b + c > a)){
			throw new Exception("三角形两边之和必须大于第三边");
		}

		System.out.printf("a = %d, b = %d, c = %d", a, b, c);
	}
}
