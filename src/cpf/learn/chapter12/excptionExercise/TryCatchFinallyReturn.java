package cpf.learn.chapter12.excptionExercise;

/**
 * @author CPF 创建于： 2021/6/13 19:44
 * 0.return必须位于任何代码块的最后位置，这是由编译器决定的
 * 1.若try中有return语句，若return语句执行，说明没有异常，没有catch什么事情了，
		* 若finally中有语句要执行，try此处的return值先保存在temp变量中
		* 若finally语句执行完，没有在最后看到新的renturn语句，那么就回到try返回刚才保存的temp
		* 若finally最后有return语句，一律执行finally的返回语句
 * 2.若catch内有return语句，说明try中有异常，就没有try什么事情了
        * 若finally中有语句要执行，catch此处的return值先保存在temp变量中
  		* 若finally语句执行完，没有在最后看到新的renturn语句，那么就回到catch返回刚才保存的temp
  		* 若finally最后有return语句，一律执行finally的返回语句
 * 3.若finally中有return语句，那就是最高优先级，最后返回的肯定以这个为主
 */
public class TryCatchFinallyReturn{
	public static void main(String[] args){
		System.out.println(method());
	}

	public static int method(){
		int i = 0;
		try{
			i = 1;
			return i;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return ++i;
		}
	}
}
