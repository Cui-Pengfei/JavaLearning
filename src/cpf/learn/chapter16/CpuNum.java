package cpf.learn.chapter16;

/**
 * @author CPF 创建于： 2021/7/2 12:34
 * @version 1.0
 * 通过java查看电脑cpu核数
 */
public class CpuNum{
	public static void main(String[] args){

		Runtime runtime = Runtime.getRuntime();

		int cpuNum = runtime.availableProcessors();

		System.out.println("cpu的核心数 = " + cpuNum);


	}//end main
}
