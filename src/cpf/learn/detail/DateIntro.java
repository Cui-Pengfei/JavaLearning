package cpf.learn.detail;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 有时候需要输出及时的时间，
 * 此处学习一下如何实现
 */
public class DateIntro{
	public static void main(String[] args){

		Date date = new Date();
		System.out.println(date);
		/*
		直接输出date的格式是这样的，这是美国标准，不符合中国人习惯。
			Mon May 17 23:56:08 CST 2021
		 */

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println(sdf.format(date));
		/*
		这可以输出非常格式化且世界通用的日期格式：
			2021-07-18 12:07:17
		 */

	}//end main
}
