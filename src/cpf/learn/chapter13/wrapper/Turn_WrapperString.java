package cpf.learn.chapter13.wrapper;

/**
 * @author CPF 创建于： 2021/6/14 19:25
 * 包装类与String类的相互转换：（还是以Integer为例）
 */
public class Turn_WrapperString{
	public static void main(String[] args){
		//包装类(Integer) <---> String
		//1.Integer ---> String
		Integer integer1 = 1;//自动装箱
		String s1 = integer1 + "";              //(1) + ""
		String s2 = integer1.toString();        //(2) Integer.toString()
		String s3 = String.valueOf(1);          //(3) String.valueOf(int)方法

		//2.String ---> Integer
		String s4 = "1234";
		Integer integer2 = 0;
		try{
			integer2 = Integer.parseInt(s4);    //(1) Integer.parseInt(String)方法
		}catch(NumberFormatException e){
			e.printStackTrace();
		}

		Integer integer3 = new Integer(s4);    //(2) Integer(String)构造器

		Integer integer4 = Integer.valueOf(s4);//(3) Integer.valueOf(String)方法

	}//end main
}
