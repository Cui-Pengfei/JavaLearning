package cpf.learn.chapter18.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author CPF 创建于： 2021/7/20 17:02
 * @version 1.0
 *
 * 1.InetAddress的构造器不是public的，因此无法直接创建对象，通过调用类方法来获得各种InetAddress对象
 * 2.主要的功能是：通过InetAddress作为中转，实现域名、IP地址的互通有无
 *
 */
public class InetAddress_{
	public static void main(String[] args) throws UnknownHostException{
		//1.获取本机的InetAddress对象
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);//CuiPengfei/192.168.1.13

		//2.根据指定主机名，获得InetAddress对象
		InetAddress cuiPengfei = InetAddress.getByName("CuiPengfei");
		System.out.println(cuiPengfei);//CuiPengfei/192.168.1.13

		InetAddress baidu = InetAddress.getByName("www.baidu.com");//域名也可以
		System.out.println(baidu);

		//3.已知InetAddress对象，获得主机名【域名】、IP地址
		System.out.println(baidu.getHostName());
		System.out.println(baidu.getHostAddress());
	}
}
