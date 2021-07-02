package cpf.learn.chapter10.exercise;

/**
 * @author CPF 创建于： 2021/6/11 18:26
 */
public class Exercise04{
	public static void main(String[] args){
		CellPhone cellPhone = new CellPhone();
		double result = cellPhone.testWork(new Computable(){
			@Override
			public double work(double a, double b){
				return a + b;
			}
		}, 1, 2);
		System.out.println(result);
	}//end main
}

interface Computable{
	double work(double a, double b);
}

class CellPhone{
	public double testWork(Computable computable, double a, double b){
		return computable.work(a, b);
	}
}
