package cpf.learn.chapter17.properties;


/**
 * @author CPF 创建于： 2021/7/13 18:06
 * @version 1.0
 * 1.Properties继承了HashTable(HashMap是HashTable的高效率但非线程安全之替代)，也就是说能够存储<key,value>键值对
 * 2.Properties可以通过load()方法传入一个InputStream或者Reader的对象，把配置文件内容读入流中.
 * 3.Properties通过内部类LineReader的readLine()方法的解析,分离出每一行存在的key|value，
 *   然后调用父类HashTable的put(K,V)方法存入table[]数组中，这样查找操作配置文件信息时，就可以调用HashTable许多强大的方法了!
 * 4.为了方便解析，.properties配置文件要有格式：
 *    key=value
 *    key=value
 *    键值对中间以=连接，不允许出现空格，也不需要任何引号（除非内容本身需要引号，这样引号也会被当做内容读取进去）
 *    键值对的默认类型是String
 * 5.Properties的常见方法
 * 5.1 load()加载配置文件的键值对到Properties对象
 * 5.2 list()将数据显示到指定节点，参数时打印流PrintStream PrintWriter
 * 5.3 getProperty(key)根据键获得值
 * 5.4 setProperty(key,value)设置键值对到Properties对象，如果key值相等，那就会覆盖
 * 5.5 store() 将Properties中的键值对存储到配置文件，参数是OutputStream | Reader，
 *     若是字节流则默认编码是8859-1(单字节编码)，就是传输字节，最后中文内容都会显示Unicode码值；
 *     若是字符流，需要特定格式可使用OutputStreamReader,不指定格式默认就是utf-8
 *     注释如果是中文的话，就会保存Unicode编码，而不是中文字符，因此最好用英文注释
 *
 *
 */
public class PropertiesIntro{
	public static void main(String[] args){

	}
}
