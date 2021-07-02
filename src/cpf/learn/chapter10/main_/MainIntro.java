package cpf.learn.chapter10.main_;

/**
 * main方法的学习
 *      1.在命令行执行java程序时候，很容易给main方法的参数args赋值。
 *      2.在IDEA中该怎么做呢？
 *          点击右上角的MainIntro小框框，选择 Edit Configurations,
 *          在 program arguments中填入想加入的字符串，每个字符串以空格间隔。
 */
public class MainIntro{
	/**
	 * main方法可以调佣所在类的静态成员，不可以调用非静态成员。
	 * main方法的参数是在java命令执行程序的时候，由外部传入多个字符串，形成的字符串数组，
	 * 这表明外部可以与main方法通信
	 *
	 * @param args 上述所得的那个数组
	 */
	public static void main(String[] args){
		int num = 0;
		for(String arg : args){
			System.out.println("第" + (++num) + "个参数：" + arg);
		}
	}
}
