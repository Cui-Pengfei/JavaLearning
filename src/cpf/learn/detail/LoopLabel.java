package cpf.learn.detail;

/**
 * @author CPF 创建于： 2021/7/8 7:52
 * @version 1.0
 * 循环标签的使用：
 * 1.使用标签可以让循环调出到指定的地方
 * 2.没使用标签的话，break默认退出本层循环，continue默认本初本层循环的这一轮
 * 3.不同的循环，标签可以重名，标签只与循环绑定，不过具有嵌套关系的循环，标签要能区别开来
 */
public class LoopLabel{
	public static void main(String[] args){
		int count = 0;
		label:
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				count++;
				if(count > 10)
					break label;
				System.out.printf("i = %d, j = %d \n", i, j);
			}
		}

		System.out.println("===============================");
		count = 0;
		label://此处
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				count++;
				if(count > 10)
					break label;
				System.out.printf("j = %d \n", j);
			}
		}
	}//end main
}
