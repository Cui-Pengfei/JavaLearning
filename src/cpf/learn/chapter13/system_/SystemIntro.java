package cpf.learn.chapter13.system_;

import java.util.Arrays;

/**
 * @author CPF 创建于： 2021/6/19 19:42
 */
public class SystemIntro{
	public static void main(String[] args){
/*1. 退出程序 exit(int status)
		status表示退出状态，可以有程序员设置不同的值表示程序逻辑中不同的退出状态；
		java底层只是会输出这个status，并不会对其不同值有不同的·操作
		*/
		//System.out.println("ok1");
		//System.exit(-1);
		//System.out.println("ok2");


/*2. 数组赋值 arrayCopy()
		@param      src      the source array. 源数组
        @param      srcPos   starting position in the source array. 源数组开始复制的地方
        @param      dest     the destination array. 目标数组
        @param      destPos  starting position in the destination data. 目标数组开始存放的地方
        @param      length   the number of array elements to be copied. 要复制的元素个数
		 */
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int copyArr[] = new int[array.length];
		System.arraycopy(array, 0, copyArr, 0, array.length);
		System.out.println(Arrays.toString(copyArr));

/*3. 当前时间距离1970-1-1的毫秒数 */
		System.out.println(System.currentTimeMillis());//通常用于作差来表示某项任务的执行时间
		long add = 0;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < 10000; i++){
			for(int j = 0; j < 1000; j++){
				stringBuilder.append(j);
			}
		}
		System.out.println(System.currentTimeMillis());

	}//end main
}
