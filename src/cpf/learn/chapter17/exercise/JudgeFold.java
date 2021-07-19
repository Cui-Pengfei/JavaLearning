package cpf.learn.chapter17.exercise;

import java.io.File;

/**
 * @author CPF 创建于： 2021/7/14 12:16
 * @version 1.0
 * 判断e盘下是否有文件夹mytemp,如果没有就创建该文件夹
 */
public class JudgeFold{
	public static void main(String[] args){
		File fold = new File("e:/mytemp");

		if(fold.exists()){
			System.out.println("e:\\mytemp文件夹已存在.");
		}else{
			fold.mkdirs();
			System.out.println("文件夹不存在，现在创造之！");
		}
	}
}
