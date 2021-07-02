package cpf.learn.oop.extend_;
/**
 * OverrideIntro.java分支：
 *  3.重写易混淆的点
 */
public class OverrideConfuse{
	public static void main(String[] args){
		//Rose向上转型
		Flower roseUpFlower = new Rose();
		System.out.println(roseUpFlower.name);
		roseUpFlower.statement();
	}
}
//花类
class Flower{
	public String name = "花";

	public void statement(){
		System.out.println("Flower类statement方法...");
	}
}
//玫瑰类
class Rose extends Flower{
	public String name = "玫瑰";

	public void statement(){
		System.out.println("Rose类statement方法...");
	}
}
