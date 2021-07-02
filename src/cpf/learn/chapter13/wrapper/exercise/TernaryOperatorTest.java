package cpf.learn.chapter13.wrapper.exercise;

/**
 * @author CPF 创建于： 2021/6/14 19:16
 */
public class TernaryOperatorTest{
	public static void main(String[] args){
		Object object = true ? new Integer(1) : new Double(2.0);
		/*
		由于三元运算符是一个整体，
		new Double(2.0)就像参与运算的一部分，虽然没有选择它，但是它也对结果精度造成影响，
		他提高了整体的精度，使之到达double,
		因此最后等价于 Object object = new Double(1.0);
		 */
		System.out.println(object.getClass());//class java.lang.Double
		System.out.println(object);//1.0


		Object object1;
		if(true){
			object1 = new Integer(1);
		}else{
			object1 = new Double(2.0);//显然if else就不是一个整体了
		}
		System.out.println(object1.getClass());
		System.out.println(object1);//1
	}//end main
}
