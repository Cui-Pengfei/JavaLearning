package cpf.learn.myTool;

/**
 * 数组的初步认识
 */
@SuppressWarnings({"all"})
public class Array{
	public static void main(String[] args) {
		/**
		 * 	案例引入：求多只母鸡的平均体重
		 *
		 */

		// 这是直接初始化，已经知道7只鸡的体重了
		// double hens[] = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		// double[] hens = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};

		// 假如只知道有7只鸡，暂时不知道体重，就换种方式
		// double hens[] = new double[7];//定义一个长度为7的double型数组

		// for(int index = 0; index < 7; index++){
		// 	hens[index] = 1.1 * (index + 1);
		// }


		// for(int index = 0; index < 7; index++){
		// 	System.out.print(String.format("%.1f",hens[index])  + "  ");
		// }


		/**
		 * 使用方式2：动态初始化
		 */
		// 1.先声明数组，先不分配空间
		// double hens[];
		double[] hens;//这两种都是允许的

		// 2.创建数组
		hens = new double[7];//注意是： 数组名 = new 数据类型[大小]

		for (int index = 0; index < 7; index++) {
			hens[index] = 1.1 * (index + 1);
		}

		for (int index = 0; index < 7; index++) {
			System.out.print(String.format("%.1f", hens[index]) + "  ");
		}

	}

/*************************此处main方法结束**************************************/

	/**
	 * 检测一个数组是否有序.
	 *
	 * @param array 待检测的数组
	 * @return 返回true表示是有序数组，false表示是无序数组
	 */
	public static boolean isArrayOrdered(int[] array) {
		for (int index = 0; index < array.length - 1; index++) {
			if (array[0] <= array[array.length - 1]) {//说明是升序或者全相等的数组

				if (array[index] > array[index + 1]) {//升序中出现降序，说明是乱序
					return false;
				}
			} else {//说明是降序
				if (array[index] < array[index + 1]) {//降序中出现升序，说明是乱序
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * 生成一个装满随机正整数的数组.
	 *
	 * @param amount 随机数的数量
	 * @param range  随机数的范围
	 * @return 装满随机数的数组
	 */

	public static int[] randomArray(int amount, int range) {
		//先来个随机数写入数组，免得我输入麻烦
		int[] group = new int[amount];
		for (int index = 0; index < group.length; index++) {
			group[index] = (int) (Math.random() * range + 1);//随机数范围
			// group[index] = index;//假如是有序的数据
		}
		return group;//返回这个满载随机数的数组
	}

	public static Integer[] randomArray(int amount, int range, boolean isInteger) {
		//先来个随机数写入数组，免得我输入麻烦
		Integer[] group = new Integer[amount];
		for (int index = 0; index < group.length; index++) {
			group[index] = (int) (Math.random() * range + 1);//随机数范围
			// group[index] = index;//假如是有序的数据
		}
		return group;//返回这个满载随机数的数组
	}

	public static void printArray(int[] array) {
		for (int index = 0; index < array.length; index++) {
			System.out.print(array[index] + "\t");
		}
		System.out.println();//换行
	}

	/**
	 * 输出数组元素
	 *
	 * @param array 要输出的数组
	 * @param begin 输出起点
	 * @param end   输出终点
	 */
	public static void printArray(int[] array, int begin, int end) {

		if (begin < 0 || end > array.length || begin > end) {
			System.out.println("printArray参数有误");
		} else {
			for (int index = begin; index < end; index++) {
				System.out.print(array[index] + " ");
			}
		}
		System.out.println();//换行
	}

	public static void printArray(double[] array, int begin, int end) {

		if (begin < 0 || end > array.length || begin > end) {
			System.out.println("printArray参数有误");
		} else {
			for (int index = begin; index < end; index++) {
				System.out.print(array[index] + " ");
			}
		}
		System.out.println();//换行
	}


	/**
	 * 输出二维数组的值.
	 *
	 * @param tda 二维数组的引用
	 */
	public static void printArray(int[][] tda) {
		for (int outer = 0; outer < tda.length; outer++) {
			for (int inner = 0; inner < tda[outer].length; inner++) {
				System.out.print(tda[outer][inner] + " ");
			}
			System.out.println();
		}
	}


	/**
	 * 数组增加一个容量.
	 * 往指定数组array尾端插入一个值为value的数据，由于是引用传递，因此这个函数不用返回值也可以
	 *
	 * @param array [要扩容的数组]
	 * @param value [填入扩容空间的数据]
	 * @return 返回存储查找结果的数组
	 */
	public static int[] insertArray(int[] array, int value) {

		int len = array.length;//用来获取上一个数组的长度

		int[] arrAdd = new int[len + 1];//新数组需要变长

		arrAdd[len] = value;//以上一个数组的len为下标的元素正是刚添加的元素，其值是value

		for (int index = 0; index < len; index++) {//先把旧值传递过去,
			arrAdd[index] = array[index];
		}

		array = arrAdd;// 赋值完毕后，把前一个数组名指向新生成的数组，这样就形成了闭环

		return array;
	}
}
