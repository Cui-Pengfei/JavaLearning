package cpf.learn.chapter13.arrays;

import cpf.learn.myTool.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CPF 创建于： 2021/6/19 19:17
 */
public class Exercise01{
	public static void main(String[] args){
		Book[] books = {
				new Book("红楼梦", 100),
				new Book("金瓶梅新", 90),
				new Book("青年文摘20年", 5),
				new Book("java从入门到放弃", 300)
		};
		//价格升序排列
		Arrays.sort(books, new Comparator<Book>(){
			@Override
			public int compare(Book book1, Book book2){
				return book1.getPrice() - book2.getPrice();//前 - 后是从小到大
			}
		});
		System.out.println("=============价格升序排列如下：=============");
		for(Book book : books){
			System.out.println(book.getName() + " : " + book.getPrice());
		}

		//价格降序排列
		Arrays.sort(books, new Comparator<Book>(){
			@Override
			public int compare(Book book1, Book book2){
				return book2.getPrice() - book1.getPrice();//前 - 后是从小到大
			}
		});
		System.out.println("===============价格降序排列如下：=============");
		for(Book book : books){
			System.out.println(book.getName() + " : " + book.getPrice());
		}

		//书名长度降序排列
		Arrays.sort(books, new Comparator<Book>(){
			@Override
			public int compare(Book book1, Book book2){
				return book2.getName().length()
					 - book1.getName().length();//后 - 前 从大到小
			}
		});
		System.out.println("===========书名长度降序排列如下：==============");
		for(Book book : books){
			System.out.println(book.getName() + " : " + book.getPrice());
		}


	}//end main
}

class Book{
	private String name;
	private int price;

	//constructor
	public Book(){
	}
	public Book(String name, int price){
		this.name = name;
		this.price = price;
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}
}
