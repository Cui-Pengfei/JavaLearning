//package�������ǵ�һ�����
package cpf.learn.oop.pkg;
//һ���������ֻ����һ��package���

//importָ�����packageָ��֮�£����ඨ��֮ǰ�������ж�䣬��û��˳��Ҫ��

import cpf.learn.myTool.Array;

import java.util.Arrays;

public class PkgDetail {
	public static void main(String[] args) {
		//�����������
		int[] array = new int[]{1, 5, 6, 9, 3, 5, 4};
		Arrays.sort(array);
		Array.printArray(array);

	}//end main
}//end class
