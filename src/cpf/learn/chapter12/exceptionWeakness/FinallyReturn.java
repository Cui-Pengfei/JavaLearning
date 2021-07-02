package cpf.learn.chapter12.exceptionWeakness;

/**
 * @author CPF 创建于： 2021/6/14 3:18
 * 这是丢失异常最明显的例子：
 * 缺失catch语句时，若finally中又有返回语句，try中存在的异常就不会被抛出
 */
public class FinallyReturn{
	public static void main(String[] args){
		try{
			throw new RuntimeException();
		}
		finally{
			return;//由于finally优先于catch执行，就先返回方法了，没有抛出异常
		}
	}//end main
}
