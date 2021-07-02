package cpf.learn.chapter14.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author CPF 创建于： 2021/6/29 4:40
 */
@SuppressWarnings({"all"})
public class Exercise01{
	public static void main(String[] args){
		News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
		News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

		ArrayList arrayList = new ArrayList();
		arrayList.add(news1);
		arrayList.add(news2);

		//倒序遍历：我打算先把集合倒序，再遍历
		//由于是List,可以进行for循环更好
		Collections.reverse(arrayList);
		int REMAIN = 15;
		for(Object obj : arrayList){
			News news = (News)obj;
			String title = news.getTitle();
			if(title.length() > REMAIN){
				news.setTitle(title.substring(0, 15) + "...");
			}
		}

		//打印处理过的新闻标题
		Iterator iterator = arrayList.iterator();
		while(iterator.hasNext()){
			News news = (News)iterator.next();
			System.out.println(news);
		}
	}//end main
}

class News{
	private String title;
	private String content;

	public News(String title){
		this.title = title;
	}

	@Override
	public String toString(){
		return "News{" +
				"title='" + title + '\'' +
				'}';
	}

	//getter setter
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}
}
