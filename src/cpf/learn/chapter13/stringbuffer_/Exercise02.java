package cpf.learn.chapter13.stringbuffer_;

import java.util.Scanner;

/**
 * @author CPF 创建于： 2021/6/17 20:54
 */
public class Exercise02{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入商品名称：");
		String name = scanner.next();
		System.out.print("请输入商品价格：");
		String price = scanner.next();
		//对输入的价格进行合法判断(字符串内只能有数字和小数点)
		if(!isLegalDouble(price)){
			System.out.println("输入的价格不合法！");
			return;
		}

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(price);

		int pointIndex = stringBuffer.indexOf(".");//获得小数点的位置
		//1324254.2
		//1324,254.2
		int pointComma = pointIndex - 3;//从尾部到头部来打逗号
		while(pointComma > 0){
			stringBuffer.insert(pointComma, ',');
			pointComma -= 3;//每三个小数点前数字，打一个逗号
		}
		System.out.println("商品名称\t\t商品价格");
		System.out.println(name + "\t\t" + stringBuffer);

	}

	public static boolean isLegalDouble(String s){
		//'0' = 48 '9' = 57 '.' = 46
		int commaNum = 0;
		for(int index = 0; index < s.length(); index++){
			char thisChar = s.charAt(index);
			if((thisChar < '0' && thisChar != '.') || thisChar > '9'){
				return false;
			}else if(thisChar == '.'){
				commaNum++;
			}
			if(commaNum > 1) return false;
		}
		return true;
	}
}
