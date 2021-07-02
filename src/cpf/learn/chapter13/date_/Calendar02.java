package cpf.learn.chapter13.date_;

import cpf.learn.myTool.ClassAbout;

import java.util.Calendar;

/**
 * @author CPF 创建于： 2021/6/19 23:39
 * 第二代日期类：Calendar
 */
public class Calendar02{
	public static void main(String[] args){
		Calendar calendar = Calendar.getInstance();//看来默认获得的就是罗马日历
		System.out.println(ClassAbout.getClassName(calendar));//GregorianCalendar 罗马日历
		System.out.println("calendar = " + calendar);

		System.out.println("年：" + calendar.get(Calendar.YEAR));
		System.out.println("月：" + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("时(12小时制)：" + calendar.get(Calendar.HOUR));
		System.out.println("时(24小时制)：" + calendar.get(Calendar.HOUR_OF_DAY));

		//没有提供对应的格式化的类、方法
	}//end main
}
