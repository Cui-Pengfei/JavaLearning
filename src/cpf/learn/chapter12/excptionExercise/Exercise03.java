package cpf.learn.chapter12.excptionExercise;

/**
 * @author CPF 创建于： 2021/6/13 19:26
 */
public class Exercise03{
	public static int method(){
		int i = 1;//i = 1
		try{
			i++;//i = 2
			String[] names = new String[3];
			if(names[1].equals("tom")){//NullPointerException
				System.out.println(names[1]);
			}else{
				names[3] = "cpf";
			}
			return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			return 2;
		}catch(NullPointerException e){//此处往下步骤有反复，开始清晰地标注：
			return ++i;//第一步：记住要返回3，用temp保存 ---> 接着执行finally
					   //第四步：finally内没有新的返回语句，返回之前记住的3
		}finally{
			++i;//第二步：i = 4
			System.out.println("i=" + i);//第三步：输出 i=4 --->接着找返回语句
		}
	}

	public static void main(String[] args){
		System.out.println(method());//第五步：输出 5
	}
}
//练习3
