package cpf.learn.chapter12.exercise;

/**
 * @author CPF 创建于： 2021/6/14 15:57
 * a)编写应用程序EcmDef.java，接收命令行的两个参数(整数)，计算两数相除。
 * b)计算两个数相除，要求使用方法cal(int n1, int n2)
 * c)对数据格式不正确、缺少命令行参数、除0进行异常处理。
 */
public class Exercise01{
	public static void main(String[] args){//要对main方法参数列表进行检查
		if(args.length == 0 || args.length == 1){
			//args没有元素时居然也不是空 它的值是{},不为空，只能用长度判断
			throw new MissCmdParameterException("缺少命令行参数");
		}else{
			if(args.length == 2){
				int n1 =1, n2 = 1;//编译器必须要求初始化，不然无法使用，搞不懂
				double result;
				try{
					n1 = Integer.parseInt(args[0]);
					n2 = Integer.parseInt(args[1]);
				}catch(NumberFormatException e){
					//这招叫作 借鸡生蛋
					throw new IncorrectDataFormatException("数据格式不正确");
				}
				result = cal(n1,n2);
				System.out.println("除法结果是：" + result);
			}else{//参数>2
				throw new IncorrectDataFormatException
						("数据格式不正确，命令行参数只能是2个");
			}
		}

	}

	public static double cal(int n1, int n2){
		double res = 0;
		try{
			res = n1 / n2;//把除0异常的捕获放在cal方法中，防止main中过于臃肿
		}catch(ArithmeticException e){
			throw new ArithmeticException("除数不能为0");
			//这里不抛出异常的话，main中的输出语句就会输出
		}
		return res;
	}
}

class IncorrectDataFormatException extends RuntimeException{//数据格式不正确
	public IncorrectDataFormatException(String message){
		super(message);
	}
}

class MissCmdParameterException extends RuntimeException{//缺少命令行参数
	public MissCmdParameterException(String message){
		super(message);
	}
}
