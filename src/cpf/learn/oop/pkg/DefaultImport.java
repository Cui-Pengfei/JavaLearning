package cpf.learn.oop.pkg;

//Ĭ������İ�
//������Ҫʲô�������ʲô�࣬��������.*������
// import  java.lang.*;
// import java.lang.Math;//����Ͳ��õ���Ϳ����ã�Ĭ���ǵ����


import cpf.learn.myTool.Array;

import java.util.Arrays;

public class DefaultImport {
	public static void main(String[] args) {
		//Ĭ�ϵĵ����ʹ����������Ϸ�
		double ran = Math.random();

		//	ʹ��ϵͳ�ṩ�� Arrays �����������
		int[] array = {1, 2, 7, 4, 5, 9, 12, 66, 31};
		System.out.print("����ǰ��");
		Array.printArray(array);
		Arrays.sort(array);//ctrl + t �ɲ鿴Arrays�ṩ�Ķ������򷽷�
		System.out.print("�����");
		Array.printArray(array);




	}//end main

}//end class
