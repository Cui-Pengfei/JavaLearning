package cpf.learn.chapter12.excptionExercise;

/**
 * @author CPF 创建于： 2021/6/13 19:08
 */
public class Exercise01{
	public static int method(){
		try{
			String[] names = new String[3];//String数组
			if(names[1].equals("tom")){//NullPointerException
				System.out.println(names[1]);
			}else{
				names[3] = "cpf";
			}
			return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			return 2;
		}catch(NullPointerException e){//捕获
			return 3;//第一步先执行return 3 用temp保存这个要返回的值，若finally内没有返回值，
					 //便会返回该值，这个值在此步会被保存，等待新的返回值替代 或 就返回该值
		}finally{//必须执行
			System.out.println("finally无论如何要执行...");//第二步再执行此句
			//return 4; //返回4
		}
	}

	public static void main(String[] args){
		System.out.println(method());
	}//输出什么? 2min
}