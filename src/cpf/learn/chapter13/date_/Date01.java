package cpf.learn.chapter13.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CPF 创建于： 2021/6/19 23:21
 * 第一代日期：
 *
 */
public class Date01{
	public static void main(String[] args) throws ParseException{

		//通过无参构造器，构造Date实例
		Date date = new Date();
		System.out.println("date = " + date);

		//通过毫秒数，构造Date实例，毫秒数自从1970-01-01算起
		long currentTimeMillis = System.currentTimeMillis();
		Date date1 = new Date(currentTimeMillis);
		System.out.println("date1 = " + date1);

		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH时mm分ss秒 E");
		String formatDate = sdf.format(date);
		System.out.println(formatDate);

		//通过字符串得到一个日期
		String myDateStr = "19年12月23日 21时18分25秒";
		SimpleDateFormat mySdf = new SimpleDateFormat("YY年MM月dd日 HH时mm分ss秒");
		Date myDate = mySdf.parse(myDateStr);
		System.out.println(sdf.format(myDate));



	}//end main
}
