package cpf.learn.debug;

/**
 * 介绍断点调试的运用与掌握...
 *
 * 以下快捷键均能在keymap内修改
 *      0.  alt + d       选择进入调试、进入下一个断点
 *          源码也可以在调试时下断点，而且有时候，我们故意在下面某个地方下个断点，
 *          看看目前的业务逻辑是否可以进入那个断点（也就是是否可以运行到那里），
 *          这对于复杂的代码分析无疑是帮助巨大的。
 *      0.  ctrl+shift+d  直接进入本页面调试，不用选择，推荐使用该快捷方式，上面的就只用来移到下一个断点
 *      0.  alt + s       结束调试
 *      1.  1       逐条执行        step into
 *      2.  2       跳过方法        step over
 *      3.  3       跳出方法        step out
 *      4.  4       强制进入        force step into 因为，系统方法使用step into不会自动进入
 *
 *
 *  step into无法进入源码类的解决方法：
 *      1. force step into可以解决
 *      2. 配置IDEA
 *          2.1 进入：setting > Build,Execution,Deployment > Debugger > setting
 *          2.2 右边有一个 "do not step into the class"
 *          2.3 取消勾选 java.* javax.*
 *
 *
 */
public class DebugIntro{
	public static void main(String[] args){

		int i = 7;
		double d = 1.0;
		String purpose = "debug调试";

		int destination = 10;
		int sum = add(destination);

		System.out.println("sum = " + sum);

	}

	static public int add(int destination){
		int add = 0;
		for(int i = 1; i <= destination; i++){
			add += i;
		}
		return add;
	}
}
