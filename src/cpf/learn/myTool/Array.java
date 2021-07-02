package cpf.learn.myTool;

/**
 * ����ĳ�����ʶ
 */
@SuppressWarnings({"all"})
public class Array{
	public static void main(String[] args) {
		/**
		 * 	�������룺���ֻĸ����ƽ������
		 *
		 */

		// ����ֱ�ӳ�ʼ�����Ѿ�֪��7ֻ����������
		// double hens[] = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		// double[] hens = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};

		// ����ֻ֪����7ֻ������ʱ��֪�����أ��ͻ��ַ�ʽ
		// double hens[] = new double[7];//����һ������Ϊ7��double������

		// for(int index = 0; index < 7; index++){
		// 	hens[index] = 1.1 * (index + 1);
		// }


		// for(int index = 0; index < 7; index++){
		// 	System.out.print(String.format("%.1f",hens[index])  + "  ");
		// }


		/**
		 * ʹ�÷�ʽ2����̬��ʼ��
		 */
		// 1.���������飬�Ȳ�����ռ�
		// double hens[];
		double[] hens;//�����ֶ��������

		// 2.��������
		hens = new double[7];//ע���ǣ� ������ = new ��������[��С]

		for (int index = 0; index < 7; index++) {
			hens[index] = 1.1 * (index + 1);
		}

		for (int index = 0; index < 7; index++) {
			System.out.print(String.format("%.1f", hens[index]) + "  ");
		}

	}

/*************************�˴�main��������**************************************/

	/**
	 * ���һ�������Ƿ�����.
	 *
	 * @param array ����������
	 * @return ����true��ʾ���������飬false��ʾ����������
	 */
	public static boolean isArrayOrdered(int[] array) {
		for (int index = 0; index < array.length - 1; index++) {
			if (array[0] <= array[array.length - 1]) {//˵�����������ȫ��ȵ�����

				if (array[index] > array[index + 1]) {//�����г��ֽ���˵��������
					return false;
				}
			} else {//˵���ǽ���
				if (array[index] < array[index + 1]) {//�����г�������˵��������
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * ����һ��װ�����������������.
	 *
	 * @param amount �����������
	 * @param range  ������ķ�Χ
	 * @return װ�������������
	 */

	public static int[] randomArray(int amount, int range) {
		//�����������д�����飬����������鷳
		int[] group = new int[amount];
		for (int index = 0; index < group.length; index++) {
			group[index] = (int) (Math.random() * range + 1);//�������Χ
			// group[index] = index;//���������������
		}
		return group;//����������������������
	}

	public static Integer[] randomArray(int amount, int range, boolean isInteger) {
		//�����������д�����飬����������鷳
		Integer[] group = new Integer[amount];
		for (int index = 0; index < group.length; index++) {
			group[index] = (int) (Math.random() * range + 1);//�������Χ
			// group[index] = index;//���������������
		}
		return group;//����������������������
	}

	public static void printArray(int[] array) {
		for (int index = 0; index < array.length; index++) {
			System.out.print(array[index] + "\t");
		}
		System.out.println();//����
	}

	/**
	 * �������Ԫ��
	 *
	 * @param array Ҫ���������
	 * @param begin ������
	 * @param end   ����յ�
	 */
	public static void printArray(int[] array, int begin, int end) {

		if (begin < 0 || end > array.length || begin > end) {
			System.out.println("printArray��������");
		} else {
			for (int index = begin; index < end; index++) {
				System.out.print(array[index] + " ");
			}
		}
		System.out.println();//����
	}

	public static void printArray(double[] array, int begin, int end) {

		if (begin < 0 || end > array.length || begin > end) {
			System.out.println("printArray��������");
		} else {
			for (int index = begin; index < end; index++) {
				System.out.print(array[index] + " ");
			}
		}
		System.out.println();//����
	}


	/**
	 * �����ά�����ֵ.
	 *
	 * @param tda ��ά���������
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
	 * ��������һ������.
	 * ��ָ������arrayβ�˲���һ��ֵΪvalue�����ݣ����������ô��ݣ��������������÷���ֵҲ����
	 *
	 * @param array [Ҫ���ݵ�����]
	 * @param value [�������ݿռ������]
	 * @return ���ش洢���ҽ��������
	 */
	public static int[] insertArray(int[] array, int value) {

		int len = array.length;//������ȡ��һ������ĳ���

		int[] arrAdd = new int[len + 1];//��������Ҫ�䳤

		arrAdd[len] = value;//����һ�������lenΪ�±��Ԫ�����Ǹ���ӵ�Ԫ�أ���ֵ��value

		for (int index = 0; index < len; index++) {//�ȰѾ�ֵ���ݹ�ȥ,
			arrAdd[index] = array[index];
		}

		array = arrAdd;// ��ֵ��Ϻ󣬰�ǰһ��������ָ�������ɵ����飬�������γ��˱ջ�

		return array;
	}
}
