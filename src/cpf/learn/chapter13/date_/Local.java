package cpf.learn.chapter13.date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author CPF 创建于： 2021/6/20 3:47
 * 第三代日期类：
 * LocalDateTime包含日期，时间；其构造器是私有的，是一个单例模式，只能依靠静态方法获取当前时间
 */
public class Local{
	public static void main(String[] args){
/*1. LocalDateTime */
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println("年：" + ldt.getYear() + "\t" +
						   "月：" + ldt.getMonthValue() + "\t" +
						   "日：" + ldt.getDayOfMonth() + "\t" +
						   "时：" + ldt.getHour() + "\t" +            //这里获得的是24小时制
						   "分：" + ldt.getMinute() + "\t" +
						   "秒：" + ldt.getSecond());
		//格式化输出方式一：
		DateTimeFormatter model = DateTimeFormatter.ofPattern("YYYY年MM月dd日 HH时mm分ss秒 E");
		String myDateTime = model.format(ldt);
		System.out.println(myDateTime);

		//格式化输出方式二：(貌似已经作废，javadoc文档中给的例子不能用了)
		//String text = ldt.toString(model);


/*2. LocalDate */
		LocalDate ld = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY年MM月dd日");
		String myDate = formatter.format(ld);
		System.out.println(myDate);

/*3. LocalTime */
		LocalTime lt = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH时mm分ss秒");
		String myTime = timeFormatter.format(lt);
		System.out.println(myTime);

/*4. Instant 时间戳 */
		System.out.println("========== 4.Instant时间戳 ==========");
		Instant instant = Instant.now();
		System.out.println(instant);//这个时间会比北京时间慢8小时，不是一个时区
		//Instant转化为Date
		Date date = Date.from(instant);
		System.out.println(date);
		//Date转化为Instant
		instant = date.toInstant();
		System.out.println(instant);

		/*
		JDK8.0引入的，Instant对应旧版的Date; LocalDate、LocalDateTime、LocalTime对应旧版的 Calendar;
		DateTimeFormatter取代 SimpleDateFormatter
		 */

/*5. plus() minus()方法 */
		System.out.println("========== 5.plus() minus() 加减时间 ==========");
		LocalDateTime localDateTime = ldt.plusDays(893);
		String text = model.format(localDateTime);
		System.out.println(text);

		localDateTime = localDateTime.minusDays(893);
		System.out.println(model.format(localDateTime));


	}//end main
}
