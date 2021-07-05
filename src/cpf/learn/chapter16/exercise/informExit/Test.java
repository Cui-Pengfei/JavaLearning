package cpf.learn.chapter16.exercise.informExit;

/**
 * @author CPF 创建于： 2021/7/5 9:21
 * @version 1.0
 */
public class Test{
	public static void main(String[] args) throws InterruptedException{
		Count count = new Count();
		Master master = new Master(count);

		count.start();
		master.start();

	}
}
